package cz.vsb.magistri.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradeDTO {
    private Integer id;
    private StudentDTO studentDTO;
    private SubjectDTO subjectDTO;
    private Integer studentId;
    private Integer subjectId;
    private String topic;
    private int mark;
}
