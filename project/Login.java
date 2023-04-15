package project;

import java.util.*;
import java.io.*;
class randompass 
{
    public String generate()
    {

        String UPPER="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower="abcdefghijklmnopqrstuvwxyz";
        String num="1234567890";
        String symbols="!@#$%^&*(){}[]<>?/";
        String combination=UPPER+lower+num+symbols;

        char[] password=new char[8];
        Random r=new Random();

        for(int i=0;i<8;i++)
        {
            password[i]=combination.charAt(r.nextInt(combination.length()));
        }
        return new String(password);
    }
}

class CreateUser 
{ 

    //scanner
    Scanner input=new Scanner(System.in);

    //defining variables
    String Fname,Lname,phone,password,password1,password2,username;
    Long Accnum=21364019020L;
    Long balance;
    int ifscCode;

    Boolean C = false;


    public void checkpass()
    {

        while (!C) 
        {
            System.out.print("\nplease set your password :");
            password1 = input.next();

            if (password1.length() < 8) 
            {
                System.out.println("\nNOTE : your password must contain lower case,upper case letter and a symbol");
                System.out.println("\nyour password must contain atleast 8 letters");
            } 

            else 
            {
                System.out.print("\nplease confirm your password :");
                password2 = input.next();

                if (Objects.equals(password1, password2)) 
                {
                C = true;
                System.out.println("\nyour password set successfully");
                } 
                else 
                {
                    System.out.println("\n\nplease check your password and try agin\n");
                }
            }
        }
        password = password1;
    }


        public void checknames()
    {        
        Boolean C = false;
        while (!C) 
        {
            System.out.print("\n");

            if (Fname.length() < 3) 
            {
                if(Lname.length()<3||Lname.length()>16)
                {
                    System.out.println("\nyour first name and last name must contain atleast 3 letters\n");
                }

                else
                {
                    System.out.println("\nyour first name must contain atleast 3 letters\n");
                    System.out.print("\nplease enter your first name :");
                    Fname= input.next();
                } 
            }

            else if(Lname.length()<3)
            {
                System.out.println("\nyour last name must contain atleast 3 letters\n");
                System.out.print("\nplease enter your last name :");
                Lname=input.nextLine();
            }

            else if (Objects.equals(Fname, Lname)) 
            {
               System.out.println("sorry! first name and last name cannot be same\n\n");
               System.out.print("\nplease enter your first name :");
               Fname = input.nextLine();
               System.out.print("\nplease enter your last name :");
               Lname = input.nextLine();
            } 

            else 
            {
                C = true;
            }
        }
    }
       
    public void getUserDetails() 
    {
        randompass pass=new randompass();
        String G=pass.generate();
        System.out.print("\nplease enter your first name :");
        Fname = input.nextLine();
        System.out.print("\nplease enter your last name :");
        Lname = input.nextLine();
        checknames();
        System.out.print("please enter your phone number :");
        phone = input.next();
        System.out.println("\n\nyour randomly generated password is : "+""+G);
        System.out.println("do you want to use the random password\n if yes please enter Y\n if no please enter N");
        char z=input.next().charAt(0);

        if(z=='y'||z=='Y')
        {
            password=G;
            System.out.println("your password has been set successfully");
        }

        else
        {
            checkpass();
        }
        
    }
    
    public Long GENACC(){
        Long ACC= Accnum+1;
        Accnum=ACC;
        return Accnum;
    }

    public void SetUserDetails() 
    {
         System.out.println("\n\nyou have succesfully created your account\n");
         username = (this.Lname + this.Fname).replaceAll(" ", "");
         Accnum = GENACC();
         balance = 20000L;
         ifscCode = 12509;
        
    }

    public void SetUserDetails(String FN,String LN,String PASS,String PH) 
    {
        username = (LN + FN).replaceAll(" ", "");
        password=PASS;
        phone=PH;
        Accnum = GENACC();
        balance = 20000L;
        ifscCode = 12509;
    }

    public void Login(String U,String P) 
    {
        
        System.out.println("please enter your username and password to continue login");
        System.out.print("\nplease enter your username : ");
        String name =input.next();
        System.out.print("\nplease enter your password :");
        String p=input.next();

        if(Objects.equals(name, U)&&Objects.equals(P,p ))
        {
            System.out.println("you have logged in successfully");
            printUserDetails();
        }
        else
        {
            System.out.println("your login details are incorrect");
        }
    }

    public void printUserDetails()
    {
        System.out.println("\n username : " + username);
        System.out.println("\n your password is "+password.substring(0, 3)+""+"*****\n");
        System.out.println(  " account number : " + Accnum);
        System.out.println("\n branch IFSC code : " + ifscCode);
        System.out.println("\n your phone number is "+"+91-"+phone);
        System.out.println("\n account balance : " + balance);
    }
}


public class Login
{
    public static void main(String[] args) 
    {
        Scanner input=new Scanner(System.in);
        //bank name
        System.out.println("\n\n\t\t\t\t\t\t welcome to SBI\n ");

        //creating user 1
        CreateUser user1 = new CreateUser();
        user1.SetUserDetails("manohar","pesaravai","manohar@","7672060147");
      
        //creating user 2
        CreateUser user2 = new CreateUser();
        user2.SetUserDetails("girinath"," pesaravai","Girinath","8978317767");
        
        //login

        System.out.println("\n\npress L to login & press S to signup");

        char y=input.next().charAt(0);
        if(y=='L'||y=='l')
        {
           user1.Login(user1.username,user1.password);
        }

        else if(y=='s'||y=='s')
        {
            System.out.println("please enter the following details to sign");
            CreateUser sign=new CreateUser();
            sign.getUserDetails();
            sign.SetUserDetails();
            //sign.printUserDetails();
            sign.Login(sign.username,sign.password);
        }

        else
        {
            System.out.println("please enter a valid input");
        }
        input.close();
    }
}
