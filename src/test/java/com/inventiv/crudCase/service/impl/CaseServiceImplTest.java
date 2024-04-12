package com.inventiv.crudCase.service.impl;

import com.inventiv.crudCase.dto.CaseDto;
import com.inventiv.crudCase.exception.CaseNotFoundException;
import com.inventiv.crudCase.fixture.CaseServiceFixture;
import com.inventiv.crudCase.mapper.EntityMapper;
import com.inventiv.crudCase.mapper.EntityMapperImpl;
import com.inventiv.crudCase.repository.CaseRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static com.inventiv.crudCase.fixture.CaseServiceFixture.E01;
import static com.inventiv.crudCase.fixture.CaseServiceFixture.E01ToSave;

public class CaseServiceImplTest {

    @Mock
    private CaseRepository caseRepository;
    private EntityMapper mapper;
    private CaseServiceImpl service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mapper = new EntityMapperImpl();
        service = new CaseServiceImpl(caseRepository, mapper);
    }

    @Test
    public void shouldRetrieveCase() {
        //Given
        Mockito.when(caseRepository.findOneByTitleIgnoreCase(E01.getTitle())).thenReturn(Optional.ofNullable(E01));
        //When
        Optional<CaseDto> caseDto = service.getByTitle(E01.getTitle());
        //Then
        Assertions.assertThat(caseDto).isNotEmpty();
        Assertions.assertThat(caseDto.get().getTitle()).isEqualTo("E01");
    }

    @Test
    public void shouldFailToRetriveCase(){
        //Given
        Mockito.when(caseRepository.findOneByTitleIgnoreCase(Mockito.any())).thenReturn(Optional.empty());
        //When /Then
        Exception exception = org.junit.jupiter.api.Assertions.assertThrows(CaseNotFoundException.class,()->{
            service.getByTitle(Mockito.any());
        });
        Assertions.assertThat(exception.getMessage()).isEqualTo("Case with title "+Mockito.any()+" does not exist.");
    }

    @Test
    public void shouldCreateCase(){
        //Given
        Mockito.when(caseRepository.findOneByTitleIgnoreCase(Mockito.any())).thenReturn(Optional.empty());
        Mockito.when(caseRepository.save(E01)).thenReturn(E01);
        //When
        CaseDto casecreated = service.createCase(E01ToSave);
        //Then
        org.junit.jupiter.api.Assertions.assertEquals(casecreated.getTitle(),E01ToSave.getTitle());


    }

    @Test
    public void shouldDeleteCase(){

        //Given
        Mockito.when(caseRepository.findOneByTitleIgnoreCase(Mockito.any())).thenReturn(Optional.ofNullable(CaseServiceFixture.E01));
        //When
        service.deleteCase(Mockito.any());
        //Then
        Mockito.verify(caseRepository,Mockito.times(1)).delete(CaseServiceFixture.E01);

    }

}
