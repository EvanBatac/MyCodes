import java.util.Scanner;
public class Array2
{
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
                    System.out.print("Enter the Value: ");
                    int value = scan.nextInt();
                    arr.AddElement(value);
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
                              arr.Asort();
                              arr.ViewElements();
                               break;
                        
                          case 2: 
                              arr.Dsort();
                              arr.ViewElements();
                              break;    
                   }
                   break;
                   
                 case 6: 
                     System.out.print("Enter the Array Index you want to Edit: ");
                     int edit = scan.nextInt();
                     System.out.print("Enter The Value: ");
                     int val = scan.nextInt();
                     arr.EditElement(edit, val);
                     arr.ViewElements();
                     break;
                     
                 case 7: 
                     System.out.println("Program Finished!");

            }

		}
		while(choice != 7);
      
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
