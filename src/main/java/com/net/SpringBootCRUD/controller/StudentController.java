/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.net.SpringBootCRUD.controller;

import com.net.SpringBootCRUD.model.Student;
import com.net.SpringBootCRUD.model.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Fornias
 */
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Student> listStudents = studentService.listAll();
        model.addAttribute("liststudent", listStudents);
        System.out.println("Get / ");
        return "index";
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("student", new Student());

        return "new";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit");
        Student student = studentService.get(id);
        mav.addObject("student", student);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteStudent(@PathVariable(name = "id") int id) {
        studentService.delete(id);
        return "redirect:/";
    }
}
