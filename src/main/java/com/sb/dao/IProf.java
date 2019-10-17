package com.sb.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sb.domain.Prof;

@Repository
public interface IProf extends CrudRepository<Prof, Integer>{

}
