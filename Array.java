import java.util.Scanner;
public class Array {
    public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      
      System.out.print("Enter Array Size: ");
      int size = scan.nextInt();
      
      MyArray arr = new MyArray(size);
      int choice = 0;
      do{
         System.out.println("1. Add Element");
         System.out.println("2. View Elements");
         System.out.println("3. Remove an Element");
         System.out.println("4. Search Element");
         System.out.println("5. Sort Elements");
         System.out.println("6. Edit Elements");
         System.out.println("7. Exit");
      
         System.out.print("Enter Your Choice: ");
         choice = scan.nextInt();
      
         switch(choice){
            case 1:
               System.out.print("Enter Array Index: ");
               int index = scan.nextInt();
               System.out.print("Enter The Value: ");
               int value = scan.nextInt();
               arr.addElement(index, value);
               break;
            
            case 2:
               arr.ViewElements();
               break;
            
            case 3: 
               System.out.print("Enter the index of the value you want to remove: ");
               int remove = scan.nextInt();
               arr. RemoveElement(remove);
               break;
            
            case 4:
               System.out.print("Enter the value that you want to Search: ");
               int search = scan.nextInt();
            
               int searchResult = arr.Search(search);
            
               if(searchResult != -1 ){
                 System.out.println("The Value is found in index " + searchResult);
               }
               else{
                 System.out.println("The Value is not found");
               }
               break;
            
            case 5:
               System.out.println("1. Ascending");
               System.out.println("2. Descending");
               System.out.print("Enter Your Choice: ");
               int ch = scan.nextInt();
            
               switch(ch){
                  case 1:
                     arr.Sort();
                     arr.ViewElements();
               } 
          
            case 6: 
               System.out.print("Enter the Array Index you want to Edit: ");
               int edit = scan.nextInt();
               System.out.print("Enter The Value: ");
               int val = scan.nextInt();
               arr.Edit(edit, val);
               arr.ViewElements();
               break;
            
            case 7:
               System.out.println("Program Finished!");
               break;
      }
     }
     while(choice != 7);             
   }
}

class MyArray {
    private int[] array;
    private int size;

    MyArray(int size) {
        this.size = size;
        array = new int[size];
    }

    public void addElement(int index, int value) {
        if (index >= 0 && index < size) {
             array[index] = value;
        } else {
            System.out.println("Invalid index for adding a value.");
        } 
    }
    public void RemoveElement(int index){
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
