package com.allstate.pmp.schema.transportation.uploadschemaapi.utils;

public class AppConstants {

    public static final String SCHEMA_URI = "/schemas";
    public static final String SCHEMA_JSON_PARAM = "schemaJson";
    public static final String SCHEMA_JSON_FILE_PARAM = "jsonFile";
    public static final String SCHEMA_XSD_FILE_PARAM = "xsdFile";
    public static final String SUCCESS_CODE = "200";
    public static final String SUCCESS_MSG = "Schema created successfully";
    public static final String FILE_SEPERATOR = "_";
    public static final String DOWNLOAD_PATH = "/downloadFile/";
    public static final String DOWNLOAD_URI = "/downloadFile/{fileName:.+}";
    public static final String DEFAULT_CONTENT_TYPE = "application/octet-stream";
    public static final String FILE_DOWNLOAD_HTTP_HEADER = "attachment; filename=\"%s\"";
    public static final String FILE_PROPERTIES_PREFIX = "file";
    public static final String FILE_STORAGE_EXCEPTION_PATH_NOT_FOUND = "Could not create the directory where the uploaded files will be stored";
    public static final String INVALID_FILE_PATH_NAME = "Sorry! Filename contains invalid path sequence";
    public static final String FILE_NOT_FOUND = "File not found ";
    public static final String FILE_STORAGE_EXCEPTION = "Could not store file %s !! Please try again!";
    public static final CharSequence INVALID_FILE_DELIMITER = "..";
    public static final String INDEX_PAGE_URI = "/index";
    public static final String INDEX_PAGE = "index";
    public static final String TEMP_DIR = "C://TMP//";
    public static final String INVALID_FILE_DIMENSIONS = "Invalid file dimensions. File dimension should note be more than 300 X 300";
    public static final String INVALID_FILE_FORMAT = "Only JSON or XSD files are allowed";
    public static final String JSON_FILE_FORMAT = ".json";
    public static final String XSD_FILE_FORMAT = ".xsd";


}
