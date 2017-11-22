package com.dieche.wl.service.impl;

import com.dieche.wl.dao.StudentDao;
import com.dieche.wl.model.Student;
import com.dieche.wl.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StduentServiceImpl implements StudentService{
    @Autowired
    private StudentDao studentDao;

    /**
     * 保存学生
     * @param student
     * @return
     */
    @Override
    public Student saveStudent(Student student) {
        return studentDao.save(student);
    }
}
