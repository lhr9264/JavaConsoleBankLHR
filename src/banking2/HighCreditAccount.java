package banking2;

public class HighCreditAccount extends Account {
    private double interestRate;
    private char creditRating;

    public HighCreditAccount(String accNumber, String accName, int balance, int interestRate, char creditRating) {
        super(accNumber, accName, balance);
        this.interestRate = (double) interestRate / 100;
        this.creditRating = creditRating;
    }

    @Override
    public void deposit(double amount) {
    	applyInterest(); 
        super.deposit(amount);
    }

    private void applyInterest() {
        if (balance <= 0) {
            return;
        }
        
        double additionalInterestRate = getAdditionalInterestRate();
        double baseInterest = balance * interestRate;
        double additionalInterest = balance * additionalInterestRate;
        double totalInterest = baseInterest + additionalInterest;
        balance += totalInterest; 
    }

    private double getAdditionalInterestRate() {
        switch (creditRating) {
            case 'A':
                return 0.07;
            case 'B':
                return 0.04;
            case 'C':
                return 0.02;
            default:
                return 0.0;
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n기본이자>" + Math.round(interestRate * 100) + "%" +
                "\n신용등급>" + creditRating;
    }
}