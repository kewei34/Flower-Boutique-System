
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProdDetails {

    protected String prodID;
    protected String prodName;
    protected int totalQty;
    protected double prodPrice;

    // constructors
    public ProdDetails() {
        this.prodID = "";
        this.prodName = "";
        this.prodPrice = 0.0;
        this.totalQty = 0;
    }

    public ProdDetails(String prodID, String prodName, int totalQty, double prodPrice) {

        this.prodID = prodID;
        this.prodName = prodName;
        this.totalQty = totalQty;
        this.prodPrice = prodPrice;
    }

    // getter and setter
    public String getProdID() {
        return prodID;
    }

    public String getProdName() {
        return prodName;
    }

    public double getProdPrice() {
        return prodPrice;
    }

    public int getTotalQty() {
        return totalQty;
    }

    public void setProdID(String prodID) {
        this.prodID = prodID;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public void setProdPrice(double prodPrice) {
        this.prodPrice = prodPrice;
    }

    public void setTotalQty(int totalQty) {
        this.totalQty = totalQty;
    }

    //for displaying all product details
    public void display(ProdDetails[] prodArr) {

        System.out.printf("No. ID%5s Name%30s Quantity   Price \n","","");
        System.out.print("------------------------------------------------------------------\n");
        for(int i=0;i<prodArr.length;i++){
            System.out.printf("%-3d %-7s %-37s %-2d    RM %7.2f \n",i+1,prodArr[i].prodID,prodArr[i].prodName,prodArr[i].totalQty,prodArr[i].prodPrice);
        }
    }


    //for display customer menu
    //order
     //move
     

    public String toString() {
        return "\nName : " +  prodName + "\nPrice : RM" + prodPrice + "\n";
    }

    // generate product ID
    public String countID(ProdDetails[] prodArr) {

        int length = prodArr.length+1;
        if (length < 10) {
            return String.format("P" + "00" + length);
        } else if(length<100)
            return String.format("P" + "0" + length);
         else
         return String.format("P" + length);
    }

    //add new product
    public ProdDetails[] add(ProdDetails[] prodArr, String name, int qty, double price) {

        //use array list as temporary storage
        List<ProdDetails> newProd= new ArrayList<ProdDetails>();    
        Collections.addAll(newProd, prodArr);
        ProdDetails[] temp = new ProdDetails[prodArr.length+1];

        //update new product
        temp[prodArr.length]= new ProdDetails(countID(prodArr),name,qty,price);
        newProd.add(temp[prodArr.length]);

        //convert to array
        prodArr = newProd.toArray(prodArr);

        return prodArr;
        
    }


    //overloading
    public void edit(ProdDetails[] prodArr,int newQty,int prodNo){

        prodArr[prodNo-1].totalQty = newQty;
    }

    //overloading
    public void edit(ProdDetails[] prodArr,String name,int prodNo){

        prodArr[prodNo-1].prodName = name;
    }

    //overloading
    public void edit(ProdDetails[] prodArr,double price,int prodNo){

        prodArr[prodNo-1].prodPrice = price;
    }

    public int search(ProdDetails[] prodArr,int choice,String search){

        
        if (choice == 1){

            for(int i=0;i<prodArr.length;i++){

                if(search.equalsIgnoreCase(prodArr[i].prodName)){
                    return i;
                }

                else{
                     if(i == prodArr.length){
                    return -1;
                }
                else 
                continue;
            }
                
            }
        }
        else{
            for(int i=0;i<prodArr.length;i++){

                if(search.equalsIgnoreCase(prodArr[i].prodID)){
                    return i;
                }
                else{
                if(i == prodArr.length){
                    return -1;
                }
                else 
                continue;
                }
                
            }
        }
        return -1;
        
        

    }
   
}