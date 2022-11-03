package controller;



import dto.Wallet;
import exception.AlreadyExistingAccountNumberException;
import exception.InsufficeintAmountException;
import exception.WalletException;
import service.WalletService;
import service.WalletServiceImpl;


import java.util.Scanner;


public class Controller {

	public static void main(String[] args) throws WalletException, InsufficeintAmountException {
		Scanner sc = new Scanner(System.in);

		WalletService ws = new WalletServiceImpl();


		System.out.println(" 1. Login , 2. Register");
		int choice = sc.nextInt();
		if (choice == 1) {
			Integer d;
			String a;
			boolean b;

			System.out.println("Enter Account number : ");
			d = (sc.nextInt());
			sc.nextLine();
			System.out.println("Enter User Password : ");
			a = sc.nextLine();
			b = ws.login(d, a);
			System.out.println(b);

			System.out.println("Login Successfully ");

			if (b) {
				System.out.println("1. Add Fund , 2. ShowBalance , 3. FundTransfer ,  4. Withdraw , 5. UnRegister ");
				int ch = sc.nextInt();
				if (ch == 1) {
					Integer dd;
					Double f;
					System.out.println("Enter Account number : ");
					dd = (sc.nextInt());
					System.out.println("Enter initial amount : ");
					f = sc.nextDouble();
					System.out.println("current Balance after Add Fund:"+ws.addFundsToWallet(dd, f));


				} else if (ch == 2) {
					Integer d1;

					System.out.println("Enter Account number : ");
					d1 = (sc.nextInt());


					System.out.println(ws.showWalletBalance(d1));


				} else if (ch == 3) {
					Integer ddd;
					Integer c1;
					Double f1;
					System.out.println("Enter From Account number : ");
					ddd = (sc.nextInt());
					System.out.println("Enter To Account number : ");
					c1 = (sc.nextInt());
					System.out.println("Enter Transfer amount : ");
					f1 = sc.nextDouble();
					System.out.println("current Balance after Transfer: "+ws.fundTransfer(ddd, c1, f1));


				} else if (ch == 4) {
					Integer ddd3;
					Double f2;

					System.out.println("Enter Account number : ");
					ddd3 = (sc.nextInt());
					System.out.println("Enter Amount : ");
					f2 = sc.nextDouble();

					System.out.println("current Balance after Withdraw: "+ws.withdraw(ddd3, f2));

				}else if (ch == 5) {
					Integer dddc;
					String ad1;

					System.out.println("Enter Account number : ");
					dddc = (sc.nextInt());
					sc.nextLine();
					System.out.println("Enter User Password : ");
					ad1 = sc.nextLine();

					System.out.println(ws.unRegisterWallet(dddc, ad1));

				}




			} else {
				System.out.println("do Registration");
			}
		}
				else if (choice == 2) {

				try {
					Wallet account = new Wallet();
					System.out.println("Enter Account number : ");
					account.setId(sc.nextInt());
					sc.nextLine();
					System.out.println("Enter Account owner's name : ");
					account.setName(sc.nextLine());
					System.out.println("Enter initial amount : ");
					account.setBalance(sc.nextDouble());
					sc.nextLine();
					System.out.println("Enter Account Password : ");
					account.setPassword(sc.nextLine());

					ws.registerWallet(account);

				} catch (WalletException e) {
					e.printStackTrace();
				} catch (InsufficeintAmountException e) {
					e.printStackTrace();
				} catch (AlreadyExistingAccountNumberException e) {
					e.printStackTrace();

				}


			}


		}
	}


