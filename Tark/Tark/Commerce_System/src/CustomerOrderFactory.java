

//Use Factory to create opject without know the details of concrete class


public class CustomerOrderFactory {  
    public static CustomerOrder createOrderProcessor( String Location, double TotalPrice, String type,String CstmrName) {
        switch (type.toLowerCase()) {
            case "standard":
                return new CustomerOrder(Location,TotalPrice,"Standard",CstmrName);
            case "express":
                return new CustomerOrder(Location,TotalPrice,"Standard",CstmrName);
            default:
                throw new IllegalArgumentException("Unknown category");
        }
    }
      
}
