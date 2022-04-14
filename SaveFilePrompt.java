import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class SaveFilePrompt {

    JTextField textFieldFileName;
    JButton buttonSave;
    JFrame frame;
    String path;
    String fileText;
    final static Font menuFont = new Font( "Monospaced", Font.PLAIN, 22);

    public SaveFilePrompt(String fileText,String path){
        this.fileText = fileText;
        this.path = path;

        frame = new JFrame("Save File");
        textFieldFileName = new JTextField("Untitled");
        buttonSave = new JButton("Save");

        textFieldFileName.setBounds(10,10,380,40);
        textFieldFileName.setFont(menuFont);
        frame.add(textFieldFileName);

        buttonSave.setBounds(150,60,100,40);
        buttonSave.setFont(menuFont);
        frame.add(buttonSave);

        buttonSave.addActionListener(e -> {
            String fileName = textFieldFileName.getText();
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            try {
                PrintWriter fileWriter = new PrintWriter(path+"/"+fileName+".java","UTF-8");
                fileWriter.write(fileText);
                fileWriter.close();
                JOptionPane.showMessageDialog(frame, "File Saved Successfully.!");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }

        });

        frame.setSize(400,150);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocation(Utility.getScreenWidth()/2,Utility.getScreenHeight()/2);
    }

    public static void main(String args[]){
        new SaveFilePrompt("asd","/home/kunal/Documents/");
    }
}
