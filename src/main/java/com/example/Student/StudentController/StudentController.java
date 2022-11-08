package com.example.Student.StudentController;

import com.example.Student.Model.Student;
import com.example.Student.StudentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    // for displaying home page
    @GetMapping("/home")
    public String HomePage(Model model) {

        return findPaginated(1,model);

    }

    // for showing new form
    @GetMapping("/show_new_form")
    public String ShowNewForm(Model model) {
        Student std = new Student();
        model.addAttribute("std", std);
        return "save";
    }

    // for saving data
    @PostMapping("/save_student")
    public String SaveStudent(@ModelAttribute("std") Student std) {
        studentService.SaveStudentData(std);
        return "redirect:/home";
    }

    @GetMapping("/update_form/{id}")
    public String UpdateStudent(@PathVariable(value = "id") Long id, Model model) {

        // getting student using id
        Student std = studentService.GetStudentByID(id);
        // sending for saving
        model.addAttribute("std", std);
        return "update_student";
    }

    @RequestMapping("/delete_student/{id}")
    public String RemoveStudent(@PathVariable Long id) {
        studentService.DeleteStudentByID(id);
        return "redirect:/home";
    }

    @RequestMapping("/sign")
    public String LoginPage() {
        return "sign";
    }

   // @RequestMapping("/logout")
   // public String LogOutPage() {
     //   return "redirect:/sign";
    //}
   @GetMapping("/page/{pageNo}")
   public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
       int pageSize = 4;
       Page< Student > page= studentService.findPaginated(pageNo,pageSize);
       List <Student> listStudent=page.getContent();  // gives the list of paginated student
       model.addAttribute("currentPage", pageNo);
       model.addAttribute("totalPages", page.getTotalPages());
       model.addAttribute("totalItems", page.getTotalElements());
       model.addAttribute("student", listStudent);
       return "home";
   }
   }