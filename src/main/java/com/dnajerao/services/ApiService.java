package com.dnajerao.services;

import java.util.List;

import org.springframework.web.server.ResponseStatusException;

import com.dnajerao.dto.NewAccountDTO;
import com.dnajerao.dto.RemoveAccountDTO;
import com.dnajerao.models.Account;
import com.dnajerao.models.User;

public interface ApiService {

	public List<User> getUserList() throws ResponseStatusException;

	public List<Account> getAccountList() throws ResponseStatusException;

	public User getUserById(int userId) throws ResponseStatusException;

	public Account getAccountById(int accountId) throws ResponseStatusException;

	public User addAccountToUser(NewAccountDTO accountDTO) throws ResponseStatusException;

	public User removeAccountToUser(RemoveAccountDTO removeDTO) throws ResponseStatusException;

}