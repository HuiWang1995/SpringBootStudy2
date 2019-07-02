package com.wlh.study.spring.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "study_spring_boot")
@Entity
public class StudySpringBoot implements Serializable {
    @Id
    private String id;
    @Column
    private String createTime;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "StudySpringBoot{" +
                "id='" + id + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
