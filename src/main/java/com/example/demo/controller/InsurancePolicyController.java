package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.model.Policy;
import com.example.demo.dao.Buypolicydao;
import com.example.demo.dao.InsuranceDao;
import com.example.demo.model.Insurance;

@Controller
@SessionAttributes("loginid")

public class InsurancePolicyController {

	@Autowired
	InsuranceDao insurancedao;

	@Autowired
	Insurance insurance;

	@Autowired
	Policy policy;

	@Autowired
	Buypolicydao buypolicydao;

	@GetMapping("index")
	public String indexMethod() {

		return "index";
	}

	@GetMapping("signup")
	public String signupMethod() {

		return "signup";
	}

	@GetMapping("login")
	public String loginMethod() {

		return "login";
	}

	@GetMapping("dashboard")
	public String dashboardMethod() {

		return "dashboard";
	}

	@GetMapping("buypolicy")
	public String buypolicyMethod() {
		return "buypolicy";
	}

	@GetMapping("logout")
	public String logoutMethod() {

		return "index";
	}

	@GetMapping("deletpolicy")
	public String deletpolicyMethod() {

		return "deletpolicy";
	}

	@PostMapping("signup")
	public String signupMethod1(
			@RequestParam("loginid") String loginid, 
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("address") String address,
			@RequestParam("email") String email, 
			@RequestParam("mobile") String mobile,
			@ModelAttribute Insurance insurance) {
		insurancedao.save(insurance);
		
		return "login";

	}

	@PostMapping("userlogin")
	public ModelAndView mainDashboard(
			@RequestParam("loginid") String loginid,
			@RequestParam("password") String password) {
		ModelAndView mv = new ModelAndView();
		Optional<Insurance> optionalholderregistration=insurancedao.findById(loginid);
		insurance = optionalholderregistration.get();

		mv.addObject("loginid", loginid);
if (loginid.equals(insurance.getLoginid())) {
			if (password.equals(insurance.getPassword())) {
				mv.setViewName("dashboard");
			} else {
				System.out.println("this is wrong Authentication");
				mv.setViewName("login");
			}
		} else if (loginid.equals(null)) {
			mv.setViewName("login");
		} else {
			mv.setViewName("signup");
		}
		return mv;
	}
	@PostMapping("buynewpolicy")
	public ModelAndView buypolicyMethod1(
			@SessionAttribute("loginid") String loginid,
			@RequestParam("policyname") String policyname, 
			@RequestParam("insurance_tenure") String insurance_tenure,
			@RequestParam("premium_amount") String premium_amount,
			@RequestParam("sum_insured") String sum_insured,
			@RequestParam("policyid") String policyid,
			@ModelAttribute Policy buyPolicy) {
		ModelAndView mv = new ModelAndView();
		buyPolicy.setLoginid(loginid);
		buypolicydao.save(buyPolicy);

		StringBuilder portfolio = new StringBuilder();
		Iterable<Policy> itr;
		// Optional<Policy> optionalpolicy;
		itr = buypolicydao.findAll();

		itr.forEach((p) -> {
			if (loginid.equals(p.getLoginid())) {
				portfolio.append(p.getPolicyname().toString()).append(" ").append(p.getPremium_amount().toString())
						.append(" ").append(p.getSum_insured().toString()).append("\n");
			}
		});

		mv.addObject("portfolio", portfolio);
		mv.setViewName("thankyou");

		return mv;
	}

	@GetMapping("viewportfolio")
	public ModelAndView viewPortfolio(
			@SessionAttribute("loginid") String loginid, 
			@ModelAttribute Policy policy) {
		ModelAndView mv = new ModelAndView();
		StringBuilder portfolio = new StringBuilder();
		Iterable<Policy> itr;
		// Optional<Policy> optionalpolicy;
		itr = buypolicydao.findAll();

		itr.forEach((p) -> {
			if (loginid.equals(p.getLoginid())) {
				portfolio.append(p.getPolicyname().toString()).append(" ").append(p.getPremium_amount().toString())
						.append(" ").append(p.getSum_insured().toString()).append("\n");
			}
		});

		mv.addObject("portfolio", portfolio);
		mv.setViewName("viewportfolio");
		return mv;
	}

	@PostMapping("deletpolicyold")
	public ModelAndView deletePolicyold(
			@SessionAttribute("loginid") String loginid,
			@RequestParam("policyname") String policyname,
			@ModelAttribute Policy policy) {
		ModelAndView mv = new ModelAndView();
		// StringBuilder portfolio=new StringBuilder();
		Iterable<Policy> itr;
		// Optional<Policy> optionalpolicy;
		itr = buypolicydao.findAll();

		itr.forEach((p) -> {
			if (policyname.equals(p.getPolicyname()) && loginid.equals(p.getLoginid())) 
			{
				buypolicydao.deleteById(p.getPolicyid().toString());
				;
			}
		});

		mv.setViewName("successdelete");
		return mv;
	}

}
