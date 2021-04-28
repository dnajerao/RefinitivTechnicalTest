DROP TABLE IF EXISTS account CASCADE;

DROP TABLE IF EXISTS user CASCADE;

CREATE TABLE user (
	userId INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(100) NOT NULL
);

CREATE TABLE account (
	accountId INT AUTO_INCREMENT PRIMARY KEY,
	user INT NOT NULL,
	accountName VARCHAR(100) NOT NULL,
	accountCurrency VARCHAR(10) NOT NULL
);

ALTER TABLE account
ADD CONSTRAINT FK_user
FOREIGN KEY (user) REFERENCES user(userId);

INSERT INTO user (name) VALUES
	('Diego Najera'),
	('Carmen Ortiz');

INSERT INTO account (user, accountName, accountCurrency) VALUES
	(1, 'Account in MXN', 'MXN'),
	(1, 'Account in USD', 'USD'),
	(2, 'Account in MXN', 'MXN'),
	(2, 'Account in MXN', 'MXN');