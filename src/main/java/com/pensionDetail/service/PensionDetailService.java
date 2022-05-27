package com.pensionDetail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pensionDetail.model.PensionerDetailModel;
import com.pensionDetail.repository.PensionServiceRepository;

@Service
public class PensionDetailService {

	@Autowired
	private PensionServiceRepository repo;
	
	public List<PensionerDetailModel> getAllDetails(){
		return repo.findAll();
		
	}
	
	public PensionerDetailModel getPensionerByPan(String PanID) {
		return repo.findPensionerDetailModelByPAN(PanID);
	}

	public PensionerDetailModel savePensioner(PensionerDetailModel pensioner) {
		// TODO Auto-generated method stub
		return repo.save(pensioner);
	}

	public void deletePensioner(String panID) {
		// TODO Auto-generated method stub
	
		repo.deleteById(panID);
				
	}
	
}
