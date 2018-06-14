package com.kyung.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kyung.dto.Meeting;

public interface MeetingRepository extends JpaRepository<Meeting, Integer> {

	Meeting findOneById(int id);

	@Modifying
	@Query("UPDATE Meeting m SET name = :name WHERE id = :id")
	void updateName(@Param("id") int id, @Param("name") String name);

}