package com.church.church.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.church.church.entities.Members;

@Repository
public interface ChurchRepository  extends CrudRepository<Members, Long>{
	List<Members> findByName(String name);

}
