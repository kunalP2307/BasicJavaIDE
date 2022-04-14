import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GetPathPrompt extends JFrame{

    public String path;
    JFrame frame;
    String fileText;
    public GetPathPrompt(String fileText){
        this.fileText = fileText;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = fileChooser.showOpenDialog(getContentPane());
        if(option == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            path = file.getAbsolutePath();
            System.out.println(path);
            new SaveFilePrompt(fileText,path);
        }
        else{
            path = null;
        }

    }

    public static void main(String args[]){
      //  new GetPathPrompt();
    }
}
