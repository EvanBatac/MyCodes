public class Array {
    public static void main(String[] args) {
      
      MyArray arr = new MyArray(5);
      arr.addValue(0,23);
      arr.addValue(1,24);
      arr.addValue(2,25);
      arr.addValue(3,26);
      arr.addValue(4,27);
      arr.ViewElements();
      
      arr.RemoveValue(1);
      arr.ViewElements();
      
      int searchResult = arr.Search(5);
      if(searchResult != -1 ){
         System.out.println("The Value is found in index " + searchResult);
      }
      else{
         System.out.println("The Value is not found");
      }
      
      arr.Sort();
      arr.ViewElements();

   }
}

class MyArray {
    private int[] array;
    private int size;

    MyArray(int size) {
        this.size = size;
        array = new int[size];
    }

    public void addValue(int index, int value) {
        if (index >= 0 && index < size) {
             array[index] = value;
        } else {
            System.out.println("Invalid index for adding a value.");
        } 
    }
    public void RemoveValue(int index){
      if (index >= 0 && index < size) {
             array[index] = 0;
        } else {
            System.out.println("Invalid index for removing a value.");
        } 
    }
    public void Edit(int index, int value){
      if (index >= 0 && index < size) {
             array[index] = value;    
        } else {
            System.out.println("Invalid index for editing a value.");
        } 
    }
    public int Search(int value){
      for(int i = 0; i < array.length; i++){
         if(value == array[i]){
            System.out.println(i);
            return i;
         }  
      }
      return -1;
    }
      public void Sort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    } 

    public void ViewElements() {
        System.out.println("Array: " + java.util.Arrays.toString(array));
    }
}
