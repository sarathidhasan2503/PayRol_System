package com.tns.payro_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


class Frame1 extends JFrame implements ActionListener {
	
	
	public int MasterAccount=5000000;
       // initialize the labels
       JLabel lbl=new JLabel("PAYROL SYSTEM");

       Font f=new Font("Times",Font.BOLD,30);
       Font f1=new Font("Times",Font.BOLD,16);
       Font f2=new Font("Times",Font.BOLD,12);
       
       JLabel lblid,lblname,lbldepartment,lbldays,lblrate,lblsubmit;
       JLabel lblExpense;
       JLabel lblsalary,lblPL;
       JTextField txMaster,txtExpence;
       JTextField txtid,txtname,txtdepartment,txtdays;
       JTextField txtrate,txtsalary;
       JRadioButton rbmale,rbfemale;
       JButton btnadd,btnsave,btnupdate,btndelete,btnexit;
       
       JButton btncompute;
       String gen;
       
       
        float days,rate,salary,expense;
       
       Frame1()
       {
       // this is display in a Frame titlebar.
       super("Employee Details");
       addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent we)
                {
                System.exit(0);
                }
       });
       // set layout to null
       setLayout(null);

       lblsubmit=new JLabel("Developed By : Sarathidhasan Saravanan");
       add(lblsubmit);
       lblsubmit.setHorizontalAlignment(lblsubmit.CENTER);
       lblsubmit.setBounds(220,510,450,20);
       lblsubmit.setFont(f1);

       // add lbl label on form.
       add(lbl);

       // set the particular position on a screen
       lbl.setBounds(200,50,500,100);
       lbl.setHorizontalAlignment(lbl.CENTER);
       // set the font of lbl label 
       lbl.setFont(f);
      

       // initializa all the label which are declared in the example above with its caption name 
       lblid=new JLabel("ID");
       lblname=new JLabel("NAME");
       lblExpense=new JLabel("EXPENSE");
       lbldays=new JLabel("N0. OF DAYS ");
       lblrate=new JLabel("RATE PER DAY");
       lblsalary=new JLabel("SALARY");
       lblPL=new JLabel("");
       
       lblid.setBounds(300,140,100,20);
       lblname.setBounds(300,180,100,20);
       lblExpense.setBounds(300, 220, 100, 20);
       lbldays.setBounds(300,250,100,20);
       lblrate.setBounds(300,280,100,20);
       lblsalary.setBounds(300,310,100,20);
       lblPL.setBounds(500,310,100,20);
       
        // add all the label on the frame
       add(lblid);
       add(lblname);
       add(lblExpense);
       add(lbldays);
       add(lblrate);
       add(lblsalary);
       add(lblPL);
       
       // set font
       lblid.setFont(f2);
       lblname.setFont(f2);
       lblExpense.setFont(f2);
       lbldays.setFont(f2);
       lblrate.setFont(f2);
       lblsalary.setFont(f2);
       lblPL.setFont(f2);

       // initialize the textfield with size
       txtid=new JTextField(15);
       txtname=new JTextField(15);
       txMaster=new JTextField(15);
       txtdays=new JTextField(15);
       txtrate=new JTextField(15);
       txtsalary=new JTextField(15);
       txtExpence=new JTextField(15);
       

       // set a particlar position on a screen with setbounds constructor
       txtid.setBounds(400,140,100,20);
       txtname.setBounds(400,180,100,20);
       txMaster.setBounds(400,220,100,20);
       txtdays.setBounds(400,250,100,20);
       txtrate.setBounds(400,280,100,20);
       txtsalary.setBounds(400,310,100,20);
       txtExpence.setBounds(550,310 , 100, 20);
     
     
       // add textfield on a Frame
       add(txtid);
       add(txtname);
       add(txMaster);
       add(txtdays);
       add(txtrate);
       add(txtsalary);
       add(txtExpence);
      
     
       // initializa button with its caption
       btnadd=new JButton("Add");
       btnsave=new JButton("Profit");
       btnupdate=new JButton("Update");
       btndelete=new JButton("Delete");

      // To add tooltip in the buttons
      btnadd.setToolTipText("Click this button to Add record in the Database.");
      btnsave.setToolTipText("Click this button to Save record in the Database.");
      btnupdate.setToolTipText("Click this button to Update record in the Database.");
      btndelete.setToolTipText("Click this button to Delete record in the Database.");
      
       // set a particular position on a Frame
       btnadd.setBounds(200,400,100,30);
       btnsave.setBounds(310,400,100,30);
       btnupdate.setBounds(420,400,100,30);
       btndelete.setBounds(530,400,100,30);

       // add button on a frame
       add(btnadd);
       add(btnsave);
       add(btndelete);
       add(btnupdate);

       // register all the button
       btnadd.addActionListener(this);
       btnsave.addActionListener(this);
       btnupdate.addActionListener(this);
       btndelete.addActionListener(this);
       
       btnexit=new JButton("Exit");
       btnexit.setToolTipText("Click this button to Quit Program.");
       btnexit.setBounds(360,480,100,30);
       add(btnexit);
       btnexit.addActionListener(this);
 
       btncompute=new JButton("Compute");
       btncompute.setToolTipText("Click this button to compute the salary of the employee.");
       btncompute.setBounds(360,350,100,30);
       add(btncompute);
       btncompute.addActionListener(this);

       
       }
	

       
       public void actionPerformed(ActionEvent ae)
	{
    	   
		try
		{
			
	 		if(ae.getActionCommand()=="Add")
			{
	 			String name=txtname.getText();
	 			String ID=txtid.getText();
	 			String Salary=txtsalary.getText();
	 			
	 			// Recipient's email ID needs to be mentioned.
		        String to = "sarathi3032000@gmail.com";

		        // Sender's email ID needs to be mentioned
		        String from = "sarathi3032000@gmail.com";

		        // Assuming you are sending email from through gmails smtp
		        String host = "smtp.gmail.com";

		        // Get system properties
		        Properties properties = System.getProperties();

		        // Setup mail server
		        properties.put("mail.smtp.host", host);
		        properties.put("mail.smtp.port", "465");
		        properties.put("mail.smtp.ssl.enable", "true");
		        properties.put("mail.smtp.auth", "true");

		        // Get the Session object.// and pass username and password
		        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

		            protected PasswordAuthentication getPasswordAuthentication() {

		                return new PasswordAuthentication("sarathi3032000@gmail.com", "bowzewomtzwfqeqb");

		            }

		        });

		        // Used to debug SMTP issues
		        session.setDebug(true);

		        try {
		            // Create a default MimeMessage object.
		            MimeMessage message = new MimeMessage(session);

		            // Set From: header field of the header.
		            message.setFrom(new InternetAddress(from));

		            // Set To: header field of the header.
		            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

		            // Set Subject: header field
		            message.setSubject("Money Credited");

		            // Now set the actual message
		            message.setText("Hi  "+name+"!\n\nYour Employee Id is :"+ID+"\n\n\n Your Account XX1234 is Debited with INR "+Salary+"\n Thank You..");

		            System.out.println("sending...");
		            // Send message
		            Transport.send(message);
		            System.out.println("Sent message successfully....");
		        } catch (MessagingException mex) {
		            mex.printStackTrace();
		        }
		        JOptionPane.showMessageDialog(this,"Email sends Successfully");
		        txtid.setText("");
				txtname.setText("");
				txtdays.setText("");
				txtrate.setText("");
				txtsalary.setText("");
				txMaster.setText("");
				txtExpence.setText("");
						
			}
			if(ae.getActionCommand()=="Update")
			{
				days=Float.parseFloat(txtdays.getText());
                rate=Float.parseFloat(txtrate.getText());
                salary=(days*rate);
                 float round = Round(salary,2);
                txtsalary.setText(Float.toString(round));
                MasterAccount-=round;
                txMaster.setText(Float.toString(MasterAccount));
                JOptionPane.showMessageDialog(this,"Master Account Updated Successfully");
				
			}
			if(ae.getActionCommand()=="Profit")
			{
				
				days=Float.parseFloat(txtdays.getText());
                rate=Float.parseFloat(txtrate.getText());
                expense=Float.parseFloat(txMaster.getText());
                salary=(days*rate);
                 float round = Round(salary,2);
                 txtsalary.setText(Float.toString(round));
                 round=round-expense;
                 txtExpence.setText(Float.toString(round));
                if(round>0) {
                	lblPL.setText("PROFIT");
                }else {
                	lblPL.setText("LOSS");
                }
				
			}
			
			if(ae.getActionCommand()=="Compute")
			{
		
		        days=Float.parseFloat(txtdays.getText());
                        rate=Float.parseFloat(txtrate.getText());
                        salary=(days*rate);
                         float round = Round(salary,2);
                        txtsalary.setText(Float.toString(round));
		        txtsalary.setEditable(false);
			}
			if(ae.getActionCommand()=="Exit")
			{
				JOptionPane.showMessageDialog(this,"Thank you for Using My App :) ");
			System.exit(0);		
			}
			
			if(ae.getActionCommand()=="delete")
			{
				Connection conn=null;
				try {
					// connection
					String url = "jdbc:mysql://localhost:3306/sarathidhasan";
					String user = "root";
					String password = "123456";
					String ID=txtid.getText();
					String Name=txtname.getText();
					String Days=txtdays.getText();
					String Rate=txtrate.getText();
					String Salary=txtsalary.getText();

					conn = DriverManager.getConnection(url, user, password);
					if (conn != null) {
						System.out.println("Connected to the database sarathidhasan");
					}
					String sql="INSERT INTO `sarathidhasan`.`Payrol_System`"
							 + " (`ID`, `Emp_Name`, `No_of_Days`, `Rate_per_Day`,`Salary`)"
							 + "VALUES('" +ID+"','"+Name+"',"+Days+",'"+Rate+"','"+Salary+"')";
		            Statement stmt = conn.createStatement();
		            stmt.executeUpdate(sql);
		            System.out.println("Added");

				} catch (SQLException ex) {
					System.out.println("Exception ::" + ex.getMessage());
					ex.printStackTrace();
				}finally {
					conn.close();
				}
				txtid.setText("");
				txtname.setText("");
				txtdays.setText("");
				txtrate.setText("");
				txtsalary.setText("");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	} 
	

  
// Method to round off decimal values  

  public static float Round(float Rval, int Rpl) {
  float p = (float)Math.pow(10,Rpl);
  Rval = Rval * p;
  float tmp = Math.round(Rval);
  return (float)tmp/p;
    }
}


public class Payrol 
{
        public static void main(String[] args)throws Exception
        {

        	
        // create a object of Frame1 class in main method
        Frame1 f1=new Frame1();

        // set frame size
        f1.setSize(900,600);

        // set frame visible true
        f1.setVisible(true);
       
        //set look and feel for frame
	UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        }
}