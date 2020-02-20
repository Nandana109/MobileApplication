package com.capgemini.ui;
import java.sql.ResultSet;
	import java.text.SimpleDateFormat;
	import java.time.LocalDate;
	import java.time.ZoneId;
	import java.util.Date;
	import java.util.Scanner;
	import java.util.Timer;
	import java.util.TimerTask;

	import com.capgemini.dao.AccountNotFoundException;
	//import com.capgemini.service.BookService;
	import com.capgemini.service.TransactionService;



	public class TransactionUI {
		static TransactionService accService = new TransactionService();

		@SuppressWarnings("resource")
		public static void main(String[] args) throws Exception {
			String AccountNumber = null;
			int Amount ;
			String ChequeNumber = null;
			String IFSC = "";
			String ChequeIssueDate="";
			String BankName="";
			String PayeeNumber = null;
			String BeneficiaryNumber=null;
			Date date = new Date();
			int balance= 0;
			int a = 0;
			Scanner s = new Scanner(System.in);
			/*System.out.println("enter the balance to deposit");
			balance=s.nextInt();*/
			while (true) {
				System.out.println("enter your choice");
				System.out.println("1.credit using slip "
						+ "2.debit using slip "
						+ "3.debit using cheque "
						+ "4.credit using cheque");
				a = s.nextInt();
				String accountId;

				switch (a) {

		case 1:
					System.out.println("AccountNumber should be 12 digits");
					AccountNumber= s.next();
					while (!(AccountNumber.length()==12 ) ){
						System.out.println("enter 12 digit number");
						AccountNumber = s.next();
					}
					System.out.println("Enter Amount");
					Amount= s.nextInt();
					while(Amount<100 || Amount>200000)
					{
						System.out.println("enter amount between 100 and 200000");
						Amount= s.nextInt();
					}
					balance=balance+Amount;
					System.out.println("Balance is  " +balance);
					
					TransactionService transactionService=new TransactionService();
					int updateCount=transactionService.addValues(AccountNumber,Amount,ChequeNumber,IFSC,ChequeIssueDate,BankName,PayeeNumber,BeneficiaryNumber,balance);
					System.out.println(updateCount);
					break;
		case 2:
					System.out.println("AccountNumber should be 12 digits");
					AccountNumber= s.next();
					
					while (!(AccountNumber.length()==12 )) {
						System.out.println("enter 12 digit number");
						AccountNumber = s.next();
					}
					System.out.println("Enter Amount");
					Amount= s.nextInt();
					if(Amount<100&&Amount>200000)
					{
						System.out.println("enter amount between 100 and 200000");
						Amount=s.nextInt();
					}
					/*balance=3000;*/
					System.out.println("balance amount "+balance);
					if(balance>=Amount)
					{ 
						balance=balance-Amount;
						System.out.println(balance);
					}
					else
					{
						System.out.println("Less Balance..Transaction Failed..");
					}
					//A rg mount=balance;
					TransactionService transactionService1=new TransactionService();
					int updateCount1=transactionService1.addValues(AccountNumber,Amount,ChequeNumber,IFSC,ChequeIssueDate,BankName,PayeeNumber,BeneficiaryNumber,balance);
					System.out.println(updateCount1);
					
					break;
		case 3:
					System.out.println("Enter AccountNumber");
					AccountNumber = s.next();	
					while (!(AccountNumber.length()==12 )) {
						System.out.println("enter 12 digit number");
						AccountNumber = s.next();
					}
					System.out.println("Enter amount");
					Amount = s.nextInt();
					if(Amount<100&&Amount>200000)
					{
						System.out.println("enter amount between 100 and 200000");
					}
					s.nextLine();
					System.out.println("enter ChequeNumber");
					 ChequeNumber=s.next();
					 while(!(ChequeNumber.length()==6)) {
						 System.out.println("enter 6 digit number");
						 ChequeNumber=s.next();
					 }
					 System.out.println("enter IFSC");
					 IFSC=s.next();
					 while(!(IFSC.length()==10)) {
						 System.out.println("enter 10 digits");
						 IFSC=s.next();
					 }
					 System.out.println("enter ChequeIssueDate");
					 ChequeIssueDate=s.next();
					 //balance=3000;
					 if(balance>=Amount)
						{ 
							balance=balance-Amount;
							System.out.println(balance);
						}
						else
						{
							System.out.println("Less Balance..Transaction Failed..");
						}
					 TransactionService transactionService2=new TransactionService();
						int updateCount2=transactionService2.addValues(AccountNumber,Amount,ChequeNumber,IFSC,ChequeIssueDate,BankName,PayeeNumber,BeneficiaryNumber,balance);
						System.out.println(updateCount2);
					break;
		case 4:
					System.out.println("Enter PayeeNumber");
					PayeeNumber=s.next();
					while (!(PayeeNumber.length()==12 )) {
						System.out.println("enter 12 digit number");
						PayeeNumber = s.next();
					}
					System.out.println("Enter BeneficiaryAccountNumber");
					BeneficiaryNumber=s.next();
					while (!(BeneficiaryNumber.length()==12 )) {
						System.out.println("enter 12 digit number");
						BeneficiaryNumber = s.next();
					}
					System.out.println("Enter amount");
					Amount = s.nextInt();
					while(Amount<100&&Amount>200000)
					{
						System.out.println("enter amount between 100 and 200000");
						Amount=s.nextInt();
					}
					System.out.println("enter ChequeNumber");
					 ChequeNumber=s.next();
					 System.out.println("enter bank name");
					 BankName=s.next();
					 System.out.println("enter IFSC");
					 IFSC=s.next();
					 System.out.println("enter ChequeIssueDate");
					 ChequeIssueDate=s.next();
					
					 balance=0;
					 balance=balance+Amount;
						System.out.println("Balance is  " +balance);
						TransactionService transactionService3=new TransactionService();
						int updateCount3=transactionService3.addValues(AccountNumber,Amount,ChequeNumber,IFSC,ChequeIssueDate,BankName,PayeeNumber,BeneficiaryNumber,balance);
						System.out.println(updateCount3);
					 System.exit(0);
				}
			}
		}

	}


