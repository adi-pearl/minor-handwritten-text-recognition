import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Writefile {
	private PrintWriter x;
	private File log;
	private char symbol;
	public void openFile(String filename,char smb){
		symbol=smb;
		log=new File(filename);
		try{
			if(log.exists()==false)log.createNewFile();
			x=new PrintWriter(new FileWriter (log,true));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void addImage(boolean image[][],int m, int n){
		for(int i=0;i<m;++i){
			for(int j=0;j<n;++j){
				x.append(image[i][j]?'1':'0');
				x.append(" ");
			}
			//x.append("\n");
		}
		x.append(symbol);
		x.append("\n");
	}
	public void closeFile(){
		x.close();
	}
}
