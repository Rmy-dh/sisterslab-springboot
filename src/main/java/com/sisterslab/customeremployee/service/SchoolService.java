package com.sisterslab.customeremployee.service;

import com.sisterslab.customeremployee.converter.SchoolConverter;
import com.sisterslab.customeremployee.dto.request.SchoolRequest;
import com.sisterslab.customeremployee.dto.response.SchoolResponse;
import com.sisterslab.customeremployee.exception.AlreadyExistException;
import com.sisterslab.customeremployee.exception.SchoolNotFoundException;
import com.sisterslab.customeremployee.model.School;
import com.sisterslab.customeremployee.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SchoolService {
    private  final SchoolRepository schoolRepository;

    public SchoolResponse addSchool(SchoolRequest schoolRequest) {
        Optional<School> school=schoolRepository.findBySchoolName(schoolRequest.getSchoolName());
        if(school.isPresent()){
            throw new AlreadyExistException("School is already exist !"+schoolRequest.getSchoolName());
        }
        return SchoolConverter.convertToSchoolResponse(
                schoolRepository.save(SchoolConverter.convertToSchool(schoolRequest)));
    }

    public String deleteById(Long id) {
        schoolRepository.deleteById(id);
        return "School Deleted!";
    }

    public SchoolResponse getSchoolById(Long id) {
        return SchoolConverter.convertToSchoolResponse(findById(id));
    }
    private School findById(Long id){
        return schoolRepository.findById(id).
                orElseThrow(()->new SchoolNotFoundException("School not found!"));
    }

    public String setSchoolNameById(Long id, SchoolRequest schoolRequest) {
        School oldSchool=findById(id);
        oldSchool.setSchoolName(schoolRequest.getSchoolName());
        schoolRepository.save(oldSchool);
        return "Successfully updated!";
    }

    public List<School> getSchoolByName(String name) {
        if(name==null){
            return schoolRepository.findAll();
        }else{
            return schoolRepository.findAllBySchoolName(name);
        }

    }

    public List<SchoolResponse> getAllSchools(String name) {

        return schoolRepository.findBySchoolNameContaining(name)
                .stream()
                .map(SchoolConverter::convertToSchoolResponse)
                .collect(Collectors.toList());
    }


}
