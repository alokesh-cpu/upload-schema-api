package com.allstate.pmp.schema.transportation.uploadschemaapi.service;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;



import com.allstate.pmp.schema.transportation.uploadschemaapi.config.FileStorageProperties;
import com.allstate.pmp.schema.transportation.uploadschemaapi.exception.FileStorageException;
import com.allstate.pmp.schema.transportation.uploadschemaapi.exception.MyFileNotFoundException;
import com.allstate.pmp.schema.transportation.uploadschemaapi.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;



@Service
public class FileStorageServiceImpl implements FileStorageService {

    private final Path fileStorageLocation;

    @Autowired
    public FileStorageServiceImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException(AppConstants.FILE_STORAGE_EXCEPTION_PATH_NOT_FOUND, ex);
        }
    }

    @Override
    public String storeFile(MultipartFile file, String version) throws IOException {

        if (!(file.getOriginalFilename().endsWith(AppConstants.JSON_FILE_FORMAT) || file.getOriginalFilename().endsWith(AppConstants.XSD_FILE_FORMAT) ))
            throw new FileStorageException(AppConstants.INVALID_FILE_FORMAT);

        File f = new File(AppConstants.TEMP_DIR+file.getOriginalFilename());

        f.createNewFile();
        FileOutputStream fout = new FileOutputStream(f);
        fout.write(file.getBytes());
        fout.close();

        if(f.exists())
            f.delete();

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains(AppConstants.INVALID_FILE_DELIMITER)) {
                throw new FileStorageException(AppConstants.INVALID_FILE_PATH_NAME + fileName);
            }
            //String newFileName = System.currentTimeMillis() + AppConstants.FILE_SEPERATOR + fileName;
            String fileExt = null;
            if (fileName.indexOf(".") > 0){
                fileExt = fileName.substring(fileName.lastIndexOf(".") , fileName.length());
                fileName = fileName.substring(0, fileName.lastIndexOf("."));
            }

            String newFileName = fileName + AppConstants.FILE_SEPERATOR + version + fileExt;
            Path targetLocation = this.fileStorageLocation.resolve(newFileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return newFileName;
        } catch (IOException ex) {
            throw new FileStorageException(String.format(AppConstants.FILE_STORAGE_EXCEPTION, fileName), ex);
        }

    }

    @Override
    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException(AppConstants.FILE_NOT_FOUND + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException(AppConstants.FILE_NOT_FOUND + fileName, ex);
        }
    }
}
