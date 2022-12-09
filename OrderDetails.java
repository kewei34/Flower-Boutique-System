import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrderDetails {

    private ProdDetails prodId;
    private ProdDetails prodName;
    private int orderQty;

    public OrderDetails(){
        this.orderQty = 0;
    }

    public OrderDetails(ProdDetails prodId,ProdDetails prodName,int orderQty){
        this.prodId = prodId;
        this.prodName = prodName;
        this.orderQty = orderQty;
    }

    public ProdDetails getProdId(){
        return prodId;
    }

    public ProdDetails getProdName(){
        return prodName;
    }

    public int getOrderQty(){
        return orderQty;
    }


    public OrderDetails[] add(OrderDetails[] orderProdArr,ProdDetails prodID,ProdDetails prodName,int qty ) {

        List<OrderDetails> newOrderProd = new ArrayList<OrderDetails>();
        //check whether orderArr is null or not
        if(Arrays.asList(orderProdArr).contains(null))
        {
            OrderDetails[] temp = new OrderDetails[1];
            temp[0]= new OrderDetails(prodId,prodName,qty);

            newOrderProd.add(temp[0]);
        }
        else{   //if no null, add product information to array
        Collections.addAll(newOrderProd,orderProdArr);
        OrderDetails[] temp = new OrderDetails[orderProdArr.length+1];
        temp[orderProdArr.length]= new OrderDetails(prodId,prodName,qty);

        newOrderProd.add(temp[orderProdArr.length]);
        }

        orderProdArr = newOrderProd.toArray(orderProdArr);

        return orderProdArr;

    }

	public void add(OrderDetails[] orderProdArr, String prodID2, String prodName2, int amount) {
	}

    
}
