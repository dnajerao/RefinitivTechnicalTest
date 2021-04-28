package com.dnajerao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.dnajerao.dto.NewAccountDTO;
import com.dnajerao.dto.RemoveAccountDTO;
import com.dnajerao.models.Account;
import com.dnajerao.models.User;
import com.dnajerao.repository.AccountRepository;
import com.dnajerao.repository.UserRepository;

@Service
public class ApiServiceImpl implements ApiService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<User> getUserList() {
		return userRepository.findAll();
	}

	@Override
	public List<Account> getAccountList() {
		return accountRepository.findAll();
	}

	@Override
	public User getUserById(int userId) throws ResponseStatusException {

		Optional<User> user = userRepository.findById(userId);

		if (!user.isPresent())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");

		return user.get();
	}

	@Override
	public Account getAccountById(int accountId) throws ResponseStatusException {
		Optional<Account> account = accountRepository.findById(accountId);

		if (!account.isPresent())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found");

		return account.get();
	}

	@Override
	public User addAccountToUser(NewAccountDTO accountDTO) throws ResponseStatusException {

		Optional<User> user = userRepository.findById(accountDTO.getUserId());
		if (!user.isPresent())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");

		accountRepository
				.saveAndFlush(new Account(accountDTO.getAccountName(), accountDTO.getAccountCurrency(), user.get()));

		return user.get();
	}

	@Override
	public User removeAccountToUser(RemoveAccountDTO removeDTO) throws ResponseStatusException {

		Optional<User> user = userRepository.findById(removeDTO.getUserId());
		if (!user.isPresent())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");

		Optional<Account> account = accountRepository.findById(removeDTO.getAccountId());
		if (!account.isPresent())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found");

		if (user.get().getUserId() != account.get().getUser().getUserId())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Account %d not belong user %d",
					account.get().getAccountId(), user.get().getUserId()));

		accountRepository.delete(account.get());

		return user.get();

	}

}
