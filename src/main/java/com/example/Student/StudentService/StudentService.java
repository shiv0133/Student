package com.example.Student.StudentService;

import com.example.Student.Model.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {

    //1. method for getting student list
    public List<Student> GetStudentData();

    //2. for saving data
    public void SaveStudentData(Student std);

    // 3.for updating data

    public Student GetStudentByID(Long id);
    
    // 4.for deleting student data
    public void DeleteStudentByID(Long id);

    // for pagination...................
    Page<Student> findPaginated(int pageNo, int pageSize);
}
