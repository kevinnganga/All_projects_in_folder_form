package com.church.church.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.church.church.Repositories.ChurchRepository;
import com.church.church.entities.Members;

@Service
public class ChurchServices {
	
	@Autowired
	private ChurchRepository churchRepository;
	
	
	public Iterable<Members> getAllMembers() {
		
		return churchRepository.findAll();
	}
	
	
	public Optional<Members> getOneMember(Long id) {
		return churchRepository.findById(id);
	}

	
	public Members addMember(Members members) {
		return churchRepository.save(members);
	}
	
	public Members Updating(String id, Members members) {
		return churchRepository.save(members);
	}
}
