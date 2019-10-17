package com.sb.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sb.domain.Room;

@Repository
public interface IRoom extends CrudRepository<Room, Integer>{

}
