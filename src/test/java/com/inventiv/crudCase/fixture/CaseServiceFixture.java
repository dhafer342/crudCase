package com.inventiv.crudCase.fixture;

import com.inventiv.crudCase.dto.CaseToSaveDto;
import com.inventiv.crudCase.entity.CaseEntity;

import java.time.LocalDateTime;

public class CaseServiceFixture {

    public static CaseEntity E01 = new CaseEntity(LocalDateTime.now(),LocalDateTime.now(),"E01","first case");
    public static CaseToSaveDto E01ToSave = new CaseToSaveDto("E01","first case");

}
