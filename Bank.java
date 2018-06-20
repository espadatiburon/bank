import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Bank
{
	Scanner sc = new Scanner(System.in);
	int input;
	int custNum = 0;
	BankAccount accountList[] = new BankAccount[10];
	Customer customerList[] = new Customer[5];
	
	private static Bank instance = null;
	private Bank()
	{}
	public static Bank getInstance()
	{
		if(instance == null) 
		{
			instance = new Bank();
		}
		return instance;
	}
	
	public void addCustomer()
	{
		int i;
		int temp = (int)(Math.random()*100 + 1);
		Customer tempCust = new Customer(temp);
		for(i = 0; i < 5; i++)
		{
			if(customerList[i] == null)
			{
				customerList[i] = tempCust;
				custNum = i;
				break;
			}
		}
		if((i == 5)&&(customerList[4] != tempCust))
		{
			System.out.println("You have reached the max amount of customers!");
		}
	}
	
	public void addAccount()
	{
		int myInput;
		System.out.print("Would you like to add a savings or checking account?(0 for savings/1 for checking): ");
		myInput = sc.nextInt();
		if(myInput == 0)
		{
			customerList[custNum].addSavingsAccount();
			accountList[((custNum + 1)*2) - 1] = customerList[custNum].getSavings();
		}
		else if(myInput == 1)
		{
			customerList[custNum].addCheckingAccount();
			accountList[((custNum+1)*2) - 2] = customerList[custNum].getChecking();
		}
	}
	
	public Customer getCustomer()
	{
		return customerList[custNum];
	}
	
	public static void main(String [] args)
	{
		Bank myBank = new Bank();
		myBank.addCustomer();
		myBank.addAccount();
		myBank.getCustomer().sDeposit();
		myBank.getCustomer().sWithdraw();
		System.out.print("Your Savings balance: " + myBank.getCustomer().getSavings().getBalance());
		System.out.println();
		myBank.addAccount();
		myBank.getCustomer().cDeposit();
		myBank.getCustomer().cWithdraw();
		System.out.print("Your Checking balance: " + myBank.getCustomer().getChecking().getBalance());
	}
}