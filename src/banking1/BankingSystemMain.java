package banking1;

import java.util.ArrayList;
import java.util.Scanner;

class Account {
	String accinfo;
	String name;
	int money;
	public Account(String accinfo, String name, int money) {
		this.accinfo = accinfo;
		this.name = name;
		this.money = money;
	}
	public void showAccInfo() {
		System.out.println("***계좌정보 출력***");
		System.out.println("-----------------");
		System.out.println();
		System.out.println("계좌번호:"+ accinfo);
		System.out.println("고객이름:"+ name);
		System.out.println("잔고:"+ money);
		System.out.println();
		System.out.println("-----------------");
	}
	public void deposit(int amount) {
		this.money += amount;
	}
	public void withdraw(int amount) {
		this.money -= amount;
	}
}


public class BankingSystemMain {

	public static void showMenu() {
		System.out.println("-----Menu-----");
		System.out.println("1.계좌개설");
		System.out.println("2.입  금");
		System.out.println("3.출  금");
		System.out.println("4.계좌정보출력");
		System.out.println("5.프로그램종료");
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		AccountManager handler = 
				new AccountManager(100);
		
		while(true) {
			showMenu();
			
			int choice = scan.nextInt();
			
			switch(choice) {
			case 1:
				handler.makeAccount();
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
		
	}////main 끝
	

}////class 끝

class AccountManager {
	ArrayList<Account> lists;
	
	static Account[] accounts = new Account[50];
	
	public AccountManager(int num) {
		lists = new ArrayList<Account>();
	}
	
	public void makeAccount() {
		Scanner scan = new Scanner(System.in);
		String bAcc,bName;
		int bMoney;
		System.out.println("***신규계좌개설***");
		System.out.print("계좌번호:");bAcc = scan.nextLine();
		System.out.print("이름:");bName = scan.nextLine();
		System.out.print("잔고:");bMoney = Integer.parseInt(scan.nextLine());
		Account acc = new Account(bAcc, bName, bMoney);
		
		lists.add(acc);
		System.out.println("계좌계설이 완료되었습니다.");
	}////end of makeAccount
	
	public void depositMoney() {
		boolean isFind = false;
		Scanner scan = new Scanner(System.in);
		System.out.println("***입 금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		System.out.print("계좌번호:");
		String searchAcc = scan.nextLine();
		for(Account acc : lists) {
			if(searchAcc.compareTo(acc.accinfo)==0) {
				System.out.print("입금액:");
				int amount = Integer.parseInt(scan.nextLine());
				
				acc.deposit(amount);
				System.out.println("입금이 완료되었습니다.");
			}
		}
	}
	public void withdrawMoney() {
		boolean isFind = false;
		Scanner scan = new Scanner(System.in);
		System.out.println("***출 금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요");
		System.out.print("계좌번호:");
		String searchAcc = scan.nextLine();
		for(Account acc : lists) {
			if(searchAcc.compareTo(acc.accinfo)==0) {
				System.out.print("출금액:");
				int amount = Integer.parseInt(scan.nextLine());
				
				acc.withdraw(amount);
				System.out.println("출금이 완료되었습니다.");
			}
		}
	}
	
	public void showAccInfo() {
		for(int i=0 ; i<lists.size() ; i++) {
			lists.get(i).showAccInfo();
		}
		System.out.println();
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
	}////end of showAccinfo
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

