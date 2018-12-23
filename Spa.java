package asmidar;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import javax.swing.JDialog;

public class Asmidar{
    public static void main(String[] args) {
        JDialog.setDefaultLookAndFeelDecorated(true);
	DecimalFormat x = new DecimalFormat("#0.00");
	String input,s,p,mem,foot,body,light,scrub,massage,rub,floral,hair,category = "",name,pn,ic;
        String nameformat = "^[a-zA-Z]{5,}$";
        String icformat = "\\d{6}-\\d{2}-\\d{4}";
        String phoneformat = "\\d{3}-\\d{7}";
	int discount;
	double price,totalprice = 0,pad = 0;
	boolean y = true;

	String[] services = {"Tulip Royal Indulgence","Body Glow Ritual","Basic Bridal Package"};
	String[] tulip = {"Package A","Package B"};
	String[] bridal = {"Package A","Package B"};
	String[] glow = {"Package A","Package B"};
	String[] member = {"Member","Non-Member"};

	JOptionPane.showMessageDialog(null, "Welcome to Tulip's Spa","Tulips Spa",JOptionPane.PLAIN_MESSAGE);

	name = (String)JOptionPane.showInputDialog(null,"Enter Your Name","Tulips Spa",JOptionPane.QUESTION_MESSAGE);
        while(name.matches(nameformat)!=y){
            JOptionPane.showMessageDialog(null,"Invalid Data . Format Must Be in Letters Only .\n\nMinimum Name's Length Are 5 Letters","Tulips Spa",JOptionPane.ERROR_MESSAGE);
            name = (String)JOptionPane.showInputDialog(null,"Enter Your Name","Tulips Spa",JOptionPane.QUESTION_MESSAGE);
        }
	ic = (String)JOptionPane.showInputDialog(null,"Enter Your IC Number","Tulips Spa",JOptionPane.QUESTION_MESSAGE);
        while(ic.matches(icformat)!=y){
            JOptionPane.showMessageDialog(null,"Invalid Data . Format Must Be in Number Only . \n\nUse Correct Format\nExample : 950310-03-3412","Tulips Spa",JOptionPane.ERROR_MESSAGE);
            ic = (String)JOptionPane.showInputDialog(null,"Enter Your IC Number","Tulips Spa",JOptionPane.QUESTION_MESSAGE);
        }
	pn = (String)JOptionPane.showInputDialog(null,"Enter Your Phone Number","Tulips Spa",JOptionPane.QUESTION_MESSAGE);
        while(pn.matches(phoneformat)!=y){
            JOptionPane.showMessageDialog(null,"Invalid Data . Format Must Be in Number Only .\n\nUse Correct Format\nExample : 012-1234567","Tulips Spa",JOptionPane.ERROR_MESSAGE);
            pn = (String)JOptionPane.showInputDialog(null,"Enter Your Phone Number","Tulips Spa",JOptionPane.QUESTION_MESSAGE);
        }

	mem = (String)JOptionPane.showInputDialog(null,"Status","Tulips Spa",JOptionPane.QUESTION_MESSAGE,null,member,member[0]);
	if(mem.equals(member[0])){
            discount = 15;
	}else{
            discount = 0;
	}
            do{
		s = (String)JOptionPane.showInputDialog(null,"Type of package you want","Tulips Spa",JOptionPane.QUESTION_MESSAGE,null,services,services[0]);
		if(s.equals(services[0])){
                    p = (String)JOptionPane.showInputDialog(null,"Tulip Royal Indulgence Packages","Tulips Spa",JOptionPane.QUESTION_MESSAGE,null,tulip,tulip[0]);
                        if(p.equals(tulip[0])){
                            foot = "Foot Soak";
                            body = "Body Rub";
                            light = "Light Refreshment";
                            scrub = "Body Scrub and Mask";
                            price = 461.00;
                        }else{
                            foot = "Foot Soak";
                            body = "Body Rub";
                            light = "Light Refreshment";
                            scrub = "";
                            price = 415.00;
                        }
                    category = category + "Type of Packages : " + s + "\n"+ p +"     (RM "+x.format(price)+")\n               - "+foot+"\n               - "+ body+"\n               - "+light+"\n               - "+scrub+"\n\n";
		}else if(s.equals(services[1])){
                    p = (String)JOptionPane.showInputDialog(null,"Body Glow Ritual Packages","Tulips Spa",JOptionPane.QUESTION_MESSAGE,null,glow,glow[0]);
			if(p.equals(glow[0])){
                            foot = "Foot Soak";
                            massage = "Body Massage";
                            scrub = "Body Scrub and Mask";
                            rub = "Body Rub";
                            price = 293.00;
			}else{
                            foot = "Foot Soak";
                            massage = "Body Massage";
                            scrub = "Body Scrub and Mask";
                            rub = "";
                            price = 263.00;
			}
			category = category + "Type of Packages : " + s + "\n"+ p +"     (RM "+x.format(price)+")\n               - "+foot+"\n               - "+massage+"\n               - "+scrub+"\n               - "+rub+"\n\n";
		}else{
			p = (String)JOptionPane.showInputDialog(null,"Basic Bridal Packages","Tulips Spa",JOptionPane.QUESTION_MESSAGE,null,bridal,bridal[0]);
			if(p.equals(bridal[0])){
			foot = "Foot Soak";
                            massage = "Body Massage";
                            floral = "Floral Bath";
                            hair = "Hair Spa";
                            price = 455.00;
			}else{
                            foot = "Foot Soak";
                            massage = "Body Massage";
                            floral = "Floral Bath";
                            hair = "";
                            price = 409.00;
			}
			category = category + "Type of Packages : " + s + "\n"+ p +"     (RM "+x.format(price)+")\n               - "+foot+"\n               - "+massage+"\n               - "+floral+"\n               - "+hair+"\n\n";
                }
                totalprice = totalprice + price;
		input = (String)JOptionPane.showInputDialog(null,"Do You Want To Continue ?\n\nEnter [Y] for Yes\nEnter [N] for No","Tulips Spa",JOptionPane.QUESTION_MESSAGE);
		while(input.equalsIgnoreCase("y")!=y && input.equalsIgnoreCase("n")!=y){
                    JOptionPane.showMessageDialog(null,"Invalid Data ! Please Enter Again !","Tulips Spa",JOptionPane.ERROR_MESSAGE);
                    input = (String)JOptionPane.showInputDialog(null,"Do You Want To Continue ?\n\nEnter [Y] for Yes\nEnter [N] for No","Tulips Spa",JOptionPane.QUESTION_MESSAGE);
		}
            }while(input.equalsIgnoreCase("y")==y);
            pad = (pad + totalprice) - (totalprice * discount/100);
	JOptionPane.showMessageDialog(null,"Status : "+mem+"\n\n"+category+"Total Price : RM "+x.format(totalprice)+"\nMembership Discount : "+discount+"%\n\nPrice After Discount : RM "+x.format(pad),"Tulips Spa",JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null,"Thank You For Booking at Tulips Spa","Tulips Spa",JOptionPane.PLAIN_MESSAGE);
    }
}