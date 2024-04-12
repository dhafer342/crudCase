package com.inventiv.crudCase.repository;

import com.inventiv.crudCase.entity.CaseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface CaseRepository extends CrudRepository<CaseEntity, BigInteger> {

    Optional<CaseEntity> findOneByTitleIgnoreCase(String title);

}
