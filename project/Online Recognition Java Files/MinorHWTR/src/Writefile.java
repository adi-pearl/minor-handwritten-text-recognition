import java.io.File;
import java.util.Formatter;

public class Writefile {
	private Formatter x;
	public void openFile(String filename){
		try{
			x=new Formatter(new File(filename));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void addImage(boolean image[][],int m, int n){
		for(int i=0;i<m;++i){
			for(int j=0;j<n;++j){
				x.format("%d", image[i][j]?1:0);
				x.format("%s", " ");
			}
			x.format("%s", "\n");
		}
		x.close();
	}
}
