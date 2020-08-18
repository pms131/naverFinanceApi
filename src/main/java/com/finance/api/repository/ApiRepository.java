package com.finance.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finance.api.model.FinanceDto;

@Repository
public interface ApiRepository extends JpaRepository<FinanceDto, String> {
}
