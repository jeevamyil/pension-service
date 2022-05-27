package com.pensionDetail.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.pensionDetail.model.PensionerDetailModel;

@Repository
public interface PensionServiceRepository extends JpaRepository<PensionerDetailModel, String>{
	
	public List<PensionerDetailModel> findAll();
	
	public PensionerDetailModel findPensionerDetailModelByPAN(String PanID);

	//public PensionerDetailModel deleteByPAN(String pan);

}
