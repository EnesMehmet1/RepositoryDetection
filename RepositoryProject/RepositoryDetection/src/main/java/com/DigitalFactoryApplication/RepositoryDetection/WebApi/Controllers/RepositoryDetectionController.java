package com.DigitalFactoryApplication.RepositoryDetection.WebApi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.DigitalFactoryApplication.RepositoryDetection.Business.Abstracts.IRepositoryDetectionService;
import com.DigitalFactoryApplication.RepositoryDetection.Business.DTO.Requests.CreateRepositoryDetectionRequest;
import com.DigitalFactoryApplication.RepositoryDetection.Business.DTO.Requests.UpdateRepositoryDetectionRequest;
import com.DigitalFactoryApplication.RepositoryDetection.Business.DTO.Responses.GetAllRepositoryDetectionResponse;
import com.DigitalFactoryApplication.RepositoryDetection.Business.DTO.Responses.GetByIdRepositoryDetectionResponse;

@RestController //annotation
@RequestMapping("/api/RepositoryDetection")
public class RepositoryDetectionController {
	private IRepositoryDetectionService repositoryDetectionService;
	@Autowired
	public RepositoryDetectionController(IRepositoryDetectionService repositoryDetectionService) {
		this.repositoryDetectionService = repositoryDetectionService;
	}
	@GetMapping() //@GetMapping("/getAll")
	public List<GetAllRepositoryDetectionResponse> getAll(){
		return repositoryDetectionService.getAll();
	}
	@PostMapping() //@PostMapping("/add")	
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(CreateRepositoryDetectionRequest repositoryDetectionRequest) {
		this.repositoryDetectionService.add(repositoryDetectionRequest);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(code=HttpStatus.CREATED)
	public GetByIdRepositoryDetectionResponse getById(@PathVariable int id){
	return repositoryDetectionService.getById(id);
	}
	
	@PutMapping()
	public void update(@RequestBody() UpdateRepositoryDetectionRequest updateModelRequest){
	this.repositoryDetectionService.update(updateModelRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id){
	this.repositoryDetectionService.delete(id);
	}
	
	@GetMapping("/get/{soirNo}")
	@ResponseStatus(code=HttpStatus.CREATED)
	public List<GetAllRepositoryDetectionResponse> getSoirNoContaning(@PathVariable String str){
	return repositoryDetectionService.getSoirNoContaning(str);
	}
	
	@GetMapping("/gets/{pieceNo}")
	@ResponseStatus(code=HttpStatus.CREATED)
	public List<GetAllRepositoryDetectionResponse> getPieceNoContaning(@PathVariable String str){
	return repositoryDetectionService.getPieceNoContaning(str);
	}
}
