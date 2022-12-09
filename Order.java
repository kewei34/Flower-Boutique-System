import java.util.*;


import java.lang.Character;

public class Order {

    private String orderID;
    private String memberID;
    private String staffID;
    private OrderDetails[] orderProdArr;
    private double subTotal;  //to store all the subtotal of the products selected
    private static int countOrder = 0;

    //no arg constructer
    public Order() {

        subTotal = 0.00;
    }
    //argument constructor
    public Order(String orderID, String memberID, String staffID, OrderDetails[] orderProdArr, double subTotal) {
        this.orderID = orderID;
        this.memberID = memberID;
        this.staffID = staffID;
        this.orderProdArr = orderProdArr;
        this.subTotal = subTotal;
    }
    //getter
    public double getSubTotal() {
        return subTotal;
    }


    public void displayOrder(int totalOrder, int[][] orderChoice, ProdDetails[] prodArr) {
        double total = 0;
        System.out.println("\n|---------------------------------------------------------------------------------------------|");
        System.out.printf("|%-37sOrder Note%-46s|\n","","");
        System.out.println("|---------------------------------------------------------------------------------------------|");
        System.out.printf("|No.  Product Name: %-20s Product Price: %-10s Quantity: %-5s Subtotal %-2s|\n", "", "", "", "");
        System.out.printf("|%-93s|\n","");
        for (int i = 0; i < totalOrder; i++) {
            System.out.printf("|%-2d)  %-35s  RM%-23.2f  %-11d  RM%-9.2f|\n", i+1,prodArr[orderChoice[i][0] - 1].prodName, prodArr[orderChoice[i][0] - 1].prodPrice, orderChoice[i][1], prodArr[orderChoice[i][0] - 1].prodPrice * orderChoice[i][1]);
            System.out.printf("|%-93s|\n","");
            total += prodArr[orderChoice[i][0] - 1].prodPrice * orderChoice[i][1];
        }
        System.out.print("|---------------------------------------------------------------------------------------------|\n");
        System.out.printf("|%-71s Total  =  RM%-9.2f|\n", "", total);
        System.out.print("|---------------------------------------------------------------------------------------------|\n");
        subTotal = total;
    }

    // generate order ID
    public String countID() {

        if (countOrder < 10) {
            return String.format("R" + "00" + countOrder);
        } else if(countOrder<100)
            return String.format("R" + "0" + countOrder);
         else
         return String.format("R" + countOrder);
    }

    //add the order record into array
    public Order[] add(Order[] orderArr,String memberID,String staffID,OrderDetails[] orderProdArr,double subtotal){
        List<Order> newOrder = new ArrayList<Order>();
        //check whether orderArr is null or not
        if(Arrays.asList(orderArr).contains(null))
        {
            Order[] temp = new Order[5];
            temp[0]= new Order(this.countID(),memberID,staffID,orderProdArr,subtotal);

            newOrder.add(temp[0]);
        }
        else{   //if no null, add product information to array
        Collections.addAll(newOrder,orderArr);
        Order[] temp = new Order[orderArr.length+5];
        temp[orderArr.length]= new Order(this.countID(),memberID,staffID,orderProdArr,subtotal);

        newOrder.add(temp[orderArr.length]);
        }

        orderArr = newOrder.toArray(orderArr);

        return orderArr;

    }

    public void displayOrderMenu(ProdDetails[] prodArr){

        for (ProdDetails prod : prodArr) {
            System.out.print(prod);
        }
    }

}