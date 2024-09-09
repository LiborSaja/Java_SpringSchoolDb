package cz.vsb.magistri.mapper;

import cz.vsb.magistri.DTO.GradeDTO;
import cz.vsb.magistri.entity.GradeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {StudentMapper.class, SubjectMapper.class})
public interface GradeMapper {
    GradeEntity toEntity(GradeDTO gradeDTO);
    @Mapping(target = "studentId", source = "student.id")
    @Mapping(target = "subjectId", source = "subject.id")
    GradeDTO toDTO(GradeEntity gradeEntity);

    GradeEntity updateEntity(GradeDTO gradeDTO, @MappingTarget GradeEntity gradeEntity);
}
