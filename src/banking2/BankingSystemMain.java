package banking2;

import java.util.Scanner;

public class BankingSystemMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		AccountManager handler = 
				new AccountManager();
				
		while(true) {
			handler.showMenu();
			
			int choice = scan.nextInt();
			
			switch(choice) {
			case 1:
				handler.makeAccount(choice);
				break;
			case 2:
				handler.depositMoney();
				break;
			case 3:
				handler.withdrawMoney();
				break;
			case 4:
				handler.showAccInfo();
				break;
			case 5:
				System.out.println("프로그램종료");
				return;
			}
		}
		
	}

}





