package com.sb.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sb.domain.Matiere;

@Repository
public interface IMatiere extends CrudRepository<Matiere, Integer>{

}
