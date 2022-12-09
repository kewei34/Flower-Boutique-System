public class Report {
    
    

public static void main(String[] args)
{
    System.out.println("____________________________________________________________________________________ ");
    System.out.printf("|%-32sDaily Sales Report%-32s|\n","","");
    System.out.println("|__________________________________________________________________________________|");
    System.out.println("+----------------------------------------------------------------------------------+");
    System.out.printf("| No. | Product ID  |       Product Name       | Product Quantity |  Subtotal(RM)  |\n");
    System.out.println("+----------------------------------------------------------------------------------+");
    System.out.printf("|%82s|\n","");
    for(int i =0;i<orderArr.length;i++){
    System.out.printf("| %-3d | %-10s |%25s |         %-6d |      %-9.2f |\n\n",i,);
    }
    System.out.printf("|%82s|\n","");
    System.out.println("+----------------------------------------------------------------------------------+");
    


    System.out.println("\n");



    System.out.println("______________________________________________________________________");
    System.out.printf("|%-14sTransaction Report based on Sales Person%-14s|\n","","");
    System.out.println("|____________________________________________________________________|");
    System.out.println("+--------------------------------------------------------------------+");
    System.out.printf("| No. |  Staff ID   |        Staff Name           |    Sales (RM)    |\n");
    System.out.println("+--------------------------------------------------------------------+");
    System.out.printf("|%68s|\n","");
    System.out.printf("|%68s|\n","");
    System.out.println("+--------------------------------------------------------------------+");
    

    System.out.println("\n");


    System.out.println("______________________________________________________________________");
    System.out.printf("|%-16sTransaction Report based on Customer%-16s|\n","","");
    System.out.println("|____________________________________________________________________|");
    System.out.println("+--------------------------------------------------------------------+");
    System.out.printf("| No. |  Member ID  |      Customer Name          |    Orders (RM)   |\n");
    System.out.println("+--------------------------------------------------------------------+");
    System.out.printf("|%68s|\n","");
    System.out.printf("|%68s|\n","");
    System.out.println("+--------------------------------------------------------------------+");
    
    
    System.out.println("\n");


    System.out.println("______________________________________________________________________");
    System.out.printf("|%-23sPoint Collection Report%-22s|\n","","");
    System.out.println("|____________________________________________________________________|");
    System.out.println("+--------------------------------------------------------------------+");
    System.out.printf("| No. |  Member ID  |      Customer Name          |      Points      |\n");
    System.out.println("+--------------------------------------------------------------------+");
    System.out.printf("|%68s|\n","");
    System.out.printf("|%68s|\n","");
    System.out.println("+--------------------------------------------------------------------+");
    

    System.out.println("\n");

    
    System.out.println("______________________________________________________________________");
    System.out.printf("|%-21sProduct Stock Level Report%-21s|\n","","");
    System.out.println("|____________________________________________________________________|");
    System.out.println("+--------------------------------------------------------------------+");
    System.out.printf("| No. |  Product ID  |      Product Name            |   Stock Left   |\n");
    System.out.println("+--------------------------------------------------------------------+");
    System.out.printf("|%68s|\n","");
    System.out.printf("|%68s|\n","");
    System.out.println("+--------------------------------------------------------------------+");


}

}
