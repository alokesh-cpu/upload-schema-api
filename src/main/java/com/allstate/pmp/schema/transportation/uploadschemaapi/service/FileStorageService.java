package com.allstate.pmp.schema.transportation.uploadschemaapi.service;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    public String storeFile(MultipartFile file, String version) throws IOException;

    public Resource loadFileAsResource(String fileName);
}