import java.util.Scanner;
public class Array2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size;
        do {
            System.out.print("Enter Array Size: ");
            try {
                size = scan.nextInt();
                if (size <= 0) {
                    System.out.println("Array size must be a positive integer.");
                    continue;
                }
                break; 
            } catch (Exception e) {
                System.out.println("Invalid input for array size. Please enter a valid integer.");
                scan.nextLine(); 
              }
        } while (true);
        MyArray arr = new MyArray(size);

        int choice = 0;
        do {
            System.out.println("1. Add Element");
            System.out.println("2. View Elements");
            System.out.println("3. Remove an Element");
            System.out.println("4. Search Element");
            System.out.println("5. Sort Elements");
            System.out.println("6. Edit Elements");
            System.out.println("7. Exit");

            System.out.print("Enter Your Choice: ");
            try {
                choice = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input for choice. Please enter a valid integer.");
                scan.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter the Value: ");
                    try {
                        int value = scan.nextInt();
                        arr.AddElement(value);
                    } catch (Exception e) {
                        System.out.println("Invalid input for element value. Please enter a valid integer.");
                        scan.nextLine();
                    }
                    break;

                case 2:
                    arr.ViewElements();
                    break;

                case 3:
                    System.out.print("Enter the index of the value you want to remove: ");
                    try {
                        int remove = scan.nextInt();
                        arr.RemoveElement(remove);
                    } catch (Exception e) {
                        System.out.println("Invalid input for removal index. Please enter a valid integer.");
                        scan.nextLine();
                    }
                    break;

                case 4:
                    System.out.print("Enter the value that you want to Search: ");
                    try {
                        int search = scan.nextInt();
                        int searchResult = arr.Search(search);

                        if (searchResult != -1) {
                            System.out.println("The Value is found in index " + searchResult);
                        } else {
                            System.out.println("The Value is not found");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input for search value. Please enter a valid integer.");
                        scan.nextLine(); 
                    }
                    break;

                case 5:
                    System.out.println("1. Ascending");
                    System.out.println("2. Descending");
                    System.out.print("Enter Your Choice: ");
                    try {
                        int ch = scan.nextInt();

                        switch (ch) {
                            case 1:
                                arr.Asort();
                                arr.ViewElements();
                                break;

                            case 2:
                                arr.Dsort();
                                arr.ViewElements();
                                break;
                            default:
                                System.out.println("Invalid choice for sorting. Please enter 1 or 2.");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input for sorting choice. Please enter 1 or 2.");
                        scan.nextLine(); 
                    }
                    break;

                case 6:
                    System.out.print("Enter the Array Index you want to Edit: ");
                    try {
                        int edit = scan.nextInt();
                        System.out.print("Enter The Value: ");
                        int val = scan.nextInt();
                        arr.EditElement(edit, val);
                    } catch (Exception e) {
                        System.out.println("Invalid input for edit index or value. Please enter valid integers.");
                        scan.nextLine();
                    }
                    break;

                case 7:
                    System.out.println("Program Finished!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 7);

        scan.close();
    }
}
class MyArray{
    private int[] array;
    private int size, index, ctr;
    MyArray(int size){
        this.size = size;
        array = new int[size];
        index = 0;
        ctr = 0;
    }
    public boolean isFull(){
        return ctr >= size;
    }
    public boolean isEmpty(){
        return ctr == 0;
    }
    public void AddElement(int value){
        if(!isFull()){
            array[index] = value;
            index++;
            ctr++;
        }
        else {
            System.out.println("Array is full!");
        }
    }
    public void ViewElements(){
        for(int i = 0; i < array.length; i++){
            System.out.print("[" + array[i] + "]");
        }
        System.out.print("Array Element Count: " + ctr);
        System.out.println();
        if(isEmpty()){
            System.out.println("Array is Empty!");
        }
    }
    public void RemoveElement(int removeIndex){
        if(removeIndex >= 0 && removeIndex < ctr){
            for (int i = removeIndex; i < ctr - 1; i++) {
                array[i] = array[i + 1];
            }
            array[ctr - 1] = 0;
            ctr--;
            index--;
        }
        else{
            System.out.println("Invalid index for removing a value.");
        }
    }
    public int Search(int SearchValue){
      for(int i = 0; i < array.length; i++){
         if(SearchValue == array[i]){
            return i;
         }  
      }
      return -1;
   }
   public void Asort(){
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
   public void Dsort(){
      for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

   }
   public void EditElement(int editIndex, int editValue){
      if (editIndex >= 0 && editIndex < ctr) {
             array[editIndex] = editValue;    
        } else {
            System.out.println("Invalid index for editing a value.");
        } 

   }
}
