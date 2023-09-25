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
    public void ViewElements() {
        System.out.println("Array: " + java.util.Arrays.toString(array));
    }
}
