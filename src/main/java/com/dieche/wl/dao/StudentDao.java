package com.dieche.wl.dao;

import com.dieche.wl.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<Student, Long>{
    /**
     * 保存学生的信息
     * @param s
     * @param <S>
     * @return
     */
    @Override
    <S extends Student> S save(S s);
}
