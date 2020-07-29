import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.security.MessageDigest;

public class User {
    // user first name
    private String firstName;
    // user last name
    private String lastName;
    // uuid for user
    private String uuid;
    // hashed pin
    private byte pinHash[];
    // list of accounts for user
    private ArrayList<Account> accounts;

    /**
     * Create new user
     * @param firstName user's first name
     * @param lastName user's last name
     * @param pin user's pin
     * @param theBank Bank object that user is customer of
     */
    public User(String firstName, String lastName, String pin, Bank theBank){
        // set user personal info
        this.firstName = firstName;
        this.lastName = lastName;

        // hashing pin w/ MD5
        // java throws error before build
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            // hashes pin
            this.pinHash = md.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e){
            System.err.println("error. NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }

        // generate ID for user
        this.uuid = theBank.getNewUserUUID();

        // create list of accounts
        this.accounts = new ArrayList<Account>();

        // log msg
        System.out.printf("New user %s, %s with ID %s created.\n",
                lastName, firstName, this.uuid);
    }
    // get/set to allow encapsulation of private object
    public void addAccount(Account anAcct){
        this.accounts.add(anAcct);

    }

    public String getUUID(){
        return this.uuid;
    }

    /**
     * check whether pin matches saved hash
     * @param aPin pin to check
     * @return whether pin is valid
     */
    public boolean validatePin(String aPin){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(md.digest(aPin.getBytes()),
                    this.pinHash);
        } catch (NoSuchAlgorithmException e){
            System.err.println("error. NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }
        // to appease java
        return false;
    }

    public String getFirstName(){
        return this.firstName;
    }

    /**
     * prints summary of accounts for user
     */
    public void printAccountsSummary(){

        System.out.printf("\n\n%s's accounts summary\n", this.firstName);
        for (int a = 0; a < this.accounts.size(); a++){
            System.out.printf("  %d) %s\n", a+1,
                    this.accounts.get(a).getSummaryLine());
        }
        System.out.println();
    }

    /**
     * get number of accounts
     * @return num of accounts
     */
    public int numAccounts(){
        return this.accounts.size();
    }

    /**
     * print trans history for particular account
     * @param acctIdx  index of account to display
     */
    public void printAcctTransHistory(int acctIdx){
        this.accounts.get(acctIdx).printTransHistory();
    }

    /**
     * get balance of account
     * @param acctIdx index of account
     * @return balance of account
     */
    public double getAcctBalance(int acctIdx){
        return this.accounts.get(acctIdx).getBalance();
    }

    /**
     * get UUID of account
     * @param acctIdx index of account
     * @return UUID of account
     */
    public String getAcctUUID(int acctIdx){
        return this.accounts.get(acctIdx).getUUID();
    }

    /**
     *
     * @param acctIdx
     * @param amount
     * @param memoDesc
     */
    public void addAcctTransaction(int acctIdx, double amount, String memoDesc){
        this.accounts.get(acctIdx).addTransaction(amount, memoDesc);
    }

}
