package com.capgemini.dao;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.Random;
import com.capgemini.dao.AccountNotFoundException;
public class TransactionDAO {
		private static final String AccountNumber = null;
		private static final String IFSC = null;

		public ResultSet searchAccount(String accountId) throws AccountNotFoundException,Exception {
			Connection con = null;
			PreparedStatement pstmt = null;
			con = TransactionDB.getConnection1();
			String ins_str = "select * from account where accountId=?";
			pstmt = con.prepareStatement(ins_str);
			pstmt.setString(1, AccountNumber);
			ResultSet accinfo = pstmt.executeQuery();
			if(accinfo.next())
			return accinfo;
			else{
				throw new AccountNotFoundException("Account not valid");
			}

		}

		static int a1 = 0;
		static int a2 = 0;

		public static int deposit(String accountNumber, int amount) throws Exception {
			Connection con = null;
			PreparedStatement pstmt = null;
			con = TransactionDB.getConnection1();
			pstmt = con.prepareStatement("select balance from account where accountId=?");
			pstmt.setString(1, accountNumber);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()){
				a1 = amount + rs.getInt(1);
			}
			pstmt = con.prepareStatement("update account set balance=? where accountId=?");
			pstmt.setInt(1, a1);
			pstmt.setString(2, accountNumber);
			int update = pstmt.executeUpdate();
			if (update > 0) {

				pstmt = con.prepareStatement("select * from account where accountId=?");
				pstmt.setString(1, accountNumber);
				ResultSet rs1 = pstmt.executeQuery();
				while (rs1.next())
					System.out.println("AccountNumber " + rs1.getString(1) + "\nAmount " + rs1.getInt(2) + "\nChequeNumber"
							+ rs1.getString(3) + "\nIFSC " + rs1.getString(4) + "\nChequeIssueDate" + rs1.getInt(5) + "\nBankName"
							+ rs1.getString(6) +"\n PayeeNumber "+rs1.getString(7)+"\n BeneficiaryNumber "+rs1.getString(8)+"\n balance "+rs1.getInt(9));
			}

			return update;
		}

		
		//static String aid = "9000";
		//static int aid2;

		public int addValues( String AccountNumber, int Amount, String ChequeNumber, String IFSC, String chequeIssueDate, String BankName, String PayeeNumber,String BeneficiaryNumber,int balance) throws Exception {
			Connection con = null;
			int x = Math.abs(new Random().nextInt());
			PreparedStatement pstmt = null;

			con = TransactionDB.getConnection1();
			String ins_str = "insert into account values(?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(ins_str);
			
			pstmt.setString(1, AccountNumber);
			pstmt.setInt(2, Amount);
			pstmt.setString(3, ChequeNumber);
			pstmt.setString(4, IFSC);
			pstmt.setString(5, chequeIssueDate);
			pstmt.setString(6, BankName);
			pstmt.setString(7, PayeeNumber);
			pstmt.setString(8, BeneficiaryNumber);
			pstmt.setInt(9, balance);
			int updateCount = pstmt.executeUpdate();
			con.close();
			return updateCount;

		}

		
	}


