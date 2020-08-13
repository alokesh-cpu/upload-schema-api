package com.allstate.pmp.schema.transportation.uploadschemaapi.service;

import com.allstate.pmp.schema.transportation.uploadschemaapi.model.SchemaDetail;

import java.util.List;

public interface ApplicationService {

    SchemaDetail createSchema(SchemaDetail schemaDetail);

    List<SchemaDetail> getAllSchemas();
}
