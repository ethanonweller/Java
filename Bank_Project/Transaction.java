import java.util.Date;

public class Transaction {

    // amount of transaction
    private double amount;
    // timestamp of transaction
    private Date timeStamp;
    // memo for transaction
    private String memoDesc;
    // account for the transaction
    private Account inAccount;

    // overloaded constructors
    /**
     * Create new transaction
     * @param amount amount of transaction
     * @param inAccount amoun
     */
    public Transaction(double amount, Account inAccount){
        this.amount = amount;
        this.inAccount = inAccount;
        this.timeStamp = new Date();
        this.memoDesc = "";
    }

    /**
     * Create new transaction, but with memo
     * @param amount amount in transaction
     * @param memo memo for transaction
     * @param inAccount account the transaction belongs to
     */
    public Transaction(double amount, String memo, Account inAccount){

        // call above constructor 1st
        this(amount, inAccount);

        // memo
        this.memoDesc = memoDesc;
    }

    /**
     * get amount of transaction
     * @return  amount
     */
    public double getAmount(){
        return this.amount;
    }

    /**
     * Get string summary of transaction
     * @return   the string
     */
    public String getSummaryLine(){

        if (this.amount >= 0){
            return String.format("%s : $%.02f : %s",
                    this.timeStamp.toString(),
                    this.amount, this.memoDesc);
        } else{
            return String.format("%s : $(%.02f) : %s",
                    this.timeStamp.toString(),
                    -this.amount, this.memoDesc);
        }

    }

}
