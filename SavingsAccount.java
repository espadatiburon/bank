import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class SavingsAccount extends BankAccount
{
	Scanner sc = new Scanner(System.in);
	double input;
	
	public SavingsAccount(int num, String name, double balance)
	{
		super(num, name, balance);
	}
	
	void withdraw()
	{
		System.out.print("Please enter an amount to withdraw: ");
		input = sc.nextDouble();
		if(balance >= input)
		{
			balance -= input;
		}
		else
		{
			System.out.println("You do not have that much!");
		}
	}	
	
	void withdraw(double withd)
	{
		balance -= withd;
	}
	
}