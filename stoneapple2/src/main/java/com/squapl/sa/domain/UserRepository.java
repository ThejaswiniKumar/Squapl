package com.squapl.sa.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
	
	@Query("SELECT t.username FROM User t where t.id = :id")
	User findByUsername(String username);
	
	User findByEmail(String email);
	

	

}
