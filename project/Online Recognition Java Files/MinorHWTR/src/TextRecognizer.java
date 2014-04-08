/* @author Aditya
 */

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
/* <applet code="Cal" width=300 height=300> </applet> */

public class TextRecognizer extends Applet{
	//GUI elements
	private JLabel statusBar;
	private JButton nextButton=new JButton("next");
	private final int wdHt=500,wdWt=500;
	private class coord{
		public int x,y;
		coord(int a, int b){x=a;y=b;}
	}
	Vector<coord> v=new Vector<>();
	//Neural Network Components
	private final int resolution=20;
	private boolean bitmap[][]=new boolean[wdHt+1][wdWt+1];
	private boolean image[][]=new boolean[resolution][resolution];
	//corpus creation variables
	private char presentSymbol;
	private int counter;
	private final String directory="D:/Study/Courses/Machine Learning Andrew Ng/project/corpus/";
	private final Writefile f=new Writefile();
	private final int noOfSamplesPerCharacter=10;
	public void init() {
		setSize(wdWt, wdHt);
		
		statusBar=new JLabel("default");
		this.add(statusBar,BorderLayout.SOUTH);
		this.add(nextButton,BorderLayout.EAST);
		HandlerClass handler= new HandlerClass();
		this.addMouseListener(handler);
		this.addMouseMotionListener(handler);
		nextButton.addActionListener(handler);
		presentSymbol='0';counter=0;
		clearBitmap();
		statusBar.setText("Draw "+presentSymbol);setForeground(Color.RED);
	}
	public void paint(Graphics g){
		super.paint(g);
		try{
		for(coord c : v)
			g.fillOval(c.x, c.y, 2, 2);
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	private void imresize(boolean bitmap[][]){
		int gridHt=wdHt/resolution,gridWt=wdWt/resolution;
		for(int i=0;i<resolution;++i)
			for(int j=0;j<resolution;++j){
				boolean present=false;
				for(int it=1+i*gridHt;present==false && it<=(i+1)*gridHt;++it)
					for(int jt=1+j*gridWt;jt<=(j+1)*gridWt;++jt){
						if(it<1||it>wdHt||jt<1||jt>wdWt)System.out.println("out");
						//System.out.println(it+" "+jt);
						if(bitmap[it][jt]==true){present=true;break;}
					}
				if(present)image[i][j]=true;
				else image[i][j]=false;
			}
	}
	private void clearBitmap(){
		for(int i=0;i<500;++i)
			for(int j=0;j<500;++j)
				bitmap[i][j]=false;
		statusBar.setText("bitmap cleared");
	}
	private class HandlerClass implements 
		MouseListener, MouseMotionListener,ActionListener{

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			statusBar.setText("Drawing: "+presentSymbol );
			bitmap[e.getY()][e.getX()]=true;
			v.add(new coord(e.getX(),e.getY()));repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			//statusBar.setText("mouse moved");
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==nextButton){
				if(counter==0)f.openFile(directory+presentSymbol+".txt",presentSymbol);
				counter++;
				
				statusBar.setText("Digit successfully Drawn");
				v.clear();repaint();
				imresize(bitmap);
				f.addImage(image, resolution, resolution);
				statusBar.setText("Digit image matrix stored in ex.txt");
				
				if(counter==noOfSamplesPerCharacter){
					if(presentSymbol<'9')presentSymbol++;
					else if(presentSymbol=='9')presentSymbol='a';
					else if(presentSymbol<'z')presentSymbol++;
					else {statusBar.setText("Corpus complete on your part...");}
					counter=0;
					f.closeFile();
				}
				clearBitmap();
				statusBar.setText("Draw "+presentSymbol);
			}
		}	
	}
}
