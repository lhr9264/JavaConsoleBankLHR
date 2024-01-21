package banking1;

import java.util.Scanner;

class Account {
	String accNumber;
	String accName;
	int balance;
	
	public Account(String accNumber,String accName,int balance) {
		this.accNumber = accNumber;
		this.accName = accName;
		this.balance = balance;
	}
	public String getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	public void deposit(int amount) {
		this.balance += amount;
	}
	public void withdraw(int amount) {
		this.balance -= amount;
	}
	@Override
	public String toString() {
		return "계좌번호: " + accNumber +"\n"+ "고객이름: " + 
				accName +"\n"+ "잔고: " + balance;
	}

}

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


class AccountManager {
	
	private Account[] accountArray;
	private int numOfAccounts;

	
	public AccountManager() {
		accountArray = new Account[50];
		numOfAccounts = 0;
	}
	
	public void showMenu() {
		System.out.println("-----Menu-----");
		System.out.println("1.계좌개설");
		System.out.println("2.입  금");
		System.out.println("3.출  금");
		System.out.println("4.계좌정보출력");
		System.out.println("5.프로그램종료");
		System.out.print("선택:");
	}
	
	
	public void makeAccount(int choice) {
		if (numOfAccounts >= 50) {
			System.out.println("더 이상 계좌를 개설할 수 없습니다.");
			return;
		}
		
		Scanner scan = new Scanner(System.in);
		String accNumber,accName;
		int balance;
		System.out.println("***신규계좌개설***");
		
		System.out.print("계좌번호 : ");
		accNumber = scan.nextLine();
		
		System.out.print("고객이름 : ");
		accName = scan.nextLine();
		
		System.out.print("잔고 : ");
		balance = Integer.parseInt(scan.nextLine());
        accountArray[numOfAccounts++] =
        		new Account(accNumber, accName, balance);
        
		System.out.println("계좌개설이 완료되었습니다.");
		}

	public void depositMoney() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("***입 금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		System.out.print("계좌번호:");
	    String accNumber = scan.nextLine();
	    
        Account account = findAccount(accNumber);
        if (account == null) {
            System.out.println("해당 계좌가 존재하지 않습니다.");
            return;
        }
        System.out.print("입금액: ");
        int depositAmount = scan.nextInt();
        account.deposit(depositAmount);
        System.out.println("입금이 완료되었습니다");
	}
	public void withdrawMoney() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("***출 금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요");
		System.out.print("계좌번호:");
		String accNumber = scan.nextLine();
		
		Account account = findAccount(accNumber);
		if (account == null) {
			System.out.println("해당 계좌가 존재하지 않습니다.");
			return;
		}
		System.out.print("출금액: ");
		int withdrawAmount = scan.nextInt();
		  System.out.println("출금이 완료되었습니다");
		account.withdraw(withdrawAmount);
	}
	
	
	public void showAccInfo() {
		  for (int i = 0; i < numOfAccounts; i++) {
			  	System.out.println("***계좌정보출력***");
				System.out.println("-------------------------");
	            System.out.println(accountArray[i]);
	        }
		  System.out.println("-------------------------");
		  System.out.println("전체계좌정보 출력이 완료되었습니다.");
		}
	
	private Account findAccount(String accNumber) {
        for (int i = 0; i < numOfAccounts; i++) {
            if (accountArray[i].getAccNumber().equals(accNumber)) {
                return accountArray[i];
            }
        }
        return null;
    }
	}



