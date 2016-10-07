/* @author Elizabeth Fregoso
 * 
 * A class containing methods to play a numerical square sliding game.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SlideGame extends JFrame implements ActionListener{
  
  
  //the board of JButtons
  private JButton[][] board;
  //the board of Values
  private int[][] boardValues;
  //the panel containing the arrays of JButtons and values
  private JPanel boardPanel;
  //the JFrame for holding the JPanel holding the game
  private JFrame boardFrame;
  //for storing the number of rows in a specific SlideGame
  private int totalRows;
  //for storing the number of columns in a specific SlideGame
  private int totalColumns;
  //for keeping multiple instances of winning messages from happening every time a 2048 block is found
  private int frameCount;
  
  
  
  /*a constructor for creating a new SlideGame with a certain number of rows and columns
   * 
   * @param boardPanel a Panel for organizing the game in a JFrame
   * @param board the board of JButtons to be interacted with during gameplay
   * @param boardValues the int array of button values to be changed with button clicking
   * @param boardLocations the location of the buttons in a separate Point array, in the format (column, row)
   * 
   * @see the gameboard in a JFrame, with clickable buttons and one random 1 placed on the board
   * */
  public SlideGame(int rows, int columns){
    if (rows < 16 && rows > 0 && columns < 16 && columns > 0){
      totalRows = rows;
      totalColumns = columns;
      boardPanel = new JPanel(new GridLayout(rows, columns));
      board = new JButton[rows][columns];
      boardValues = new int[rows][columns];
      /*The first for loop is for scrolling for the rows, and the second is for scrolling through the
       * columns. A button is created in each spot and an ActionListener is added to them, 
       * as well as being added to the board panel.*/
      for (int rowIndex = 0; rowIndex < rows; rowIndex += 1){
        for (int columnIndex = 0; columnIndex < columns; columnIndex += 1){
          board[rowIndex][columnIndex] = new JButton();
          board[rowIndex][columnIndex].putClientProperty( "rowIndex" , rowIndex);
          board[rowIndex][columnIndex].putClientProperty( "columnIndex" , columnIndex);
          board[rowIndex][columnIndex].addActionListener(this);
          board[rowIndex][columnIndex].setBackground(new Color(229, 204, 255));
          boardPanel.add(board[rowIndex][columnIndex]);
        }
      }
      this.labelRandomOne(board, boardValues);
      boardFrame = new JFrame();
      boardFrame.getContentPane().add(boardPanel, "Center");
      boardFrame.setSize(400, 600);
      boardFrame.setVisible(true);
    }
    else{
      System.out.println("You're too hardcore for this game.\nDumb down a bit and try dimensions 15 x 15 instead.\n\nGo full screen for the best effect, too.");
    }
  }
  
  
  
  /*The action performed when a button is clicked.*/
  @Override
  public void actionPerformed(ActionEvent e){
    JButton b = (JButton)e.getSource();         //a variable for storing the button that caused the click event
    int columnAt = (Integer)(b.getClientProperty("rowIndex"));
    int rowAt = (Integer)(b.getClientProperty("columnIndex"));
    //for the UpLeft method
    if (b == board[0][0]){
      SlideGame.slideUpLeft(boardValues, 0, 0);
      this.labelRandomOne(board, boardValues);
    }
    //for the DownLeft method
    else if (b == board[0][(totalRows - 1)]){
      SlideGame.slideDownLeft(boardValues, (totalRows - 1), 0);
      this.labelRandomOne(board, boardValues);
    }
    //for the UpRight method
    else if (b == board[(totalColumns - 1)][0]){
      SlideGame.slideUpRight(boardValues, 0, (totalColumns - 1)); 
      this.labelRandomOne(board, boardValues);
    }
    //for the DownRight method
    else if (b == board[(totalColumns - 1)][(totalRows - 1)]){
      SlideGame.slideDownRight(boardValues, (totalRows - 1), (totalColumns - 1)); 
      this.labelRandomOne(board, boardValues);
    }
    //for the slideLeft method
    else if (columnAt == 0 && rowAt != (totalRows - 1) && rowAt != 0){
      SlideGame.slideLeft(boardValues, rowAt);
      this.labelRandomOne(board, boardValues);
    }
    //for the slideRight method
    else if (columnAt == (totalColumns - 1) && rowAt != (totalRows - 1) && rowAt != 0){
      SlideGame.slideRight(boardValues, rowAt);
      this.labelRandomOne(board, boardValues);
    }
    //for the slideUp method
    else if (rowAt == 0 && columnAt != (totalColumns - 1) && columnAt != 0){
      SlideGame.slideUp(boardValues, columnAt);
      this.labelRandomOne(board, boardValues);
    }
    //for the slideDown method
    else if (rowAt == (totalRows - 1) && columnAt != (totalColumns - 1) && columnAt != 0){
      SlideGame.slideDown(boardValues, columnAt);
      this.labelRandomOne(board, boardValues);
    }
    else
      ;
    this.labelButtonsWithValues(board, boardValues);
    this.isWinner();
  }
  
  
  
  public void isWinner(){
    for (int columnIndex = 0; columnIndex < boardValues.length; columnIndex += 1){
      for (int rowIndex = 0; rowIndex < boardValues[columnIndex].length; rowIndex += 1){
        if (boardValues[columnIndex][rowIndex] == 2048 && frameCount == 0){
          JFrame winnerFrame = new JFrame();
          JTextArea winnerText = new JTextArea("A WINNER IS YOU!!!\nKeep playing if you really wanna.");
          JPanel winnerPanel = new JPanel();
          winnerPanel.add(winnerText);
          winnerFrame.getContentPane().add(winnerPanel, "Center");
          winnerFrame.setSize(200, 80);
          this.pack();
          winnerFrame.setVisible(true);
          frameCount += 1;
        }
      }
    }
  }
  
  
  
  /*Sets a random button on the board to have a value of one
   * 
   * @see one of the squares on the board should have a random one value assigned to it
   */
  public void labelRandomOne(JButton[][] j, int[][] array){
    //initialize two variables at a random number to act as random indeces before the length of their array, when eventually they equal an index with value zero, 
    //when eventually they equal an index at value of zero, replace it with a one, annd exit loop
    //when they don't, have int k and j regenerate random numbers
    //use two different variables and have them equal int k and j each time around
    int randomColumn = ((int)(Math.random() * array.length));
    int randomRow = ((int)(Math.random() * array[randomColumn].length));
    while (array[randomColumn][randomRow] != 0){
      randomColumn = ((int)(Math.random() * array.length));
      randomRow = ((int)(Math.random() * array[randomColumn].length));
    }
    if (array[randomColumn][randomRow] == 0){
      j[randomColumn][randomRow].setText("1");
      array[randomColumn][randomRow] = 1;
    }
  }
  
  
  
//every time a button is clicked, change the value in boardValues and label the button with that value
  public void labelButtonsWithValues(JButton[][] j, int[][] array){
    /* The first for loop is for scrolling through the columns, and the second is for
     * scrolling for the rows. If a nonzero value is found, it is assigned a button label
     * with that value.*/
    for (int columnIndex = 0; columnIndex < array.length; columnIndex += 1){
      for (int rowIndex = 0; rowIndex < array[columnIndex].length; rowIndex += 1){
        if (array[columnIndex][rowIndex] != 0){
          String s = new String(Integer.toString(array[columnIndex][rowIndex]));
          j[columnIndex][rowIndex].setText(s);
        }
        else {
          j[columnIndex][rowIndex].setText("");
        }
      }
    }
  }
  
  
  
  /*Slides a certain row in a 2D array to the left, combining two touching like numbers at a time
   * 
   * @return the altered array
   */
  public static boolean slideLeft(int[][] array, int row){
    //for a row within a certain array, move all numbers left with the conditions listed in the above JavaDoc comment
    boolean anythingMoves = false;
    for (int i = 0; i < (array.length); i += 1){
      if (array[i][row] != 0){       //if the value at the index is not equal to zero
        if (i != 0){
          anythingMoves = true;
          int k = i;                 //an indexing variable used to scroll ahead of the official index without affecting it
          //while the index is greater than zero and the array element before the indexed element equals zero, swap values
          while (k > 0 && array[k - 1][row] == 0){
            array[k - 1][row] = array[k][row];
            array[k][row] = 0;
            k -= 1;
          }
          if (k > 0 && array[k - 1][row] == array[k][row]){
            array[k - 1][row] = (array[k - 1][row] * 2);
            array[k][row] = 0;
          }
        }
      }
    }
    return anythingMoves;
  }
  
  
  /*Slides a certain row in a 2D array to the right, combining two like touching numbers at a time
   * 
   * @return the altered array
   */
  public static boolean slideRight(int[][] array, int row){
    /*For a row within a certain array, move all nonzero values to the right by swapping values with
     * neighboring zeroes in the specified direction.*/
    boolean anythingMoves = false;
    for (int i = (array.length - 1); i >= 0; i -= 1){    //given an entire array and picking a row to be manipulated
      if (array[i][row] != 0){           //if the value at the index is not equal to zero
        if (i != (array.length - 1)){    //if the index is past the first entry, and the entry is not 0
          anythingMoves = true;
          int k = i;                     //an indexing variable used to scroll ahead of the official index without affecting it
          //while k is less than the length of the array and the next number is a zero, swap values
          while (k < (array.length - 1) && array[k + 1][row] == 0){
            array[k + 1][row] = array[k][row];
            array[k][row] = 0;
            k += 1;
          }
          if (k > 0 && k < (array.length - 1) && array[k + 1][row] == array[k][row]){
            array[k + 1][row] = (array[k + 1][row] * 2);
            array[k][row] = 0;
          }
        }
      }
    }
    return anythingMoves;
  }
  
  
  /*Slides a certain column in a 2D array up, combining two like touching numbers at a time.
   * 
   * @return the altered array
   * 
   */
  public static boolean slideUp(int[][] array, int col){
    /*For a column within a 2D array, move all nonzero values up by swapping values with
     * neighboring zeroes in the specified direction.*/
    boolean anythingMoves = false;
    for (int i = 0; i < array[col].length; i += 1){    //given an entire array and picking a row to be manipulated
      if (array[col][i] != 0){                         //if the value at the index is not equal to zero
        if (i != 0){                                   //if the index is past the first entry, and the entry is not 0
          anythingMoves = true;
          int k = i;
          //while the index is greater than zero and the element before the index is equal to zero, swap values.
          while (k > 0 && array[col][k - 1] == 0){
            array[col][k - 1] = array[col][k];
            array[col][k] = 0;
            k -= 1;
          }
          if (k > 0 && array[col][k - 1] == array[col][k]){
            array[col][k - 1] = (array[col][k - 1] * 2);
            array[col][k] = 0;
          }
        }
      }
    }
    return anythingMoves;
  }
  
  
  /*Slides a certain column in a 2D array down, combining two like touching numbers at a time.
   * 
   * @return the altered array
   * 
   */
  public static boolean slideDown(int[][] array, int col){
    /*For a column in a 2D array, move all nonzero values down by swapping values with neighboring
     * zeros in the specified direction.*/
    boolean anythingMoves = false;
    for (int i = (array[col].length - 1); i >= 0; i -= 1){    
      if (array[col][i] != 0){
        if (i != (array[col].length - 1)){
          anythingMoves = true;
          int k = i;                           //an indexing variable used to scroll ahead of the official index without affecting it
          //while the index is within the array length and the next element is equal to zero, swap values.
          while (k < (array[col].length - 1) && array[col][k + 1] == 0){
            array[col][k + 1] = array[col][k];
            array[col][k] = 0;
            k += 1;
          }
          if (k < (array[col].length - 1) && array[col][k + 1] == array[col][k]){
            array[col][k + 1] = (array[col][k + 1] * 2);
            array[col][k] = 0;
          }
        }
      }
    }
    return anythingMoves;
  }
  
  
  /*Slides values in an array up and to the left diagonally, combining two like touching numbers at a time.
   * 
   * @return the altered array
   * 
   */
  public static boolean slideUpLeft(int[][] array, int row, int col){
    /*When a button in the top left corner has been clicked, move all values along the diagonal 
     * up and to the left with two different indeces and 
     * by swapping values with neighboring nonzeroes in the specified direction.*/
    boolean anythingMoves = false;
    for (int i1 = col, i2 = row; (i1 <= (array.length - 1) && i2 <= (array[col].length - 1)); i1 += 1, i2 += 1){
      if (array[i1][i2] != 0){     //if the value at the crossection indeces is not 0
        if (i1 != 0 || i2 != 0){   //if both indeces are past their first entries, and the entry is not 0
          anythingMoves = true;
          int k = i1;           //horizonal counter variable k
          int j = i2;           //vertical counter variable j
          //while k and j are both within array's length and the previous diagonal square holds a zero, swap values.
          while ((k > 0 && j > 0) && array[k - 1][j - 1] == 0){
            array[k - 1][j - 1] = array[k][j];
            array[k][j] = 0;
            k -= 1;
            j -= 1;
          }
          if ((k > 0 && j > 0) && array[k - 1][j - 1] == array[k][j]){
            array[k - 1][j - 1] = (array[k - 1][j - 1] * 2);
            array[k][j] = 0;
          }
        }
      }
    }
    return anythingMoves;
  }
  
  
  /*Slides values in an array down and to the right diagonally, combining two like touching numbers at a time.
   * 
   * @return the altered array
   * 
   */
  public static boolean slideDownRight(int[][] array, int row, int col){
    /*When a button in the bottom right corner is clicked, move values along a diagonal in the direction
     * of the button using two different indeces and by swapping values with neighboring zeroes
     * in the specified direction.*/
    boolean anythingMoves = false;
    for (int i1 = col, i2 = row; (i1 >= 0 && i2 >= 0); i1 -= 1, i2 -= 1){    //given an entire array and picking a row to be manipulated
      if (array[i1][i2] != 0){         //if the value at the crossection indeces is not 0
        if (i1 != col || i2 != row){   //if both indeces are past their first entries, and the entry is not 0
          anythingMoves = true;
          int k = i1;           //set horizonal counter k to i1
          int j = i2;           //set vertical counter j to i2
          //while k and j are both within array's lengths and the previous diagonal square holds a zero, swap values.
          while ((k < (array.length - 1) && j < (array[col].length - 1)) && array[k + 1][j + 1] == 0){
            array[k + 1][j + 1] = array[k][j];
            array[k][j] = 0;
            k += 1;
            j += 1;
          }
          if ((k < (array.length - 1) && j < (array[col].length - 1)) && array[k + 1][j + 1] == array[k][j]){
            array[k + 1][j + 1] = (array[k + 1][j + 1] * 2);
            array[k][j] = 0;
          }
        }
      }
    }
    return anythingMoves;
  }
  
  
  /*Slides values in an array down and to the left diagonally, combining two like touching numbers at a time.
   * 
   * @return the altered array
   * */
  public static boolean slideDownLeft(int[][] array, int row, int col){
    /*When a button in the bottom left corner is clicked, move values along a diagonal line in the direction
     * of the button using two different indeces and by swapping values with neighboring zeroes
     * in the specified direction.*/
    boolean anythingMoves = false;
    for (int i1 = col, i2 = row; (i1 <= array.length && i2 >= 0); i1 += 1, i2 -= 1){
      if (array[i1][i2] != 0){   //if the value at the crossection indeces is not 0...
        if (i1 != col && i2 != row){
          anythingMoves = true;
          int k = i1;           //horizonal counter variable k
          int j = i2;           //vertical counter variable j
          //while k and j are both within array's lengths and the previous diagonal square holds a zero, swap values.
          while ((k > 0 && j < array[k].length) && array[k - 1][j + 1] == 0){
            array[k - 1][j + 1] = array[k][j];
            array[k][j] = 0;
            k -= 1;
            j += 1;
          }
          if ((k > 0 && j < array[k].length) && array[k - 1][j + 1] == array[k][j]){
            array[k - 1][j + 1] = (array[k - 1][j + 1] * 2);
            array[k][j] = 0;
          }
        }
      }
    }
    return anythingMoves;
  }
  
  
  /*Slides values in an array up and to the right diagonally, combining two like touching numbers at a time.
   * 
   * @return the altered array
   * */
  public static boolean slideUpRight(int[][] array, int row, int col){
    /*When a button in the top right corner is clicked, move values along a diagonal line in the direction
     * of the button using two different indeces and by swapping values with neighboring zeroes
     * in the specified direction.*/
    boolean anythingMoves = false;
    for (int i1 = col, i2 = row; (i1 >= 0 && i2 <= array[col].length); i1 -= 1, i2 += 1){
      if (array[i1][i2] != 0){   //if the value at the crossection indeces is not 0...
        if (i1 != col && i2 != row){
          anythingMoves = true;
          int k = i1;           //horizonal counter variable k
          int j = i2;           //vertical counter variable j
          //while k and j are both within array's lengths and the previous diagonal square holds a zero, swap values.
          while ((k < array.length && j > 0) && array[k + 1][j - 1] == 0){
            array[k + 1][j - 1] = array[k][j];
            array[k][j] = 0;
            k += 1;
            j -= 1;
          }
          if ((k < array.length && j > 0) && array[k + 1][j - 1] == array[k][j]){
            array[k + 1][j - 1] = (array[k + 1][j - 1] * 2);
            array[k][j] = 0;
          }
        }
      }
    }
    return anythingMoves;
  }
  
  
  
  /*A Main method for starting the game.*/
  public static void main(String[] args){
    try{
      String firstDimension = args[0];
      String secondDimension = args[1];
      new SlideGame(Integer.parseInt(firstDimension), Integer.parseInt(secondDimension));
    }
    catch (ArrayIndexOutOfBoundsException a){
      new SlideGame(4, 4);
    }
    catch (NumberFormatException n){
      System.out.println("Try playing this game later on, when you're sober.");
    }
  }
}