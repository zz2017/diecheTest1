package com.dieche.wl.controller;

import com.dieche.wl.model.GlobalRequestResult;
import com.dieche.wl.model.Student;
import com.dieche.wl.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping(value = "/stu")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 新增学生
     * @param student
     * @return
     */
    @RequestMapping(value = "addStudent", method = RequestMethod.POST)
    @ResponseBody
    public GlobalRequestResult addStudent(Student student){
        if(student == null){
            return GlobalRequestResult.wrapErrorResult("传入的参数为空");
        }
        Student s = studentService.saveStudent(student);
        log.info("插入学生表中的数据为：{}", s);
        if(s == null){
            return GlobalRequestResult.wrapErrorResult("添加学生失败");
        }else {
            return GlobalRequestResult.wrapSuccessMsgResult("添加学生成功");
        }
    }
}
