package scarves;

import java.text.DecimalFormat;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Scarves {
    public static void main(String[] args) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        DecimalFormat x = new DecimalFormat ("0.00");
        String input,sc,material,color,scarvetype = "";
        int digit = 0,d,quantity = 0,discount;
        double price,total,totalprice = 0;
        boolean y = true;
        
        String[] scarve = {"Bawal","Shawl","Halfmoon"};
        String[] bawalmaterial = {"Crepe","Wool  "};
        String[] shawlmaterial = {"Cotton       ","Pashmina"};
        String[] crepecolor = {"Pink        ","Blue        ","Purple     "};
        String[] woolcolor = {"Turqoise","Indigo     ","Emerald "};
        String[] cottoncolor = {"Pink  ","Black"};
        String[] satincolor = {"Black              ","Gold                ","White Cream","Apple Green  "};
        
        JOptionPane.showMessageDialog(null,"--------------- Welcome To Dalila Boutique ---------------\n\nDiscount :"
                + "\n          - If buy less than 10, get no discount\n          - If buy 10 to 20, get 5% discount\n          - If buy more than 20, get 10% discount","Dalila Boutique",JOptionPane.PLAIN_MESSAGE);
        do{
            do{
                try{
                    input = (String)JOptionPane.showInputDialog(null,"How many scarves ?","Dalila Boutique",JOptionPane.QUESTION_MESSAGE);
                    digit = Integer.parseInt(input);
                    if(digit <= 0){
                        JOptionPane.showMessageDialog(null,"Invalid data . Minimum order = 1","Dalila Boutique",JOptionPane.ERROR_MESSAGE);
                    }
                }catch(NumberFormatException NFE){
                    JOptionPane.showMessageDialog(null,"Invalid data . Minimum order = 1","Dalila Boutique",JOptionPane.ERROR_MESSAGE);
                }
            }while(digit <= 0);
            
            for(d = 0;d < digit;d++){
                sc = (String)JOptionPane.showInputDialog(null,"Scarves type ?","Dalila Boutique",JOptionPane.QUESTION_MESSAGE,null,scarve,scarve[0]);
                if(sc.equals(scarve[0])){ //scarves - bawal
                    material = (String)JOptionPane.showInputDialog(null,"Bawal's material","Dalila Boutique",JOptionPane.QUESTION_MESSAGE,null,bawalmaterial,bawalmaterial[0]);
                    if(material.equals(bawalmaterial[0])){ //material - crepe
                        color = (String)JOptionPane.showInputDialog(null,"Crepe's color","Dalila Boutique",JOptionPane.QUESTION_MESSAGE,null,crepecolor,crepecolor[0]);
                        price = 10.00 ;
                    }else{ //material - wool
                        color = (String)JOptionPane.showInputDialog(null,"Wool's color","Dalila Boutique",JOptionPane.QUESTION_MESSAGE,null,woolcolor,woolcolor[0]);
                        price = 15.00;
                    }
                    do{
                        try{
                            input = (String)JOptionPane.showInputDialog(null,"Scarves quantity","Dalila Boutique",JOptionPane.QUESTION_MESSAGE);
                            quantity = Integer.parseInt(input);
                            if(quantity <= 0){
                                JOptionPane.showMessageDialog(null,"Invalid data . Minimum order = 1","Dalila Boutique",JOptionPane.ERROR_MESSAGE);
                            }
                        }catch(NumberFormatException NFE){
                            JOptionPane.showMessageDialog(null,"Invalid data . Minimum order = 1","Dalila Boutique",JOptionPane.ERROR_MESSAGE);
                        } 
                    }while(quantity <= 0);
                    
                    if(quantity < 10){
                        discount = 0;
                    }else if(quantity >= 10 || quantity <= 20){
                        discount = 5;
                    }else{
                        discount = 10;
                    }
                    total = price * quantity;
                    scarvetype = scarvetype + sc + "                  " + material + "                     " + color + "            " + x.format(price) + "                         " + quantity + "               "+x.format(total)+"\n";
                }else if(sc.equals(scarve[1])){ //scarves - shawl
                    material = (String)JOptionPane.showInputDialog(null,"Shawl's material","Dalila Boutique",JOptionPane.QUESTION_MESSAGE,null,shawlmaterial,shawlmaterial[0]);
                    if(material.equals(shawlmaterial[0])){ //material - cotton
                        color = (String)JOptionPane.showInputDialog(null,"Cotton's color","Dalila Boutique",JOptionPane.QUESTION_MESSAGE,null,cottoncolor,cottoncolor[0]);
                        price = 10.00 ;
                    }else{ //material - pashmina
                        color = "Black ";
                        price = 15.00;
                    }
                    do{
                        try{
                            input = (String)JOptionPane.showInputDialog(null,"Scarves quantity","Dalila Boutique",JOptionPane.QUESTION_MESSAGE);
                            quantity = Integer.parseInt(input);
                            if(quantity <= 0){
                                JOptionPane.showMessageDialog(null,"Invalid data . Minimum order = 1","Dalila Boutique",JOptionPane.ERROR_MESSAGE);
                            }
                        }catch(NumberFormatException NFE){
                            JOptionPane.showMessageDialog(null,"Invalid data . Minimum order = 1","Dalila Boutique",JOptionPane.ERROR_MESSAGE);
                        } 
                    }while(quantity <= 0);
                    
                    if(quantity < 10){
                        discount = 0;
                    }else if(quantity >= 10 || quantity <= 20){
                        discount = 5;
                    }else{
                        discount = 10;
                    }
                    total = price * quantity;
                    scarvetype = scarvetype + sc + "                  " + material + "             " + color + "                  " + x.format(price) + "                         " + quantity + "               "+x.format(total)+"\n";
                }else{ //scarves - halfmoon
                    material = "Satin";
                    price = 20.00;
                    color = (String)JOptionPane.showInputDialog(null,"Satin's color","Dalila Boutique",JOptionPane.QUESTION_MESSAGE,null,satincolor,satincolor[0]);
                    do{
                        try{
                            input = (String)JOptionPane.showInputDialog(null,"Scarves quantity","Dalila Boutique",JOptionPane.QUESTION_MESSAGE);
                            quantity = Integer.parseInt(input);
                            if(quantity <= 0){
                                JOptionPane.showMessageDialog(null,"Invalid data . Minimum order = 1","Dalila Boutique",JOptionPane.ERROR_MESSAGE);
                            }
                        }catch(NumberFormatException NFE){
                            JOptionPane.showMessageDialog(null,"Invalid data . Minimum order = 1","Dalila Boutique",JOptionPane.ERROR_MESSAGE);
                        } 
                    }while(quantity <= 0);
                    
                    if(quantity < 10){
                        discount = 0;
                    }else if(quantity >= 10 || quantity <= 20){
                        discount = 5;
                    }else{
                        discount = 10;
                    }
                    total = price * quantity;
                    scarvetype = scarvetype + sc + "           " + material + "                       " + color + "     " + x.format(price) + "                         " + quantity + "               "+x.format(total)+"\n";
                }
                totalprice = totalprice + (price * quantity)-(price * quantity * discount/100);
            }
            input = (String)JOptionPane.showInputDialog(null,"Do you want to continue ?\n\nEnter (Y) for YES or Enter (N) for NO","Dalila Boutique",JOptionPane.QUESTION_MESSAGE);
            while(input.equalsIgnoreCase("y")!=y && input.equalsIgnoreCase("n")!=y){
                input = (String)JOptionPane.showInputDialog(null,"Invalid data . Enter again .\n\nEnter (Y) for YES or Enter (N) for NO","Dalila Boutique",JOptionPane.ERROR_MESSAGE);
            }
        }while(input.equalsIgnoreCase("y")==y);
        JOptionPane.showMessageDialog(null,"-- ITEMS --\nScarve                Material                 Colour                 Price (RM)               Qty           Total (RM)\n"+scarvetype+"\nTotal Price : RM "+x.format(totalprice),"Dalila Boutique",JOptionPane.PLAIN_MESSAGE);
    }
}