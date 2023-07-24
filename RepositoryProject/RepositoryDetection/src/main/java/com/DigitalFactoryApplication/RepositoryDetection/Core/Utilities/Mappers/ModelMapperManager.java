package com.DigitalFactoryApplication.RepositoryDetection.Core.Utilities.Mappers; //DTO
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;


@Service //ioc
public class ModelMapperManager implements IModelMapperService{
	private  ModelMapper modelMapper;
	
	public ModelMapperManager(ModelMapper modelMapper) {
		super();
		this.modelMapper = modelMapper;
	}

	@Override
	public ModelMapper forResponse() {   //LOOSE OLDUĞU İÇN BAZI NESNELERİ VERMEYEBİLİİZ YANİ ENTİTİY PROPORTYLERİNİ
		this.modelMapper.getConfiguration().setAmbiguityIgnored(true) //BELİRSİZLİK DURUMUNU TRUE ET
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		return this.modelMapper;
	}

	@Override
	public ModelMapper forRequest() {
		this.modelMapper.getConfiguration().setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.STANDARD);
		return this.modelMapper;
	}
	

}
