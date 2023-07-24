package com.DigitalFactoryApplication.RepositoryDetection.Business.Abstracts;

import java.util.List;

import com.DigitalFactoryApplication.RepositoryDetection.Business.DTO.Requests.CreateRepositoryDetectionRequest;
import com.DigitalFactoryApplication.RepositoryDetection.Business.DTO.Requests.UpdateRepositoryDetectionRequest;
import com.DigitalFactoryApplication.RepositoryDetection.Business.DTO.Responses.GetAllRepositoryDetectionResponse;
import com.DigitalFactoryApplication.RepositoryDetection.Business.DTO.Responses.GetByIdRepositoryDetectionResponse;

public interface IRepositoryDetectionService {
	List<GetAllRepositoryDetectionResponse> getAll();
	List<GetAllRepositoryDetectionResponse> getSoirNoContaning(String str);
	void add(CreateRepositoryDetectionRequest cmr);
	GetByIdRepositoryDetectionResponse  getById(int id);
	void update(UpdateRepositoryDetectionRequest updateModelRequest);
	void delete(int id);
	List<GetAllRepositoryDetectionResponse> getPieceNoContaning(String str);
}
