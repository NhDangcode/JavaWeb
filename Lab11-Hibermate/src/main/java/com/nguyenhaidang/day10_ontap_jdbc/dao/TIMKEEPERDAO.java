package com.nguyenhaidang.day10_ontap_jdbc.dao;

import com.nguyenhaidang.day10_ontap_jdbc.entity.SALARY_GRADE;
import com.nguyenhaidang.day10_ontap_jdbc.entity.TIMEKEEPEREntity;

import java.util.List;

public interface TIMKEEPERDAO {
    List<TIMEKEEPEREntity> getAll();
    TIMEKEEPEREntity getTIMEKEEPERByid( String id);
    Boolean insertTIMEKEEPER(TIMEKEEPEREntity timekeeper);
    Boolean updateTIMEKEEPER(TIMEKEEPEREntity timekeeper);
    Boolean deleteTIMEKEEPERByid(String id );
}
