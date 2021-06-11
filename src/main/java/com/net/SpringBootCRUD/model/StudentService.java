 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.net.SpringBootCRUD.model;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fornias
 */
@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public List<Student> listAll() {
        return studentDao.findAll();
    }

    public void save(Student student) {
        studentDao.save(student);
    }

    public Student get(long id) {
        return studentDao.findById(id).get();
    }

    public void delete(long id) {
        studentDao.deleteById(id);
    }
}
