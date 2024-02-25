package com.sisterslab.customeremployee.repository;

import com.sisterslab.customeremployee.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SchoolRepository extends JpaRepository<School,Long> {
    Optional<School> findBySchoolName(String name);
    List<School> findAllBySchoolName(String name);
    List<School> findBySchoolNameContaining(String name);

}
