package cz.vsb.magistri.service;

import cz.vsb.magistri.DTO.SubjectDTO;
import cz.vsb.magistri.entity.SubjectEntity;
import cz.vsb.magistri.mapper.SubjectMapper;
import cz.vsb.magistri.repository.SubjectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private SubjectMapper subjectMapper;

    public List<SubjectDTO> getSubjects() {
        List<SubjectEntity> subjectEntities = subjectRepository.findAll();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        for (SubjectEntity subjectEntity : subjectEntities) {
            subjectDTOS.add(subjectMapper.toDTO(subjectEntity));
        }
        return subjectDTOS;
    }

    public SubjectDTO addSubject(SubjectDTO subjectDTO) {
        SubjectEntity subjectEntity = subjectMapper.toEntity(subjectDTO);
        SubjectEntity savedEntity = subjectRepository.save(subjectEntity);
        return subjectMapper.toDTO(savedEntity);
    }

    public SubjectDTO getSubject(Integer id) {
        SubjectEntity subjectEntity = subjectRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        return subjectMapper.toDTO(subjectEntity);
    }

    public SubjectDTO editSubject(Integer id, SubjectDTO subjectDTO) {
        if (!subjectRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }
        SubjectEntity subjectEntity = subjectMapper.toEntity(subjectDTO);
        subjectEntity.setId(id);
        SubjectEntity savedSubject = subjectRepository.save(subjectEntity);
        return subjectMapper.toDTO(savedSubject);
    }

    public SubjectDTO deleteSubject(Integer id) {
        SubjectEntity subjectToDelete = subjectRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        SubjectDTO deletedSubject = subjectMapper.toDTO(subjectToDelete);
        subjectRepository.delete(subjectToDelete);
        return deletedSubject;
    }
}
