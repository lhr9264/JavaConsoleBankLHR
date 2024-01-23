package banking4;

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
			default :
				System.out.println("메뉴 입력 예외 발생됨");
				System.out.println("메뉴는 1~5사이의 정수를 입력하세요");
			}
			
		}
		
	}

}





