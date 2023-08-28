package com.example.demo.controller;

import com.example.demo.model.Insurance;
import com.example.demo.dao.InsuranceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/policy")
public class PolicyRestController {

	@Autowired
	private InsuranceDao insurancedao;

	@GetMapping
	public Iterable<Insurance> getAllInsurance() {
		return insurancedao.findAll();
	}

	@GetMapping("/{loginid}")
	public Optional<Insurance> getInsurance(@PathVariable String loginid) {
		System.out.println(loginid);
		return insurancedao.findById(loginid);
	}

	@PostMapping
	public Insurance addInsurance(@RequestBody Insurance insurance) {

		return insurancedao.save(insurance);
	}

	
	  @PutMapping("/{loginid}") 
	  public Insurance updateInsurance(@PathVariable String loginid, @RequestBody Insurance insurance)
	  { 
		  // Typically, you'd ensure that theID from the path matches the ID of the provided policy object
		  System.out.println("this is insurance "+insurance.getLoginid());
		  insurance.setLoginid(loginid);
		  return insurancedao.save(insurance); }
	  
	  @DeleteMapping("/{loginid}")
	  public void deleteInsurance(@RequestBody Insurance insurance) {
		  insurancedao.delete(insurance); }
	 
}