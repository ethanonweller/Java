import java.util.ArrayList;
import java.util.Random;

public class Bank {
    // bank name
    private String name;
    // list of users
    private ArrayList<User> users;
    // list of all user accounts
    private ArrayList<Account> accounts;

    /**
     * create new bank object w/ empty list of users/accounts
     * @param name  name of bank
     */
    public Bank(String name){
        this.name = name;
        this.users = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
    }

    public String getNewUserUUID(){

        // inits
        String uuid;
        Random rng = new Random();
        int length = 8;
        boolean nonUniq;

        // loop until unique ID is made
        do{
            //gen number
            uuid = "";
            for (int i = 0; i < length; i++) {
                uuid += ((Integer) rng.nextInt(10)).toString();
            }
            //check for uniqueness
            nonUniq = false;
            for (User u : this.users){
                if (uuid.compareTo(u.getUUID()) == 0){
                    nonUniq = true;
                    break;
                }
            }
        } while (nonUniq);

        return uuid;
    }

    public String getNewAccountUUID(){

        // inits
        String uuid;
        Random rng = new Random();
        int length = 10;
        boolean nonUniq;

        // loop until unique ID is made
        do{
            //gen number
            uuid = "";
            for (int i = 0; i < length; i++) {
                uuid += ((Integer) rng.nextInt(10)).toString();
            }
            //check for uniqueness
            nonUniq = false;
            for (Account a : this.accounts){
                if (uuid.compareTo(a.getUUID()) == 0){
                    nonUniq = true;
                    break;
                }
            }
        } while (nonUniq);

        return uuid;
    }

    /**
     * add account
     * @param anAcct  how many accounts to add
     */
    public void addAccount(Account anAcct){
        this.accounts.add(anAcct);
    }

    /**
     * Create new user of bank
     * @param firstName  user's first name
     * @param lastName   user's last name
     * @param pin        user's pin
     * @return           new user object
     */
    public User addUser(String firstName, String lastName, String pin){
        // create new user object and add to list
        User newUser = new User(firstName, lastName, pin, this);
        this.users.add(newUser);

        // create savings acct
        Account newAccount = new Account("Savings", newUser, this);
        newUser.addAccount(newAccount);
        this.addAccount(newAccount);

        return newUser;
    }

    /**
     * get user object associated with userID and pin
     * @param userID UUID of user
     * @param pin pin of user
     * @return user object if login is successful or null if not
     */
    public User userLogin(String userID, String pin){
        // search list of users
        for (User u : this.users){
            //check if user id is correct
            if (u.getUUID().compareTo(userID) == 0 && u.validatePin(pin)){
                return u;
            }
        }
        // if no user found or no pin found
        return null;
    }

    /**
     * gets name of bank
     * @return
     */
    public String getName(){
        return this.name;
    }

}
