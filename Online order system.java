package onlineorder;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Onlineorder{
    public static void main(String[] args){
        JDialog.setDefaultLookAndFeelDecorated(true);
        String f,d,m,input,foodorder = "",drinkorder = "",name,user,passw,email;
        String nameformat = "([a-zA-Z\\-]+){6,}\\s+([a-zA-Z\\-]+){6,}";
        String usernameformat = "^[a-zA-Z]{6,10}$";
        String passwordformat = "^(?=.*\\d)(?=.*[a-zA-Z])[a-zA-Z0-9]{6,20}$";
        String emailformat = "^(.+)@(.+)$";
        int r,discount,quantity = 0;
        double foodprice,drinkprice,totalprice = 0,totalamount,grandtotal;
        boolean y = true;
        DecimalFormat x = new DecimalFormat("#0.00");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
	Date date = new Date();
        String[] food = {"Beef Boat Noodle","Chicken Boat Noodle","Somtam with Salted Eggs","Ka Prao Beef Rice","Nasi Goreng Sotong Goreng"};
        String[] drink = {"Thai Milk Tea","Thai Milk Green Tea","Nanas Rambutan Asam Boi","Thai Coconut"};
        String[] method = {"Dine In","Take Away"};
        String[][] menu = {{"-------------------------- Thailand's Menu --------------------------"
                + "\nFood\n\nBeef Boat Noodle                          :   RM 1.90","Chicken Boat Noodle                   :   RM  1.90","Somtam with Salted Eggs          :   RM  8.90"
                ,"Ka Prao Beef Rice                        :   RM 9.90","Nasi Goreng Sotong Goreng      :   RM 9.90"},
                {"\n\nDrink\n\nThai Milk Tea                                 :   RM 3.30","Thai Milk Green Tea                    :   RM 3.30",
                 "Nanas Rambutan Asam Boi      :   RM 3.80","Thai Coconut                                 :   RM 5.90"
                +"\n\nIf Buy More Than RM 20, Get 10% Discount (Member)"}};                      
        JOptionPane.showMessageDialog(null,menu,"Dope Alley",JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null,"                    Welcome To Dope Alley          ","Dope Alley",JOptionPane.PLAIN_MESSAGE);
        r = JOptionPane.showConfirmDialog(null,"Urgent Customer ? ","Dope Alley",JOptionPane.YES_NO_OPTION);
        do{
            if(JOptionPane.YES_OPTION == r){
                do{
                    f = (String)JOptionPane.showInputDialog(null,"Type of food you want","Dope Alley",JOptionPane.QUESTION_MESSAGE,null,food,food[0]);
                    if(f.equals(food[0])||f.equals(food[1])){
                        foodprice = 1.90;
                    }else if(f.equals(food[2])){
                        foodprice = 8.90;
                    }else{
                        foodprice = 9.90; 
                    }
                    do{
                        try{
                            input = (String) JOptionPane.showInputDialog(null,"Food quantity","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                            quantity = Integer.parseInt(input);
                            if(quantity <= 0 || quantity > 100){
                                JOptionPane.showMessageDialog(null,"Invalid input . Number only .\n\nMininum order = 1\nMaximum order = 100","Dope Alley",JOptionPane.ERROR_MESSAGE);
                            }
                        }catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(null,"Invalid input . Number only .\n\nMininum order = 1\nMaximum order = 100","Dope Alley",JOptionPane.ERROR_MESSAGE);
                        }
                    }while(quantity <= 0 || quantity > 100);
                    foodorder = foodorder + f +"          RM "+x.format(foodprice)+" per each x "+quantity+"\n";
                    totalprice = totalprice + (foodprice * quantity);
                    input = (String)JOptionPane.showInputDialog(null,"Do you want to purchase another food ?\n\nEnter [Y] for Yes\nEnter [N] for No","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                    while(input.equalsIgnoreCase("y")!=y && input.equalsIgnoreCase("n")!=y){
                        JOptionPane.showMessageDialog(null,"Invalid input . Use correct format (character only) !","Dope Alley",JOptionPane.ERROR_MESSAGE);
                        input = (String)JOptionPane.showInputDialog(null,"Do you want to purchase another food ? \n\nEnter [Y] for Yes\nEnter [N] for No","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                    }
                }while(input.equalsIgnoreCase("y")==y);
                do{
                    d = (String)JOptionPane.showInputDialog(null,"Type of drink you want","Dope Alley",JOptionPane.QUESTION_MESSAGE,null,drink,drink[0]);
                    if(d.equals(drink[0])||d.equals(drink[1])){
                        drinkprice = 3.30;
                    }else if(d.equals(drink[2])){
                        drinkprice = 3.80;
                    }else{
                        drinkprice = 5.90;
                    }
                    do{
                        try{
                            input = (String) JOptionPane.showInputDialog(null,"Drink quantity","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                            quantity = Integer.parseInt(input);
                            if(quantity <= 0 || quantity > 100){
                                JOptionPane.showMessageDialog(null,"Invalid input . Number only .\n\nMininum order = 1\nMaximum order = 100","Dope Alley",JOptionPane.ERROR_MESSAGE);
                            }
                        }catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(null,"Invalid input . Number only .\n\nMininum order = 1\nMaximum order = 100","Dope Alley",JOptionPane.ERROR_MESSAGE);
                        }
                    }while(quantity <= 0 || quantity > 100);
                    drinkorder = drinkorder + d +"          RM "+x.format(drinkprice)+" per each x "+quantity+"\n";
                    totalprice = totalprice + (drinkprice * quantity);
                    input = (String)JOptionPane.showInputDialog(null,"Do you want to purchase another drink ?\n\nEnter [Y] for Yes\nEnter [N] for No","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                    while(input.equalsIgnoreCase("y")!=y && input.equalsIgnoreCase("n")!=y){
                        JOptionPane.showMessageDialog(null,"Invalid input . Use correct format (character only) !","Dope Alley",JOptionPane.ERROR_MESSAGE);
                        input = (String)JOptionPane.showInputDialog(null,"Do you want to purchase another drink ?\n\nEnter [Y] for Yes\nEnter [N] for No","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                    }
                }while(input.equalsIgnoreCase("y")==y);
                totalamount = totalprice + (totalprice * 6/100);
                JOptionPane.showMessageDialog(null,"Food : \n"+foodorder+"\nDrink : \n"+drinkorder+"\n\nTotal Price : RM "+x.format(totalprice),"Dope Alley",JOptionPane.PLAIN_MESSAGE);
                m = (String)JOptionPane.showInputDialog(null,"Do you want to Dine In or Take Away ? ","Dope Alley",JOptionPane.QUESTION_MESSAGE,null,method,method[0]);
                JOptionPane.showMessageDialog(null,dateFormat.format(date)+"\nMethod : "+m+"\n\nFood : \n"+foodorder+"\nDrink : \n"+drinkorder+"\n\nTotal Price : RM "+x.format(totalamount)
                        +"\nIncluding GST 6%","Dope Alley",JOptionPane.PLAIN_MESSAGE);
            }else{
                r = JOptionPane.showConfirmDialog(null,"Do you have login ID ? ","Dope Alley",JOptionPane.YES_NO_OPTION);
                if(JOptionPane.YES_OPTION == r){
                    user = (String)JOptionPane.showInputDialog(null,"Username","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                    while(user.matches(usernameformat)!=y){
                        JOptionPane.showMessageDialog(null,"Invalid input . Use correct format (character only) !\nLength must be in between 6-10 characters.\n\nExample : aainaa","Dope Alley",JOptionPane.ERROR_MESSAGE);
                        user = (String)JOptionPane.showInputDialog(null,"Username","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                    }
                    passw = (String)JOptionPane.showInputDialog(null,"Password","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                    while(passw.matches(passwordformat)!=y){
                        JOptionPane.showMessageDialog(null,"Invalid input . Use correct format (AlphaNum) !\nLength must be in between 6-20 characters.\n\nExample : aainaa95","Dope Alley",JOptionPane.ERROR_MESSAGE);
                        passw = (String)JOptionPane.showInputDialog(null,"Password","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                    }
                    JOptionPane.showMessageDialog(null,"----------------------- Profile Details -----------------------\n\nUsername  : "+user+"\nPassword   : "+passw,"Dope Alley",JOptionPane.PLAIN_MESSAGE);
                    do{
                        f = (String)JOptionPane.showInputDialog(null,"Type of food you want","Dope Alley",JOptionPane.QUESTION_MESSAGE,null,food,food[0]);
                        if(f.equals(food[0])||f.equals(food[1])){
                            foodprice = 1.90;
                        }else if(f.equals(food[2])){
                            foodprice = 8.90;
                        }else{
                            foodprice = 9.90; 
                        }
                        do{
                            try{
                                input = (String) JOptionPane.showInputDialog(null,"Food quantity","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                                quantity = Integer.parseInt(input);
                                if(quantity <= 0 || quantity > 100){
                                    JOptionPane.showMessageDialog(null,"Invalid input . Number only .\n\nMininum order = 1\nMaximum order = 100","Dope Alley",JOptionPane.ERROR_MESSAGE);
                                }
                            }catch(NumberFormatException e){
                                JOptionPane.showMessageDialog(null,"Invalid input . Number only .\n\nMininum order = 1\nMaximum order = 100","Dope Alley",JOptionPane.ERROR_MESSAGE);
                            }
                        }while(quantity <= 0 || quantity > 100);
                        foodorder = foodorder + f +"          RM "+x.format(foodprice)+" per each x "+quantity+"\n";
                        totalprice = totalprice + (foodprice * quantity);
                        input = (String)JOptionPane.showInputDialog(null,"Do you want to purchase another food ?\n\nEnter [Y] for Yes\nEnter [N] for No","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                        while(input.equalsIgnoreCase("y")!=y && input.equalsIgnoreCase("n")!=y){
                            JOptionPane.showMessageDialog(null,"Invalid input . Use correct format (character only) !","Dope Alley",JOptionPane.ERROR_MESSAGE);
                            input = (String)JOptionPane.showInputDialog(null,"Do you want to purchase another food ?\n\nEnter [Y] for Yes\nEnter [N] for No","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                        }
                    }while(input.equalsIgnoreCase("y")==y);
                    do{
                        d = (String)JOptionPane.showInputDialog(null,"Type of drink you want","Dope Alley",JOptionPane.QUESTION_MESSAGE,null,drink,drink[0]);
                        if(d.equals(drink[0])||d.equals(drink[1])){
                            drinkprice = 3.30;
                        }else if(d.equals(drink[2])){
                            drinkprice = 3.80;
                        }else{
                            drinkprice = 5.90;
                        }
                        do{
                            try{
                                input = (String) JOptionPane.showInputDialog(null,"Drink quantity","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                                quantity = Integer.parseInt(input);
                                if(quantity <= 0 || quantity > 100){
                                    JOptionPane.showMessageDialog(null,"Invalid input . Number only .\n\nMininum order = 1\nMaximum order = 100","Dope Alley",JOptionPane.ERROR_MESSAGE);
                                }
                            }catch(NumberFormatException e){
                                JOptionPane.showMessageDialog(null,"Invalid input . Number only .\n\nMininum order = 1\nMaximum order = 100","Dope Alley",JOptionPane.ERROR_MESSAGE);
                            }
                        }while(quantity <= 0 || quantity > 100);
                        drinkorder = drinkorder + d +"          RM "+x.format(drinkprice)+" per each x "+quantity+"\n";
                        totalprice = totalprice + (drinkprice * quantity);
                        input = (String)JOptionPane.showInputDialog(null,"Do you want to purchase another drink ?\n\nEnter [Y] for Yes\nEnter [N] for No","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                        while(input.equalsIgnoreCase("y")!=y && input.equalsIgnoreCase("n")!=y){
                            JOptionPane.showMessageDialog(null,"Invalid input . Use correct format (character only) !","Dope Alley",JOptionPane.ERROR_MESSAGE);
                            input = (String)JOptionPane.showInputDialog(null,"Do you want to purchase another drink ?\n\nEnter [Y] for Yes\nEnter [N] for No","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                        }
                    }while(input.equalsIgnoreCase("y")==y);
                    if(totalprice >= 20 && totalprice <= 10000){
                        discount = 10;
                    }else{
                        discount = 0;
                    }
                    totalamount = totalprice - (totalprice * discount/100);
                    grandtotal = totalamount + (totalamount * 6/100);
                    JOptionPane.showMessageDialog(null,"Username : "+user+"\n\nFood : \n"+foodorder+"\nDrink : \n"+drinkorder+"\n\nTotal Price : RM "+x.format(totalprice),"Dope Alley",JOptionPane.PLAIN_MESSAGE);
                    m = (String)JOptionPane.showInputDialog(null,"Do You Want To Dine In or Take Away ? ","Dope Alley",JOptionPane.QUESTION_MESSAGE,null,method,method[0]);
                    JOptionPane.showMessageDialog(null,dateFormat.format(date)+"\nUsername : "+user+"\nMethod : "+m+"\n\nFood : \n"+foodorder+"\nDrink : \n"+drinkorder+
                            "\n\nTotal Price : RM "+x.format(totalamount)+"     ("+discount+"% discount)\n\nGrand Total : RM "+x.format(grandtotal)+"\nIncluding GST 6%","Dope Alley",JOptionPane.PLAIN_MESSAGE);
                }else{
                    name = (String)JOptionPane.showInputDialog(null,"First and Last Name","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                    while(name.matches(nameformat)!=y){
                        JOptionPane.showMessageDialog(null,"Invalid input . Use correct format (String) !\nFirst and Last Name (Length must be in 6 characters)\n\nExample : Aainaa Diyana","Dope Alley",JOptionPane.ERROR_MESSAGE);
                        name = (String)JOptionPane.showInputDialog(null,"First and Last Name","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                    }
                    user = (String)JOptionPane.showInputDialog(null,"Username","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                    while(user.matches(usernameformat)!=y){
                        JOptionPane.showMessageDialog(null,"Invalid input . Use correct format (Character only) !\nLength must be in between 6-10 characters.\n\nExample : aainaa","Dope Alley",JOptionPane.ERROR_MESSAGE);
                        user = (String)JOptionPane.showInputDialog(null,"Username","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                    }
                    passw = (String)JOptionPane.showInputDialog(null,"Password","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                    while(passw.matches(passwordformat)!=y){
                        JOptionPane.showMessageDialog(null,"Invalid input . Use correct format (AlphaNum) !\nLength must be in between 6-20 characters.\n\nExample : aainaa95","Dope Alley",JOptionPane.ERROR_MESSAGE);
                        passw = (String)JOptionPane.showInputDialog(null,"Password","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                    }
                    email = (String)JOptionPane.showInputDialog(null,"Email","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                    while(email.matches(emailformat)!=y){
                        JOptionPane.showMessageDialog(null,"Invalid input . Use correct format (someone@somewhere.com) !\n\nExample : aainaa95@gmail.com","Dope Alley",JOptionPane.ERROR_MESSAGE);
                        email = (String)JOptionPane.showInputDialog(null,"Email","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                    }
                    JOptionPane.showMessageDialog(null,"----------------------- Profile Details -----------------------"
                            + "\n\nFirst and Last Name     : "+name+"\nUsername                       : "
                            +user+"\nPassword                       : "+passw+"\nEmail                                : "
                            +email,"Dope Alley",JOptionPane.PLAIN_MESSAGE);
                    do{
                        f = (String)JOptionPane.showInputDialog(null,"Type of food you want","Dope Alley",JOptionPane.QUESTION_MESSAGE,null,food,food[0]);
                        if(f.equals(food[0])||f.equals(food[1])){
                            foodprice = 1.90;
                        }else if(f.equals(food[2])){
                            foodprice = 8.90;
                        }else{
                            foodprice = 9.90; 
                        }
                        do{
                            try{
                                input = (String) JOptionPane.showInputDialog(null,"Food quantity","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                                quantity = Integer.parseInt(input);
                                if(quantity <= 0 || quantity > 100){
                                    JOptionPane.showMessageDialog(null,"Invalid input . Number only .\n\nMininum order = 1\nMaximum order = 100","Dope Alley",JOptionPane.ERROR_MESSAGE);
                                }
                            }catch(NumberFormatException e){
                                JOptionPane.showMessageDialog(null,"Invalid input . Number only .\n\nMininum order = 1\nMaximum order = 100","Dope Alley",JOptionPane.ERROR_MESSAGE);
                            }
                        }while(quantity <= 0 || quantity > 100);
                        foodorder = foodorder + f +"          RM "+x.format(foodprice)+" per each x "+quantity+"\n";
                        totalprice = totalprice + (foodprice * quantity);
                        input = (String)JOptionPane.showInputDialog(null,"Do you want to purchase another food ?\n\nEnter [Y] for Yes\nEnter [N] for No","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                        while(input.equalsIgnoreCase("y")!=y && input.equalsIgnoreCase("n")!=y){
                            JOptionPane.showMessageDialog(null,"Invalid input . Use correct format (character only) !","Dope Alley",JOptionPane.ERROR_MESSAGE);
                            input = (String)JOptionPane.showInputDialog(null,"Do you want to purchase another food ?\n\nEnter [Y] for Yes\nEnter [N] for No","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                        }
                    }while(input.equalsIgnoreCase("y")==y);
                    do{
                        d = (String)JOptionPane.showInputDialog(null,"Type of drink you want","Dope Alley",JOptionPane.QUESTION_MESSAGE,null,drink,drink[0]);
                        if(d.equals(drink[0])||d.equals(drink[1])){
                            drinkprice = 3.30;
                        }else if(d.equals(drink[2])){
                            drinkprice = 3.80;
                        }else{
                            drinkprice = 5.90;
                        }
                        do{
                            try{
                                input = (String) JOptionPane.showInputDialog(null,"Drink quantity","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                                quantity = Integer.parseInt(input);
                                if(quantity <= 0 || quantity > 100){
                                    JOptionPane.showMessageDialog(null,"Invalid input . Number only .\n\nMininum order = 1\nMaximum order = 100","Dope Alley",JOptionPane.ERROR_MESSAGE);
                                }
                            }catch(NumberFormatException e){
                                JOptionPane.showMessageDialog(null,"Invalid input . Number only .\n\nMininum order = 1\nMaximum order = 100","Dope Alley",JOptionPane.ERROR_MESSAGE);
                            }
                        }while(quantity <= 0 || quantity > 100);
                        drinkorder = drinkorder + d +"          RM "+x.format(drinkprice)+" per each x "+quantity+"\n";
                        totalprice = totalprice + (drinkprice * quantity);
                        input = (String)JOptionPane.showInputDialog(null,"Do you want to purchase another drink ?\n\nEnter [Y] for Yes\nEnter [N] for No","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                        while(input.equalsIgnoreCase("y")!=y && input.equalsIgnoreCase("n")!=y){
                            JOptionPane.showMessageDialog(null,"Invalid input . Use correct format (character only) !","Dope Alley",JOptionPane.ERROR_MESSAGE);
                            input = (String)JOptionPane.showInputDialog(null,"Do you want to purchase another drink ?\n\nEnter [Y] for Yes\nEnter [N] for No","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                        }
                    }while(input.equalsIgnoreCase("y")==y);
                    if(totalprice >= 20 && totalprice <= 10000){
                        discount = 10;
                    }else{
                        discount = 0;
                    }
                    totalamount = totalprice - (totalprice * discount/100);
                    grandtotal = totalamount + (totalamount * 6/100);
                    JOptionPane.showMessageDialog(null,"Username : "+user+"\n\nFood : \n"+foodorder+"\nDrink : \n"+drinkorder+"\n\nTotal Price : RM "+x.format(totalprice),"Dope Alley",JOptionPane.PLAIN_MESSAGE);
                    m = (String)JOptionPane.showInputDialog(null,"Do you want to Dine In or Take Away ? ","Dope Alley",JOptionPane.QUESTION_MESSAGE,null,method,method[0]);
                    JOptionPane.showMessageDialog(null,dateFormat.format(date)+"\nUsername : "+user+"\nMethod : "+m+"\n\nFood : \n"+foodorder+"\nDrink : \n"+drinkorder+
                            "\n\nTotal Price : RM "+x.format(totalamount)+"     ("+discount+"% discount)\n\nGrand Total : RM "+x.format(grandtotal)+"\nIncluding GST 6%","Dope Alley",JOptionPane.PLAIN_MESSAGE);
                }
            }
            input = (String)JOptionPane.showInputDialog(null,"Do you want to contiue & update order ?\n\nEnter [Y] for Yes\nEnter [N] for No","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                while(input.equalsIgnoreCase("y")!=y && input.equalsIgnoreCase("n")!=y){
                    JOptionPane.showMessageDialog(null,"Invalid input . Use correct format (character only) !","Dope Alley",JOptionPane.ERROR_MESSAGE);
                    input = (String)JOptionPane.showInputDialog(null,"Do you want to continue & update order ?\n\nEnter [Y] for Yes\nEnter [N] for No","Dope Alley",JOptionPane.QUESTION_MESSAGE);
                }
        }while(input.equalsIgnoreCase("y")==y);
    }
}