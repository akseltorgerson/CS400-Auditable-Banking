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
public class AuditableBanking {

  /**
   * Adds a transaction group to an array of transaction groups. If the allTransactions array is
   * already full then this method will do nothing other than return allTransactionCount.
   * 
   * @param newTransactions is the new transaction group being added (perfect size).
   * @param allTransactions is the collection that newTransactions is being added to (oversize).
   * @param allTransactionsCount is the number of transaction groups within allTransactions (before
   *        newTransactions is added.
   * @return the number of transaction groups within allTransactions after newTransactions is added.
   */
  public static int submitTransactions(int[] newTransactions, int[][] allTransactions,
      int allTransactionsCount) {
    for (int i = 0; i < newTransactions.length; i++) { // loops through every transaction in the new transaction array
      allTransactions[allTransactionsCount][i] = newTransactions[i]; // adds the new transaction array index by index to the all transaction array at the next index
    }
    allTransactionsCount += 1; // increases the transaction count after it has completed
    return allTransactionsCount; // returns the transaction count
  }

  public static int processCommand(String command, int[][] allTransactions, int allTransactionsCount) {
      String [] stringCommandArray = command.split(" "); //splits String command into an array where each element is a string
      int [] commandArray = new int[stringCommandArray.length]; //creates empty array of type int[] with same length as stringCommandArrray
      
      for(int i = 0; i<stringCommandArray.length; i++){
        commandArray[i]= Integer.parseInt(stringCommandArray[i]); // copies the String of stringCommandArray into an identical int in commandArray
      }
      if(commandArray[0] == 0 || commandArray[0] == 1 || commandArray[0] == 2 ) { //if the first number is valid, submit transaction.
        allTransactionsCount = submitTransactions(commandArray, allTransactions, allTransactionsCount);
      }
      return allTransactionsCount; //return updated transaction count
  }
}
