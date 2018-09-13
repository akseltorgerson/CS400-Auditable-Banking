import java.util.Arrays;

//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: P01 Auditable Banking
// Files: None
// Course: CS300, Semester 1, 2018
//
// Author: Aksel Torgerson
// Email: atorgerson@wisc.edu
// Lecturer's Name: Alexi Brooks
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Jacob Mayl
// Partner Email: mayl@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X_ Write-up states that pair programming is allowed for this assignment.
// _X_ We have both read and understand the course Pair Programming Policy.
// _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons:
// Online Sources:
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
public class AuditableBankingTests {
  public static void main(String[] args) {
    int allTransactions[][] = new int[150][150];
    int allTransactionsCount = 0;

    String trans1 = "0 1 0 1 1";
    String trans2 = "2 1 0 4 5";
    String trans3 = "1 -44 545 1 -6";
    String trans4 = "0 0 1 1 1";

    allTransactionsCount =
        AuditableBanking.processCommand(trans1, allTransactions, allTransactionsCount);
    allTransactionsCount =
        AuditableBanking.processCommand(trans2, allTransactions, allTransactionsCount);
    allTransactionsCount =
        AuditableBanking.processCommand(trans3, allTransactions, allTransactionsCount);
    allTransactionsCount =
        AuditableBanking.processCommand(trans4, allTransactions, allTransactionsCount);
    /*
    for (int i = 0; i < allTransactionsCount; i++) {
      System.out.print("Transaction #" + (i + 1) + ": ");
      for (int j = 0; j < 5; j++) {
        System.out.print(allTransactions[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println("Number of transactions: " + allTransactionsCount);
    */
    testCalculateNumberOfOverdrafts();
    testCalculateCurrentBalance();

  }

  public static boolean testCalculateNumberOfOverdrafts() {
    boolean foundProblem = false;
    int[][] transactions = new int[][] {
        {1, 10, -20, +30, -20, -20},        // +2 overdrafts (ending balance: -20)
        {0, 1, 1, 1, 0, 0, 1, 1, 1, 1},     // +2 overdrafts (ending balance: -15)
        {1, 115},                           // +0 overdrafts (ending balance: +100)
        {2, 3, 1, 0, 1},                    // +1 overdrafts (ending balance: -100)
    };

    // test with a single transaction of the Integer Amount encoding
    int transactionCount = 1;
    int accountBalance = AuditableBanking.calculateNumberOfOverdrafts(transactions, transactionCount);
    if (accountBalance != 2) {
      System.out.println(
          "FAILURE: calculateNumberOfOverdrafts did not return 2 when transactionCount = 1, and transactions contained: "
              + Arrays.deepToString(transactions));
      foundProblem = true;
    } else
      System.out.println("PASSED TEST 1/2 of testCalculateNumberOfOverdrafts!!!");
    
    // test with four transactions: including one of each encoding
    transactionCount = 4;
    accountBalance = AuditableBanking.calculateNumberOfOverdrafts(transactions, transactionCount);
    if (accountBalance != 5) {
      System.out.println(
          "FAILURE: calculateNumberOfOverdrafts did not return 5 when transactionCount = 4, and transactions contained: "
              + Arrays.deepToString(transactions));
      foundProblem = true;
    } else
      System.out.println("PASSED TESTS 2/2 of testCalculateNumberOfOverdrafts!!!");

    return !foundProblem;
  }
  
  public static boolean testCalculateCurrentBalance() {
    boolean foundProblem = false;
    int[][] transactions = new int[][] {
        {1, 10, -20, +30, -20, -20},        // +2 overdrafts (ending balance: -20)
        {0, 1, 1, 1, 0, 0, 1, 1, 1, 1},     // +2 overdrafts (ending balance: -15)
        {1, 115},                           // +0 overdrafts (ending balance: +100)
        {2, 3, 1, 0, 1},                    // +1 overdrafts (ending balance: -100)
    };
    
    // test with a single transaction of the Integer Amount encoding
    int transactionCount = 1;
    int accountBalance = AuditableBanking.calculateCurrentBalance(transactions, transactionCount);
    if (accountBalance != -20) {
      System.out.println(
          "FAILURE: calculateCurrentBalance did not return -20 when transactionCount = 1, and transactions contained: "
              + Arrays.deepToString(transactions));
      foundProblem = true;
    } else
      System.out.println("PASSED TEST 1/2 of testCalculateCurrentBalance!!!");
    
    // test with four transactions: including one of each encoding
    transactionCount = 4;
    accountBalance = AuditableBanking.calculateCurrentBalance(transactions, transactionCount);
    if (accountBalance != -100) {
      System.out.println(
          "FAILURE: calculateCurrentBalance did not return 100 when transactionCount = 4, and transactions contained: "
              + Arrays.deepToString(transactions));
      foundProblem = true;
    } else
      System.out.println("PASSED TESTS 2/2 of TestCalculateCurrentBalance!!!");

    return !foundProblem;
  }
}
