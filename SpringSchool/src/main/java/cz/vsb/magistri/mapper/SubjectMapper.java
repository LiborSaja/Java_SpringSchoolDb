package cz.vsb.magistri.mapper;

import cz.vsb.magistri.DTO.SubjectDTO;
import cz.vsb.magistri.entity.SubjectEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    SubjectEntity toEntity(SubjectDTO subjectDTO);
    SubjectDTO toDTO(SubjectEntity subjectEntity);
}
