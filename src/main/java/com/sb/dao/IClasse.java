package com.sb.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sb.domain.Classe;

@Repository
public interface IClasse extends CrudRepository<Classe, Integer>{

}
