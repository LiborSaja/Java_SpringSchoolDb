package cz.vsb.magistri.service;

import cz.vsb.magistri.DTO.GradeDTO;
import cz.vsb.magistri.entity.GradeEntity;
import cz.vsb.magistri.mapper.GradeMapper;
import cz.vsb.magistri.repository.GradeRepository;
import cz.vsb.magistri.repository.StudentRepository;
import cz.vsb.magistri.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GradeService {
    @Autowired
    GradeRepository gradeRepository;
    @Autowired
    GradeMapper gradeMapper;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SubjectRepository subjectRepository;

    public GradeDTO addGrade(GradeDTO gradeDTO){
        GradeEntity gradeToAdd = gradeMapper.toEntity(gradeDTO);
        gradeToAdd.setStudent(studentRepository.getReferenceById(gradeDTO.getStudentId()));
        gradeToAdd.setSubject(subjectRepository.getReferenceById(gradeDTO.getSubjectId()));
        return gradeMapper.toDTO(gradeRepository.save(gradeToAdd));
    }

    public List<GradeDTO> getAllGrades(){
        List<GradeDTO> allGrades = new ArrayList<>();
        for (GradeEntity gradeEntity : gradeRepository.findAll()){
//            GradeDTO gradeDTO = new GradeDTO();
//            gradeDTO.setStudentDTO(studentRepository.getReferenceById());
            allGrades.add(gradeMapper.toDTO(gradeEntity));
        }
        return allGrades;
    }

    public GradeDTO getGrade(int gradeId){
        return gradeMapper.toDTO(gradeRepository.getReferenceById(gradeId));
    }

    public  GradeDTO editGrade(int gradeId, GradeDTO gradeDTO) {
        gradeDTO.setId(gradeId);
        GradeEntity gradeEntity = gradeRepository.getReferenceById(gradeId);
        gradeMapper.updateEntity(gradeDTO, gradeEntity);
        gradeEntity.setSubject(subjectRepository.getReferenceById(gradeDTO.getSubjectId()));
        gradeEntity.setStudent(studentRepository.getReferenceById(gradeDTO.getStudentId()));
        return gradeMapper.toDTO(gradeRepository.save(gradeEntity));
    }

    public GradeDTO deleteGrade(int gradeId){
        GradeEntity gradeEntity = gradeRepository.getReferenceById(gradeId);
        GradeDTO deleteGrade = gradeMapper.toDTO((gradeEntity));
        gradeRepository.delete(gradeEntity);
        return deleteGrade;
    }
}
