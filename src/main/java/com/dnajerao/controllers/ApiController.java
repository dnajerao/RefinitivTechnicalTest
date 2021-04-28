package com.dnajerao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dnajerao.dto.NewAccountDTO;
import com.dnajerao.dto.RemoveAccountDTO;
import com.dnajerao.models.Account;
import com.dnajerao.models.User;
import com.dnajerao.services.ApiService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "API")
@RestController
@RequestMapping(path = "/api")
public class ApiController {

	@Autowired
	private ApiService apiService;

	@RequestMapping(method = RequestMethod.GET, path = "/getUserList")
	@ApiOperation(httpMethod = "GET", value = "Get all users with accounts list")
	public List<User> getUserList() throws ResponseStatusException {
		return apiService.getUserList();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/getAccountList")
	@ApiOperation(httpMethod = "GET", value = "Get all accounts")
	public List<Account> getAccountList() throws ResponseStatusException {
		return apiService.getAccountList();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/getUserById/{userId}")
	@ApiOperation(httpMethod = "GET", value = "Get user by Id")
	public User getUserById(@PathVariable int userId) throws ResponseStatusException {
		return apiService.getUserById(userId);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/getAccountById/{accountId}")
	@ApiOperation(httpMethod = "GET", value = "Get account by Id")
	public Account getAccountById(@PathVariable int accountId) throws ResponseStatusException {
		return apiService.getAccountById(accountId);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/addAccountToUser")
	@ApiOperation(httpMethod = "POST", value = "Add account to an existing user")
	public User addAccountToUser(@RequestBody NewAccountDTO accountDTO) throws ResponseStatusException {
		return apiService.addAccountToUser(accountDTO);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/removeAccountToUser")
	@ApiOperation(httpMethod = "DELETE", value = "Remove account to an existing user")
	public User removeAccountFromUser(@RequestBody RemoveAccountDTO removeDTO) throws ResponseStatusException {
		return apiService.removeAccountToUser(removeDTO);
	}

}