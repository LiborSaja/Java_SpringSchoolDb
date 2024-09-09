package cz.vsb.magistri.controller;

import cz.vsb.magistri.DTO.GradeDTO;
import cz.vsb.magistri.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GradeController {
    @Autowired
    GradeService gradeService;

    @PostMapping({"/grades", "/grades/"})
    public GradeDTO addGrade(@RequestBody GradeDTO gradeDTO){
        return gradeService.addGrade(gradeDTO);
    }

    @GetMapping({"/grades", "/grades/"})
    public List<GradeDTO> getAllGrades(){
        return gradeService.getAllGrades();
    }

    @GetMapping({"/grades/{gradeId}", "/grades/{gradeId}/"})
    public  GradeDTO getGradeById(@PathVariable int gradeId){
        return gradeService.getGrade(gradeId);
    }

    @PutMapping({"/grades/{gradeId}", "/grades/{gradeId}/"})
    public GradeDTO editGrade(@PathVariable("gradeId") int id, @RequestBody GradeDTO gradeDTO){
    return  gradeService.editGrade(id, gradeDTO);
    }

    @DeleteMapping({"/grades/{gradeId}", "/grades/{gradeId}/"})
    public GradeDTO deleteGrade(@PathVariable int gradeId){
        return gradeService.deleteGrade(gradeId);
    }
}
