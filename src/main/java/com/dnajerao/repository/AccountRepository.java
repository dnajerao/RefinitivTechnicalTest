package com.dnajerao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dnajerao.models.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
