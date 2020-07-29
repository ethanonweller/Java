import java.util.Scanner;

public class ATM {
    public static void main(String[] args)
        {
            // init scanner
            Scanner sc = new Scanner(System.in);

            //init bank
            Bank theBank = new Bank("Bank of America");

            //add a user which also makes savings account
            User aUser = theBank.addUser("Mark", "Stevens", "0530");

            // add checking account for user
            Account newAccount = new Account("Checking", aUser, theBank);
            aUser.addAccount(newAccount);
            theBank.addAccount(newAccount);

            User curUser;
            while (true){

                // login until successful
                curUser = ATM.mainMenuPrompt(theBank, sc);

                // main until user quits
                ATM.printUserMenu(curUser ,sc);

            }

        }

    /**
     * Print ATM login menu
     * @param theBank  bank object whose account to use
     * @param sc       scanner object for user input
     * @return         successful login
     */
        public static User mainMenuPrompt(Bank theBank, Scanner sc){
        // inits
            String userID;
            String pin;
            User authUser;

            // prompt the user for user ID/PIN until true
            do{

                System.out.printf("\n\nWelcome to %s\n\n", theBank.getName());
                System.out.print("Enter user ID: ");
                userID = sc.nextLine();
                System.out.printf("Enter pin: ");
                pin = sc.nextLine();

                // get user object corresponding to ID/PIN
                authUser = theBank.userLogin(userID, pin);
                if (authUser == null){
                    System.out.println("Incorrect user ID/PIN combination. " +
                            "Please try again.");
                }
            } while(authUser == null); // loop until successful login

            return authUser;
        }

        public static void printUserMenu(User theUser, Scanner sc){

            // print summary of user accounts
            theUser.printAccountsSummary();

            // init
            int choice;

            // user menu
            do {
                System.out.printf("Welcome %s, what would you like to do?\n",
                        theUser.getFirstName());
                System.out.println(" 1) Show account transaction history");
                System.out.println(" 2) Withdrawal");
                System.out.println(" 3) Deposit");
                System.out.println(" 4) Transfer");
                System.out.println(" 5) Quit");
                System.out.println();
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                //check user input
                if (choice < 1 || choice > 5){
                    System.out.println("That is not a valid option, choose 1-5");
                }
            } while(choice < 1 || choice > 5);

                //process choice
                switch (choice){

                    case 1:
                        ATM.showTransHist(theUser, sc);
                        break;
                    case 2:
                        ATM.withdrawFunds(theUser, sc);
                        break;
                    case 3:
                        ATM.depositFunds(theUser, sc);
                        break;
                    case 4:
                        ATM.transferFunds(theUser, sc);
                        break;
                    case 5:
                        sc.nextLine();
                        break;
                }

            //redisplay menu unless quit is chosen
            if (choice != 5){
                ATM.printUserMenu(theUser, sc);
            }
        }

    /**
     * Show trans history for account
     * @param theUser auth user object
     * @param sc scanner object for user input
     */
        public static void showTransHist(User theUser, Scanner sc){

            int theAcct;

            do {
                System.out.printf("Enter the number of (1-%d) of the account" +
                        "whose history you want to see: ",
                        theUser.numAccounts());
                theAcct = sc.nextInt()-1;
                if (theAcct < 0 || theAcct >= theUser.numAccounts()){
                    System.out.println("Invalid account. Try again.");
                }
            } while(theAcct < 0 || theAcct >= theUser.numAccounts());

            //print trans history
            theUser.printAcctTransHistory(theAcct);
        }

        public static void transferFunds(User theUser, Scanner sc){

            //inits
            int fromAcct;
            int toAcct;
            double amount;
            double acctBal;

            // get account to trans from
            do{
                System.out.printf("Enter the number (1-%d) of the account\n" +
                        "to transfer from: ", theUser.numAccounts());
                fromAcct = sc.nextInt()-1;
                if(fromAcct < 0 || fromAcct >= theUser.numAccounts()){
                    System.out.println("Invalid account. Please try again.");
                }
            } while(fromAcct < 0 || fromAcct >= theUser.numAccounts());
            acctBal = theUser.getAcctBalance(fromAcct);

            //get account to trans to
            do{
                System.out.printf("Enter the number (1-%d) of the account\n" +
                        "to transfer to: ", theUser.numAccounts());
                toAcct = sc.nextInt()-1;
                if(toAcct < 0 || toAcct >= theUser.numAccounts()){
                    System.out.println("Invalid account. Please try again.");
                }
            } while(toAcct < 0 || toAcct >= theUser.numAccounts());

            //get amount to trans
            do{
                System.out.printf("Enter the amount to transfer, (max $%.02f): $",
                        acctBal);
                amount = sc.nextDouble();
                if (amount < 0){
                    System.out.println("Amount must be greater than zero. ");
                } else if (amount > acctBal){
                    System.out.printf("Amount must not be greater than\n" +
                            "balance of $%.02f.\n", acctBal);
                }
            } while(amount < 0 || amount > acctBal);

            // do transfer
            theUser.addAcctTransaction(fromAcct, -1*amount, String.format(
            "Transfer to account %s", theUser.getAcctUUID(toAcct)));
            theUser.addAcctTransaction(toAcct, amount, String.format(
                    "Transfer to account %s", theUser.getAcctUUID(fromAcct)));
        }

    /**
     * process withdrawal from account
     * @param theUser auth user object
     * @param sc scanner object for user input
     */
        public static void withdrawFunds(User theUser, Scanner sc){
            //inits
            int fromAcct;
            double amount;
            double acctBal;
            String memo;

            // get account to trans from
            do{
                System.out.printf("Enter the number (1-%d) of the account\n" +
                        "to withdraw from: ", theUser.numAccounts());
                fromAcct = sc.nextInt()-1;
                if(fromAcct < 0 || fromAcct >= theUser.numAccounts()){
                    System.out.println("Invalid account. Please try again.");
                }
            } while(fromAcct < 0 || fromAcct >= theUser.numAccounts());
            acctBal = theUser.getAcctBalance(fromAcct);

            //get amount to trans
            do{
                System.out.printf("Enter the amount to withdraw, (max $%.02f): $",
                        acctBal);
                amount = sc.nextDouble();
                if (amount < 0){
                    System.out.println("Amount must be greater than zero. ");
                } else if (amount > acctBal){
                    System.out.printf("Amount must not be greater than\n" +
                            "balance of $%.02f.\n", acctBal);
                }
            } while(amount < 0 || amount > acctBal);

            sc.nextLine();

            //get memo
            System.out.print("Enter a memo: ");
            memo = sc.nextLine();

            // perform withdrawal
            theUser.addAcctTransaction(fromAcct, -1*amount, memo);
        }

    /**
     * perform deposit to account
     * @param theUser auth user
     * @param sc scanner for user input
     */
        public static void depositFunds(User theUser, Scanner sc){
            //inits
            int toAcct;
            double amount;
            double acctBal;
            String memo;

            // get account to trans from
            do{
                System.out.printf("Enter the number (1-%d) of the account\n" +
                        "to deposit in: ", theUser.numAccounts());
                toAcct = sc.nextInt()-1;
                if(toAcct < 0 || toAcct >= theUser.numAccounts()){
                    System.out.println("Invalid account. Please try again.");
                }
            } while(toAcct < 0 || toAcct >= theUser.numAccounts());
            acctBal = theUser.getAcctBalance(toAcct);

            //get amount to trans
            do{
                System.out.printf("Enter the amount to transfer, (max $%.02f): $",
                        acctBal);
                amount = sc.nextDouble();
                if (amount < 0){
                    System.out.println("Amount must be greater than zero. ");
                }
            } while(amount < 0);

            sc.nextLine();

            //get memo
            System.out.print("Enter a memo: ");
            memo = sc.nextLine();

            // perform deposit
            theUser.addAcctTransaction(toAcct, amount, memo);
        }

}
