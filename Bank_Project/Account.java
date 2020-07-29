import java.util.ArrayList;

public class Account {
    // name of account
    private String name;
    // account ID, NOT USER ID
    private String uuid;
    // User object that owns account
    private User holder;
    // transaction history for account
    private ArrayList<Transaction> transactions;

    /**
     * Create new account
     *
     * @param name    name of the account
     * @param holder  user object that holds this account
     * @param theBank bank that issues the account
     */
    public Account(String name, User holder, Bank theBank) {

        // set acct holder/name
        this.name = name;
        this.holder = holder;

        // new account UUID
        this.uuid = theBank.getNewAccountUUID();

        // init transactions
        this.transactions = new ArrayList<Transaction>();
    }

    /**
     * Get account ID
     *
     * @return the UUID
     */
    public String getUUID() {
        return this.uuid;
    }

    /**
     * Get summary of accounts
     *
     * @return UUID, balance + OR - and name
     */
    public String getSummaryLine() {
        // get account's balance
        double balance = this.getBalance();

        // format summary depending on + OR - balance
        if (balance >= 0) {
            return String.format("%s : $%.02f : %s", this.uuid, balance,
                    this.name);
        } else {
            return String.format("%s : $(%.02f) : %s", this.uuid, balance,
                    this.name);
        }
    }

    /**
     * gets balance of accounts
     *
     * @return balance
     */
    public double getBalance() {

        double balance = 0;
        for (Transaction t : this.transactions) {
            balance += t.getAmount();
        }
        return balance;
    }

    public void printTransHistory() {

        System.out.printf("\nTransaction history for account %s\n",
                this.uuid);
        for (int t = this.transactions.size() - 1; t >= 0; t--) {
            System.out.println(this.transactions.get(t).getSummaryLine());
        }
        System.out.println();

    }

    /**
     * Add new transaction to account
     * @param amount    amount in transaction
     * @param memoDesc memo of transaction
     */
    public void addTransaction(double amount, String memoDesc){
        Transaction newTrans = new Transaction(amount, memoDesc, this);
        this.transactions.add(newTrans);
    }

}
