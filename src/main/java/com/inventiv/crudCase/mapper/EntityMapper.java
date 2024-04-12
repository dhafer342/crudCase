package com.inventiv.crudCase.mapper;

import com.inventiv.crudCase.dto.CaseDto;
import com.inventiv.crudCase.dto.CaseToSaveDto;
import com.inventiv.crudCase.entity.CaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EntityMapper {

    CaseDto CaseToCaseDto(CaseEntity caseEntity);
    CaseEntity CaseToSaveDtoToCase(CaseToSaveDto caseDto);

}
