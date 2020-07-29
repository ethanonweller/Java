# ATM Interface

This console based ATM allows the user to 
- Show account specific transaction history
- Withdrawal funds
- Deposit funds
- Transfer funds
- Record memos for transactions

I have hard coded in a single account holder and a new UUID is generated each time the program is run to be used as his account number

His pin ~0530~ has also been hard coded, but is not displayed on the login screen and is compared to a MD5 hash

This program was made to replicate a realistic setting by encapsulating certain variables to ensure security
