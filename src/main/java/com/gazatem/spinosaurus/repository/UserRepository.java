package com.gazatem.spinosaurus.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gazatem.spinosaurus.domain.User;


public interface UserRepository extends CrudRepository<User, Long> {
	
	@Query("from User u left join fetch u.roles where u.email = :email")
	User findByEmail(@Param("email") String email);
	
}
