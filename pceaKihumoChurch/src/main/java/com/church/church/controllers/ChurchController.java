package com.church.church.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.church.church.Repositories.ChurchRepository;
import com.church.church.entities.Members;
import com.church.church.services.ChurchServices;



@Controller
public class ChurchController {

	
	@Autowired
	private ChurchServices churchservices;
	
	@Autowired
	ChurchRepository churchrepository;
	
	
	/*........................................................................................
									MEMBERS
    .........................................................................................*/
	
	@RequestMapping("/")                                   
	private String allMembers(Model model) {
		
	Iterable<Members> members = churchservices.getAllMembers();
	model.addAttribute("AllMembers", members);
		return "index";
		
	}
	
	
	@PostMapping("/add")
	public String addMember( @ModelAttribute("AllMembers") @Valid Members members, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-student";
		}

		
		churchservices.addMember(members);
		return "redirect:index";
	}
	
	
	@PostMapping("update/{id}")
	public String updateStudent(@PathVariable("id") long id, @Valid Members members, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			members.setId(id);
			return "update-student";
		}

		churchrepository.save(members);
		model.addAttribute("AllMembers", churchrepository.findAll());
		return "index";
	}
	
	
	
	@GetMapping("delete/{id}")
	public String deleteStudent(@PathVariable("id") long id, Model model) {
		 Members members = churchrepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		churchrepository.delete(members);
		model.addAttribute("AllMembers", churchrepository.findAll());
		return "index";
	}
	
	
	
	@GetMapping("edit/{id}")
	public String showUpdatesForm(@ModelAttribute("AllMember") @PathVariable("id") long id, Model model) {
		Members members = churchrepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("AllMember", members);
		return "update-student";
	}
	
	@GetMapping("signup")
	public String showSignUpForm(@ModelAttribute("AllMembers") Members members) {
		return "add-student";
	}
	
	@PostMapping("/adding")
	public String addStudent(@Valid Members members, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-student";
		}

		churchservices.addMember(members);
		return "redirect:index";
		}
	}

	
	
	
	//}

