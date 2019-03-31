//ISBN Code

import java.util.*;

public class main {



    public static void main(String[] args){
        
        boolean check = true;
        
        while(check){
            try{
            System.out.print("Please input Product ID : ");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            //convert input from string to int
            String inputSubstring = input.substring(3);
            
            //convert string to integer list
            List<Integer> list = new ArrayList<Integer>();
            for(char c : inputSubstring.toCharArray()) {     
              list.add(Character.getNumericValue(c));
            }      
            //get the sum of the product id
            int sumOfProductId10 = sum(list);
            //do modulus 10 to get the last number
            //add the last number from sumOfProductId to the list
            int mod = sumOfProductId10 % 10;
            list.add(mod);
            
            //check with modulus 11
            int sumOfProductId11 = mod11(list);
            if(sumOfProductId11 % 11 == 0){
                System.out.println("ISBN " + list.get(0) + "-" + list.get(1) + list.get(2) + "-" + list.get(3) + list.get(4) + list.get(5) + list.get(6) + list.get(7) + list.get(8) + "-" + list.get(9));
            }else{
                //check if the last number become 10 and mod11 == 0
                list.remove(9);
                list.add(10);
                sumOfProductId11 = mod11(list);
                if(sumOfProductId11 % 11 == 0){
                    System.out.println("ISBN " + list.get(0) + "-" + list.get(1) + list.get(2) + "-" + list.get(3) + list.get(4) + list.get(5) + list.get(6) + list.get(7) + list.get(8) + "-x");
                }else{
                    //remove 10 from the list
                    //call for method to add mod11for9numbers
                    //divide the sum by 11, ans + 1
                    //take the ans*11 (subtract it from the previous sum from mod11for9numbers)
                    //list.add(from the subtract)
                    //do the check again to make sure % 11 == 0
                    list.remove(9);
                    int sumOfProductId11with9numbers = mod11for9numbers(list);
                    if(sumOfProductId11with9numbers % 11 == 0){
                        //just add the list as 0
                        list.add(0);
                        System.out.println("ISBN " + list.get(0) + "-" + list.get(1) + list.get(2) + "-" + list.get(3) + list.get(4) + list.get(5) + list.get(6) + list.get(7) + list.get(8) + "-" + list.get(9));
                    }else{
                        sumOfProductId11with9numbers = mod11for9numbers(list);
                        int divide = sumOfProductId11with9numbers/11;
                        int newSum = 11*(divide+1);
                        int difference = newSum - sumOfProductId11with9numbers;
                        list.add(difference);
                        sumOfProductId11 = mod11(list);
                        if(sumOfProductId11 % 11 == 0){
                            System.out.println("ISBN " + list.get(0) + "-" + list.get(1) + list.get(2) + "-" + list.get(3) + list.get(4) + list.get(5) + list.get(6) + list.get(7) + list.get(8) + "-" + list.get(9));
                        }
                        
                    }
                }
            }
            }catch(Exception e){
                System.out.println("Please input only numbers!!");
            }
        }
    }
    
    //other methods
    public static int sum(List<Integer> list) {
        int sum = 0;
        for (int i: list) {
            sum += i;
        }
        return sum;
}

    public static int mod11(List<Integer> list) {
        int mod11Sum = 0;
        int check = 11;
        for(int i = 0; i<=9; i++){
            check--;
            mod11Sum += (check*list.get(i));
        }
        
        return mod11Sum;
}

    public static int mod11for9numbers(List<Integer> list) {
        int mod11Sum = 0;
        int check = 11;
        for(int i = 0; i<=8; i++){
            check--;
            mod11Sum += (check*list.get(i));
        }
        return mod11Sum;
}




}

