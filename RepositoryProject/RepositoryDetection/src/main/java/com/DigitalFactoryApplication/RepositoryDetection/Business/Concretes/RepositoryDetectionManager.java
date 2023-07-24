package com.DigitalFactoryApplication.RepositoryDetection.Business.Concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.DigitalFactoryApplication.RepositoryDetection.Business.Abstracts.IRepositoryDetectionService;
import com.DigitalFactoryApplication.RepositoryDetection.Business.DTO.Requests.CreateRepositoryDetectionRequest;
import com.DigitalFactoryApplication.RepositoryDetection.Business.DTO.Requests.UpdateRepositoryDetectionRequest;
import com.DigitalFactoryApplication.RepositoryDetection.Business.DTO.Responses.GetAllRepositoryDetectionResponse;
import com.DigitalFactoryApplication.RepositoryDetection.Business.DTO.Responses.GetByIdRepositoryDetectionResponse;
import com.DigitalFactoryApplication.RepositoryDetection.Core.Utilities.Mappers.IModelMapperService;
import com.DigitalFactoryApplication.RepositoryDetection.DataAccess.Abstract.IRepositoryDetectionRepository;
import com.DigitalFactoryApplication.RepositoryDetection.Entity.RepositoryDetection;

@Service //Business class IOC'de oluşacak
public class RepositoryDetectionManager implements IRepositoryDetectionService {
	IRepositoryDetectionRepository repositoryDetectionRepository;
	private IModelMapperService modelMapperService;
	public RepositoryDetectionManager(IRepositoryDetectionRepository repositoryDetectionRepository,
			IModelMapperService modelMapperService) {
		this.repositoryDetectionRepository = repositoryDetectionRepository;
		this.modelMapperService = modelMapperService;
	}
	@Override
	public List<GetAllRepositoryDetectionResponse> getAll() {
		List<RepositoryDetection> repositoryDetection=repositoryDetectionRepository.findAll();
		
		List<GetAllRepositoryDetectionResponse> RepositoryDetectionResponse=repositoryDetection.stream().map(model->this.modelMapperService.forResponse()
				.map(model,GetAllRepositoryDetectionResponse.class)).collect(Collectors.toList());
		return RepositoryDetectionResponse;
	}

	public RepositoryDetectionManager() {
	}

	@Override
	public void add(CreateRepositoryDetectionRequest cmr) {
		RepositoryDetection repositoryDetection=this.modelMapperService.forRequest().map(cmr,RepositoryDetection.class);
		this.repositoryDetectionRepository.save(repositoryDetection);
		
	}

	@Override
	public GetByIdRepositoryDetectionResponse getById(int id) {
		RepositoryDetection model=this.repositoryDetectionRepository.findById(id).orElseThrow();   //iş kodu ile daha da genişletilecek burada idye tekabül eden satırı getirdik
		GetByIdRepositoryDetectionResponse response= this.modelMapperService.forResponse().map(model,GetByIdRepositoryDetectionResponse.class); //burada ise modeli dto ile response'a aktardık
		return response;
	}

	@Override
	public void update(UpdateRepositoryDetectionRequest updateModelRequest) {
		// TODO Auto-generated method stub
		RepositoryDetection model=this.modelMapperService.forRequest().map(updateModelRequest,RepositoryDetection.class);
		this.repositoryDetectionRepository.save(model); //add methodundakı aynı kod ama orada ıd olmadıhgı ıcın ınster yapıyordu
		// burada ıd oldugu ıcın update yapıyor
	}

	@Override
	public void delete(int id) {
		this.repositoryDetectionRepository.deleteById(id);
		
	}
	@Override
	public List<GetAllRepositoryDetectionResponse> getSoirNoContaning(String str) {
		List<RepositoryDetection> findBySoirNoContaining = repositoryDetectionRepository.findBySoirNoContaining(str);
		List<GetAllRepositoryDetectionResponse> RepositoryDetectionResponse=findBySoirNoContaining.stream().
				map(model->this.modelMapperService.forResponse()
				.map(model,GetAllRepositoryDetectionResponse.class)).collect(Collectors.toList());
        return RepositoryDetectionResponse;
	}
	
	@Override
	public List<GetAllRepositoryDetectionResponse> getPieceNoContaning(String str) {
		List<RepositoryDetection> findByPieceNoContaining = repositoryDetectionRepository.findByPieceNoContaining(str);
		List<GetAllRepositoryDetectionResponse> RepositoryDetectionResponse=findByPieceNoContaining.stream().
				map(model->this.modelMapperService.forResponse()
				.map(model,GetAllRepositoryDetectionResponse.class)).collect(Collectors.toList());
        return RepositoryDetectionResponse;
	}
	
}
