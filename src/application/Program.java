/*Fazer um programa para ler os dados de uma conta bancária e depois realizar um
saque nesta conta bancária, mostrando o novo saldo. Um saque não pode ocorrer
ou se não houver saldo na conta, ou se o valor do saque for superior ao limite de
saque da conta. Implemente a conta bancária conforme projeto abaixo:*/

package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter account data");
		System.out.println("Number: ");
		int number = sc.nextInt();
		System.out.println("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.println("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.println("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();

		Account acc = new Account(number, holder, balance, withdrawLimit);

		System.out.println();
		System.out.println("Enter amount for withdraw: ");
		double amount = sc.nextDouble();

		if (amount > acc.getWithDrawLimit()) {
			System.out.println("Withdraw error: The amount exceeds withdraw limit");
		}
		else if (amount > acc.getBalance()){
			System.out.println("Withdraw error: Not enough balance");
		}
		else {
			acc.withDraw(amount);
			System.out.printf("New balance: " + String.format("%.2f", acc.getBalance()));
		}

		sc.close();
	}

}
