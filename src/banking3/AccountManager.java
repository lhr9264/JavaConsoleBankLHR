package banking3;

import java.util.Scanner;

public class AccountManager {
	
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
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("***신규계좌개설***");
		System.out.println("-----계좌선택-----");
		System.out.println("1. 보통계좌");
	    System.out.println("2. 신용신뢰계좌");
	    System.out.print("계좌 종류를 선택하세요: ");
	    int accountType = scanner.nextInt();
	
       switch (accountType) {
       	case 1 :
       		makeNormalAccount(scanner);
       		break;
       	case 2 :
       		makeHighCreditAccount(scanner);
       		break;
       }
	}
	private void makeNormalAccount(Scanner scanner) {
		System.out.print("계좌번호: ");
		String accNumber = scanner.next();
		
		System.out.print("고객이름: ");
		String accName = scanner.next();
		
		System.out.print("잔고: ");
		int balance = scanner.nextInt();
		
		System.out.print("기본이자%(정수형태로입력): ");
		double InterestRate = scanner.nextDouble();
		
		NormalAccount normalAccount =
				new NormalAccount(accNumber, accName, balance, InterestRate);
	    accountArray[numOfAccounts++] = normalAccount;

	    System.out.println("계좌개설이 완료되었습니다.");
	}
	private void makeHighCreditAccount(Scanner scanner) {

        System.out.print("계좌번호: ");
        String accNumber = scanner.next();

        System.out.print("고객이름: ");
        String accName = scanner.next();

        System.out.print("잔고: ");
        int balance = scanner.nextInt();

        System.out.print("기본이자(정수형태로 입력): ");
        int InterestRate = scanner.nextInt();

        System.out.print("신용등급(A,B,C등급): ");
        char creditRating = scanner.next().charAt(0);

        HighCreditAccount highCreditAccount = new HighCreditAccount(accNumber, accName, balance, InterestRate, creditRating);
        accountArray[numOfAccounts++] = highCreditAccount;

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
	    if (depositAmount <= 0) {
	    	System.out.println("음수는 입금불가");
	    	return;
	    }
	    if ((depositAmount%500)==0 ) {
	    	account.deposit(depositAmount);
	    	System.out.println("입금이 완료되었습니다");
	    }
	    else {
	    	System.out.println("500원 단위로 입금가능함.");
	    }
	    
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
	    
	    if (withdrawAmount <= 0) {
	    	System.out.println("음수는 출금불가");
	    	return;
	    }
	    if (withdrawAmount % 1000 != 0) {
	        System.out.println("1000원 단위로 출금이 가능합니다. 출금이 취소되었습니다.");
	        return;
	    }

	    if (withdrawAmount > account.getBalance()) {
	        System.out.print("잔고가 부족합니다. 금액전체를 출금할까요? (y or n): ");
	        String selectWithdraw = scan.next();
	        if (selectWithdraw.equals("y")) {
	        	account.withdrawAll(withdrawAmount);
				System.out.println("출금이 완료되었습니다.");
				return;
			}
			else if(selectWithdraw.equals("n")) {
				System.out.println("취소되었습니다.");
				return;
			}
	    } else {
	        account.withdraw(withdrawAmount);
	        System.out.println("출금이 완료되었습니다.");
	    }
	}
	
	
	public void showAccInfo() {
		System.out.println("***계좌정보출력***");
			for (int i = 0; i < numOfAccounts; i++) {
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
