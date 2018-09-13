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
    for (int i = 0; i < newTransactions.length; i++) { // loops through every transaction in the new
                                                       // transaction array
      allTransactions[allTransactionsCount][i] = newTransactions[i]; // adds the new transaction
                                                                     // array index by index to the
                                                                     // all transaction array at the
                                                                     // next index
    }
    allTransactionsCount += 1; // increases the transaction count after it has completed
    return allTransactionsCount; // returns the transaction count
  }

  public static int processCommand(String command, int[][] allTransactions,
      int allTransactionsCount) {
    String[] stringCommandArray = command.split(" "); // splits String command into an array where
                                                      // each element is a string
    int[] commandArray = new int[stringCommandArray.length]; // creates empty array of type int[]
                                                             // with same length as
                                                             // stringCommandArrray

    for (int i = 0; i < stringCommandArray.length; i++) {
      commandArray[i] = Integer.parseInt(stringCommandArray[i]); // copies the String of
                                                                 // stringCommandArray into an
                                                                 // identical int in commandArray
    }
    if (commandArray[0] == 0 || commandArray[0] == 1 || commandArray[0] == 2) { // if the first
                                                                                // number is valid,
                                                                                // submit
                                                                                // transaction.
      allTransactionsCount =
          submitTransactions(commandArray, allTransactions, allTransactionsCount);
    }
    return allTransactionsCount; // return updated transaction count
  }

  public static int calculateNumberOfOverdrafts(int[][] allTransactions, int allTransactionsCount) {
    int overdrafts = 0;
    int accountBalance = 0; // account balance and overdrafts start at 0 since there is no prior
                            // transactions
    for (int i = 0; i < allTransactionsCount; i++) {
      if (allTransactions[i][0] == 0) {
        for (int j = 1; j < allTransactions[i].length; j++) {
          if (allTransactions[i][j] == 0 && accountBalance <= 0) {
            overdrafts++;
            accountBalance--;
          } else {
            accountBalance++;
          }
        }
      } else if (allTransactions[i][0] == 1) {
        for (int j = 1; j < allTransactions[i].length; j++) {
          accountBalance += allTransactions[i][j];
          if (accountBalance < 0 && allTransactions[i][j] < 0) {
            overdrafts++;
          }
        }
      } else if (allTransactions[i][0] == 2) {
        int[] multipliers = {20, 40, 80, 100};
        for (int j = 1; j < allTransactions[i].length; j++) {
          accountBalance -= (allTransactions[i][j] * multipliers[j - 1]);
          if (accountBalance < 0) {
            overdrafts++;
          }
        }
      }
    }
    return overdrafts;
  }

  public static int calculateCurrentBalance(int[][] allTransactions, int allTransactionsCount) {
    int firstNum;
    int totalBalance = 0;
    for (int i = 0; i < allTransactionsCount; i++) {
      firstNum = allTransactions[i][0];
      switch (firstNum) {
        case 0: // if it is a binary transaction:
          for (int j = 1; j < allTransactions[i].length; j++) { // for each number after index 0 in the array...
            if (allTransactions[i][j] == 1) // if the int =1, increment total balance by 1
            {
              totalBalance++;
            }
            if (allTransactions[i][j] == 0) // if the int = 0, decrement total balance by 1
            {
              totalBalance--;
            }
          }
          break;
      case 1: // if it is an Integer transaction
        for (int j = 1; j < allTransactions[i].length; j++) // for each number after index 0 in the array...
        {
          totalBalance = totalBalance + allTransactions[i][j]; // add the int to the total balance.
        }
        break;
      case 2: // if it is a Quick Draw transaction
        totalBalance = totalBalance - 20*allTransactions[i][1]; //adds $20 for each time that withdraw was made. (value at index1)
        totalBalance = totalBalance - 40*allTransactions[i][2]; //adds $40 for each time that withdraw was made. (value at index2)
        totalBalance = totalBalance - 80*allTransactions[i][3]; //adds $80 for each time that withdraw was made. (value at index3)
        totalBalance = totalBalance - 100*allTransactions[i][4]; //adds $100 for each time that withdraw was made. (value at index4)
      break;
      }
    }
    return totalBalance;
  }
}
