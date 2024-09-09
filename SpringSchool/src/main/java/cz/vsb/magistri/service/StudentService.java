package cz.vsb.magistri.service;

import cz.vsb.magistri.DTO.StudentDTO;
import cz.vsb.magistri.entity.StudentEntity;
import cz.vsb.magistri.mapper.StudentMapper;
import cz.vsb.magistri.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;

    public List<StudentDTO> getStudents() {
        List<StudentEntity> studentEntities = studentRepository.findAll();
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (StudentEntity studentEntity : studentEntities) {
            studentDTOS.add(studentMapper.toDTO(studentEntity));
        }
        return studentDTOS;
    }

    public StudentDTO addStudent(StudentDTO studentDTO) {
        StudentEntity studentEntity = studentMapper.toEntity(studentDTO);
        StudentEntity savedEntity = studentRepository.save(studentEntity);
        return studentMapper.toDTO(savedEntity);
    }

    public StudentDTO getStudent(Integer id) {
        StudentEntity studentEntity = studentRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        //if(!studentRepository.existsById(id)){
        //    throw new EntityNotFoundException();
        //}
        //StudentEntity studentEntity = studentRepository.getReferenceById(id);
        return studentMapper.toDTO(studentEntity);
    }

    public StudentDTO editStudent(Integer id, StudentDTO studentDTO) {
//        StudentEntity studentToEdit = studentRepository
//                .findById(id)
//                .orElseThrow(EntityNotFoundException::new);
        if (!studentRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }
        StudentEntity studentEntity = studentMapper.toEntity(studentDTO);
        studentEntity.setId(id);
        StudentEntity savedStudent = studentRepository.save(studentEntity);
        return studentMapper.toDTO(savedStudent);
    }

    public StudentDTO deleteStudent(Integer id) {
        StudentEntity studentToDelete = studentRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        StudentDTO deletedStudent = studentMapper.toDTO(studentToDelete);
        studentRepository.delete(studentToDelete);
        return deletedStudent;
    }
}
