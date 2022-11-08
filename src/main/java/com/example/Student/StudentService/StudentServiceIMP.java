package com.example.Student.StudentService;

import com.example.Student.Model.Student;
import com.example.Student.StudentRepository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceIMP implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> GetStudentData() {
        return studentRepository.findAll();
    }

    @Override
    public void SaveStudentData(Student std) {
        studentRepository.save(std);
    }

    @Override
    public Student GetStudentByID(Long id) {
        Optional<Student> optional=studentRepository.findById(id);
        Student std=null;
        if(optional.isPresent()){
            std=optional.get();
        }
        else {
            throw  new RuntimeException("Student Not fond for the id ::" +id);
        }
        return  std;
    }

    @Override
    public void DeleteStudentByID(Long id) {
      studentRepository.deleteById(id);
    }

    @Override
    public Page<Student> findPaginated(int pageNo, int pageSize) {
        Pageable pageable= PageRequest.of( pageNo - 1, pageSize);
        return this.studentRepository.findAll(pageable);
    }


}
