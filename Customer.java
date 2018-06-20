import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Customer
{
	Scanner sc = new Scanner(System.in);
	int id;
	String name; 
	SavingsAccount savingsAcct;
	CheckingAccount checkingAcct;
	int temp;
	
	public Customer(int identity)
	{
		id = identity;
		System.out.print("Please enter your name: ");
		name = sc.nextLine();
	}
	
	public void addSavingsAccount()
	{
		if(savingsAcct == null)
		{
			savingsAcct = new SavingsAccount(id, name, 0);
			if(checkingAcct != null)
			{
				checkingAcct.addSavings(savingsAcct);
			}
		}
		else
		{
			System.out.println("You already have a savings account!");
		}
	}
	
	public void addCheckingAccount()
	{
		if(checkingAcct == null)
		{
			if(savingsAcct != null)
			{
				checkingAcct = new CheckingAccount(id, name, 0, savingsAcct);
			}
			else
			{
				checkingAcct = new CheckingAccount(id, name, 0);
			}
		}
		else
		{
			System.out.println("You already have a checking account!");
		}
	}
	
	public SavingsAccount getSavings()
	{
		if(savingsAcct != null)
		{
			return savingsAcct;
		}
		return null;
	}
	
	public CheckingAccount getChecking()
	{
		if(checkingAcct != null)
		{
			return checkingAcct;
		}
		return null;
	}
	
	public void sDeposit()
	{
		if(savingsAcct != null)
		{
			savingsAcct.deposit();
		}
	}

	public void sWithdraw()
	{
		if(savingsAcct != null)
		{
			savingsAcct.withdraw();
		}
	}

	public void cDeposit()
	{
		if(checkingAcct != null)
		{
			checkingAcct.deposit();
		}
	}
	
	public void cWithdraw()
	{
		if(checkingAcct != null)
		{
			try
			{
				checkingAcct.withdraw();
			}
			catch(InsufficientFundsException ex)
			{
				System.out.println("You do not have sufficient funds for that!");
			}
		}
	}
}