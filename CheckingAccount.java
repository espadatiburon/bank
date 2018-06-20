import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class CheckingAccount extends BankAccount
{
	Scanner sc = new Scanner(System.in);
	double input; 
	SavingsAccount mySavings;
	
	public CheckingAccount(int num, String name, double balance)
	{
		super(num, name, balance);
	}
	
	public CheckingAccount(int num, String name, double balance, SavingsAccount saveAcc)
	{
		super(num, name, balance);
		mySavings = saveAcc;
	}
	
	void withdraw() throws InsufficientFundsException
	{
		System.out.print("Please enter an amount to withdraw: ");
		input = sc.nextDouble();
		try{
			if(balance >= input)
			{
				balance -= input;
			}
			else if((mySavings != null)&&(mySavings.getBalance() + super.getBalance() > input))
			{
				super.balance = 0;
				mySavings.withdraw(input - super.getBalance());
			}
			else
			{
				throw new InsufficientFundsException();
			}
		} catch(InsufficientFundsException ex)
		{
			System.out.println("You do not have sufficient funds to do that!");
		}
	}	
	
	public void addSavings(SavingsAccount addSave)
	{
		mySavings = addSave;
	}
}