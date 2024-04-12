package com.inventiv.crudCase.service.impl;

import com.inventiv.crudCase.dto.CaseDto;
import com.inventiv.crudCase.dto.CaseToSaveDto;
import com.inventiv.crudCase.dto.CaseToUpdateDto;
import com.inventiv.crudCase.entity.CaseEntity;
import com.inventiv.crudCase.exception.CaseAlreadyExistException;
import com.inventiv.crudCase.exception.CaseNotFoundException;
import com.inventiv.crudCase.mapper.EntityMapper;
import com.inventiv.crudCase.repository.CaseRepository;
import com.inventiv.crudCase.service.CaseService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CaseServiceImpl implements CaseService {

    CaseRepository caseRepository;
    EntityMapper mapper;


    public CaseServiceImpl(CaseRepository repository,EntityMapper mapper) {
        this.caseRepository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<CaseDto> getByTitle(String title) {
        return Optional.ofNullable(mapper.CaseToCaseDto(caseRepository.findOneByTitleIgnoreCase(title).orElseThrow(() -> new CaseNotFoundException(title))));
    }

    @Override
    public CaseDto updateCase(String title, CaseToUpdateDto caseToUpdateDto) {

        CaseEntity caseToUpdate = caseRepository.findOneByTitleIgnoreCase(title).orElseThrow(() -> new CaseNotFoundException(title));

        caseToUpdate.setDescription(caseToUpdateDto.getDescription());
        caseToUpdate.setLastUpdateDate(LocalDateTime.now());
        caseRepository.save(caseToUpdate);

        return mapper.CaseToCaseDto(caseToUpdate);
    }

    @Override
    public CaseDto createCase(CaseToSaveDto caseToSaveDto) {

        if(caseRepository.findOneByTitleIgnoreCase(caseToSaveDto.getTitle()).isPresent()){
            throw new CaseAlreadyExistException(caseToSaveDto.getTitle());
        }

        CaseEntity caseEntity = mapper.CaseToSaveDtoToCase(caseToSaveDto);
        LocalDateTime timeSave = LocalDateTime.now();
        caseEntity.setCreationDate(timeSave);
        caseEntity.setLastUpdateDate(timeSave);
        caseRepository.save(caseEntity);

        return mapper.CaseToCaseDto(caseEntity);
    }

    @Override
    public void deleteCase(String title) {

        CaseEntity caseToDelete = caseRepository.findOneByTitleIgnoreCase(title).orElseThrow(() -> new CaseNotFoundException(title));
        caseRepository.delete(caseToDelete);

    }
}
