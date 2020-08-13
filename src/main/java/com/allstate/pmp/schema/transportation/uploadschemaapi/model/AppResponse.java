package com.allstate.pmp.schema.transportation.uploadschemaapi.model;

public class AppResponse {

    private String code;
    private String message;
    private String jsonFileName;
    private String jsonFilePath;
    private String xsdFileName;
    private String xsdFilePath;


    public AppResponse() {

    }

    public AppResponse(String code, String message,String jsonFileName, String jsonFilePath ,String xsdFileName, String xsdFilePath) {
        this.code = code;
        this.message = message;
        this.jsonFileName = jsonFileName;
        this.jsonFilePath = jsonFilePath;
        this.xsdFileName = xsdFileName;
        this.xsdFilePath = xsdFilePath;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getJsonFilePath() {
        return jsonFilePath;
    }

    public void setJsonFilePath(String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
    }

    public String getXsdFilePath() {
        return xsdFilePath;
    }

    public void setXsdFilePath(String xsdFilePath) {
        this.xsdFilePath = xsdFilePath;
    }

    public String getJsonFileName() {
        return jsonFileName;
    }

    public void setJsonFileName(String jsonFileName) {
        this.jsonFileName = jsonFileName;
    }

    public String getXsdFileName() {
        return xsdFileName;
    }

    public void setXsdFileName(String xsdFileName) {
        this.xsdFileName = xsdFileName;
    }



}
