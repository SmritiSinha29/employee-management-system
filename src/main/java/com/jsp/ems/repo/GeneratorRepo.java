package com.jsp.ems.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.ems.entity.IdGenerator;

public interface GeneratorRepo extends  JpaRepository<IdGenerator, Integer>{

}
