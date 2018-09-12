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
  public static void main (String[] args) {
    int allTransactions[][] = new int[150][150];
    int allTransactionsCount = 0;
    
    String trans1 = "0 1 0 1 1";
    String trans2 = "2 1 0 4 5";
    String trans3 = "1 -44 545 1 -6";
    String trans4 = "0 0 1 1 1";
    
    allTransactionsCount = AuditableBanking.processCommand(trans1, allTransactions, allTransactionsCount);
    allTransactionsCount = AuditableBanking.processCommand(trans2, allTransactions, allTransactionsCount);
    allTransactionsCount = AuditableBanking.processCommand(trans3, allTransactions, allTransactionsCount);
    allTransactionsCount = AuditableBanking.processCommand(trans4, allTransactions, allTransactionsCount);
    
    for (int i = 0; i < allTransactionsCount; i++) {
      System.out.print("Transaction #" + (i+1) + ": ");
      for (int j = 0; j < 5; j++) {        
        System.out.print(allTransactions[i][j] + " ");
      }
      System.out.println();
    }
    System.out.print("Number of transactions: " +allTransactionsCount);
  }   
}
