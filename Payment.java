import java.util.Date;

public class Payment
{
    public static double sst = 0.06;
    public static double memberDiscount = 0.10;
    private double total;
    private int point;
    private double grandTotal ;
    private Date paymentDate;

    public Payment(){    //non-arg constructor
        total =0.00;
        grandTotal = 0.00;
        paymentDate = new Date();
    }

    public Payment(double total,double grandTotal,Date paymentDate)   //arg constructor
    {
        this.total = total;
        this.grandTotal = grandTotal;
        paymentDate = new Date();
    }

    public double getTotal()    //getter for total
    {
        return total;
    }

    public double getGrandTotal() // getter for grandtotal
    {
        return grandTotal;
    }

    public Date getPaymentDate()  //getter for payment date
    {
        return paymentDate;
    }

    public double calculateTotalOrder(double total)  //function to calculate total order
    {
        return total + total*sst - total*memberDiscount;
    }

    
    public void displayPayment(double total)   //to display the payment information
    {
        System.out.println("\n|-------------------------------------------|");
        System.out.printf("|%-15sPayment Note                |\n","");
        System.out.println("|-------------------------------------------|");
        System.out.printf("|     Price before discount :  RM%-8.2f   |\n",total);
        System.out.printf("|     GST (6%%)              :  RM%-8.2f   |\n",6.8);
        System.out.printf("|     Member discount       : -RM%-8.2f   |\n",total*memberDiscount );
        System.out.printf("|     Grand Total           :  RM%-8.2f   |\n",total + total*sst - total*memberDiscount);
        System.out.println("|-------------------------------------------|");
    }

    public void calculateBalance(double amountToPay, double total)    //to calculate the balance and display an order receipt
    {
        point = (int)total;

            System.out.println("\n|------------------------------------------------|");
            System.out.printf("|  Today's Date: %tF                      |\n",paymentDate);  //to show the date of purchase
            System.out.print("|  Payment Successful                            |\n");
            System.out.printf("|  Your Balance is RM%-8.2f                    |\n",amountToPay-total);
            System.out.printf("|  Congratulations, You have earned %-4d points  |\n",point);
            System.out.println("|------------------------------------------------|");
        

    }
}

