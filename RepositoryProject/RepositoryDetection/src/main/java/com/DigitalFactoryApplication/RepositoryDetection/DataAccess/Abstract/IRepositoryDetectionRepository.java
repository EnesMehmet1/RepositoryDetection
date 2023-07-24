package com.DigitalFactoryApplication.RepositoryDetection.DataAccess.Abstract;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DigitalFactoryApplication.RepositoryDetection.Entity.RepositoryDetection;

public interface IRepositoryDetectionRepository extends JpaRepository<RepositoryDetection,Integer>{

	List<RepositoryDetection> findBySoirNoContaining(String str);

	List<RepositoryDetection> findByPieceNoContaining(String str);

}
