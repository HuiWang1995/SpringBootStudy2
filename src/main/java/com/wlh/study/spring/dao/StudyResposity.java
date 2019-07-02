package com.wlh.study.spring.dao;

import com.wlh.study.spring.pojo.StudySpringBoot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
//@Component
public interface StudyResposity extends JpaRepository<StudySpringBoot, String> {
}
