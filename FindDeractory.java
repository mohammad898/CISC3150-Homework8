

	import java.io.File;
	import java.io.IOException;
	import java.io.PrintWriter;

	public class FindDeractory{
		/*

https://docs.oracle.com/javase/7/docs/api/java/io/PrintWriter.html
 http://www.java-examples.com/list-contents-directory
 http://www.avajava.com/tutorials/lessons/how-do-i-recursively-display-all-files-and-directories-in-a-directory.html
https://stackoverflow.com/questions/10655085/print-directory-tree
http://www.java2s.com/Tutorial/Java/0180__File/Displaydirectorytree.htm
*/
		

		
		public static PrintWriter printwriter;
		
		public static File file = new File("dir_tree.txt");
public static void Search_file(File file, int l) {
			
			File[] fileArray = file.listFiles();
			
			
			for (int i = 0; i < fileArray.length; i++) {
				
				
				if (fileArray[i].isDirectory() && !(fileArray[i].isHidden())) {
					for (int j = 0; j < l; j++) {
						
						printwriter.write("---"+fileArray[i].getName()+ "\n");
						printwriter.flush();
					}
					
					printwriter.print(fileArray[i].getName());
					printwriter.println();
					printwriter.flush();
					
					
					Search_file(fileArray[i], l + 1);
				}
			}
		}
			
		public static void main(String[] args) {
			
			int position= 0;
		
			try {
				printwriter = new PrintWriter(file);
				
				
				File file_directory = new File("/Users/Paru/Desktop/CISC3150_hw8");
				
				
				Search_file(file_directory, position);
				
			} catch (IOException e) {
				System.out.println(" Something wrong in your directory.Please check it again.");
			} finally {
				printwriter.close();
				System.out.println("Diractory searching complete");
			}
		}
		
		
	}
