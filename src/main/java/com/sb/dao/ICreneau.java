package com.sb.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sb.domain.Creneau;

@Repository
public interface ICreneau extends CrudRepository<Creneau, Integer>{

}
