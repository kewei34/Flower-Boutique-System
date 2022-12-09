import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlowerBoutiqueSystem{

    public static void main(String[] args) {

        ProdDetails[] prodArr = new ProdDetails[15];
        prodArr[0] = new ProdDetails("P001", "We Bare Bears Bouquet", 5, 79);
        prodArr[1] = new ProdDetails("P002", "Winnie The Pooh Bouquet", 3, 79);
        prodArr[2] = new ProdDetails("P003", "Convocation Bear Bouquet", 5, 89);
        prodArr[3] = new ProdDetails("P004", "Love Swan Bouquet", 5, 99);
        prodArr[4] = new ProdDetails("P005", "Hello Kitty Bouquet", 5, 79);
        prodArr[5] = new ProdDetails("P006", "Love You Forever Bouquet", 5, 450);
        prodArr[6] = new ProdDetails("P007", "Love Story", 7, 99);
        prodArr[7] = new ProdDetails("P008", "Secret Love", 4, 199);
        prodArr[8] = new ProdDetails("P009", "Ballon Bouquet", 3, 89);
        prodArr[9] = new ProdDetails("P010", "Rainbow Bouquet", 2, 199);
        prodArr[10] = new ProdDetails("P011", "Ferrero Rocher Surprise Box", 8, 99);
        prodArr[11] = new ProdDetails("P012", "Chocolate Love", 3, 79);
        prodArr[12] = new ProdDetails("P013", "Kitkat Bouquet", 5, 59);
        prodArr[13] = new ProdDetails("P014", "Kinder Bueno Bouquet", 4, 89);
        prodArr[14] = new ProdDetails("P015", "Mix Chocolate Rose Bouquet", 3, 69);

        Member memberArr[] = {new Member("M001","abu12345","Abu Bakar",'M',"0123456789","abu123@gmail.com","abu123abu",30),
                            new Member("M001","siti12345","Siti Aisha",'F',"0124567839","siti345@gmail.com","sitiAisha123",23)};

        Staff staffArr[] = {new Staff("S001","kewei12345","Chong Ke Wei",'F',"01116920255","kewei123@hotmail.com","Admin",3000),
                            new Staff("S002","jeriel12345","Ng Jeriel",'M',"0127338084","jeriel@gmail.com","Staff",2500)};
        
        Order[] orderArr = new Order[20];

        Scanner input = new Scanner(System.in);
        OrderDetails[] orderProdArr = new OrderDetails[20];

        //create object
        ProdDetails prodDetails = new ProdDetails();
        Member member = new Member();
        Staff staff = new Staff();
        Order order = new Order();
        Payment payment = new Payment();
        OrderDetails orderDetails = new OrderDetails();

        //variable declaration
        int choice = 0;
        String prodName = "";
        int qty = -1;
        double price = 0.0;
        boolean error = true;
        char ans = 'N';
        int editNo = 0;
        String name = "";
        String pw = "";
        String username = "";
        String phoneNo = "";
        String email = "";
        char gender;
        String loginID;
        boolean backMain = false;
        int loginNo = -1;
        int task =0;
        int result;
        boolean backStaffMenu = false;
        boolean backAdminMenu = false;
        
        char answer = 'N';
        int amount = 0;
        int counter = 0;
        int[][] orderChoice = new int[20][2];
        int i = 0, j = 0;  

    do{
        System.out.printf("\n%-10s|------------------------------------|\n", "");
        System.out.printf("%-10s|             Staff Login            |\n", "");
        System.out.printf("%-10s|------------------------------------|\n\n", "");
        //looping if password is wrong
        do{
do{
error = false;
System.out.print("Staff ID :");
loginID = input.nextLine();
int loopID =0;
for(i=0;i<staffArr.length;i++){
    error = true;
    if(loginID.equals(staffArr[i].getID())){
        loginNo = i;
        error = false;
        break;
    }
    else{
        loopID++;
        if(loopID == staffArr.length){
            System.out.printf("\n%-10s|------------------------------------|\n", "");
        System.out.printf("%-10s|%-15sError!!!%-13s|\n", "", "", "");
        System.out.printf("%-10s|------------------------------------|\n", "");
        System.out.printf("%-10s|         Invalid staff ID.          |\n", "");
        System.out.printf("%-10s|------------------------------------|\n\n", "");
        input.nextLine();
        error = true;
        }
    }
}
}while(error);

if(loginNo>=0){
        System.out.print("Password : ");
        String loginPW = input.nextLine();
        if(loginPW.equals(staffArr[loginNo].getPassword())){
            System.out.print("\nLogin Successfully !\n");
            if(staffArr[loginNo].position.equals("Staff")){

do{
System.out.printf("|-----------------------------------|\n");
System.out.printf("|             Menu                  |\n", "");
System.out.printf("|-----------------------------------|\n");
System.out.printf("|         |1| Display my profile    |\n", "");
System.out.printf("|         |2| Edit my profile       |\n", "");
System.out.printf("|         |3| Member register       |\n", "");
System.out.printf("|         |4| Edit member profile   |\n", "");
System.out.printf("|         |5| Order                 |\n", "");
System.out.printf("|         |6| Log Out               |\n", "");
System.out.printf("|-----------------------------------|\n\n");
System.out.print("Please choose one task to perform.(1-6) :");
task = input.nextInt();
input.nextLine();

if(task ==1){
        //display profile
        System.out.printf("\n%-10s|------------------------------------|\n", "");
        System.out.printf("%-10s|            Display Profile         |\n", "");
        System.out.printf("%-10s|------------------------------------|\n\n", "");
        System.out.printf("Staff ID    : %s\nName        : %s\nPassword    : %s\nGender      : %c\nPhone No    : %s\nEmail       : %s\nSalary      : %.2f\nPosition    : %s\n",staffArr[loginNo].id,staffArr[loginNo].name,staffArr[loginNo].pw,staffArr[loginNo].gender,staffArr[loginNo].phoneNo,staffArr[loginNo].email,staffArr[loginNo].salary,staffArr[loginNo].position);
        System.out.print("\nPress enter to return to back to menu.\n");
        input.nextLine();
        input.nextLine();
        backStaffMenu = true;
        }


else if(task ==2){
        //edit profile
        System.out.printf("\n%-10s|------------------------------------|\n", "");
        System.out.printf("%-10s|             Edit Profile           |\n", "");
        System.out.printf("%-10s|------------------------------------|\n\n", "");
        //let user  to choose category to be edit
        System.out.printf("\n|------------------------------------------------|\n");
        System.out.printf("|%-15s |1| Name                        |\n", "");
        System.out.printf("|%-15s |2| Password                    |\n", "");
        System.out.printf("|%-15s |3| Gender                      |\n", "");
        System.out.printf("|%-15s |4| Phone Number                |\n", "");
        System.out.printf("|%-15s |5| Email                       |\n", "");
        System.out.printf("|------------------------------------------------|\n\n");

        do{
        try {
            error = true;
            System.out.print("Select the categories you want to edit.(1-5) : ");
            choice = input.nextInt();
            input.nextLine();

            if (choice < 1 || choice > 5) {
                System.out.printf("\n%-10s|------------------------------------------|\n", "");
                System.out.printf("%-10s|%-15sError!!!%-19s|\n", "", "", "");
                System.out.printf("%-10s|--------------------------------------------|\n", "");
                System.out.printf("%-10s|   Please enter digit between 1 to 5 only.  |\n", "");
                System.out.printf("%-10s|--------------------------------------------|\n\n", "");
                input.nextLine();
            }
            error = false;
        } catch (Exception e) {
            digitError();
            input.nextLine();
        }

        if(choice == 1){
            String editName = checkName();
            staffArr[loginNo].name = editName;
            System.out.println("The information had been updated successfully!\n");
            System.out.print("\nPress enter to return to back to menu.\n");
        input.nextLine();
        backStaffMenu = true;
        }

        else if(choice ==2){
            String editPW = checkPW();
            staffArr[loginNo].pw = editPW;
            System.out.println("The information had been updated successfully!\n");
            System.out.print("\nPress enter to return to back to menu.\n");
        input.nextLine();
        input.nextLine();
        backStaffMenu = true;
        }

        else if(choice == 3){
            char editGender = checkGender();
            staffArr[loginNo].gender = editGender;
            System.out.println("The information had been updated successfully!\n");
            System.out.print("\nPress enter to return to back to menu.\n");
        input.nextLine();
        input.nextLine();
        backStaffMenu = true;
        }

        else if(choice ==4){
           String editPhoneNo= checkPhone();
            staffArr[loginNo].phoneNo = editPhoneNo;
            System.out.println("The information had been updated successfully!\n");
            System.out.print("\nPress enter to return to back to menu.\n");
        input.nextLine();
        input.nextLine();
        backStaffMenu = true;
        }
        else{
            String editEmail = checkEmail();
            staffArr[loginNo].email = editEmail;
            System.out.println("The information had been updated successfully!\n");
            System.out.print("\nPress enter to return to back to menu.\n");
        input.nextLine();
        input.nextLine();
        backStaffMenu = true;
        }
    }while (error || choice < 1 || choice > 5);
}//end edit

else if(task ==3){

    //register
    System.out.printf("\n%-10s|------------------------------------|\n", "");
    System.out.printf("%-10s|             Register               |\n", "");
    System.out.printf("%-10s|------------------------------------|\n\n", "");
    //loop again if the user enter a username that contains space
    do{
        error = false;
    System.out.print("Please enter a username : ");
    username = input.nextLine();
    for(i=0;i<username.length();i++){
        if(username.charAt(i)==' '){
            System.out.printf("\n%-10s|------------------------------------|\n", "");
            System.out.printf("%-10s|%-15sError!!!%-13s|\n", "", "", "");
            System.out.printf("%-10s|------------------------------------|\n", "");
            System.out.printf("%-10s|  Username cannot contain space.    |\n", "");
            System.out.printf("%-10s|------------------------------------|\n\n", ""); 
            error = true;
            input.nextLine();
            break;
        }
    }
}while(error);


pw = checkPW();

name =checkName();

gender = checkGender();

phoneNo = checkPhone();

email = checkEmail();


member.add(memberArr,pw,name,gender,phoneNo,email,username,0);

System.out.print("Register successfully ! \n");
System.out.print("\nPress enter to return to back to menu.\n");
        input.nextLine();
        input.nextLine();
        backStaffMenu = true;

}//end register

else if(task == 4){

    do{
    System.out.print("Enter member ID to search for member that want to edit : ");
    String searchMember = input.nextLine();
    result = member.search(memberArr,searchMember);
    if(result >-1){
        member.display(memberArr,result);

         //let user  to choose category to be edit
         System.out.printf("\n|------------------------------------------------|\n");
         System.out.printf("|%-15s |1| Name                        |\n", "");
         System.out.printf("|%-15s |2| Password                    |\n", "");
         System.out.printf("|%-15s |3| Gender                      |\n", "");
         System.out.printf("|%-15s |4| Phone Number                |\n", "");
         System.out.printf("|%-15s |5| Email                       |\n", "");
         System.out.printf("|------------------------------------------------|\n\n");

         do{
         try {
             error = true;
             System.out.print("Select the categories you want to edit.(1-5) : ");
             choice = input.nextInt();
             input.nextLine();

             if (choice < 1 || choice > 5) {
                 System.out.printf("\n%-10s|------------------------------------------|\n", "");
                 System.out.printf("%-10s|%-15sError!!!%-19s|\n", "", "", "");
                 System.out.printf("%-10s|--------------------------------------------|\n", "");
                 System.out.printf("%-10s|   Please enter digit between 1 to 5 only.  |\n", "");
                 System.out.printf("%-10s|--------------------------------------------|\n\n", "");
                 input.nextLine();
             }
             error = false;
         } catch (Exception e) {
             digitError();
             input.nextLine();
         }

         if(choice == 1){
             String editName = checkName();
             memberArr[result].name = editName;
             System.out.println("The information had been updated successfully!\n");
             member.display(memberArr, result);
             System.out.print("\nPress enter to return to back to menu.\n");
             
        input.nextLine();
        input.nextLine();
        backStaffMenu = true;

         }

         else if(choice ==2){
             String editPW = checkPW();
             memberArr[result].pw = editPW;
             System.out.println("The information had been updated successfully!\n");
             member.display(memberArr, result);
             System.out.print("\nPress enter to return to back to menu.\n");
             
        input.nextLine();
        input.nextLine();
        backStaffMenu = true;
         }

         else if(choice == 3){
             char editGender = checkGender();
             memberArr[result].gender = editGender;
             System.out.println("The information had been updated successfully!\n");
             member.display(memberArr, result);
             System.out.print("\nPress enter to return to back to menu.\n");
             
        input.nextLine();
        input.nextLine();
        backStaffMenu = true;
         }

         else if(choice ==4){
             String editPhoneNo= checkPhone();
             memberArr[result].phoneNo = editPhoneNo;
             System.out.println("The information had been updated successfully!\n");
             member.display(memberArr, result);
             System.out.print("\nPress enter to return to back to menu.\n");
             
        input.nextLine();
        input.nextLine();
        backStaffMenu = true;
         }
         else{
             String editEmail = checkEmail();
             memberArr[result].email = editEmail;
             System.out.println("The information had been updated successfully!\n");
             member.display(memberArr, result);
             System.out.print("\nPress enter to return to back to menu.\n");
             
        input.nextLine();
        input.nextLine();
        backStaffMenu = true;
         }
     }while (error || choice < 1 || choice > 5);
 }
 else{
    System.out.printf("\n%-10s|------------------------------------|\n", "");
    System.out.printf("%-10s|%-15sError!!!%-13s|\n", "", "", "");
    System.out.printf("%-10s|------------------------------------|\n", "");
    System.out.printf("%-10s|           No result found.         |\n", "");
    System.out.printf("%-10s|------------------------------------|\n\n", "");
    System.out.print("\nPress enter to return to back to menu.\n");
        input.nextLine();
        input.nextLine();
        backStaffMenu = true;
    }
}while(Character.toUpperCase(ans)=='Y');
}//end edit member

else if(task == 5){

    //order
    error = true;
    System.out.print("Enter member id : " );
    String orderMember = input.next();
    result = member.search(memberArr, orderMember);
    if(result<-1){
        System.out.printf("\n%-10s|------------------------------------|\n", "");
    System.out.printf("%-10s|%-15sError!!!%-13s|\n", "", "", "");
    System.out.printf("%-10s|------------------------------------|\n", "");
    System.out.printf("%-10s|           No result found.         |\n", "");
    System.out.printf("%-10s|------------------------------------|\n\n", "");
    }

    else{
                System.out.print("Enter member ID : ");
                result = member.search(memberArr, input.nextLine());
                if(result<-1){
                    System.out.printf("\n%-10s|------------------------------------|\n", "");
    System.out.printf("%-10s|%-15sError!!!%-13s|\n", "", "", "");
    System.out.printf("%-10s|------------------------------------|\n", "");
    System.out.printf("%-10s|           No result found.         |\n", "");
    System.out.printf("%-10s|------------------------------------|\n\n", "");
                }
                else{
                    do{
                    do{
                        i = 0; j=0;
                order.displayOrderMenu(prodArr);
                do {
                    error = true;
                    try {
                        System.out.printf("\n%10sPlease choose the product no. that you want (Exp:1) : ","");
                        choice = input.nextInt(); //prompt user to enter product no.
                        input.nextLine();

                        error = false;
                    } catch (Exception e) {
                        System.out.printf("%-10sPlease enter an integer value!\n","");
                        input.nextLine();        //check if user entered char value
                    }

                } while (error);
                if (choice > prodArr.length) {  //prompt user is product is unavailable
                    System.out.printf("%-10sThe product that you choose is not in our menu.\n%-10sPlease choose other products.\n","","");
                } else if (prodArr[choice - 1].getTotalQty() <= 0) { 
                    System.out.printf("%-10sSorry,product is not available for the moment.\n%-10sPlease choose other product.\n");
                }
                //loop back if data entered is wrong or product unavailable
            } while (choice > prodArr.length || prodArr[choice - 1].getTotalQty() <= 0); 
            
            orderChoice[i][j] = choice;  //2D array for collecting user choice-product name and quantity 
            j++;
            do {
                do {
                    error = true;
                    try {       //prompt user to enter the product quantity
                        System.out.printf("%-10sHow much %s do you want              : ","", prodArr[choice - 1].getProdName());
                        amount = input.nextInt();
                        input.nextLine();

                        error = false;
                    } catch (Exception e) {  //prompt user if user entered an integer
                        System.out.printf("%-10sPlease enter an integer value!\n","");
                        input.nextLine();
                    }

                } while (error);

                while (amount <= 0 || amount > prodArr[choice - 1].getTotalQty()) {

                    if (amount <= 0) {
                        System.out.printf("%-10sPlease enter a value more than 0                       : ","");
                        amount = input.nextInt();
                        input.nextLine();
                    } else if (amount > prodArr[choice - 1].getTotalQty()) {
                        System.out.printf("%-10sYou can order a maximum of %d %s only : ","",prodArr[choice - 1].getTotalQty(), prodArr[choice - 1].getProdName());    //promt user if they order more than quantity our stock 
                        amount = input.nextInt();
                        input.nextLine();
                    }
                }
                            ///loop back if data entered is wrong or product unavailable
            } while (amount <= 0 || amount > prodArr[choice - 1].getTotalQty());

            orderChoice[i][j] = amount;
            j = 0;
            System.out.printf("%-10sAre you sure you want %d %s ? (y/n)   : ","", amount, prodArr[choice - 1].getProdName());
            answer = input.next().charAt(0);
            input.nextLine();
            while (Character.toUpperCase(answer) != 'Y' && Character.toUpperCase(answer) != 'N') {
                System.out.println("          Please enter Y or N only! ");
                System.out.printf("%-10sAre you sure you want %d %s ? (y/n)   : ","", amount, prodArr[choice - 1].getProdName());
                answer = input.next().charAt(0);
                input.nextLine();     //check user input
            }
            if (Character.toUpperCase(answer) == 'Y') {
                prodArr[choice - 1].setTotalQty(prodArr[choice - 1].getTotalQty() - amount);
                i++;
                counter++;
               orderDetails.add(orderProdArr,prodArr[choice-1].prodID,prodArr[choice-1].prodName,amount);
            }
            System.out.printf("%-10sWould you like to order more flowers? (y/n)         : ","");
            answer = input.next().charAt(0);  //prompt user if they want to continue ordering
            input.nextLine();
            while (Character.toUpperCase(answer) != 'Y' && Character.toUpperCase(answer) != 'N') {
                System.out.printf("%-10sPlease enter Y or N only!\n ","");
                System.out.printf("%-10sWould you like to order more flowers? (y/n)        : ","");
                answer = input.next().charAt(0);
                input.nextLine();
            }

        } while (Character.toUpperCase(answer) == 'Y');
    }

        //display order note
        order.displayOrder(counter, orderChoice, prodArr); //call display order function
        double total = payment.calculateTotalOrder(order.getSubTotal());   //passing parameters 
        payment.displayPayment(order.getSubTotal());  // display payment info
        double amountToPay =0.00;
        do {
            do {
                error = true;          //prompt user to enter pay amount
                try {
                    System.out.printf("\n%-10sPlease enter the amount that you want to pay : RM","");
                    amountToPay = input.nextDouble();
                    input.nextLine();

                    error = false;     //prompt user to enter integer value
                } catch (Exception e) {
                    System.out.printf("%-10sPlease enter an integer value!\n","");
                    input.nextLine();
                }

            } while (error);     //prompt user if enter value smaller than total amount
            if (amountToPay <total) 
                System.out.printf("%-10sPlease enter amount larger than RM%.2f\n","",total);
            

        } while (amountToPay <total);

        payment.calculateBalance(amountToPay, total);    //calculate balance and show payment receipt
        System.out.print("\nPress enter to return to back to menu.\n");
    input.nextLine();
    input.nextLine();
    backStaffMenu = true;
    } while (Character.toUpperCase(answer) == 'Y');

}//end order
        
else{
    backMain = true;

}
}while(backStaffMenu);
            }//staff

            else{
                //back menu looping
                do{
System.out.printf("|-----------------------------------|\n");
System.out.printf("|             Menu                  |\n", "");
System.out.printf("|-----------------------------------|\n");
System.out.printf("|         |1| Display my profile    |\n", "");
System.out.printf("|         |2| Edit my profile       |\n", "");
System.out.printf("|         |3| Edit Staff profile    |\n", "");
System.out.printf("|         |4| Edit product          |\n", "");
System.out.printf("|         |5| Add product           |\n", "");
System.out.printf("|         |6| Search product        |\n", "");
System.out.printf("|         |7| View Report           |\n", "");
System.out.printf("|         |8| Add Staff             |\n", "");
System.out.printf("|         |9| Log Out               |\n", "");
System.out.printf("|-----------------------------------|\n\n");
System.out.print("Please choose one task to perform.(1-8) :");
task = input.nextInt();
input.nextLine();

if(task ==1){
    //display profile
    System.out.printf("\n%-10s|------------------------------------|\n", "");
    System.out.printf("%-10s|            Display Profile         |\n", "");
    System.out.printf("%-10s|------------------------------------|\n\n", "");
    System.out.printf("Staff ID    : %s\nName        : %s\nPassword    : %s\nGender      : %c\nPhone No    : %s\nEmail       : %s\nSalary      : %.2f\nPosition    : %s\n",staffArr[loginNo].id,staffArr[loginNo].name,staffArr[loginNo].pw,staffArr[loginNo].gender,staffArr[loginNo].phoneNo,staffArr[loginNo].email,staffArr[loginNo].salary,staffArr[loginNo].position);
    System.out.print("\nPress enter to return to back to menu.\n");
    input.nextLine();
    input.nextLine();
    backAdminMenu = true;
}

else if(task ==2){
    //edit profile
    System.out.printf("\n%-10s|------------------------------------|\n", "");
    System.out.printf("%-10s|             Edit Profile           |\n", "");
    System.out.printf("%-10s|------------------------------------|\n\n", "");
    //let user  to choose category to be edit
    System.out.printf("\n|------------------------------------------------|\n");
    System.out.printf("|%-15s |1| Name                        |\n", "");
    System.out.printf("|%-15s |2| Password                    |\n", "");
    System.out.printf("|%-15s |3| Gender                      |\n", "");
    System.out.printf("|%-15s |4| Phone Number                |\n", "");
    System.out.printf("|%-15s |5| Email                       |\n", "");
    System.out.printf("|------------------------------------------------|\n\n");

    do{
    try {
        error = true;
        System.out.print("Select the categories you want to edit.(1-5) : ");
        choice = input.nextInt();
        input.nextLine();

        if (choice < 1 || choice > 5) {
            System.out.printf("\n%-10s|------------------------------------------|\n", "");
            System.out.printf("%-10s|%-15sError!!!%-19s|\n", "", "", "");
            System.out.printf("%-10s|--------------------------------------------|\n", "");
            System.out.printf("%-10s|   Please enter digit between 1 to 5 only.  |\n", "");
            System.out.printf("%-10s|--------------------------------------------|\n\n", "");
            input.nextLine();
        }
        error = false;
    } catch (Exception e) {
        digitError();
        input.nextLine();
    }

    if(choice == 1){
        String editName = checkName();
        staffArr[loginNo].name = editName;
        System.out.println("The information had been updated successfully!\n");
        System.out.print("\nPress enter to return to back to menu.\n");
    input.nextLine();
    input.nextLine();
    backStaffMenu = true;

    }

    else if(choice ==2){
        String editPW = checkPW();
        staffArr[loginNo].pw = editPW;
        System.out.println("The information had been updated successfully!\n");
        System.out.print("\nPress enter to return to back to menu.\n");
    input.nextLine();
    input.nextLine();
    backStaffMenu = true;
    }

    else if(choice == 3){
        char editGender = checkGender();
        staffArr[loginNo].gender = editGender;
        System.out.println("The information had been updated successfully!\n");
        System.out.print("\nPress enter to return to back to menu.\n");
    input.nextLine();
    input.nextLine();
    backStaffMenu = true;
    }

    else if(choice ==4){
       String editPhoneNo= checkPhone();
        staffArr[loginNo].phoneNo = editPhoneNo;
        System.out.println("The information had been updated successfully!\n");
        System.out.print("\nPress enter to return to back to menu.\n");
    input.nextLine();
    input.nextLine();
    backStaffMenu = true;
    }
    else{
        String editEmail = checkEmail();
        staffArr[loginNo].email = editEmail;
        System.out.println("The information had been updated successfully!\n");
        System.out.print("\nPress enter to return to back to menu.\n");
    input.nextLine();
    input.nextLine();
    backStaffMenu = true;
    }
}while (error || choice < 1 || choice > 5);
}//end edit

else if (task ==3){

    System.out.print("Enter staff ID : ");
    result = staff.search(staffArr, input.next());
    if(result<-1){
        System.out.printf("\n%-10s|------------------------------------|\n", "");
    System.out.printf("%-10s|%-15sError!!!%-13s|\n", "", "", "");
    System.out.printf("%-10s|------------------------------------|\n", "");
    System.out.printf("%-10s|           No result found.         |\n", "");
    System.out.printf("%-10s|------------------------------------|\n\n", "");
    System.out.print("\nPress enter to return to back to menu.\n");
    input.nextLine();
    input.nextLine();
    backAdminMenu = true;
    }
    else{
        System.out.printf("Staff ID    : %s\nName        : %s\nPassword    : %s\nGender      : %c\nPhone No    : %s\nEmail       : %s\nSalary      : %.2f\nPosition    : %s\n",staffArr[result].id,staffArr[result].name,staffArr[result].pw,staffArr[result].gender,staffArr[result].phoneNo,staffArr[result].email,staffArr[result].salary,staffArr[result].position);

        System.out.printf("\n|------------------------------------------------|\n");
    System.out.printf("|%-15s |1| Salary                      |\n", "");
    System.out.printf("|%-15s |2| Position                    |\n", "");
    System.out.printf("|------------------------------------------------|\n\n");
    System.out.print("Select a task to perform (1/2) :");
    choice = input.nextInt();
    double salary = staffArr[result].salary;
    char position;
    if(choice == 1){
        do{
            error = true;
        try {
            System.out.print("Enter new salary : ");
            salary = input.nextDouble();

            error = false;
        } catch (Exception e) {
            digitError();
            input.nextLine();
        }
    }while(error);

    staffArr[result].salary = salary;
    System.out.println("\nThe information updated successfully ! \n");
    System.out.print("\nPress enter to return to back to menu.\n");
    input.nextLine();
    input.nextLine();
    backAdminMenu = true;
    }
    else{
        do{
            error = true;
        System.out.print("Choose staff position(A=Admin,S=staff) : ");
        input.nextLine();
        position = input.nextLine().charAt(0);
        if(Character.toUpperCase(position) !='A'&&Character.toUpperCase(position) !='S'){
            System.out.printf("\n%-10s|------------------------------------|\n", "");
    System.out.printf("%-10s|%-15sError!!!%-13s|\n", "", "", "");
    System.out.printf("%-10s|------------------------------------|\n", "");
    System.out.printf("%-10s|   You can only enter A or S.       |\n", "");
    System.out.printf("%-10s|------------------------------------|\n\n", "");
    error = true;
    input.nextLine();
        }
        else
        error = false;
    }while(error);
    if(Character.toUpperCase(position) =='A'){
        staffArr[result].position="Admin";
        System.out.println("\nThe information updated successfully ! \n");
        System.out.print("\nPress enter to return to back to menu.\n");
    input.nextLine();
    input.nextLine();
    backAdminMenu = true;
    }
    else{
        staffArr[result].position="Staff";
        System.out.println("\nThe information updated successfully ! \n");
        System.out.print("\nPress enter to return to back to menu.\n");
    input.nextLine();
    input.nextLine();
    backAdminMenu = true;
    }
    }

    }
}//edit staff

else if (task ==4){
//edit
System.out.printf("\n%-10s|------------------------------------|\n", "");
System.out.printf("%-10s|             Edit Product           |\n", "");
System.out.printf("%-10s|------------------------------------|\n\n", "");
//display product details
prodDetails.display(prodArr);

//looping to edit more product
do{
//validation check -to ensure the user enter number inside range and correct data type
do {
    error = true;
    try {
        //let user to select the product that he want to edit 
        System.out.print("\nPlease select the no. of product you want to modify. : ");
        editNo = input.nextInt();
        input.nextLine();
        if(editNo>prodArr.length||editNo<=0){
        System.out.printf("\n%-10s|--------------------------------------------|\n", "");
        System.out.printf("%-10s|%-15sError!!!%-21s|\n", "", "", "");
        System.out.printf("%-10s|--------------------------------------------|\n", "");
        System.out.printf("%-10s|   Please enter digit between 1 to %2d only. |\n", "",prodArr.length);
        System.out.printf("%-10s|--------------------------------------------|\n\n", "");
        }

        error = false;
    } catch (Exception e) {
        digitError();
        input.nextLine();
    }
} while (error||editNo>prodArr.length||editNo<=0);

//let user  to choose category to be edit
System.out.printf("\n|----------------------------------------------------------|\n");
System.out.printf("|%-20s |1| Product Name%-20s |\n", "", "");
System.out.printf("|%-20s |2| Product Quantity%-16s |\n", "", "");
System.out.printf("|%-20s |3| Product Price%-19s |\n", "", "");
System.out.printf("|----------------------------------------------------------|\n\n");

try {
    error = true;
    System.out.print("Select the categories you want to edit.(1-3) : ");
    choice = input.nextInt();
    input.nextLine();

    if (choice < 1 || choice > 3) {
        System.out.printf("\n%-10s|------------------------------------------|\n", "");
        System.out.printf("%-10s|%-15sError!!!%-19s|\n", "", "", "");
        System.out.printf("%-10s|--------------------------------------------|\n", "");
        System.out.printf("%-10s|   Please enter digit between 1 to 3 only.  |\n", "");
        System.out.printf("%-10s|--------------------------------------------|\n\n", "");
        input.nextLine();
    }
    error = false;
} catch (Exception e) {
    digitError();

    input.nextLine();
}
while (error || choice < 1 || choice >= 3);

String newName;
int newQty = -1;
double newPrice = -0.01;

switch (choice) {
case 1:
//edit name
System.out.printf("\nEnter new name for %s : ", prodArr[editNo - 1].prodName);
newName = input.nextLine();
System.out.printf("\nName  : %s\nQty   : %d\nPrice : %.2f\n", newName, prodArr[editNo - 1].totalQty, prodArr[editNo - 1].prodPrice);
prodDetails.edit(prodArr, newName, editNo);
System.out.print("\nThe information had been updated successflly !\n");
System.out.print("\nDo you want to continue editing? (Y/N) : ");
    ans = input.nextLine().charAt(0);
    if(Character.toUpperCase(ans)=='N'){
        System.out.print("\nPress enter to return to back to menu.\n");
    input.nextLine();
    input.nextLine();
    backAdminMenu = true;
    }
break;

case 2:
//edit qty
do {
    error = true;
    try {
        System.out.printf("\nEnter new quantity for %s : ", prodArr[editNo - 1].prodName);
        newQty = input.nextInt();
        input.nextLine();

        error = false;
    } catch (Exception e) {
        digitError();
        input.nextLine();
    }
} while (error);
System.out.printf("\nName  : %s\nQty   : %d\nPrice : %.2f\n", prodArr[editNo - 1].prodName, newQty, prodArr[editNo - 1].prodPrice);
prodDetails.edit(prodArr, newQty, editNo);
System.out.print("\nThe information had been updated successflly !\n");
System.out.print("\nDo you want to continue editing? (Y/N) : ");
    ans = input.nextLine().charAt(0);
    if(Character.toUpperCase(ans)=='N'){
        System.out.print("\nPress enter to return to back to menu.\n");
    input.nextLine();
    input.nextLine();
    backAdminMenu = true;
    }
break;

case 3:
//edit price
do {
    error = true;
    try {
        System.out.printf("\nEnter new price for %s : ", prodArr[editNo - 1].prodName);
        newPrice = input.nextDouble();
        input.nextLine();
        if (newPrice < 0.0) {
            System.out.printf("\n%-10s|------------------------------------|\n", "");
            System.out.printf("%-10s|%-15sError!!!%-13s|\n", "", "", "");
            System.out.printf("%-10s|------------------------------------|\n", "");
            System.out.printf("%-10s| Please enter only positive value.  |\n", "");
            System.out.printf("%-10s|------------------------------------|\n\n", "");

            error = false;
        }

        error = false;
    } catch (Exception e) {
        digitError();

        input.nextLine();
    }
} while (error || newPrice < 0.0);
System.out.printf("\nName  : %s\nQty   : %d\nPrice : %.2f\n", prodArr[editNo - 1].prodName, prodArr[editNo - 1].totalQty, newPrice);
prodDetails.edit(prodArr, newPrice, editNo);
System.out.print("\nThe information had been updated successflly !\n");
System.out.print("\nDo you want to continue editing? (Y/N) : ");
ans = input.nextLine().charAt(0);
if(Character.toUpperCase(ans)=='N'){
    System.out.print("\nPress enter to return to back to menu.\n");
input.nextLine();
input.nextLine();
backAdminMenu = true;
}
break;
}
}while(Character.toUpperCase(ans) =='Y');
}

else if (task ==5){

    //add 
    System.out.printf("\n%-10s|------------------------------------|\n", "");
    System.out.printf("%-10s|             Add Product            |\n", "");
    System.out.printf("%-10s|------------------------------------|\n\n", "");

    //loop when the user want to modify whole information inserted
    do {
            System.out.printf("%-10sEnter the name of the product : ", "");
            prodName = input.nextLine();

        //validation check-to ensure that the value for the quantity is not less than 0 and ensure that the user input only digit
        do {
            try {
                System.out.printf("%-10sEnter the quantity of %s : ", "", prodName);
                qty = input.nextInt();
                input.nextLine();
                if (qty < 0) {
                    System.out.printf("\n%-10s|------------------------------------|\n", "");
                    System.out.printf("%-10s|%-15sError!!!%-13s|\n", "", "", "");
                    System.out.printf("%-10s|------------------------------------|\n", "");
                    System.out.printf("%-10s|   Please enter digit more than 0.  |\n", "");
                    System.out.printf("%-10s|------------------------------------|\n\n", "");
                }
                error = false;
            } catch (Exception e) {
                digitError();
                input.nextLine();
            }
        } while (qty < 0 || error);

        //validation check-to prevent the staff put the price less than zero
        do {
            error = true;
            try {
                System.out.printf("%-10sEnter the price of %s : ", "", prodName);
                price = input.nextDouble();
                input.nextLine();
                if (price < 0.0) {
                    System.out.printf("\n%-10s|------------------------------------|\n", "");
                    System.out.printf("%-10s|%-15sError!!!%-13s|\n", "", "", "");
                    System.out.printf("%-10s|------------------------------------|\n", "");
                    System.out.printf("%-10s|    Please enter positive value.    |\n", "");
                    System.out.printf("%-10s|------------------------------------|\n\n", "");
                }
                error = false;
            } catch (Exception e) {
                digitError();
                input.nextLine();
            }

        } while (price < 0.0 || error);

        //display the information for the user to confirm
        System.out.printf("\nID       : " + prodDetails.countID(prodArr) + "\nName     : %s \nQuantity : %d \nPrice    : %.2f \n", prodName, qty, price);
       
        do {
            System.out.print("Do you comfirm the information is correct ? (Y/N) : ");
            ans = input.next().charAt(0);
            input.nextLine();
            if (Character.toUpperCase(ans) != 'Y' && Character.toUpperCase(ans) != 'N') {
                System.out.print("\nPlease enter only Y or N.\n\n");
            }
        } while (Character.toUpperCase(ans) != 'Y' && Character.toUpperCase(ans) != 'N');

        if (ans == 'Y' || ans == 'y') {
            //if all of the information is correct,store into array
            prodArr = prodDetails.add(prodArr, prodName, qty, price);
            System.out.printf("\n%-10s|------------------------------------|\n", "");
            System.out.printf("%-10s|%-14sSuccessful%-12s|\n", "", "", "");
            System.out.printf("%-10s|------------------------------------|\n", "");
            System.out.printf("%-10s|The new product added successfully! |\n", "");
            System.out.printf("%-10s|------------------------------------|\n\n", "");
                System.out.print("\nPress enter to return to back to menu.\n");
            input.nextLine();
            input.nextLine();
            backAdminMenu = true;

        }

        //if the information is incorrect,let the user choose the data field to be modified
        while (ans != 'Y' && ans != 'y') {
            System.out.print("\n1. Name \n2.Quantity\n3.Price\n4.All\n\n");
            do {
                System.out.print("Please select the data field that you want to modify :");
                choice = input.nextInt();
                input.nextLine();
                if (choice > 4 || choice <= 0)
                    System.out.print("Please enter the number between 1 to 4.\n\n");
            } while (choice > 4 || choice <= 0);

            switch (choice) {
                case 1:
                    //modify name
                    System.out.println("Enter the name of the product :");
                    prodName = input.nextLine();
                    input.nextLine();
                    break;

                case 2:
                    //mofidy quantity
                    do {
                        System.out.printf("Enter the quantity of %s :\n", prodName);
                        qty = input.nextInt();
                        input.nextLine();
                        if (qty < 0) {
                            System.out.println("Please enter the number that more than or equal to 0.");
                        }
                    } while (qty < 0);
                    break;

                case 3:
                    //mofidy price
                    do {
                        System.out.printf("Enter the price of %s :\n", prodName);
                        price = input.nextDouble();
                        input.nextLine();
                        if (price < 0.0) {
                            System.out.print("Please enter only positive value for price.");
                        }
                    } while (price < 0.0);
                    break;
            } //end switch
            System.out.printf("\nID       : " + prodDetails.countID(prodArr) + "\nName     : %s \nQuantity : %d \nPrice    : %.2f \n", prodName, qty, price);
            System.out.print("Do you comfirm the information is correct ? (Y/N)\n");
            ans = input.next().charAt(0);
            input.nextLine();
            if (ans == 'Y' || ans == 'y')
                prodDetails = new ProdDetails(prodDetails.countID(prodArr), prodName, qty, price);
                    System.out.print("\nPress enter to return to back to menu.\n");
                input.nextLine();
                input.nextLine();
                backAdminMenu = true;
            break;
        }
    } while (choice == 4);
}

else if(task ==6){
    //search
        //looping to search again
        do{
            System.out.printf("\n%-10s|------------------------------------|\n", "");
            System.out.printf("%-10s|             Search Product         |\n", "");
            System.out.printf("%-10s|------------------------------------|\n\n", "");
            //let user  to choose category to be search
            System.out.printf("\n|----------------------------------------------------------|\n");
            System.out.printf("|%-20s |1| Product Name %-20s|\n", "", "");
            System.out.printf("|%-20s |2| Product ID   %-20s|\n", "", "");
            System.out.printf("|----------------------------------------------------------|\n\n");
    
            //validation check -to ensure the user enter number inside range and correct data type
            do {
                try {
                    error = true;
                    System.out.print("Select the categories you want to search.(1-2) : ");
                    choice = input.nextInt();
                    input.nextLine();
    
                    if (choice < 1 || choice > 2) {
                        System.out.printf("\n%-10s|------------------------------------------|\n", "");
                        System.out.printf("%-10s|%-15sError!!!%-19s|\n", "", "", "");
                        System.out.printf("%-10s|--------------------------------------------|\n", "");
                        System.out.printf("%-10s|   Please enter digit between 1 to 2 only.  |\n", "");
                        System.out.printf("%-10s|--------------------------------------------|\n\n", "");
                        input.nextLine();
                    }
                    error = false;
                } catch (Exception e) {
                    digitError();
    
                    input.nextLine();
                }
            } while (error || choice < 1 || choice > 2);
    
            switch (choice) {
    
                case 1:
                    System.out.print("Enter the name to search : ");
                    String searchName = input.nextLine();
                    result = prodDetails.search(prodArr, 1, searchName);
                    if (result != -1) {
                        System.out.printf("\nID    :%s\nName  : %s\nQty   :%d\nPrice  :%.2f", prodArr[result].prodID, prodArr[result].prodName, prodArr[result].totalQty, prodArr[result].prodPrice);
                        System.out.print("\nDo you want to continue searching? (Y/N) : ");
                        ans = input.nextLine().charAt(0);
                        if(Character.toUpperCase(ans)=='N'){
                            System.out.print("\nPress enter to return to back to menu.\n");
                        input.nextLine();
                        input.nextLine();
                        backAdminMenu = true;
                        }
                    } else
                        System.out.printf("\n%-10s|------------------------------------|\n", "");
                    System.out.printf("%-10s|%-15sError!!!%-13s|\n", "", "", "");
                    System.out.printf("%-10s|------------------------------------|\n", "");
                    System.out.printf("%-10s|           No result found.         |\n", "");
                    System.out.printf("%-10s|------------------------------------|\n\n", "");
                    System.out.print("Do you want to continue searching? (Y/N) : ");
                    ans = input.nextLine().charAt(0);
                    if(Character.toUpperCase(ans)=='N'){
                        System.out.print("\nPress enter to return to back to menu.\n");
                    input.nextLine();
                    input.nextLine();
                    backAdminMenu = true;
                    }
    
                    break;
    
                case 2:
                    System.out.print("Enter the ID to search : ");
                    String searchID = input.nextLine();
                    result = prodDetails.search(prodArr, 2, searchID);
                    if (result != -1) {
                        System.out.printf("\nID    :%s\nName  : %s\nQty   :%d\nPrice  :%.2f", prodArr[result].prodID, prodArr[result].prodName, prodArr[result].totalQty, prodArr[result].prodPrice);
                        System.out.print("\nDo you want to continue searching? (Y/N) : ");
                    ans = input.nextLine().charAt(0);
                    if(Character.toUpperCase(ans)=='N'){
                        System.out.print("\nPress enter to return to back to menu.\n");
                    input.nextLine();
                    input.nextLine();
                    backAdminMenu = true;
                    }
                    } else {
                        System.out.printf("\n%-10s|------------------------------------|\n", "");
                        System.out.printf("%-10s|%-15sError!!!%-13s|\n", "", "", "");
                        System.out.printf("%-10s|------------------------------------|\n", "");
                        System.out.printf("%-10s|           No result found.         |\n", "");
                        System.out.printf("%-10s|------------------------------------|\n\n", "");
                        System.out.print("\nDo you want to continue searching? (Y/N) : ");
                        ans = input.nextLine().charAt(0);
                        if(Character.toUpperCase(ans)=='N'){
                            System.out.print("\nPress enter to return to back to menu.\n");
                        input.nextLine();
                        input.nextLine();
                        backAdminMenu = true;
                        }
                    }
                    break;
            }
        }while(Character.toUpperCase(ans) =='Y');
}//search product

else if(task == 7){
    int[] array = new int[10];
    double[] orders = new double[10];
    array[0] = 100;
    array[1] = 302;
    orders[0] = 120.50;
    orders[1]= 301.45;
    //report
    System.out.printf("\n|-----------------------------------------------------------------|\n");
    System.out.printf("|%-15s |1| Daily Sales Report                           |\n", "");
    System.out.printf("|%-15s |2| Transaction Report based on Staff            |\n", "");
    System.out.printf("|%-15s |3| Transaction Report based on Customer         |\n", "");
    System.out.printf("|%-15s |4| Point Collection Report                      |\n", "");
    System.out.printf("|%-15s |5| Product Stock Level Report                   |\n", "");
    System.out.printf("|-----------------------------------------------------------------|\n\n");

    System.out.print("Select a report to view(1-5) : ");
    choice = input.nextInt();

    if(choice ==1){

    System.out.println("____________________________________________________________________________________ ");
    System.out.printf("|%-32sDaily Sales Report%-32s|\n","","");
    System.out.println("|__________________________________________________________________________________|");
    System.out.println("+----------------------------------------------------------------------------------+");
    System.out.printf("| No. | Product ID  |       Product Name       | Product Quantity |  Subtotal(RM)  |\n");
    System.out.println("+----------------------------------------------------------------------------------+");
    for(i =0;i<2;i++){
    System.out.printf("| %-3d | %-10s |%25s |         %-6d |      %-9.2d |\n\n",i+1,prodArr[i].prodID,prodArr[i].prodName,prodArr[i].totalQty,300);
    }
    System.out.printf("|%82s|\n","");
    System.out.println("+----------------------------------------------------------------------------------+");
    System.out.print("\nPress enter to return to back to menu.\n");
                        input.nextLine();
                        input.nextLine();
                        backAdminMenu = true;
    }
    

    else if(choice == 2){
        System.out.println("______________________________________________________________________");
    System.out.printf("|%-14sTransaction Report based on Staff       %-14s|\n","","");
    System.out.println("|____________________________________________________________________|");
    System.out.println("+--------------------------------------------------------------------+");
    System.out.printf("| No. |  Staff ID   |        Staff Name           |    Sales (RM)    |\n");
    System.out.println("+--------------------------------------------------------------------+");
    for(i=0;i<staffArr.length;i++){
    System.out.printf("| %3d | %8s | %30s | %10d |\n",i+1,staffArr[i].id,staffArr[i].name,array[i]);
    }
    System.out.println("+--------------------------------------------------------------------+");
    System.out.print("\nPress enter to return to back to menu.\n");
                        input.nextLine();
                        input.nextLine();
                        backAdminMenu = true;
    }

    else if(choice ==3){
        System.out.println("______________________________________________________________________");
    System.out.printf("|%-16sTransaction Report based on Customer%-16s|\n","","");
    System.out.println("|____________________________________________________________________|");
    System.out.println("+--------------------------------------------------------------------+");
    System.out.printf("| No. |  Member ID  |      Customer Name          |    Orders (RM)   |\n");
    System.out.println("+--------------------------------------------------------------------+");
    for(i=0;i<memberArr.length;i++){
    System.out.printf("|%3d | %10s | %30s | % 10.2f |\n",i+1,memberArr[i].id,memberArr[i].name,orders[i]);
    }
    System.out.println("+--------------------------------------------------------------------+");
    System.out.print("\nPress enter to return to back to menu.\n");
                        input.nextLine();
                        input.nextLine();
                        backAdminMenu = true;
    }

    else if (choice ==4){
        System.out.println("______________________________________________________________________");
    System.out.printf("|%-23sPoint Collection Report%-22s|\n","","");
    System.out.println("|____________________________________________________________________|");
    System.out.println("+--------------------------------------------------------------------+");
    System.out.printf("| No. |  Member ID  |      Customer Name          |      Points       |\n");
    System.out.println("+--------------------------------------------------------------------+");
    for(i=0;i<memberArr.length;i++){
    System.out.printf("| %3d| %10s | %20s |                  %d      |\n",i+1,memberArr[i].id,memberArr[i].name,memberArr[i].getPoint());
    }
    System.out.println("+--------------------------------------------------------------------+");
    System.out.print("\nPress enter to return to back to menu.\n");
                        input.nextLine();
                        input.nextLine();
                        backAdminMenu = true;
}
}

else if (choice == 5){

    System.out.println("______________________________________________________________________");
    System.out.printf("|%-21sProduct Stock Level Report%-21s|\n","","");
    System.out.println("|____________________________________________________________________|");
    System.out.println("+--------------------------------------------------------------------+");
    System.out.printf("| No. |  Product ID  |      Product Name            |   Stock Left   |\n");
    System.out.println("+--------------------------------------------------------------------+");
    for(i=0;i<staffArr.length;i++){
    System.out.printf("| %3d | %10s | %20s | %10d |\n",i+1,prodArr[i].prodID,prodArr[i].prodName,prodArr[i].totalQty);
    }
    System.out.println("+--------------------------------------------------------------------+");
    System.out.print("\nPress enter to return to back to menu.\n");
                        input.nextLine();
                        input.nextLine();
                        backAdminMenu = true;
}

else if(choice == 8){

    System.out.printf("\n%-10s|------------------------------------|\n", "");
    System.out.printf("%-10s|             Add Staff              |\n", "");
    System.out.printf("%-10s|------------------------------------|\n\n", "");

    
    //password
    System.out.printf("Staff: %-5s",staff.countID());
    pw = checkPW();
    input.nextLine(); 

    name =checkName();
    input.nextLine();

    
    gender = checkGender();

    phoneNo = checkPhone();
    System.out.println("Admin = A\nStaff = S");
    System.out.print("Please choose position (A/S): ");
    char position = input.nextLine().charAt(0);
    input.nextLine();
    
    System.out.print("Please enter staff salary   : RM");
    double salary = input.nextDouble();
    input.nextLine();

    email = checkEmail();
    
    
    member.add(memberArr,pw,name,gender,phoneNo,email,username,0);

    System.out.print("Register successfully ! \n");
}

else{
    backMain=true;
}


            }while(backAdminMenu);

            }//admin
            
        }//if password correct 
        else{
            System.out.printf("\n%-10s|------------------------------------|\n", "");
        System.out.printf("%-10s|%-15sError!!!%-13s|\n", "", "", "");
        System.out.printf("%-10s|------------------------------------|\n", "");
        System.out.printf("%-10s|         Incorrect password.        |\n", "");
        System.out.printf("%-10s|------------------------------------|\n\n", "");
            error = true;
        }
    }
    
        }while(error);
        input.nextLine();
    }while(backMain);
    }//end main



    public static String checkPhone() {

        Scanner input = new Scanner(System.in);
        boolean error;
        String phoneNo;
        do {
            error = false;
            System.out.print("Enter your phone number(eg:0123456789): ");
            phoneNo = input.next();
            if (phoneNo.length() > 11 || phoneNo.length() < 7) {
                System.out.printf("\n%-10s|-----------------------------------------|\n", "");
                System.out.printf("%-10s|%-15sError!!!%-18s|\n", "", "", "");
                System.out.printf("%-10s|-----------------------------------------|\n", "");
                System.out.printf("%-10s| Phone number length should between 7-11.|\n", "");
                System.out.printf("%-10s|-----------------------------------------|\n\n", "");
                error = true;
            } else {
                for (int i = 0; i < phoneNo.length(); i++) {
                    if (!Character.isDigit(phoneNo.charAt(i))) {
                        digitError();
                        error = true;
                    }
                }
            }
        } while (error);

        return phoneNo;
    }

    public static String checkEmail() {

        Scanner input = new Scanner(System.in);
        boolean error;
        String email;
        do {
            error = false;
            System.out.print("Enter your email : ");
            email = input.next();
            String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
            Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = emailPat.matcher(email);
            error = matcher.find();
            if(!error){
                System.out.printf("\n%-10s|-----------------------------------------|\n", "");
                System.out.printf("%-10s|%-15sError!!!%-18s|\n", "", "", "");
                System.out.printf("%-10s|-----------------------------------------|\n", "");
                System.out.printf("%-10s| Please enter correct format for email.  |\n", "");
                System.out.printf("%-10s|-----------------------------------------|\n\n", "");
            }
        } while (!error);
        return email;
    }

    public static char checkGender() {

        Scanner input = new Scanner(System.in);
        boolean error;
        char gender;
        do {
            System.out.print("Choose you gender(F=female,M=male) : ");
            gender = input.nextLine().charAt(0);
            if (Character.toUpperCase(gender) != 'F' && Character.toUpperCase(gender) != 'M') {
                System.out.printf("\n%-10s|------------------------------------|\n", "");
                System.out.printf("%-10s|%-15sError!!!%-13s|\n", "", "", "");
                System.out.printf("%-10s|------------------------------------|\n", "");
                System.out.printf("%-10s|    You can only insert F or M.     |\n", "");
                System.out.printf("%-10s|------------------------------------|\n\n", "");
                error = true;
            } else
                error = false;
        } while (error);

        return gender;
    }

    public static String checkName() {

        Scanner input = new Scanner(System.in);
        boolean error ;
        String name;
        do {
            error = true;
            System.out.print("Enter your name : ");
            name = input.nextLine();
            for (int i = 0; i < name.length(); i++) {
                if (!Character.isLetter(name.charAt(i)) && name.charAt(i) != '/' && name.charAt(i) != '\''
                        && name.charAt(i) != ' ') {
                    System.out.printf("\n%-10s|--------------------------------------------------|\n", "");
                    System.out.printf("%-10s|%-22sError!!!%-20s|\n", "", "", "");
                    System.out.printf("%-10s|--------------------------------------------------|\n", "");
                    System.out.printf("%-10s|Name cannot contain digit or symbol except / or '.|\n", "");
                    System.out.printf("%-10s|--------------------------------------------------|\n\n", "");
                    error = true;
                } else
                    error = false;
            }
        } while (error);

        return name;
    }

    public static String checkPW() {

        Scanner input = new Scanner(System.in);
        boolean error;
        String pw;
        do {
            error = false;
            System.out.print("Please enter your password(length should between 8-16 characters or digits,cannot contain symbol and space.):");
            pw = input.next();
            if (pw.length() < 8 || pw.length() > 16) {
                System.out.printf("\n%-10s|------------------------------------|\n", "");
                System.out.printf("%-10s|%-15sError!!!%-13s|\n", "", "", "");
                System.out.printf("%-10s|------------------------------------|\n", "");
                System.out.printf("%-10s|  Length should between 8-16 only.  |\n", "");
                System.out.printf("%-10s|------------------------------------|\n\n", "");
                error = true;
            } else {
                for (int i = 0; i < pw.length(); i++) {
                    if (pw.charAt(i) == ' ' || !Character.isLetterOrDigit(pw.charAt(i))) {
                        System.out.printf("\n%-10s|----------------------------------------|\n", "");
                        System.out.printf("%-10s|%-17sError!!!%-15s|\n", "", "", "");
                        System.out.printf("%-10s|----------------------------------------|\n", "");
                        System.out.printf("%-10s|Password cannot contain symbol or space.|\n", "");
                        System.out.printf("%-10s|----------------------------------------|\n\n", "");
                        error = true;
                    }
                }
            }
        } while (error);

        return pw;
    }

    public static void digitError() {

        System.out.printf("\n%-10s|------------------------------------|\n", "");
                            System.out.printf("%-10s|%-15sError!!!%-13s|\n", "", "", "");
                            System.out.printf("%-10s|------------------------------------|\n", "");
                            System.out.printf("%-10s|    Please enter digit only.        |\n", "");
                            System.out.printf("%-10s|------------------------------------|\n\n", "");
    }
}