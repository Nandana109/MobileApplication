package com.capgemini.service;
	import java.sql.ResultSet;
	import com.capgemini.bean.TransactionBean;
	import com.capgemini.dao.AccountNotFoundException;
	import com.capgemini.dao.TransactionDAO;

	public class TransactionService {

		@SuppressWarnings("unused")
		public ResultSet searchAccount(String accountId) throws AccountNotFoundException, Exception {
			TransactionDAO daoclass = new TransactionDAO();
			ResultSet accResult;
			return accResult = daoclass.searchAccount(accountId);

		}

		@SuppressWarnings("unused")
		public int deposit(String accountNumber, int amount) {
			TransactionDAO daoclass = new TransactionDAO();
			int update;
			try {
				update = TransactionDAO.deposit(accountNumber, amount);
				return update;
			} catch (Exception ex) {
				System.out.println(ex.toString());
				return 0;
			}
		}

		
		
		public int addValues(String AccountNumber, int Amount, String ChequeNumber, String IFSC, String ChequeIssueDate, String BankName
				, String PayeeNumber, String BeneficiaryNumber,int balance) throws Exception {
			// TODO Auto-generated method stub
			TransactionDAO daoclass = new TransactionDAO();
			new TransactionBean(AccountNumber, Amount,ChequeNumber,IFSC,ChequeIssueDate,BankName,PayeeNumber,BeneficiaryNumber,balance);
			return daoclass.addValues(AccountNumber,Amount,ChequeNumber,IFSC,ChequeIssueDate,BankName,PayeeNumber,BeneficiaryNumber,balance);

		}
			

	}

