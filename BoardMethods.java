public class BoardMethods{  

/*Slides a certain row in a 2D array to the left, combining two touching like numbers at a time
   * 
   * @return the altered array
   */
  public static int[][] slideLeft(int[][] array, int row){
       //for a row within a certain array, move all numbers left with the conditions listed in the above JavaDoc comment
    for (int i = 0; i < (array.length); i += 1){
      if (array[i][row] != 0){                         //if the value at the index is not equal to zero
        int k = i;                                     //an indexing variable used to scroll ahead of the official index without affecting it
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
    return array;
  }
  
  
  /*Slides a certain row in a 2D array to the right, combining two like touching numbers at a time
   * 
   * @return the altered array
   */
  public static int[][] slideRight(int[][] array, int row){
    /*For a row within a certain array, move all nonzero values to the right by swapping values with
     * neighboring zeroes in the specified direction.*/
    for (int i = (array.length - 1); i >= 0; i -= 1){                 //given an entire array and picking a row to be manipulated
      if (array[i][row] != 0){                                           //if the value at the index is not equal to zero
        if (i != (array.length - 1)){                                       //if the index is past the first entry, and the entry is not 0
          int k = i;                                                        //an indexing variable used to scroll ahead of the official index without affecting it
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
    return array;
  }
  
  
  /*Slides a certain column in a 2D array up, combining two like touching numbers at a time.
   * 
   * @return the altered array
   * 
   */
  public static int[][] slideUp(int[][] array, int col){
    /*For a column within a 2D array, move all nonzero values up by swapping values with
     * neighboring zeroes in the specified direction.*/
    for (int i = 0; i < array[col].length; i += 1){             //given an entire array and picking a row to be manipulated
      if (array[col][i] != 0){                                     //if the value at the index is not equal to zero
        if (i != 0){                                               //if the index is past the first entry, and the entry is not 0
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
    return array;
  }
  
  
  /*Slides a certain column in a 2D array down, combining two like touching numbers at a time.
   * 
   * @return the altered array
   * 
   */
  public static int[][] slideDown(int[][] array, int col){
    /*For a column in a 2D array, move all nonzero values down by swapping values with neighboring
     * zeros in the specified direction.*/
    for (int i = (array[col].length - 1); i >= 0; i -= 1){    
      if (array[col][i] != 0){
        if (i != (array[col].length - 1)){
          int k = i;       //an indexing variable used to scroll ahead of the official index without affecting it
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
    return array;
  }
  
  
  /*Slides values in an array up and to the left diagonally, combining two like touching numbers at a time.
   * 
   * @return the altered array
   * 
   */
  public static int[][] slideUpLeft(int[][] array, int row, int col){
    /*When a button in the top left corner has been clicked, move all values along the diagonal 
     * up and to the left with two different indeces and 
     * by swapping values with neighboring nonzeroes in the specified direction.*/
    for (int i1 = col, i2 = row; (i1 <= (array.length - 1) && i2 <= (array[col].length - 1)); i1 += 1, i2 += 1){
      if (array[i1][i2] != 0){   //if the value at the crossection indeces is not 0
        if (i1 != 0 || i2 != 0){   //if both indeces are past their first entries, and the entry is not 0
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
    return array;
  }
  
  
  /*Slides values in an array down and to the right diagonally, combining two like touching numbers at a time.
   * 
   * @return the altered array
   * 
   */
  public static int[][] slideDownRight(int[][] array, int row, int col){
    /*When a button in the bottom right corner is clicked, move values along a diagonal in the direction
     * of the button using two different indeces and by swapping values with neighboring zeroes
     * in the specified direction.*/
    for (int i1 = col, i2 = row; (i1 >= 0 && i2 >= 0); i1 -= 1, i2 -= 1){    //given an entire array and picking a row to be manipulated
      if (array[i1][i2] != 0){   //if the value at the crossection indeces is not 0
        if (i1 != col || i2 != row){   //if both indeces are past their first entries, and the entry is not 0
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
    return array;
  }
  
  
  /*Slides values in an array down and to the left diagonally, combining two like touching numbers at a time.
   * 
   * @return the altered array
   * */
  public static int[][] slideDownLeft(int[][] array, int row, int col){
    /*When a button in the bottom left corner is clicked, move values along a diagonal line in the direction
     * of the button using two different indeces and by swapping values with neighboring zeroes
     * in the specified direction.*/
    for (int i1 = col, i2 = row; (i1 <= array.length && i2 >= 0); i1 += 1, i2 -= 1){
      if (array[i1][i2] != 0){   //if the value at the crossection indeces is not 0...
        int k = i1;           //horizonal counter variable k
        int j = i2;           //vertical counter variable j
        //while the next bottom left diagonal square holds a zero
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
    return array;
  }
  
  /*Slides values in an array up and to the right diagonally, combining two like touching numbers at a time.
   * 
   * @return the altered array
   * */
  public static int[][] slideUpRight(int[][] array, int row, int col){
    /*When a button in the bottom left corner is clicked, move values along a diagonal line in the direction
     * of the button using two different indeces and by swapping values with neighboring zeroes
     * in the specified direction.*/
    for (int i1 = col, i2 = row; (i1 >= 0 && i2 <= array[col].length); i1 -= 1, i2 += 1){
      if (array[i1][i2] != 0){   //if the value at the crossection indeces is not 0...
        int k = i1;           //horizonal counter variable k
        int j = i2;           //vertical counter variable j
        //while the next bottom left diagonal square holds a zero
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
    return array;
  }
  
}
