package com.capgemini.bean;
import java.io.Serializable;
@SuppressWarnings("serial")
	public class TransactionBean implements Serializable{

		private String AccountNumber;
		private int Amount;
		private String ChequeNumber;
		private String IFSC;
		private String ChequeIssueDate ;
		private String BankName;
		private String PayeeNumber;
		private String BeneficiaryNumber;
		private int balance;
		
		public TransactionBean(String AccountNumber,int Amount, String ChequeNumber, String IFSC, String ChequeIssueDate, String BankName, String PayeeNumber, String BeneficiaryNumber,int balance) {
			super();
			this.AccountNumber = AccountNumber;
			this.Amount = Amount;
			this.ChequeNumber=ChequeNumber;
			this.IFSC = IFSC;
			this.ChequeIssueDate = ChequeIssueDate;
			this.BankName = BankName;
			this.PayeeNumber=PayeeNumber;
			this.BeneficiaryNumber=BeneficiaryNumber;
			this.balance=balance;
		}

		

		public String getAccountNumber() {
			return AccountNumber;
		}

		public void setAccountNumber(String accountNumber) {
			AccountNumber = accountNumber;
		}

		public String getIFSC() {
			return IFSC;
		}

		public void setIFSC(String iFSC) {
			IFSC = iFSC;
		}

		public String getChequeIssueDate() {
			return ChequeIssueDate;
		}

		public void setChequeIssueDate(String chequeIssueDate) {
			ChequeIssueDate = chequeIssueDate;
		}

		public String getBankName() {
			return BankName;
		}

		public void setBankName(String bankName) {
			BankName = bankName;
		}

		public int getAmount() {
			return Amount;
		}

		public void setAmount(int amount) {
			Amount = amount;
		}

		public String getChequeNumber() {
			return ChequeNumber;
		}

		public void setChequeNumber(String chequeNumber) {
			ChequeNumber = chequeNumber;
		}

		public String getPayeeNumber() {
			return PayeeNumber;
		}

		public void setPayeeNumber(String payeeNumber) {
			PayeeNumber = payeeNumber;
		}

		public String getBeneficiaryNumber() {
			return BeneficiaryNumber;
		}

		public void setBeneficiaryNumber(String beneficiaryNumber) {
			BeneficiaryNumber = beneficiaryNumber;
		}



		public int getBalance() {
			return balance;
		}



		public void setBalance(int balance) {
			this.balance = balance;
		}
	}
