package banking5;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AccountManager  {
	private Set<Account> accountArray = new HashSet<>();

	public AccountManager() {
	}

	public void showMenu() {
		System.out.println("-----Menu-----");
		System.out.println("1.계좌개설");
		System.out.println("2.입  금");
		System.out.println("3.출  금");
		System.out.println("4.계좌정보출력");
		System.out.println("5.계좌정보삭제");
		System.out.println("6.프로그램종료");
		System.out.print("선택:");
	}
	
	
	public void makeAccount(int choice) {
		if (accountArray.size() >= 50) {
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
		
		Account existingAccount = findAccount(accNumber);
		if(existingAccount != null) {
			System.out.print("중복계좌발견됨. 덮어쓸까요? (y or n): ");
			String overwriteChoice = scanner.next();
			
			if(overwriteChoice.equals("n")) {
				System.out.println("계좌개설이 취소되었습니다.");
				return;
			}
			else if (overwriteChoice.equals("y")) {
				accountArray.remove(existingAccount);
			}
			else {
				System.out.println("잘못입력되었습니다.");
				return;
			}
		}
		
		System.out.print("고객이름: ");
		String accName = scanner.next();
		
		System.out.print("잔고: ");
		int balance = scanner.nextInt();
		
		System.out.print("기본이자%(정수형태로입력): ");
		double InterestRate = scanner.nextDouble();
		
		NormalAccount normalAccount =
				new NormalAccount(accNumber, accName, balance, InterestRate);
		accountArray.remove(normalAccount);
		accountArray.add(normalAccount);

	    System.out.println("계좌개설이 완료되었습니다.");
	}
	private void makeHighCreditAccount(Scanner scanner) {

        System.out.print("계좌번호: ");
        String accNumber = scanner.next();

        Account existingAccount = findAccount(accNumber);
        if (existingAccount != null) {
            System.out.print("중복계좌발견됨. 덮어쓸까요? (y or n): ");
            String overwriteChoice = scanner.next();

            if (overwriteChoice.equals("n")) {
                System.out.println("계좌개설이 취소되었습니다.");
                return;
            }
			else if (overwriteChoice.equals("y")) {
				accountArray.remove(existingAccount);
			}
			else {
				System.out.println("잘못입력되었습니다.");
				return;
			}
        }
        
        System.out.print("고객이름: ");
        String accName = scanner.next();

        System.out.print("잔고: ");
        int balance = scanner.nextInt();

        System.out.print("기본이자(정수형태로 입력): ");
        int InterestRate = scanner.nextInt();

        System.out.print("신용등급(A,B,C등급): ");
        char creditRating = scanner.next().charAt(0);

        HighCreditAccount highCreditAccount =
        		new HighCreditAccount(accNumber, accName, balance, InterestRate, creditRating);
        accountArray.remove(highCreditAccount);
        accountArray.add(highCreditAccount);

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
	    if (depositAmount % 500 != 0 ) {
	    	System.out.println("500원 단위로 입금가능함.");
	    	return;
	    }
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
			for (Account acc : accountArray) {
				System.out.println("-------------------------");
	            System.out.println(acc);
	        }
		  System.out.println("-------------------------");
		  System.out.println("전체계좌정보 출력이 완료되었습니다.");
		}
	
	public void deleteAccount() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("***계좌정보삭제***");
		System.out.print("계좌번호를 입력하세요: ");
		String accNumber = scan.next();
		
		Account accountDelete = findAccount(accNumber);
		
        if (accountDelete != null) {
            System.out.print("계좌정보를 삭제하시겠습니까? (y or n): ");
            String deleteChoice = scan.next();

            if (deleteChoice.equals("y")) {
                accountArray.remove(accountDelete);
                System.out.println("계좌정보가 삭제되었습니다.");
            } else if (deleteChoice.equals("n")) {
                System.out.println("계좌정보 삭제가 취소되었습니다.");
            } else {
                System.out.println("잘못입력되었습니다.");
            }
        } else {
            System.out.println("해당 계좌가 존재하지 않습니다.");
        }
	}
	
	public void saveAccountInfo() {
		try {
			ObjectOutputStream out = 
					new ObjectOutputStream(
							new FileOutputStream("src/banking5/AccountInfo.obj"));
			for(Account acc : accountArray) {
				out.writeObject(acc);
			}
			out.close();
		}
		catch (Exception e)	{
			e.printStackTrace();
		}
		System.out.println("AccountInfo.obj 파일로 저장되었습니다.");
	} 
	public void readAccountInfo() {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(
					new FileInputStream("src/banking5/AccountInfo.obj"));
			while(true) {
				Account acc = (Account)in.readObject();
				accountArray.add(acc);
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("AccountInfo.obj를 찾을수 없습니다.");
		}
		catch(EOFException e) {
			System.out.println("AccountInfo.obj 복원완료");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("복원 중 알수없는 오류발생");
		}
		finally {
			try {
				in.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
		

	
	
	private Account findAccount(String accNumber) {
        for (Account acc : accountArray) {
            if (acc.getAccNumber().equals(accNumber)) {
                return acc;
            }
        }
        return null;
    }
	
	
}
