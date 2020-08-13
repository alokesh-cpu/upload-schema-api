package com.allstate.pmp.schema.transportation.uploadschemaapi.service;

import com.allstate.pmp.schema.transportation.uploadschemaapi.model.SchemaDetail;
import com.allstate.pmp.schema.transportation.uploadschemaapi.repo.SchemaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    SchemaRepository schemaRepository;
    @Override
    public SchemaDetail createSchema(SchemaDetail schemaDetail) {
        return schemaRepository.save(schemaDetail);
    }

    @Override
    public List<SchemaDetail> getAllSchemas() {
        return schemaRepository.findAll();
    }
}
