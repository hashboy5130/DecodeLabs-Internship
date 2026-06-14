ATM Interface System

🔹 Internship Project – DecodeLabs (Batch 2026)

This is a **simple, working ATM simulation** built with **Java**.  
It demonstrates **Object-Oriented Programming (OOP)** concepts like:

- Classes & Objects
- Encapsulation (private variables + public methods)
- Method calling
- Input validation
- Real-world banking logic (deposit, withdraw, check balance)

---

## 👨‍💻 **Project Structure**

ATM-Project/
│
├── BankAccount.java # Account data + business logic
├── ATM.java # Menu + user interaction
└── README.md # This file


---

**How to Run**

1️. Requirements
- Java JDK 8 or higher installed  
  👉 [Download Java](https://www.oracle.com/java/technologies/downloads/)

2. Compile
Open terminal in project folder and run:

```bash
javac BankAccount.java ATM.java

3. Compile

Sample RUN Output

===================================
   WELCOME TO DECODELABS ATM
===================================
Enter your 4-digit PIN: 1234

✅ Access granted. Welcome Nuwan Perera!

========== ATM MENU ==========
1. Check Balance
2. Deposit Money
3. Withdraw Money
4. Exit
==============================
Enter your choice: 1

💰 Your current balance is: Rs. 5000.0

========== ATM MENU ==========
1. Check Balance
2. Deposit Money
3. Withdraw Money
4. Exit
==============================
Enter your choice: 3

Enter amount to withdraw: Rs. 2000
✅ Withdrawal successful: Rs. 2000.0

========== ATM MENU ==========
1. Check Balance
2. Deposit Money
3. Withdraw Money
4. Exit
==============================
Enter your choice: 4
👋 Thank you for using DecodeLabs ATM. Goodbye!
