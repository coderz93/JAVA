package cloth;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Cloth {
    public static void main(String[] args) {
        JDialog.setDefaultLookAndFeelDecorated(true); //This Will Make The Dialogue Box Had Decoration And Have Colour.
        String input,sta,clo,siz,typ,mat,pay,username = "",password;
        int quantity,dis,i,noq;
        double price,addprice,total,totaladdprice,totalprice = 0;
        boolean y = true; //This Is To Hold The Boolean Variable y Is True.
        boolean user = true;
        boolean pass = true;
        DecimalFormat x = new DecimalFormat("#0.00"); //This Will Helps You To Always Keeps In Two Decimal Places.
    
        String[] status = {"Member","Non-Member"};
        String[] cloth = {"Formal","Non-Formal","T-Shirt"};
        String[] types = {"Long Sleeve","Short Sleeve"};
        String[] material = {"Cotton","Wool","Flax"};
        String[] size = {"S","M","L","XL"};
        String[] payment = {"CIMB","MAYBANK","BSN"};
        
        StringBuilder output = new StringBuilder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        Date date = new Date();

        JOptionPane.showMessageDialog(null,"     Welcome To Online Abstrax Jingga     ","Abstrax Jingga",JOptionPane.PLAIN_MESSAGE); //Greeting Customers.
        sta = (String)JOptionPane.showInputDialog(null,"Status :","Abstrax Jingga",JOptionPane.QUESTION_MESSAGE,null,status,status[0]);
        if(sta.equals(status[0])){
            dis = 10;
            while(user){
                username = (String)JOptionPane.showInputDialog(null,"Username :","Abstrax Jingga",JOptionPane.QUESTION_MESSAGE);
                String regex = "^[a-zA-Z]{4,10}$";//"[a-zA-Z\\-'\\s]+"; //0-9
                if(username.matches(regex)){
                    user = false;
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Input . Username must be character only !\n\nNumber of characters must be between 6 to 10.","Abstrax Jingga",JOptionPane.ERROR_MESSAGE);
                }
            }while(pass){
                password = (String)JOptionPane.showInputDialog(null,"Password :","Abstrax Jingga",JOptionPane.QUESTION_MESSAGE);
                String regex = "^(?=.*\\d)(?=.*[a-zA-Z])[a-zA-Z0-9]{6,20}$"; //!@#$%&*
                if(password.matches(regex)){
                    pass = false;
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Input . Password must be included characters & numbers !\n\nNumber of characters must be between 6 to 20.","Abstrax Jingga",JOptionPane.ERROR_MESSAGE);
                }
            }
            output.append("<html><table><tr>").append(dateFormat.format(date));
            output.append("<tr><td>USERNAME : ").append(username).append("</td></tr>");
            output.append("<tr><td>STATUS : ").append(sta).append("     (").append(dis).append("% discount)").append("</td></tr>");
            output.append("<tr><td>").append("</td></tr>");
            output.append("<td>CLOTH'S TYPE").append("</td>");
            output.append("<td>MATERIAL ").append("</td>");
            output.append("<td>SLEEVE'S TYPE ").append("</td>");
            output.append("<td>QUANTITY ").append("</td>");
            output.append("<td>SIZE (Addprice (RM)) ").append("</td>");
            output.append("<td>PRICE(RM) ").append("</td>");
            output.append("<td>TOTAL(RM) ").append("</td></tr>");    

            do{            
                input = (String)JOptionPane.showInputDialog(null,"How Many Cloth Do You Want To Buy ?","Abstrax Jingga",JOptionPane.QUESTION_MESSAGE);
                noq = Integer.parseInt(input);
                while(noq < 1){
                    JOptionPane.showMessageDialog(null,"Invalid Input !\nEnter Again !","Abstrax Jingga",JOptionPane.ERROR_MESSAGE);
                    input = (String)JOptionPane.showInputDialog(null,"Cloth's Quantity : ","Abstrax Jingga",JOptionPane.QUESTION_MESSAGE);
                    noq = Integer.parseInt(input);
                }for (i = 0; i < noq; i++){
                    clo = (String)JOptionPane.showInputDialog(null,"Types of Cloth :","Abstrax Jingga",JOptionPane.QUESTION_MESSAGE,null,cloth,cloth[0]);
                    mat = (String)JOptionPane.showInputDialog(null,"Types of Material :","Abstrax Jingga",JOptionPane.QUESTION_MESSAGE,null,material,material[0]);
                    typ = (String)JOptionPane.showInputDialog(null,"Types of Sleeve :","Abstrax Jingga",JOptionPane.QUESTION_MESSAGE,null,types,types[0]);
                    siz = (String)JOptionPane.showInputDialog(null,"Size :","Abstrax Jingga",JOptionPane.QUESTION_MESSAGE,null,size,size[0]);
                    input = (String)JOptionPane.showInputDialog(null,"Cloth's Quantity : ","Abstrax Jingga",JOptionPane.QUESTION_MESSAGE);
                    quantity = Integer.parseInt(input);

                    if(clo.equals(cloth[0])){
                        price = 150.00;
                    }else if(clo.equals(cloth[1])){
                        price = 100.00;
                    }else{
                        price = 50.00;
                    }
                    if(siz.equals(size[0])){
                        addprice = 2.00;
                    }else if(siz.equals(size[1])){
                        addprice = 4.00;
                    }else if(siz.equals(size[2])){
                        addprice = 6.00;
                    }else {
                        addprice = 8.00;
                    }
                    while(quantity < 1){
                        JOptionPane.showMessageDialog(null,"Invalid Input !\nEnter Again !","Abstrax Jingga",JOptionPane.ERROR_MESSAGE);
                        input = (String)JOptionPane.showInputDialog(null,"Cloth's Quantity : ","Abstrax Jingga",JOptionPane.QUESTION_MESSAGE);
                        quantity = Integer.parseInt(input);
                    }
                    totaladdprice = addprice * quantity;
                    total = (price + addprice)*quantity;
                    totalprice = totalprice + total - (total * dis/100);
                    output.append("<tr><td>").append(clo).append("</td>");
                    output.append("<td>").append(mat).append("</td>");
                    output.append("<td>").append(typ).append("</td>");
                    output.append("<td>").append(quantity).append("</td>");
                    output.append("<td>").append(siz).append(" (RM ").append(x.format(totaladdprice)).append(")").append("</td>");
                    output.append("<td>").append(x.format(price)).append("</td>");
                    output.append("<td>").append(x.format(total)).append("</td></tr>");
                }            
                input = (String) JOptionPane.showInputDialog(null,"Do You Want To Proceed With Another Purchasing ?"
                       + "\n\nEnter [Y or y] For Yes - Order.\nEnter [N or n] For No - Exit.","Abstrax Jingga",JOptionPane.QUESTION_MESSAGE);
                while (input.equalsIgnoreCase("y")!=y && input.equalsIgnoreCase("n")!=y){    // Validate The User Input. Here I'm Using The Boolean.
                    JOptionPane.showMessageDialog(null,"Invalid Input !\nEnter Again !","Abstrax Jingga",JOptionPane.ERROR_MESSAGE);
                    input = (String) JOptionPane.showInputDialog(null,"Enter [Y or y] For Yes - Order.\nEnter [N or n] For No - Exit.","Abstrax Jingga",JOptionPane.QUESTION_MESSAGE); //Ask The User Again.
                }     
            }while (input.equalsIgnoreCase("y") == y); //This Is For Do-While Looping.
            pay = (String)JOptionPane.showInputDialog(null,"Select Payment : ","Abstrax Jingga",JOptionPane.QUESTION_MESSAGE,null,payment,payment[0]);
            output.append("<html><table><tr><br/>** Total ").append("Amount (Including Postage) :").append(" RM ").append(x.format(totalprice)).append("</tr></table></html>");
            output.append("<html><table><tr>** Payment's Type : Credit Card").append(" - ").append(pay).append("</tr></table></html>");
            output.append("</tr></table></html>");

            JOptionPane.showMessageDialog(null, output,"Abstrax Jingga",JOptionPane.PLAIN_MESSAGE);      
            System.exit(0);
        }else{
            dis = 0;
            output.append("<html><table><tr>").append(dateFormat.format(date));
            output.append("<tr><td>STATUS : ").append(sta).append("     (").append(dis).append("% discount)").append("</td></tr>");
            output.append("<tr><td>").append("</td></tr>");
            output.append("<td>CLOTH'S TYPE").append("</td>");
            output.append("<td>MATERIAL ").append("</td>");
            output.append("<td>SLEEVE'S TYPE ").append("</td>");
            output.append("<td>QUANTITY ").append("</td>");
            output.append("<td>SIZE (Addprice (RM)) ").append("</td>");
            output.append("<td>PRICE(RM) ").append("</td>");
            output.append("<td>TOTAL(RM) ").append("</td></tr>");    
            do{            
                input = (String)JOptionPane.showInputDialog(null,"How Many Cloth Do You Want To Buy ?","Abstrax Jingga",JOptionPane.QUESTION_MESSAGE);
                noq = Integer.parseInt(input);
                while(noq < 1){
                    JOptionPane.showMessageDialog(null,"Invalid Input !\nEnter Again !","Abstrax Jingga",JOptionPane.ERROR_MESSAGE);
                    input = (String)JOptionPane.showInputDialog(null,"Cloth's Quantity : ","Abstrax Jingga",JOptionPane.QUESTION_MESSAGE);
                    noq = Integer.parseInt(input);
                }for (i = 0; i < noq; i++){
                    clo = (String)JOptionPane.showInputDialog(null,"Types of Cloth :","Abstrax Jingga",JOptionPane.QUESTION_MESSAGE,null,cloth,cloth[0]);
                    mat = (String)JOptionPane.showInputDialog(null,"Types of Material :","Abstrax Jingga",JOptionPane.QUESTION_MESSAGE,null,material,material[0]);
                    typ = (String)JOptionPane.showInputDialog(null,"Types of Sleeve :","Abstrax Jingga",JOptionPane.QUESTION_MESSAGE,null,types,types[0]);
                    siz = (String)JOptionPane.showInputDialog(null,"Size :","Abstrax Jingga",JOptionPane.QUESTION_MESSAGE,null,size,size[0]);
                    input = (String)JOptionPane.showInputDialog(null,"Cloth's Quantity : ","Abstrax Jingga",JOptionPane.QUESTION_MESSAGE);
                    quantity = Integer.parseInt(input);

                    if(clo.equals(cloth[0])){
                        price = 150.00;
                    }else if(clo.equals(cloth[1])){
                        price = 100.00;
                    }else{
                        price = 50.00;
                    }
                    if(siz.equals(size[0])){
                        addprice = 2.00;
                    }else if(siz.equals(size[1])){
                        addprice = 4.00;
                    }else if(siz.equals(size[2])){
                        addprice = 6.00;
                    }else{
                        addprice = 8.00;
                    }
                    while(quantity < 1){
                        JOptionPane.showMessageDialog(null,"Invalid Input !\nEnter Again !","Abstrax Jingga",JOptionPane.ERROR_MESSAGE);
                        input = (String)JOptionPane.showInputDialog(null,"Cloth's Quantity : ","Abstrax Jingga",JOptionPane.QUESTION_MESSAGE);
                        quantity = Integer.parseInt(input);
                    }
                    totaladdprice = addprice * quantity;
                    total = (price + addprice)*quantity;
                    totalprice = totalprice + total - (total * dis/100);
                    output.append("<tr><td>").append(clo).append("</td>");
                    output.append("<td>").append(mat).append("</td>");
                    output.append("<td>").append(typ).append("</td>");
                    output.append("<td>").append(quantity).append("</td>");
                    output.append("<td>").append(siz).append(" (RM ").append(x.format(totaladdprice)).append(")").append("</td>");
                    output.append("<td>").append(x.format(price)).append("</td>");
                    output.append("<td>").append(x.format(total)).append("</td></tr>");
                }            
                input = (String) JOptionPane.showInputDialog(null,"Do You Want To Proceed With Another Purchasing ?"
                       + "\n\nEnter [Y or y] For Yes - Order.\nEnter [N or n] For No - Exit.","Abstrax Jingga",JOptionPane.QUESTION_MESSAGE);
                while (input.equalsIgnoreCase("y")!=y && input.equalsIgnoreCase("n")!=y) {    // Validate The User Input. Here I'm Using The Boolean.
                    JOptionPane.showMessageDialog(null,"Invalid Input !\nEnter Again !","Abstrax Jingga",JOptionPane.ERROR_MESSAGE);
                    input = (String) JOptionPane.showInputDialog(null,"Enter [Y or y] For Yes - Order.\nEnter [N or n] For No - Exit.","Abstrax Jingga",JOptionPane.QUESTION_MESSAGE); //Ask The User Again.
                }     
            } while (input.equalsIgnoreCase("y") == y); //This Is For Do-While Looping.
            pay = (String)JOptionPane.showInputDialog(null,"Select Payment : ","Abstrax Jingga",JOptionPane.QUESTION_MESSAGE,null,payment,payment[0]);
            output.append("<html><table><tr><br/>** Total ").append("Amount (Including Postage) :").append(" RM ").append(x.format(totalprice)).append("</tr></table></html>");
            output.append("<html><table><tr>** Payment's Type : Credit Card").append(" - ").append(pay).append("</tr></table></html>");
            output.append("</tr></table></html>");
            JOptionPane.showMessageDialog(null, output,"Abstrax Jingga",JOptionPane.PLAIN_MESSAGE);
            
            System.exit(0);
        }
    }
}      