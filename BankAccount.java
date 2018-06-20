import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public abstract class BankAccount
{
	Scanner sc = new Scanner(System.in);
	double input;
	int accountNo = 0;
	String owner = "";
	double balance = 0;
	
	public BankAccount(int number, String name, double bal)
	{
		accountNo = number;
		owner = name;
		balance = bal;
	}
	
	public void deposit()
	{
		System.out.print("Please enter an amount to deposit: ");
		input = sc.nextDouble();
		balance += input;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	abstract void withdraw() throws InsufficientFundsException;
	
}