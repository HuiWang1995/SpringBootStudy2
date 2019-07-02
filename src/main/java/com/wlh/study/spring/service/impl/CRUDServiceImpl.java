package com.wlh.study.spring.service.impl;

import com.wlh.study.spring.dao.StudyResposity;
import com.wlh.study.spring.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CRUDServiceImpl implements CRUDService {
    @Autowired
    private StudyResposity studyResposity;
    @Override
    public String getAll() {
        return studyResposity.findAll().toString();
    }
}
