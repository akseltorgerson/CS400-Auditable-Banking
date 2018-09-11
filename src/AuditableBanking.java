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
// Partner Lecturer's Name: Gary Dahl
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
public class AuditableBanking {

/**
 * Adds a transaction group to an array of transaction groups. If the allTransactions array is
 * already full then this method will do nothing other than return allTransactionCount.
 * 
 * @param newTransactions is the new transaction group being added (perfect size).
 * @param allTransactions is the collection that newTransactions is being added to (oversize).
 * @param allTransactionsCount is the number of transaction groups within allTransactions 
 *        (before newTransactions is added.
 * @return the number of transaction groups within allTransactions after newTransactions is added.
 */
  public static int submitTransactions(int[] newTransactions, int[][] allTransactions, 
      int allTransactionsCount) {        
    
    for (int i = 0; i < newTransactions.length; i++) {
      allTransactions[allTransactionsCount][i] = newTransactions[i];
    }
    
    allTransactionsCount += 1;
    
    return allTransactionsCount;
  }
}
