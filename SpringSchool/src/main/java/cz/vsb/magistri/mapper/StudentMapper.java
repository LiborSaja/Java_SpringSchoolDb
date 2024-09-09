package cz.vsb.magistri.mapper;

import cz.vsb.magistri.DTO.StudentDTO;
import cz.vsb.magistri.entity.StudentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentEntity toEntity(StudentDTO studentDTO);
    StudentDTO toDTO(StudentEntity studentEntity);
}
