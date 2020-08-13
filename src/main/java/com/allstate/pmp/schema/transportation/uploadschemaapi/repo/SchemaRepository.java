package com.allstate.pmp.schema.transportation.uploadschemaapi.repo;

import com.allstate.pmp.schema.transportation.uploadschemaapi.model.SchemaDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchemaRepository extends JpaRepository<SchemaDetail, Long> {
}
