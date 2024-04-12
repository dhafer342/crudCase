package com.inventiv.crudCase.service;

import com.inventiv.crudCase.dto.CaseDto;
import com.inventiv.crudCase.dto.CaseToSaveDto;
import com.inventiv.crudCase.dto.CaseToUpdateDto;

import java.util.Optional;

public interface CaseService {

 Optional<CaseDto> getByTitle(String title);

 CaseDto updateCase(String title, CaseToUpdateDto caseToUpdateDto);

 CaseDto createCase(CaseToSaveDto caseToSaveDto);

 void deleteCase(String title);

}
