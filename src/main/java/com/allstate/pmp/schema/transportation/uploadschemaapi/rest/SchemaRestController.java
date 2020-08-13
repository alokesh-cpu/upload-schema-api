package com.allstate.pmp.schema.transportation.uploadschemaapi.rest;

import com.allstate.pmp.schema.transportation.uploadschemaapi.model.AppResponse;
import com.allstate.pmp.schema.transportation.uploadschemaapi.model.SchemaDetail;
import com.allstate.pmp.schema.transportation.uploadschemaapi.service.ApplicationService;
import com.allstate.pmp.schema.transportation.uploadschemaapi.service.FileStorageService;
import com.allstate.pmp.schema.transportation.uploadschemaapi.utils.AppConstants;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class SchemaRestController {

    @Autowired
    ApplicationService applicationService;
    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    FileStorageService fileStorageService;

    @RequestMapping(value = AppConstants.SCHEMA_URI, method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public AppResponse createSchema(
            @RequestParam(value = AppConstants.SCHEMA_JSON_PARAM, required = true) String schemaJson,
            @RequestParam(required = true, value = AppConstants.SCHEMA_JSON_FILE_PARAM) MultipartFile jsonFile,
            @RequestParam(required = true, value = AppConstants.SCHEMA_XSD_FILE_PARAM) MultipartFile xsdFile)
            throws JsonParseException, JsonMappingException, IOException {
        SchemaDetail schemaDetail = objectMapper.readValue(schemaJson, SchemaDetail.class);
        String jsonFileName = fileStorageService.storeFile(jsonFile , schemaDetail.getVersion());
        String xsdFileName = fileStorageService.storeFile(xsdFile , schemaDetail.getVersion());
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path(AppConstants.DOWNLOAD_PATH)
                .path(jsonFileName).toUriString();

        String xsdFileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path(AppConstants.DOWNLOAD_PATH)
                .path(xsdFileName).toUriString();

        schemaDetail.setJsonFilepath(fileDownloadUri);
        schemaDetail.setXsdFilepath(xsdFileDownloadUri);
        applicationService.createSchema(schemaDetail);

        return new AppResponse(AppConstants.SUCCESS_CODE, AppConstants.SUCCESS_MSG ,jsonFileName, fileDownloadUri , xsdFileName,xsdFileDownloadUri);
    }

    @RequestMapping(value = AppConstants.SCHEMA_URI, method = RequestMethod.GET)
    public List<SchemaDetail> getAllSchemas() {
        return applicationService.getAllSchemas();
    }

    @RequestMapping(value = AppConstants.DOWNLOAD_URI, method = RequestMethod.GET)
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        Resource resource = fileStorageService.loadFileAsResource(fileName);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (contentType == null) {
            contentType = AppConstants.DEFAULT_CONTENT_TYPE;
        }
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        String.format(AppConstants.FILE_DOWNLOAD_HTTP_HEADER, resource.getFilename()))
                .body(resource);
    }
}
