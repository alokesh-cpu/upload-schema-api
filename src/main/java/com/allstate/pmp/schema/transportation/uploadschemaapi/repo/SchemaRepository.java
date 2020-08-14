package com.allstate.pmp.schema.transportation.uploadschemaapi.repo;

import com.allstate.pmp.schema.transportation.uploadschemaapi.model.SchemaDetail;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;


@Repository
public interface SchemaRepository extends MongoRepository<SchemaDetail, Long> {
}
