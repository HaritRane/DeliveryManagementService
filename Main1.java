package  cms;
import java.util.Scanner;
public class Main1
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int opt1,opt2,opt3;
        char option;
        System.out.println("\t\t\t*********WELCOME TO ONLINE DELIVERY SYSTEM*********");
        System.out.println("\t\t\t---------------customer is our number 1 priority!--");
        do
        {
            System.out.println("\n\n\nPLEASE ENTER 1 IF YOU ARE CUSTOMER !!");
            System.out.println("PLEASE ENTER 2 IF YOU ARE EMPLOYEE !!");

            opt1=sc.nextInt();
            switch(opt1)
            {
                case 1:
                    Customer c=new Customer();
                    System.out.println("WELCOME DEAR CUSTOMER!!");
                    do
                    {
                        System.out.println("\n-------MENU-------");
                        System.out.println("Press 1 to place order");
                        System.out.println("Press 2 to display order");
                        System.out.println("Press 3 to track order");
                        System.out.println("Press 4 to EXIT");
                        opt2=sc.nextInt();
                        switch(opt2)
                        {
                            case 1:
                                c.accept_order();
                                System.out.println("ORDER ACCEPTED");
                                break;
                            case 2:
                                c.display_order();
                                break;
                            case 3:

                                break;
                            case 4:
                                System.out.println("--THANK YOU!---");
                                System.out.println("--DO VISIT AGAIN SOON!---");
                                break;
                            default:System.out.println("Please enter valid option");

                        }
                        System.out.println("\n---DEAR USER would you like to place or visit another order!!--");
                        System.out.println("---IF YES,input y else input n!!---");

                        option = sc.next().charAt (0);
                    }
                    while(option == 'y');
                    break;
                case 2:
                    System.out.println("WELCOME EMPLOYEE!!");
                    Employee e=new Employee();
                    do
                    {
                        System.out.println("\n-------MENU-------");
                        System.out.println("Press 1 to DISPLAY LIST ");
                        System.out.println("Press 2 to UPDATE DETAILS ");//list ,upd status
                        System.out.println("Press 3 to VIEW TODAYS QUEUE");
                        System.out.println("Press 4 to EXIT");
                        opt2=sc.nextInt();
                        switch(opt2)
                        {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                System.out.println("--THANK YOU!---");
                                break;
                            default:System.out.println("Please enter valid option");
                        }
                        System.out.println("\nDEAR USER would you like to edit or visit another order");
                        System.out.println("IF YES,input y else input n");

                        option = sc.next().charAt (0);
                    }
                    while(option == 'y');
                    break;
                default:System.out.println("Please enter valid option");
            }
            System.out.println("WOULD YOU LIKE TO EXIT MAIN MENU PRESS 0,else PRESS 1 ");
            opt3=sc.nextInt();
        }while(opt3!=0);
        System.out.println("----THANKYOU!----");
    }
}
class details
{
    String name,order;
    int price,size,id,date,weight;
    String end_des,status;
    details()
    {
        name=null;
        order=null;
        size=0;
        price=0;
        date=0;
        id=0;
        end_des=null;

    }
}
class Customer
{
    details user=new details();
    Scanner sc=new Scanner(System.in);
    void accept_order()
    {
        int op,id=0;
        System.out.println("Please enter NAME:");
        user.name=sc.next();
        System.out.println("\nAVAILABLE BOUQUETS:");
        System.out.println("Please enter ORDER:");
        System.out.println("PRESS 1 FOR ROSE FLOWERS");
        System.out.println("PRESS 2 FOR LILY FLOWERS");
        System.out.println("PRESS 3 FOR ORCHID FLOWERS");
        op=sc.nextInt();
        if(op==1)
        {
            user.order="rose";
            System.out.println("ROSE FLOWERS BOUQUET BOOKED");
        }
        if(op==2)
        {
            user.order="lily";
            System.out.println("LILY FLOWERS BOUQUET BOOKED");
        }
        if(op==3)
        {
            user.order="orchid";
            System.out.println("ORCHID FLOWERS BOUQUET BOOKED");
        }
        System.out. println("\nEnter the size of Bouquet as per S-small, M-medium ,L-large:");
        user.size = sc.next().charAt(0);
        //assign price according to size
        if (user.size == 'S' || user.size == 's')
        {
            user.price = 150;
            System.out.println("SIZE S BOOKED!(PRICE=150 ruppes)");
        }
        else if (user.size == 'M' || user.size == 'm')
        {
            user.price = 300;
            System.out.println("SIZE M BOOKED!(PRICE=300 ruppes)");
        }
        else if (user.size == 'L'||user.size=='l')
        {
            user.price = 450;
            System.out.println("SIZE L BOOKED!(PRICE=450ruppes)");
        }

        System.out.println("\nAVAILABLE AREAS FOR DELIVERY:");
        System.out.println("Enter 1 for KARVENAGAR AREA");
        System.out.println("Enter 2 for DECCAN AREA");
        System.out.println("Enter 3 for BANER AREA");
        System.out.println("Enter 4 for AUNDH AREA");
        System.out.println("Enter 5 for WARJE AREA");
        int c=sc.nextInt();

        if(c==1)
        {
            user.end_des="KARVENAGAR";
            user.weight=1;
        }
        if(c==2)
        {
            user.end_des="WARJE";
            user.weight=2;
        }
        if(c==3)
        {
            user.end_des="DECCAN";
            user.weight=3;
        }
        if(c==4)
        {
            user.end_des="BANER";
            user.weight=4;
        }
        if(c==5)
        {
            user.end_des="AUNDH";
            user.weight=5;
        }
        id=id+1;
        user.id=id;
        System.out.println("PLease enter date for delivery:");
        user.date=sc.nextInt();

        System.out.println("DEAR USER,WE THANK YOU FOR YOUR COOPERATION!");

    }
    void display_order()
    {
        System.out.println("YOUR ORDER IS ACCEPTED!!");
        System.out.println("\n\n---ORDER DETAILS---");
        System.out.println("CUSTOMER NAME:"+user.name);
        System.out.println("CUSTOMER ORDER:"+user.order);
        System.out.println("ORDER SIZE:"+user.size);
        System.out.println("ORDER PRICE:"+user.price);
        System.out.println("ORDER UNIQUE ID:"+user.id);
        System.out.println("ORDER DELIVERY DATE:"+user.date);
        System.out.println("ORDER END DESTINATION:"+user.end_des);
    }
    void track_order()
    {
        System.out.println("Please enter your UNIQUE ID of Order");
        int find_uniqueid=sc.nextInt();

        {
            System.out.println("The order status of your order is:"+user.order);
        }
    }

}
class Employee
{
    void list_display()
    {

    }
    void update_list()
    {

    }
    void todays_list()
    {

    }


}