package com.pensionDetail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pensionDetail.model.PensionerDetailModel;
import com.pensionDetail.service.PensionDetailService;

@RestController
@RequestMapping(value = "v1/pensionDetailService")
public class PensionServiceController {

	@Autowired
	private PensionDetailService ps;

	@GetMapping(value = "/")
	public ResponseEntity<String> gethola() {
		return ResponseEntity.ok("hola");
	}

	@GetMapping(value = "/all", produces = "application/json")
	public ResponseEntity<List<PensionerDetailModel>> getallDetails() {
		List<PensionerDetailModel> res = ps.getAllDetails();
		return ResponseEntity.ok(res);
	}

	@GetMapping(value = "/get/{panid}", produces = "application/json")
	public ResponseEntity getUserByPan(@PathVariable("panid") String panId) {

		PensionerDetailModel res = ps.getPensionerByPan(panId);
		if (res != null) {
			return ResponseEntity.ok(res);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pensioner details not found for the given pan id");
		}

	}

	@PostMapping(value = "/create")
	public ResponseEntity createPensioner(@RequestBody PensionerDetailModel pensioner) {

		PensionerDetailModel res = ps.getPensionerByPan(pensioner.getPAN());
		if (res != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("pensioner already exists for the given pan id");
		} else {
			return ResponseEntity.ok(ps.savePensioner(pensioner));
		}

	}

	@DeleteMapping(value = "/delete/{panId}")
	public ResponseEntity deletePensioner(@PathVariable("panId") String PanID) {

		PensionerDetailModel res = ps.getPensionerByPan(PanID);
		if (res == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("the requested source cannot be found, try with valid pensioner detail");
		} else {
			ps.deletePensioner(PanID);
			return ResponseEntity.status(HttpStatus.OK).body("deleted " + res);
		}

	}

}
