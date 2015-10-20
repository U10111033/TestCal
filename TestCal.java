/**U10111033, Computer science 4, Hsueh_Hsin Lu*/

//Library Call
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestCal extends JFrame{
	//new the button
	private JButton B9 = new JButton("9");
	private JButton B8 = new JButton("8");
	private JButton B7 = new JButton("7");
	private JButton Bp = new JButton("+");
	private JButton B4 = new JButton("4");
	private JButton B5 = new JButton("5");
	private JButton B6 = new JButton("6");
	private JButton Bmi = new JButton("-");
	private JButton B1 = new JButton("1");
	private JButton B2 = new JButton("2");
	private JButton B3 = new JButton("3");
	private JButton Bmu = new JButton("*");
	private JButton B0 = new JButton("0");
	private JButton Bc = new JButton("C");
	private JButton Be = new JButton("=");
	private JButton Bd = new JButton("/");
	
	private static long num; //nomber
	private static byte op; //operator
	private static JLabel resTex = new JLabel("0"); //Lable, initial is zero
	
	public TestCal(){
		JPanel p1 = new JPanel(); //Button panel
		p1.setLayout(new GridLayout(4,4)); //set grid
		
		//add the button to the panel
		p1.add(B9);
		p1.add(B8);
		p1.add(B7);
		p1.add(Bp);
		p1.add(B4);
		p1.add(B5);
		p1.add(B6);
		p1.add(Bmi);
		p1.add(B1);
		p1.add(B2);
		p1.add(B3);
		p1.add(Bmu);
		p1.add(B0);
		p1.add(Bc);
		p1.add(Be);
		p1.add(Bd);
		
		//label pannel
		JPanel p2 = new JPanel(new BorderLayout());
		p2.add(resTex, BorderLayout.NORTH); //add the label
		p2.add(p1,BorderLayout.CENTER); //add the button
		
		add(p2);
		
		//set Listener
		B9.addActionListener(new AL());
		B8.addActionListener(new AL());
		B7.addActionListener(new AL());
		Bp.addActionListener(new AL());
		B4.addActionListener(new AL());
		B5.addActionListener(new AL());
		B6.addActionListener(new AL());
		Bmi.addActionListener(new AL());
		B1.addActionListener(new AL());
		B2.addActionListener(new AL());
		B3.addActionListener(new AL());
		Bmu.addActionListener(new AL());
		B0.addActionListener(new AL());
		Bc.addActionListener(new AL());
		Be.addActionListener(new AL());
		Bd.addActionListener(new AL());
	}
	
	public static void main(String args[]){
		JFrame myF = new TestCal(); //constructor
		myF.setTitle("Test Calculator"); //title
		myF.setLocationRelativeTo(null); //location
		myF.pack(); //set size
		myF.setVisible(true); //visible
	}

	class AL implements ActionListener{
		@Override //override !! importent !!
		public void actionPerformed(ActionEvent e){ //use the ActionEvent
			long result;
			
			//get the stuff of the button
			JButton btn=(JButton) e.getSource();
			
			//check stuff if it is number
			if(btn == B9)
				output_digit(B9);
			else if(btn == B8)
				output_digit(B8);
			else if(btn == B7)
				output_digit(B7);
			else if(btn == B6)
				output_digit(B6);
			else if(btn == B5)
				output_digit(B5);
			else if(btn == B4)
				output_digit(B4);
			else if(btn == B3)
				output_digit(B3);
			else if(btn == B2)
				output_digit(B2);
			else if(btn == B1)
				output_digit(B1);
			else if(btn == B0)
				output_digit(B0);
			
			//check stuff if it is opretor
			if(btn==Bc){
				result=0L;
				num=0L;
				op=0;
				resTex.setText(Long.toString(num));
			}else if(btn==Bp){//+
				save_num(Bp);
				op=1;
			}else if(btn==Bmi){//-
				save_num(Bmi);
				op=2;
			}else if(btn==Bmu){//*
				save_num(Bmu);                   
				op=3;
			}else if(btn==Bd){///
				save_num(Bd);
				op=4;
			}else if(btn==Be){
				result=Long.parseLong(resTex.getText());
				
				switch(op){
					case 1:
						num+=result;
						break;
					case 2:
						num-=result;
						break;
					case 3:
						num*=result;
						break;
					case 4:
						num/=result;
						break;
					default:
				}
				result=0L;
					
				resTex.setText(Long.toString(num));
			}
		}
		
		//catch the  stuff from button(transfer the strint to Label)
		private void output_digit(JButton jbtn){
			resTex.setText(Long.toString(Long.parseLong(resTex.getText() + jbtn.getLabel())));
		}
		
		//catch the  stuff from button(transfer the strint to number)
		private void save_num(JButton oper){
			num=Long.parseLong(resTex.getText());
			resTex.setText(Long.toString(0L));
		}
	}
}