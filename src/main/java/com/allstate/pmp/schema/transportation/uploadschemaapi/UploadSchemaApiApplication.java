package com.allstate.pmp.schema.transportation.uploadschemaapi;

import com.allstate.pmp.schema.transportation.uploadschemaapi.config.FileStorageProperties;
import com.allstate.pmp.schema.transportation.uploadschemaapi.service.ApplicationService;
import com.allstate.pmp.schema.transportation.uploadschemaapi.service.ApplicationServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties({ FileStorageProperties.class })
public class UploadSchemaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploadSchemaApiApplication.class, args);
	}

	@Bean
	public ApplicationService getApplicationService(){
		ApplicationService applicationService= new ApplicationServiceImpl();
		return applicationService;
	}

}
