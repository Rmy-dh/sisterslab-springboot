package com.sisterslab.customeremployee.controller;

import com.sisterslab.customeremployee.dto.request.SchoolRequest;
import com.sisterslab.customeremployee.dto.response.SchoolResponse;
import com.sisterslab.customeremployee.model.School;
import com.sisterslab.customeremployee.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;
    @PostMapping
    public SchoolResponse addSchool(@RequestBody SchoolRequest schoolRequest){
        return schoolService.addSchool(schoolRequest);

    }
    @DeleteMapping("/{id}")
    public String deleteSchoolById(@PathVariable Long id){
        return schoolService.deleteById(id);
    }
    @GetMapping("/{id}")
    public SchoolResponse getSchoolById(@PathVariable("id") Long id){
        return schoolService.getSchoolById(id);

    }
    @PutMapping("/{id}")
    public String setSchoolNameById(@PathVariable Long id,@RequestBody SchoolRequest schoolRequest){
        return schoolService.setSchoolNameById(id,schoolRequest);

    }
    @GetMapping
    public List<School> getSchool(@RequestParam(required = false) String name){
        return schoolService.getSchoolByName(name);

    }
    @GetMapping("/list")
    public List<SchoolResponse> getAllSameSchools(@RequestParam String name){
        return schoolService.getAllSchools(name);
    }

}
