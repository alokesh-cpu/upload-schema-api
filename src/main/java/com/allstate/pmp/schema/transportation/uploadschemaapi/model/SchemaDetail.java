package com.allstate.pmp.schema.transportation.uploadschemaapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.criteria.CriteriaBuilder;

//@Entity
@Document
public class SchemaDetail {
    @Id
    private String id;
    private String name;
    private String version;
    private String namespace;
    private String group_name;
    private String artifact;
    private String jsonFilepath;
    private String xsdFilepath;

    public SchemaDetail() {
    }

    public SchemaDetail(String id, String name, String version, String namespace, String group_name, String artifact, String jsonFilepath,String xsdFilepath) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.namespace = namespace;
        this.group_name = group_name;
        this.artifact = artifact;
        this.jsonFilepath = jsonFilepath;
        this.xsdFilepath = xsdFilepath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getArtifact() {
        return artifact;
    }

    public void setArtifact(String artifact) {
        this.artifact = artifact;
    }

    public String getJsonFilepath() {
        return jsonFilepath;
    }

    public void setJsonFilepath(String jsonFilepath) {
        this.jsonFilepath = jsonFilepath;
    }

    public String getXsdFilepath() {
        return xsdFilepath;
    }

    public void setXsdFilepath(String xsdFilepath) {
        this.xsdFilepath = xsdFilepath;
    }

    @Override
    public String toString() {
        return "Schema{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", version=" + version +
                ", namespace='" + namespace + '\'' +
                ", group_name='" + group_name + '\'' +
                ", artifact='" + artifact + '\'' +
                ", jsonFilepath='" + jsonFilepath + '\'' +
                ", xsdFilepath='" + xsdFilepath + '\'' +
                '}';
    }
}
