import java.awt.Color;
import java.util.Random;
import javax.swing.*;
public class ThreadRace extends Thread
{
	String ThreadName;
	
	JPanel l1,l2,l3;
	JFrame fr;
	public ThreadRace()
	{
		buildGUI();
	}
	public ThreadRace(String s)
	{
		super(s);
	}
	public void run()
	{
		if(Thread.currentThread().getName().equals("A"))
		{
			runA();
		}
		if(Thread.currentThread().getName().equals("B"))
		{
			runB();
		}
		if(Thread.currentThread().getName().equals("C"))
		{
			runC();
		}
	}
	public void runA()
	{
		Random ran=new Random();
		int s=ran.nextInt(1000);
		for(int i=-10;i<1500;i++)
		{
			l1.setBounds(i,s,20,20);
			try{
				Thread.sleep(5);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		runC();
	}
	public void runB()
	{
		Random ran=new Random();
		int r=ran.nextInt(200);
		for(int i=-10;i<1500;i++)
		{
			l2.setBounds(i,r,20,20);
			try{
				Thread.sleep(11);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		runA();
	}
	public void runC()
	{
		Random ran=new Random();
		int m=ran.nextInt(10);
		for(int i=-10;i<1500;i++)
		{
			l3.setBounds(i,m,20,20);
			try{
				Thread.sleep(10);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		runB();
	}
	public void buildGUI()
	{
		fr=new JFrame("moving objects");
		fr.setVisible(true);
		fr.setSize(400,200);
		fr.setLayout(null);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		l1=new JPanel();
		l1.setSize(20,20);
		l1.setBackground(Color.red);
		
		fr.add(l1);
		l2=new JPanel();
		l2.setSize(20,20);
		l2.setBackground(Color.blue);
		
		fr.add(l2);
		l3=new JPanel();
		l3.setSize(20,20);
		l3.setBackground(Color.black);
		
		fr.add(l3);
	}
	public static void main(String args[])
	{
		
		ThreadRace obj=new ThreadRace();
		Thread obstacle1=new Thread(obj);
		Thread obstacle2=new Thread(obj);
		Thread obstacle3=new Thread(obj);
		obstacle1.setName("A");
		obstacle2.setName("B");
		obstacle3.setName("C");
		obstacle1.start();
		obstacle2.start();
		obstacle3.start();
	}
}

		