package com.DigitalFactoryApplication.RepositoryDetection.Core.Utilities.Mappers; //DTO
import org.modelmapper.ModelMapper;

public interface IModelMapperService {
	ModelMapper forResponse();
	ModelMapper forRequest();
	}
