package banking;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountManager {
	ArrayList<Account> lists;
		
		static Account[] accounts = new Account[50];
		static int index = 0;
		public AccountManager(int num) {
			lists = new ArrayList<Account>();
		}
		
		//계좌개설
		public void makeAccount() {
			Scanner scan = new Scanner(System.in);
			String accountNumber,name;
			int money,interestrate;
			System.out.println("***신규계좌개설***");
			System.out.println("1.보통계좌");
			System.out.println("2.신용계좌");
			System.out.print("선택: ");
			scan.nextInt();
			
				
			System.out.print("계좌번호: ");accountNumber = scan.nextLine();
			System.out.print("이름: ");name = scan.nextLine();
			System.out.print("잔고: ");money = Integer.parseInt(scan.nextLine());
			System.out.print("기본이자%(정수형태로입력): ");interestrate = Integer.parseInt(scan.nextLine());
			Account acc = new Account(accountNumber, name, money, interestrate);
			accounts[index++] = acc;
			
			lists.add(acc);
			System.out.println("계좌계설이 완료되었습니다.");
		}////계좌 개설 끝
		
		//입금
		public void depositMoney() {
			boolean isFind = false;
			Scanner scan = new Scanner(System.in);
			System.out.println("***입 금***");
			System.out.println("계좌번호와 출금할 금액을 입력하세요");
			System.out.print("계좌번호:");
			String searchAcc = scan.nextLine();
			for(Account acc : lists) {
				if(searchAcc.compareTo(acc.getAccinfo())==0) {
					System.out.print("입금액:");
					int amount = Integer.parseInt(scan.nextLine());
					
					acc.deposit(amount);
					System.out.println("입금이 완료되었습니다.");
				}
				else {
					System.out.println("계좌정보가 없습니다.");
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
				if(searchAcc.compareTo(acc.getAccinfo())==0) {
					System.out.print("출금액:");
					int amount = Integer.parseInt(scan.nextLine());
					
					acc.withdraw(amount);
					System.out.println("출금이 완료되었습니다.");
				}
				else {
					System.out.println("계좌정보가 없습니다.");
				}
			}
		}
		
		public void showAccInfo() {
			for(Account account : lists) {
				System.out.println(account.toString());
				System.out.println("--------------------");
			}
			System.out.println("전체계좌정보 출력이 완료되었습니다.");
		}////end of showAccinfo

	}
