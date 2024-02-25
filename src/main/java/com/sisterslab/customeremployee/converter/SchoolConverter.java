package com.sisterslab.customeremployee.converter;

import com.sisterslab.customeremployee.dto.request.SchoolRequest;
import com.sisterslab.customeremployee.dto.response.SchoolResponse;
import com.sisterslab.customeremployee.model.School;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SchoolConverter {
    public static School convertToSchool(SchoolRequest schoolRequest){
        School school=new School();
        school.setSchoolName(schoolRequest.getSchoolName());
        return school;
    }
    public static SchoolResponse convertToSchoolResponse(School school){
        SchoolResponse schoolResponse=new SchoolResponse();
        schoolResponse.setSchoolName(school.getSchoolName());
        schoolResponse.setStartDate(school.getStartDate());
        return schoolResponse;
    }
}
