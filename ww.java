import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.*;
import java. awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.Timer;
import java.lang.*;

class Node
{
   int r;
   int c;
   Node next;
   Node prev;
}

public class ww implements ActionListener, KeyListener
{
   public int wordsFound=0, wrongClicks=0;
   public double timeBonus=0.0, finalScore=0.0;
   public int c=0,i1=0,maxletter=0,greatestlength=0,sizeOfCell=44,xStartPoint=130,on=0,p=0, q=0,cw=0, go=0,ss=0,sm=0,SS=0,SM=0,timerEnded=0,I=0,pause=0, gradred=0, gradgreen=0,  gradblue=0,  upperLimit=254, lowerLimit=24;
   public int ON[], row[], col[];
   public char crossword[][], answer[][];
   public String words[], ansSarr[];
   public String Words[][];
   public String WordsE[][]=new String[6][6];
   public String WordsM[][]=new String[6][6];
   public String WordsH[][]=new String[6][6];
   public String ansS=" ", word=" ";
   public boolean go1=false, win=false,t=true;
   public Node L1=null;
   public JFrame f,sf1,sf2;
   public JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13;
   public JRadioButton rb1,rb2,rb3;
   public ButtonGroup BG;
   public ImageIcon image2;
   public JTextArea ta1;
   public JTextField  tf2, tf3, tf4;
   public JTextField  tf[]=new JTextField[7];
   public JButton jb2[][], jb3[][];
   public JButton jb1[];
   public  JLabel l11,l13, l14, l15, l16, l17, l18, l19, l20, l21, l22, l23, l24, l25, l26, l27,l28;
   public Timer timer=null;
    
   ww()
   { 
      f=new JFrame("GAME WINDOW");      
      JLabel l1=new JLabel("WELCOME TO WORDWEB");
      l1.setBounds(140,5,650,50);
      l1.setForeground(new Color(255,0,0));
      l1.setFont(new Font("ALGERIAN",Font.PLAIN,45));

      ImageIcon image1=new ImageIcon("C:\\word web image3.png");
      JLabel l2=new JLabel(image1);
      l2.setBounds(100,50,600,600);
      
      b1=new JButton("PLAY");
      b1.setFont(b1.getFont().deriveFont(30.0f));
      b1.setBounds(300,660,200,50);
      b1.setForeground(new Color(0,0,0));
      b1.setBackground(new Color(34,177,76));
      b1.addActionListener(this);
      f.setSize(800,800);
    f.getContentPane().setBackground(Color.BLACK);
     
      f.add(l1);
      f.add(l2);
      f.add(b1);
  
     f.setUndecorated(true);
      b1.setBorder(new BevelBorder(BevelBorder.LOWERED));
        f.add(b1, BorderLayout.CENTER);
     l2.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLUE,Color.BLUE));
        f.add(l2, BorderLayout.CENTER);
     f.getRootPane().setBorder(BorderFactory.createMatteBorder(6,6,6,6,Color.BLUE));
     f.setLayout(null);
 
      f.setLocationRelativeTo(null);
      f.setVisible(true);
      f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    //  Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    //  f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);

  }

 public void actionPerformed(java.awt.event.ActionEvent e)
 {
     int i=0, j=0,k=0;

     if(e.getSource()==b1)
   {
     f.getContentPane().removeAll();
     f.repaint();
     page2();
  }
    if(e.getSource()==b2)
   {
          if(tf2.getText().isEmpty() && tf3.getText().isEmpty() && tf4.getText().isEmpty())
            {
               JOptionPane.showMessageDialog(null,"PLEASE ENTER YOUR NAME, CITY AND DOB!");
            }

         else 
           {
                   if(tf2.getText().isEmpty())
                      JOptionPane.showMessageDialog(null,"PLEASE ENTER YOUR NAME!");
                   else
                    { 
                         if(tf3.getText().isEmpty())
                           JOptionPane.showMessageDialog(null,"PLEASE ENTER YOUR CITY!");
                         else
                          {
                               if(tf4.getText().isEmpty())
                                 JOptionPane.showMessageDialog(null,"PLEASE ENTER YOUR DOB!");
                               else
                                {
                                    if(!(rb1.isSelected() || rb2.isSelected() || rb3.isSelected()))
                                       JOptionPane.showMessageDialog(null,"PLEASE CHOOSE A LEVEL!");
                                    else
                                      {
                                             for(i=0; i<tf4.getText().length(); i++)
                                               {
                                                        if(Character.isLetter(tf4.getText().charAt(i)))
                                                         {
                                                           JOptionPane.showMessageDialog(null,"WRONG DOB FORMAT","ALERT",JOptionPane.WARNING_MESSAGE);
                                                           break;
                                                          }
                                                }
                                           if(i==tf4.getText().length())
                                           {
                                               f.getContentPane().removeAll();
                                               f.repaint();
                                               f.setSize(800,800);
                                               page3();
                                            }
                                      }                                    
                                }
                          }
                    }
           }
  }
    
    if(e.getSource()==b4)
   {
        if(t==true)
        {
              for(i=0; i<i1; i++)
                {
                        if((tf[i].getText().substring(4, tf[i].getText().length()).length()) > maxletter)
                          {
                             JOptionPane.showMessageDialog(null,tf[i].getText()+" is having length greater than "+maxletter, "ALERT", JOptionPane.WARNING_MESSAGE);
                              break;
                          }
                 }
  loop0:  for(j=0; j<i1; j++)
                {
                     for(k=0; k<tf[j].getText().length(); k++)
                       {
                            if(Character.isUpperCase(tf[j].getText().charAt(k)))
                             {
                                    JOptionPane.showMessageDialog(null,"CAN NOT USE CAPITAL LETTER ANYWHERE","ALERT",JOptionPane.WARNING_MESSAGE);
                                    break loop0;
                              }
                        }
                }
            if(i==i1 && j==i1)
              t=false ;
        }
      else
      {
         f.getContentPane().removeAll();
         f.repaint();
         page4();    
         JOptionPane.showMessageDialog(null,"DO PRESS ENTER AFTER YOU SELECT ONE FULL WORD\n\tAND THEN GO FOR OTHER WORD", "ALERT", JOptionPane.WARNING_MESSAGE);
         Clock();
     }
 }

  if(e.getSource()==b5)
  {
     b5.setBackground(new Color(0,255,0));
     b6.setBackground(new Color(63,72,204));
     b7.setBackground(new Color(163,73,164));
     c=1;
  }

  if(e.getSource()==b6)
  {
     b6.setBackground(new Color(0,255,0));
     b5.setBackground(new Color(0,162,232));
      b7.setBackground(new Color(163,73,164));
     c=2;
     ansSarr=new String[i1];
   }

  if(e.getSource()==b7)
   {
     b7.setBackground(new Color(0,255,0));
     b5.setBackground(new Color(0,162,232));
     b6.setBackground(new Color(63,72,204));
     c=3;
    }
  
  if(e.getSource()==b9)
     f.dispose();  

  if(e.getSource()==b8)
  {
        if(c==1)
       {
           t=true;
           f.getContentPane().removeAll();
           f.repaint();
           page2();
       }

      if(c==2)
       {
           f.getContentPane().removeAll();
           f.repaint();
           page4();
           Clock();
       }

        if(c==3)
        {
           f.getContentPane().removeAll();
           f.repaint();
         f.setSize(400,400);
           page6();           
        }
      
  }  

   if(e.getSource()==b12)
   {
     f.getContentPane().removeAll();
     f.repaint();
     page5();
  }

  if(go==1)
 {
  for(i=0; i<greatestlength; i++)
   {
      for(j=0; j<greatestlength; j++)
        { 
             if(e.getSource()==jb2[i][j])
               {
                    if(L1==null)
                    {
                         L1=new Node();
                         L1.r=i;
                         L1.c=j;
                         L1.next=null;
                         L1.prev=null;
                     }
                    else
                     {
                         L1.next=new Node();
                         L1.next.prev=L1;
                         L1=L1.next;
                         L1.r=i;
                         L1.c=j;
                         L1.next=null;
                      }
 
                    jb2[i][j].setOpaque(true);
                    jb2[i][j].setForeground(new Color(0,0,0));     
                    jb2[i][j].setBackground(new Color(234,222,0));
                    ansS=ansS+(jb2[i][j].getText());
               }
         }
     }
 }

  if(timerEnded==2)
{
     for(I=0; I<i1; I++)
     {
           if(e.getSource()==jb1[I])
            {
                  p=row[I];
                  q=col[I];

                colorProvider();          
               jb1[I].setForeground(new Color(0,0,0));                          
               jb1[I].setBackground(new Color(gradred, gradgreen, gradblue));
                    
                  switch(ON[I])
                   {
                                                        case 0: // towards right
                                                         for(k=1; k<=4; k++)
                                                          {
                                                              for(j=0; j<words[I].length(); j++)
                                                               { 
                                                                   jb2[p][q+j].setBackground(new Color(234,222,0));
                                                                   miniClock(p,(q+j));
                                                                }
                                                           } 
                                                            break;

                                                            case 1:  // towards left
                                                               for(k=1; k<=4; k++)
                                                          {
                                                              for(j=0; j<words[I].length(); j++)
                                                               {
                                                                   jb2[p][q-j].setBackground(new Color(234,222,0));
                                                                   miniClock(p,(q-j));
                                                                }
                                                           } 
                                                            break;

                                                            case 2:  // towards up
                                                            for(k=1; k<=4; k++)
                                                          {
                                                              for(i=0; i<words[I].length(); i++)
                                                               {
                                                                   jb2[p-i][q].setBackground(new Color(234,222,0));
                                                                   miniClock((p-i),q);
                                                                }
                                                           } 
                                                            break;

                                                            case 3:  // towards down
                                                               for(k=1; k<=4; k++)
                                                          {
                                                              for(i=0; i<words[I].length(); i++)
                                                               {
                                                                   jb2[p+i][q].setBackground(new Color(234,222,0));
                                                                   miniClock((p+i),q);
                                                                }
                                                           } 
                                                            break;

                                                            case 4:  // towards upper-diagonal-right
                                                             for(k=1; k<=4; k++)
                                                          {
                                                              for(i=0,j=0; i<words[I].length() && j<words[I].length(); i++, j++)
                                                               {
                                                                    jb2[p-i][q+j].setBackground(new Color(234,222,0));
                                                                   miniClock((p-i),(q+j));
                                                                 }
                                                           } 
                                                            break;

                                                            case 5:  // towards upper-diagonal-left
                                                             for(k=1; k<=4; k++)
                                                          {
                                                              for(i=0,j=0; i<words[I].length() && j<words[I].length(); i++, j++)
                                                               {
                                                                   jb2[p-i][q-j].setBackground(new Color(234,222,0));
                                                                   miniClock((p-i),(q-j));
                                                                }
                                                           } 
                                                            break;

                                                            case 6:  // towards lower-diagonal-right
                                                              for(k=1; k<=4; k++)
                                                          {
                                                              for(i=0,j=0; i<words[I].length() && j<words[I].length(); i++, j++)
                                                               {
                                                                   jb2[p+i][q+j].setBackground(new Color(234,222,0));
                                                                   miniClock((p+i),(q+j));
                                                                }
                                                           } 
                                                            break;

                                                            case 7:  // towards lower-diagonal-left
                                                              for(k=1; k<=4; k++)
                                                          {
                                                              for(i=0,j=0; i<words[I].length() && j<words[I].length(); i++, j++)
                                                               {
                                                                   jb2[p+i][q-j].setBackground(new Color(234,222,0));
                                                                   miniClock((p+i),(q-j));
                                                                 }
                                                           } 
                                                            break;
                   }       
            }
      }
  }  // end of outer most if timerEnded
}

public void keyTyped(java.awt.event.KeyEvent ke)
{
   int i=0, k=0;   
         for(i=0; i<i1; i++)
          {
                 if((" "+words[i]).equals(ansS))
                  {
                          while(L1.prev!=null)
                           L1=L1.prev;

                                    colorProvider();
                           
                          do
                             { 
                                    jb2[L1.r][L1.c].setOpaque(true);
                                    jb2[L1.r][L1.c].setBackground(new Color(gradred,gradgreen,gradblue));
                                    L1=L1.next; 
                              }
                          while(L1!=null);
                      jb1[i].setForeground(new Color(0,0,0));
                      jb1[i].setBackground(new Color(gradred,gradgreen,gradblue));

                      for(k=0; k<ansSarr.length; k++)
                          {
                                  if(ansSarr[k]!=null)
                                     {
                                          if(ansSarr[k].equals(ansS))
                                                 break;
                                          else
                                            continue;
                                      }              
                          }
                      if(k==ansSarr.length)
                        {
                            wordsFound=wordsFound+1;
                             ansSarr[i]=ansS;
                         }  
                                if(wordsFound==i1)
                                      win=true;              
                      break;
                  }   
          }

               if(i==i1)
                 {
                        while(L1.prev!=null)
                           L1=L1.prev;
                           
                          do
                             { 
                                    jb2[L1.r][L1.c].setOpaque(true);
                                    jb2[L1.r][L1.c].setBackground(new Color(255,0,0));
                                    L1=L1.next; 
                                    wrongClicks++;
                              }
                          while(L1!=null);                                      
                 }                
  L1=null;
  ansS=" ";
}
   
public void keyReleased(java.awt.event.KeyEvent ke)
{

}

public void keyPressed(java.awt.event.KeyEvent ke)
{

}
 
public void page2()
 { 
    JLabel l3= new JLabel("HOW TO PLAY?");
    l3.setBounds(270,5,285,50);
    l3.setForeground(new Color(255,0,0));
    l3.setFont(new Font("ALGERIAN",Font.PLAIN,40));
    l3.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GREEN, Color.GREEN));
    f.add(l3, BorderLayout.CENTER);
    
    ta1=new JTextArea();
    ta1.setBounds(35,77,720,185+60);
    ta1.setFont(new Font("ROCKWELL", Font.PLAIN, 16));
    ta1.setForeground(new Color(0,0,0));
    ta1.setBorder(new BevelBorder(BevelBorder.RAISED));
    howtoplay();
    ta1.setBackground(new Color(153,217,234));
    f.add(ta1);

       JLabel l4=new JLabel("NAME:");
       l4.setBounds(50,300+60,250,50);
       l4.setFont(l4.getFont().deriveFont(30.0f));
       l4.setForeground(new Color(255,128,0));

       tf2=new JTextField();
       tf2.setBounds(150,315+60,180,20);
       tf2.setBackground(new Color(153,217,234));

       JLabel l5=new JLabel("CITY:");
       l5.setBounds(50,(300+50+60),250,50);
       l5.setFont(l5.getFont().deriveFont(30.0f));
       l5.setForeground(new Color(255,128,0));

       tf3=new JTextField();
       tf3.setBounds(150,(315+50+60),180,20);
       tf3.setBackground(new Color(153,217,234));

       JLabel l6=new JLabel("DOB:");
       l6.setBounds(50,(300+100+60),250,50);
       l6.setFont(l6.getFont().deriveFont(30.0f));
       l6.setForeground(new Color(255,128,0));

       tf4=new JTextField();
       tf4.setBounds(150,(315+100+60),180,20);
       tf4.setBackground(new Color(153,217,234));

      JLabel l7=new JLabel("LEVEL?");
      l7.setBounds(450,300+60,250,50);
      l7.setFont(l7.getFont().deriveFont(30.0f));
      l7.setForeground(new Color(255,128,0));

      rb1=new JRadioButton("EASY");
      rb1.setBounds(450+120,320+60,100,20);
      rb1.setFont(rb1.getFont().deriveFont(15.0f));
      rb1.setBackground(new Color(153,217,234));      

     rb2= new JRadioButton("MEDIUM");
     rb2.setBounds(450+120,320+30+60,100,20);
     rb2.setFont(rb2.getFont().deriveFont(15.0f));
     rb2.setBackground(new Color(153,217,234));
 
    rb3=new JRadioButton("HARD");
    rb3.setBounds(450+120,320+60+60,100,20);
    rb3.setFont(rb3.getFont().deriveFont(15.0f));
    rb3.setBackground(new Color(153,217,234));

   BG=new ButtonGroup();
   BG.add(rb1);  BG.add(rb2);   BG.add(rb3);

    image2=new ImageIcon("C:\\nextbutton2.png");
     b2=new JButton(image2);
      b2.setFont(b2.getFont().deriveFont(30.0f));
      b2.setBounds(370,550,100,97);
      b2.setBorder(new BevelBorder(BevelBorder.RAISED,Color.GREEN, Color.GREEN));
      b2.setForeground(new Color(0,0,0));
      b2.setBackground(new Color(0,0,0));
      b2.addActionListener(this);
     
      f.add(l4);
      f.add(tf2);
      f.add(l5);
      f.add(tf3);
      f.add(l6);
      f.add(tf4);
      f.add(l7);
      f.add(rb1);
      f.add(rb2);
      f.add(rb3);
      f.add(b2);
 }

public void page3()
{
    int j=0, y=0;
    JLabel l8=new JLabel();
    if(rb1.isSelected())
     {
          initializeWordArrE();
          l8= new JLabel("ENTER 7 WORDS HAVING A MAXIMUM OF 7 LETTERS");
          tf=new JTextField[7];
          i1=7;
          maxletter=7;
          greatestlength=10;
          sm=1;
          ss=30;
          sizeOfCell=50;
          xStartPoint=180;
      }   
    
   if(rb2.isSelected())
      {
         initializeWordArrM();
         l8= new JLabel("ENTER 9 WORDS HAVING A MAXIMUM OF 8 LETTERS");
         tf=new JTextField[9];
         i1=9;
         maxletter=8;
         greatestlength=12;
         sm=2;
         ss=30;
         sizeOfCell=46;
         xStartPoint=180;
      }

   if(rb3.isSelected())
      {
         initializeWordArrH();
         l8= new JLabel("ENTER 10 WORDS HAVING A MAXIMUM OF 9 LETTERS");
         tf=new JTextField[12];
         i1=10;
         maxletter=9;
         greatestlength=13;
         sm=2;
         ss=60;
         sizeOfCell=44;
         xStartPoint=180;
      }
           SS=ss;
           SM=sm;
           ansSarr=new String[i1];

         l8.setBounds(50,5,700,50);
         l8.setForeground(new Color(255,0,0));
         l8.setFont(new Font("ALGERIAN",Font.ITALIC,28));
         l8.setBorder(new BevelBorder(BevelBorder.RAISED));
         f.add(l8, BorderLayout.CENTER);

   for(j=0,y=90; j<i1; j++, y+=50)
    {
        tf[j]=new JTextField("("+String.valueOf(j+1)+")  ");
        tf[j].setFont(new Font("VERDANA",Font.BOLD,20));
        tf[j].setBounds(50,y,200,38);
        f.add(tf[j]);
    }

      b3=new JButton("AUTO FILL WORDS");
      b3.setFont(new Font("VERDANA",Font.PLAIN,27));
      b3.setBounds(350,90+50,300,300);
      b3.setForeground(new Color(0,0,0));
      b3.setBackground(new Color(34,177,76));
      b3.addActionListener(new ActionListener()
         {
              public void actionPerformed(java.awt.event.ActionEvent e)
                { 
                      l28=new JLabel("Processing......");
                      l28.setBounds(100,600,70,30);
                      l28.setForeground(new Color(0,255,0));
                      l28.setFont(new Font("VERDANA",Font.PLAIN,17));
                      f.add(l28);  
                      autoFill();      
                      l28.setVisible(false);     
                }
          });
      f.add(b3);
   
     ImageIcon image2=new ImageIcon("C:\\nextbutton2.png");
     b4=new JButton(image2);
      b4.setFont(b4.getFont().deriveFont(30.0f));
      b4.setBounds(445,550,100,97);
      b4.setBorder(new BevelBorder(BevelBorder.RAISED,Color.GREEN, Color.GREEN));
      b4.setForeground(new Color(0,0,0));
      b4.setBackground(new Color(0,0,0));
      b4.addActionListener(this);
      f.add(b4);
         JOptionPane.showMessageDialog(null,"PLEASE TURN YOUR CAPS LOCK OFF IF ON");
}

 public void page5()
{
   wordsFound=0;
   wrongClicks=0;
   timeBonus=0.0;
   finalScore=0.0;
   pause=0;
   win=false;

   b5=new JButton("PLAY A NEW GAME");
   b5.setBounds(100,50,600,90);
   b5.setFont(new Font("VERDANA",Font.BOLD,40));
   b5.setBorder(new BevelBorder(BevelBorder.RAISED));
   b5.setBackground(new Color(0,162,232));
   b5.addActionListener(this);
   f.add(b5);

   b6=new JButton("REARRANGE THE WORDS");
   b6.setBounds(100,50+150,600,90);
   b6.setFont(new Font("VERDANA",Font.BOLD,40));
   b6.setBorder(new BevelBorder(BevelBorder.RAISED));
   b6.setBackground(new Color(63,72,204));
   b6.addActionListener(this);
   f.add(b6);

   b7=new JButton("CHANGE THE LEVEL");
   b7.setBounds(100,50+300,600,90);
   b7.setFont(new Font("VERDANA",Font.BOLD,40));
   b7.setBorder(new BevelBorder(BevelBorder.RAISED));
   b7.setBackground(new Color(163,73,164));
   b7.addActionListener(this);
   f.add(b7);

    b8=new JButton("GO !!");
   b8.setBounds(100,550,200,100);
   b8.setFont(new Font("ALGERIAN",Font.BOLD,35));
   b8.setBorder(new BevelBorder(BevelBorder.RAISED));
   b8.setBackground(new Color(181,230,29));
   b8.addActionListener(this);
   f.add(b8);

   b9=new JButton("EXIT !!");
   b9.setBounds(500,550,200,100);
   b9.setFont(new Font("ALGERIAN",Font.BOLD,35));
   b9.setBorder(new BevelBorder(BevelBorder.RAISED));
   b9.setBackground(new Color(237,28,36));
   b9.addActionListener(this);
   f.add(b9);
}

public void page6()
 {
   JLabel l9=new JLabel("     SELECT LEVEL !!");
   l9.setBounds(50,5,300,50);
   l9.setFont(new Font("VERDANA",Font.BOLD,25));
   l9.setForeground(new Color(255,0,0));
   l9.setBorder(new BevelBorder(BevelBorder.RAISED));
   l9.setBackground(new Color(163,73,164));
   f.add(l9);
  
      rb1.setBounds(150,100,100,20);
      rb1.setFont(rb1.getFont().deriveFont(15.0f));
      rb1.setBackground(new Color(153,217,234));  
    
      rb2.setBounds(150,100+30,100,20);
      rb2.setFont(rb2.getFont().deriveFont(15.0f));
      rb2.setBackground(new Color(153,217,234));

     rb3.setBounds(150,100+60,100,20);
     rb3.setFont(rb3.getFont().deriveFont(15.0f));
     rb3.setBackground(new Color(153,217,234));   

   f.add(rb1);
   f.add(rb2);
   f.add(rb3);         

      image2=new ImageIcon("C:\\nextbutton2.png");
      b13=new JButton(image2);
      b13.setFont(b2.getFont().deriveFont(30.0f));
      b13.setBounds(150,220,100,97);
      b13.setBorder(new BevelBorder(BevelBorder.RAISED,Color.GREEN, Color.GREEN));
      b13.setForeground(new Color(0,0,0));
      b13.setBackground(new Color(0,0,0));
      b13.addActionListener(new ActionListener()
        {
              public void actionPerformed(java.awt.event.ActionEvent e)
                 {
                        if(i1==9 && rb1.isSelected())
                                 JOptionPane.showMessageDialog(null,"SORRY! I can't decrease level from medium to easy.");
                         else
                          { 
                                   if(i1==10 && rb1.isSelected())                    
                                            JOptionPane.showMessageDialog(null,"SORRY! I can't decrease level from hard to easy.");
                                   else
                                      { 
                                           if(i1==10 && rb2.isSelected())
                                               JOptionPane.showMessageDialog(null,"SORRY! I can't decrease level from hard to medium.");
                                           else
                                            {
                                               if(rb1.isSelected())
                                                {
                                                     greatestlength=10;
                                                     ss=30;
                                                     sm=1;
                                                     sizeOfCell=50;
                                                     xStartPoint=180;
                                                }
                                               if(rb2.isSelected())
                                               {
                                                    greatestlength=12;
                                                    ss=30;
                                                    sm=2;
                                                     sizeOfCell=46;
                                                     xStartPoint=180;
                                               }
                                              if(rb3.isSelected())
                                               {
                                                    greatestlength=13;
                                                    ss=60;
                                                    sm=2;
                                                     sizeOfCell=44;
                                                     xStartPoint=180;
                                               }
                                             SS=ss;
                                             SM=sm;
                                             ansSarr=new String[i1];
                                             pause=0;
                                             win=false;
                                             f.getContentPane().removeAll();
                                             f.repaint();
                                             f.setSize(800,800);
                                             page4();
                                             Clock();
                                         }
                                    }                                
                             }                                          
                  }
        });
      f.add(b13);
 }

public void page4()
{
   go=1;
   int y=0,P=0,Q=0,x=0,i=0,j=0;
   String s=" ";
   sm=SM;
   ss=SS;
 JLabel  l10=new JLabel(" YOUR WORDWEB!!");
   l10.setBounds(10,10,285,65);
   l10.setFont(new Font("ALGERIAN",Font.BOLD,30));
   l10.setForeground(new Color(0,0,0));
   l10.setOpaque(true);
   l10.setBackground(new Color(0,162,232));
   l10.setBorder(new BevelBorder(BevelBorder.RAISED));
   f.add(l10);
 
   l11=new JLabel(" CLICK THE TIMER TO STOP IT");
   l11.setBounds(360,10,420,65);
   l11.setFont(new Font("VERDANA",Font.BOLD,24));
   l11.setForeground(new Color(0,0,0));
   l11.setOpaque(true);
   l11.setBorder(new BevelBorder(BevelBorder.RAISED));
   l11.setBackground(new Color(255,128,0));
   f.add(l11);

 JLabel l12=new JLabel(" WORDS!");
   l12.setBounds(10,105-7,110,50);
   l12.setFont(new Font("VERDANA",Font.BOLD,18));
   l12.setForeground(new Color(0,0,0));
   l12.setOpaque(true);
   l12.setBorder(new BevelBorder(BevelBorder.RAISED));
   l12.setBackground(new Color(255,128,0));
   f.add(l12);

   image2=new ImageIcon("C:\\timer2.png");
   b11=new JButton(image2); 
   b11.setBounds(290,105-7,53,53);
   b11.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GREEN, Color.GREEN));
   b11.setOpaque(true);
   b11.setBackground(new Color(0,0,0));
   b11.addActionListener(new ActionListener()
     {
          public void actionPerformed(java.awt.event.ActionEvent e)
            {
                if(pause==0)
                  pause=1;

               if(pause==2)
                {
                                          for(p=0; p<greatestlength; p++)
                                                  {
                                                       for(q=0; q<greatestlength; q++)
                                                         {
                                                                jb3[p][q].setVisible(false);
                                                                jb2[p][q].setVisible(true);
                                                          }
                                                   }   
                      pause=0;
                      Clock();
                }              
            }
     });
   f.add(b11);
  
   jb1=new JButton[i1]; 
   for(j=0,y=(160-7); j<i1; j++, y+=50)
    {
        StringTokenizer st=new StringTokenizer(tf[j].getText());
        s=st.nextToken();
        s=st.nextToken();
        jb1[j]=new JButton(s);
        jb1[j].setFont(new Font("VERDANA",Font.ITALIC,15));
        jb1[j].setBounds(10,y,100,30);
        jb1[j].setBorder(new BevelBorder(BevelBorder.RAISED));
        jb1[j].setForeground(new Color(255,255,255));
        jb1[j].setOpaque(true);
        jb1[j].setBackground(new Color(0,0,0));
        f.add(jb1[j]);  
    }

  wwmaker();

 jb2=new JButton[greatestlength][greatestlength];
 jb3=new JButton[greatestlength][greatestlength]; 
  for(P=0, y=(160-7); P<greatestlength; P++,y+=sizeOfCell)
    {
        for(Q=0, x=xStartPoint; Q<greatestlength; Q++, x+=sizeOfCell)
        {
           jb2[P][Q]=new JButton();
           jb2[P][Q].setBounds(x,y,sizeOfCell,sizeOfCell);
           jb2[P][Q].setFont(new Font("VERDANA",Font.BOLD,17));
           jb2[P][Q].setText(String.valueOf(crossword[P][Q]));
           jb2[P][Q].setBorder(new BevelBorder(BevelBorder.RAISED));
           jb2[P][Q].setForeground(new Color(255,255,255)); 
           jb2[P][Q].setBackground(new Color(0,0,0));
           jb2[P][Q].addActionListener(this);
           jb2[P][Q].addKeyListener(this);
           f.add(jb2[P][Q]);

           jb3[P][Q]=new JButton();
           jb3[P][Q].setBounds(x,y,sizeOfCell,sizeOfCell);
           jb3[P][Q].setBorder(new BevelBorder(BevelBorder.RAISED));
           jb3[P][Q].setBackground(new Color(0,0,0));
         }
     }   

  l13=new JLabel();
  l13.setBounds(360,105-7,170,50);
  l13.setFont(new Font("VERDANA",Font.PLAIN,25));
  l13.setForeground(new Color(0,255,0));
  // l13.setBorder(new BevelBorder(BevelBorder.RAISED));
  f.add(l13);  
} 

public void wwmaker()
{
    int result=0, i=0, j=0;
                                       ON=new int[i1];
                                       row=new int[i1];
                                       col=new int[i1];
                                       crossword=new char[greatestlength][greatestlength];
                                       answer=new char[greatestlength][greatestlength];                                        
                                       words=new String[i1];
                                       for(i=0; i<i1; i++)    
                                       words[i]=jb1[i].getText();

                                         cw=0;    // counter variable to count words 'cw'
                                         do
                                          {
                                              on=(int)(Math.random()*8);   // this is the orientation number depending upon which the control gets to the direction in which the word has to be placed
                                              p=(int)(Math.random()*greatestlength);    // this is the row number that has been randomly choosen, from where the control will start orienting the word depending upon the value of 'on'
                                              q=(int)(Math.random()*greatestlength);   //this is the column number that has been randomly choosen, from where the control will start orienting the word depending upon the value of 'on'

                                              result=spaceCalculator();    // this is the second most important part of the code (find this function down....and read the comments for more details)

                                                if(result==1)
                                                   {
                                                       switch(on)
                                                         {
                                                            case 0: // towards right
                                                              for(j=0; j<words[cw].length(); j++)
                                                                crossword[p][q+j]=words[cw].charAt(j);
                                                            break;

                                                            case 1:  // towards left
                                                              for(j=0; j<words[cw].length(); j++)
                                                                crossword[p][q-j]=words[cw].charAt(j);
                                                            break;

                                                            case 2:  // towards up
                                                            for(i=0; i<words[cw].length(); i++)
                                                                crossword[p-i][q]=words[cw].charAt(i);
                                                            break;

                                                            case 3:  // towards down
                                                              for(i=0; i<words[cw].length(); i++)
                                                                crossword[p+i][q]=words[cw].charAt(i);
                                                            break;

                                                            case 4:  // towards upper-diagonal-right
                                                              for(i=0, j=0; i<words[cw].length() && j<words[cw].length(); i++, j++)
                                                                crossword[p-i][q+j]=words[cw].charAt(i);
                                                            break;

                                                            case 5:  // towards upper-diagonal-left
                                                              for(i=0, j=0; i<words[cw].length() && j<words[cw].length(); i++, j++)
                                                                crossword[p-i][q-j]=words[cw].charAt(i);
                                                            break;

                                                            case 6:  // towards lower-diagonal-right
                                                              for(i=0, j=0; i<words[cw].length() && j<words[cw].length(); i++, j++)
                                                                crossword[p+i][q+j]=words[cw].charAt(i);
                                                            break;

                                                            case 7:  // towards lower-diagonal-left
                                                              for(i=0, j=0; i<words[cw].length() && j<words[cw].length(); i++, j++)
                                                                crossword[p+i][q-j]=words[cw].charAt(i);
                                                            break;
                                                         }            // end of switch case
                                                       
                                                        ON[cw]=on;
                                                         row[cw]=p;
                                                         col[cw]=q;
                                                       cw=cw+1;
                                                    }            // end of if
                                              }
                                         while(cw!=i1);

                      for(i=0; i<greatestlength; i++)   /* this for loop creates the answer matrix that the user can use to cross-heck his answers*/
                        {
                           for(j=0; j<greatestlength; j++)
                             {
                                if(crossword[i][j]!='\u0000')
                                  answer[i][j]=crossword[i][j];
                             }
                        }
                                  
                                // code for filling the empty cells of the crossword matrix with random letters begins//
                       
                                    for(i=0; i<greatestlength; i++)
                                      {
                                         for(j=0; j<greatestlength; j++)
                                           {
                                              if(crossword[i][j]=='\u0000')
                                                  crossword[i][j]=(char)(97+Math.random()*25);
                                              
                                              else
                                                  continue;
                                           }
                                      }

}

public int spaceCalculator()
 {
   int result=0, j=0, i=0;
    switch(on)
    {

      case 0:   // towards right
      if(words[cw].length()<=greatestlength-q)
      {
           for(j=0; j<words[cw].length(); j++)
           {
            if(crossword[p][j+q]=='\u0000')
                continue;

            else
            {
               if(crossword[p][j+q]!=words[cw].charAt(j))
                    result=0;
               break;
            }
           }
           
            if(j==words[cw].length())
            result=1;
      }
      else
        result=0;
      break;

      case 1:  //towards left
      if(words[cw].length()<=q+1)
      {
           for(j=0; j<words[cw].length(); j++)
           {
            if(crossword[p][q-j]=='\u0000')
                continue;

            else
            {
               if(crossword[p][q-j]!=words[cw].charAt(j))
                    result=0;
               break;
            }
           }

          if(j==words[cw].length())
            result=1;       
      }
      else
        result=0;
      break;

      case 2: // towards up
      if(words[cw].length()<=p+1)
      {
           for(i=0; i<words[cw].length(); i++)
           {
            if(crossword[p-i][q]=='\u0000')
                continue;

            else
            {
                if(crossword[p-i][q]!=words[cw].charAt(i))
                    result=0;
                break;
            }
           }

           if(i==words[cw].length())
            result=1;
      }
      else
        result=0;
      break;

      case 3: // towards down
      if(words[cw].length()<=greatestlength-p)
      {
           for(i=0; i<words[cw].length(); i++)
           {
            if(crossword[p+i][q]=='\u0000')
                continue;

            else
            {
               if(crossword[p+i][q]!=words[cw].charAt(i))
                    result=0;
               break;
            }
           }

         if(j==words[cw].length())
            result=1;
      }
      else
        result=0;
      break;

        case 4: // towards upper-diagonal-right
      if((words[cw].length()<=p+1) && (words[cw].length()<=greatestlength-q))
      {
           for(i=0,j=0; i<words[cw].length() && j<words[cw].length(); i++,j++)
           {
            if(crossword[p-i][q+j]=='\u0000')
                continue;

            else
             {
                if(crossword[p-i][q+j]!=words[cw].charAt(i))
                    result=0;
                break;
             }
           }

          if(i==words[cw].length() && j==words[cw].length())
            result=1;
      }
      else
        result=0;
      break;

      case 5: // towards upper-diagonal-left
      if((words[cw].length()<=p+1) && (words[cw].length()<=q+1))
      {
           for(i=0,j=0; i<words[cw].length() && j<words[cw].length(); i++,j++)
           {
            if(crossword[p-i][q-j]=='\u0000')
                continue;

            else
             {
                if(crossword[p-i][q-j]!=words[cw].charAt(i))
                    result=0;
                break;
             }
           }
            
           if(i==words[cw].length() && j==words[cw].length())
            result=1;
      }
      else
        result=0;
      break;

      case 6:  // towards lower-diagonal-right
      if((words[cw].length()<=greatestlength-q) && (words[cw].length()<=greatestlength-p))
      {
           for(i=0,j=0; i<words[cw].length() && j<words[cw].length(); i++,j++)
           {
            if(crossword[p+i][q+j]=='\u0000')
                continue;

            else
             {
                if(crossword[p+i][q+j]!=words[cw].charAt(i))
                    result=0;
                break;
             }
           }

           if(i==words[cw].length() && j==words[cw].length())
            result=1;
      }
      else
        result=0;
      break;

      case 7: // towards lower-diagonal-left
      if((words[cw].length()<=q+1) && (words[cw].length()<=greatestlength-p))
      {
           for(i=0,j=0; i<words[cw].length() && j<words[cw].length(); i++,j++)
           {
            if(crossword[p+i][q-j]=='\u0000')
                continue;

            else
             {
                if(crossword[p+i][q-j]!=words[cw].charAt(i))
                    result=0;
                break;
             }
           }

           if(i==words[cw].length() && j==words[cw].length())
            result=1;
      }
      else
        result=0;
      break;

   }              // end of switch case
   return result;
 }               // end of check function

 public void Clock()
  {
                     timer=new Timer(1000, new ActionListener()
                       {
                            public void actionPerformed(java.awt.event.ActionEvent e)
                               {
                                       ss=ss-1;

                                       if(ss<=15 && sm==0)
                                         l13.setForeground(new Color(255,0,0));

                                       l13.setText(" "+sm+"min."+ss+"sec.");
                                       if(ss==0)
                                          {
                                             if(sm!=0)
                                              {
                                                 sm=sm-1;
                                                 ss=60;
                                                 SS=60;
                                               }
                                             else
                                             {
                                                   timer.stop();
                                                   postClockTask();
                                               }
                                          }
                                   
                                             if(win)
                                              {
                                                   timer.stop();
                                                   postClockTask();
                                               }
                                     if(pause==1)
                                       {
                                             timer.stop();
                                             for(p=0; p<greatestlength; p++)
                                                  {
                                                       for(q=0; q<greatestlength; q++)
                                                         {
                                                                jb2[p][q].setVisible(false);
                                                                f.add(jb3[p][q]);
                                                          }
                                                   } 
                                         JOptionPane.showMessageDialog(null,"GAME PAUSED!! \nCLICK THE TIMER AGAIN TO CONTINUE");
                                          pause=2;   
                                       }

                                                 try
                                                  {
                                                            Thread.sleep(100);
                                                   }
                                                catch(InterruptedException IE)
                                                {
                                                          System.out.println(IE);
                                                 }
                               }          
                      });
                  timer.setRepeats(true);
                  timer.start();        
  }
   
public void postClockTask()
{
    int i=0,j=0;

    if(win)
       JOptionPane.showMessageDialog(null,"WOO! YOU ARE SO QUICK \n LET'S CHECK RESULTS!");
    else
      JOptionPane.showMessageDialog(null,"OOPS! YOUR TIME'S OUT \n (click 'ok' to see your score)");
    timerEnded=2;

    l13.setVisible(false);
    b11.setVisible(false);

    if(!(ansS.equals(" ")))
      {   
                          while(L1.prev!=null)
                                L1=L1.prev;
                           
                          do
                             { 
                                    jb2[L1.r][L1.c].setOpaque(true);
                                    jb2[L1.r][L1.c].setForeground(new Color(255,255,255));
                                    jb2[L1.r][L1.c].setBackground(new Color(0,0,0));
                                    L1=L1.next; 
                              }
                          while(L1!=null);    
            L1=null;
            ansS=" "; 
      }

     for(i=0; i<greatestlength; i++)
    {
        for(j=0; j<greatestlength; j++)
           {
                  ActionListener[] al= jb2[i][j].getActionListeners();
                  for(ActionListener listener : al)
                  jb2[i][j].removeActionListener(listener);
           }
    }
  
  b12=new JButton("DONE!");
  b12.setBounds(360,105-7,170,50);
  b12.setFont(new Font("VERDANA",Font.PLAIN,25));
  b12.setForeground(new Color(0,0,0));
  b12.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GREEN, Color.GREEN));
  b12.setOpaque(true);
  b12.setBackground(new Color(34,177,76));
  b12.addActionListener(this);
  f.add(b12);  

  l11.setText("CLICK DONE!! TO MOVE AHEAD");
    
    sf2=new JFrame("SCORE CARD");
    sf2.setSize(500,500);
    l14=new JLabel("NAME:");
    l14.setBounds(10,20,100,50);
    l14.setFont(new Font("ARIAL ROUNDED MT", Font.BOLD, 20));
    l14.setForeground(new Color(192,192,192));
    sf2.add(l14);
     
    l15=new JLabel(tf2.getText());
    l15.setBounds(86,20,170,50);
    l15.setFont(new Font("ARIAL", Font.PLAIN, 17));
    l15.setForeground(new Color(192,192,192));
    sf2.add(l15);
    
    l16=new JLabel("LEVEL:");
    l16.setBounds(300,20,100,50);
    l16.setFont(new Font("ARIAL ROUNDED MT", Font.BOLD, 20));
    l16.setForeground(new Color(192,192,192));
    sf2.add(l16);

    if(rb1.isSelected())
    l17=new JLabel(rb1.getText());
    
    if(rb2.isSelected())
    l17=new JLabel(rb2.getText());

    if(rb3.isSelected())
    l17=new JLabel(rb3.getText());

    l17.setBounds(380,20,80,50);
    l17.setFont(new Font("ARIAL", Font.PLAIN, 17));
    l17.setForeground(new Color(192,192,192));
    sf2.add(l17);

    l18=new JLabel("CITY:");
    l18.setBounds(10,80,100,50);
    l18.setFont(new Font("ARIAL ROUNDED MT", Font.BOLD, 20));
    l18.setForeground(new Color(192,192,192));
    sf2.add(l18);

    l19=new JLabel(tf3.getText());
    l19.setBounds(70,80,170,50);
    l19.setFont(new Font("ARIAL", Font.PLAIN, 17));
    l19.setForeground(new Color(192,192,192));
    sf2.add(l19);

     l20=new JLabel("DOB:");
    l20.setBounds(300,80,70,50);
    l20.setFont(new Font("ARIAL ROUNDED MT", Font.BOLD, 20));
   l20.setForeground(new Color(192,192,192));
    sf2.add(l20);

   l21=new JLabel(tf4.getText());
    l21.setBounds(380,80,100,50);
    l21.setFont(new Font("ARIAL", Font.PLAIN, 20));
    l21.setForeground(new Color(192,192,192));
    sf2.add(l21);

   l22=new JLabel("TOTAL WORDS: "+(String.valueOf(i1)));
   l22.setBounds(130,160,200,30);
   l22.setFont(new Font("COURIER", Font.PLAIN, 17));
   l22.setForeground(new Color(128,0,255));
   sf2.add(l22);

   l23=new JLabel("TOTAL WORDS FOUND(+5): "+(String.valueOf(wordsFound)));
   l23.setBounds(130,180,300,30);
   l23.setFont(new Font("COURIER", Font.PLAIN, 17));
   l23.setForeground(new Color(0,255,0));
   sf2.add(l23);

   l24=new JLabel("WRONG CLICKS(-2):"+(String.valueOf(wrongClicks)));
   l24.setBounds(130,200,200,30);
   l24.setFont(new Font("COURIER", Font.PLAIN, 17));
   l24.setForeground(new Color(255,0,0));
   sf2.add(l24);
  
   l25=new JLabel("TIME REMAINING: "+sm+"min. "+ss+" sec.");
   l25.setBounds(130,220,300,30);
   l25.setFont(new Font("COURIER", Font.PLAIN, 17));
   l25.setForeground(new Color(255,255,255));
   sf2.add(l25);

   timeBonus=((sm*60)+ss)*0.5;
   l26=new JLabel("TIME BONUS(+0.5/sec.): "+(String.valueOf(timeBonus)));
   l26.setBounds(130,240,300,30);
   l26.setFont(new Font("COURIER", Font.PLAIN, 17));
   l26.setForeground(new Color(255,128,0));
   sf2.add(l26);
   
  finalScore=(wordsFound*5)-(wrongClicks*2);
  finalScore=finalScore+timeBonus;
   l27=new JLabel("FINAL SCORE:- "+(String.valueOf(finalScore)));
   l27.setBounds(75,330,400,45);
   l27.setFont(new Font("ALGERIAN", Font.BOLD, 35));
   l27.setForeground(new Color(0,0,255));
   l27.setBorder(new BevelBorder(BevelBorder.RAISED));
   l27.setBackground(new Color(0,0,0));
   sf2.add(l27);
    
   sf2.setLayout(null);   
   sf2.getContentPane().setBackground(Color.BLACK);
   sf2.setVisible(true);
   sf2.setResizable(false);
   wordsFound=0;
   wrongClicks=0;
   timeBonus=0.0;
   finalScore=0.0;
                                                
  JOptionPane.showMessageDialog(null,"CLICK ON WORDS TO LOCATE THEM!","NOTICE",JOptionPane.INFORMATION_MESSAGE);
   for(j=0; j<i1; j++)
    jb1[j].addActionListener(this);           

}

public void miniClock(int p, int q)
{
   Thread thread=new Thread()
   {
      public void run()
       {
    timer=new Timer(1500, new ActionListener()
       {
            public void actionPerformed(java.awt.event.ActionEvent e)
                {
                     jb2[p][q].setForeground(new Color(0,0,0));
                     jb2[p][q].setBackground(new Color(gradred,gradgreen,gradblue));
                          try
                              {
                                    sleep(1,1);
                              }
                         catch(InterruptedException IE)
                              {
                                      System.out.println(IE);
                               }                   
                 }           
        });
         timer.setRepeats(false);
         timer.start();
   }
 };
  thread.start();
}

 public void autoFill()
 {
  Thread thread=new Thread()
   {
      public void run()
       {
            for(p=0; p<i1; p++)
            {
              do
              {
                  word=Words[(int)(Math.random()*(Words[0].length))][(int)(Math.random()*(Words[0].length))];
               }
             while(word==null);

              if(word.length()<=maxletter)
               {
                        try
                              {
                                   sleep(700);
                              }
                         catch(InterruptedException IE)
                              {
                                      System.out.println(IE);
                               }

                      for(q=0; q<p; q++)
                        {
                            if(tf[q].getText().substring(4, tf[q].getText().length()).equals(word))
                              break;
                        }
                           if(q==p)
                             {
                                tf[p].setText("("+(p+1)+") "+word);
                                tf[p].setForeground(Color.BLACK);
                             }
                          else
                           p=p-1;        
                }               
          }
      }
   };
  thread.start();    
}

  public void howtoplay()
{
    ta1.setText("\n    The players will first of all select the level that they prefer to play, depending upon which\n    which they would enter some words. In return they would be given a wordweb. All the\n    words would be arranged in any one of  the eight directions (i.e. towards up,down,left,right,\n    up-diagonal-right, up-diagonal-left,down-diagonal-right,down-diagonal-left). Players will fetch\n    for all the words in the time alloted to them. Note: Do press enter after every selection of a\n    word, each selection will be indicated by yellow color, whereas wrong ones by red color\n    leading to deduction in score. Your right answer will be indicated by different colors.\n    For every correct answer '+5' points be awarded while for every wrong click '-2' point will be\n    deducted. A time bonus of '+0.5' points will be given on finishing the game before time\n    (stop the timmer as you finish).\n  \t\t                 LET'S PLAY THEN!");
 }

public  void colorProvider()
{
    int r=(int)(Math.random()*6);
                                if(r==0)
                                 {
                                    gradred=upperLimit;
                                    gradgreen=lowerLimit;
                                    gradblue=(int)(70+(Math.random()*(upperLimit-70+1)));
                                 }
                                if(r==1)
                                 {
                                    gradred=(int)(lowerLimit+(Math.random()*(upperLimit-lowerLimit+1)));
                                    gradgreen=upperLimit;
                                    gradblue=lowerLimit;
                                 }
                                if(r==2)
                                 {
                                    gradred=upperLimit;
                                    gradgreen=(int)(70+(Math.random()*(upperLimit-70+1)));
                                    gradblue=lowerLimit;
                                 }
                                if(r==3)
                                 {
                                    gradred=lowerLimit;
                                    gradgreen=upperLimit;
                                    gradblue=(int)(lowerLimit+(Math.random()*(upperLimit-lowerLimit+1)));
                                 }
                                if(r==4)
                                 {
                                    gradred=(int)(lowerLimit+(Math.random()*(upperLimit-lowerLimit+1)));
                                    gradgreen=lowerLimit;
                                    gradblue=upperLimit;
                                 }
                                if(r==5)
                                 {
                                    gradred=lowerLimit;
                                    gradgreen=(int)(lowerLimit+(Math.random()*(upperLimit-lowerLimit+1)));
                                    gradblue=upperLimit;
                                 }

}

 public static void main(String ar[])throws Exception
{
    SwingUtilities.invokeLater(new Runnable()
    {
         @Override
        public void run()
           {
                  new  ww();
           }
     });
}

public void initializeWordArrE()
 {
     WordsE[0][0]="king";
     WordsE[0][1]= "queen";
     WordsE[0][2]= "jack";
     WordsE[0][3]= "lion";
     WordsE[0][4]= "tiger";
     WordsE[1][0]= "ashoka";
     WordsE[1][1]= "india";
     WordsE[1][2]= "kanpur";
     WordsE[1][3]= "express";
     WordsE[1][4]= "field";
     WordsE[2][0]= "flight";
     WordsE[2][1]= "europe";
     WordsE[2][2]= "kashmir";
     WordsE[2][3]= "america";
     WordsE[2][4]= "africa";
     WordsE[3][0]= "jammu";
     WordsE[3][1]= "lucknow";
     WordsE[3][2]= "bridge";
     WordsE[3][3]= "cream";
     WordsE[3][4]= "fighter";
     WordsE[4][0]= "boxer";
     WordsE[4][1]= "knife";
     WordsE[4][2]= "wegde";
     WordsE[4][3]= "joker";
      Words=WordsE;
 }

public void initializeWordArrM()
 {
     WordsM[0][0]="friend";
     WordsM[0][1]= "kolkata";
     WordsM[0][2]= "compass";
     WordsM[0][3]= "elephant";
     WordsM[0][4]= "tiger";
     WordsM[1][0]= "ashoka";
     WordsM[1][1]= "india";
     WordsM[1][2]= "kanpur";
     WordsM[1][3]= "express";
     WordsM[1][4]= "field";
     WordsM[2][0]= "flight";
     WordsM[2][1]= "europe";
     WordsM[2][2]= "kashmir";
     WordsM[2][3]= "america";
     WordsM[2][4]= "africa";
     WordsM[3][0]= "jammu";
     WordsM[3][1]= "scissor";
     WordsM[3][2]= "bridge";
     WordsM[3][3]= "cream";
     WordsM[3][4]= "fighter";
     WordsM[4][0]= "doggy";
     WordsM[4][1]= "knife";
     WordsM[4][2]= "wegde";
     WordsM[4][3]= "computer";
      Words=WordsM;
 }

public void initializeWordArrH()
 {
     WordsH[0][0]="friend";
     WordsH[0][1]= "kolkata";
     WordsH[0][2]= "compass";
     WordsH[0][3]= "elephant";
     WordsH[0][4]= "snake";
     WordsH[1][0]= "ashoka";
     WordsH[1][1]= "india";
     WordsH[1][2]= "kanpur";
     WordsH[1][3]= "express";
     WordsH[1][4]= "field";
     WordsH[2][0]= "tennis";
     WordsH[2][1]= "europe";
     WordsH[2][2]= "kashmir";
     WordsH[2][3]= "america";
     WordsH[2][4]= "africa";
     WordsH[3][0]= "jammu";
     WordsH[3][1]= "scissor";
     WordsH[3][2]= "bridge";
     WordsH[3][3]= "cream";
     WordsH[3][4]= "fighter";
     WordsH[4][0]= "doggy";
     WordsH[4][1]= "aeroplane";
     WordsH[4][2]= "mobile";
     WordsH[4][3]= "computer";
      Words=WordsH;
 }

}  // end of class ww

