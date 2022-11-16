import java.util.Scanner;

class Account {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ATM atm = new SBI();
        atm.Debit();
    }
}

interface ATM {
    int Debit();
}

class SBI implements ATM {

    private static int availableBalance = 20000;
    private static int pin = 2684;

    Scanner scanner = new Scanner(System.in);

    @Override
    public int Debit() {
// amount
        System.out.println("Enter Amount");
        int DebitAmount = scanner.nextInt();


// pin
        System.out.println("Enter Pin");
        int pin = scanner.nextInt();

// validate
        if (pin == SBI.pin) {
            if (availableBalance >= DebitAmount) {
                availableBalance -= DebitAmount;

                return DebitAmount;
            } else {
                System.out.println("Debit amount exceeded account balance.");
            }
        } else {
            System.out.println("Invalid Pin");
        }
        return Debit();
    }
}