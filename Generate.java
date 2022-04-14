import javax.swing.*;
import java.awt.*;

public class Generate {

    JFrame frame;
    JPanel panel;
    final static Font defaultTextAreaFont = new Font("Monospaced", Font.PLAIN, 18);
    final String[] buttonsText = {"Getters","Setters","Getters & Setters","Constructor","toString()","Override Methods"};
    JButton[] buttons;

    public String text;
    public String file;

    public Generate(String text,String file){

        this.text = text;
        this.file = file;

        frame = new JFrame("Generate");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new GridLayout(8,0,8,8));
        initButtons();
        setOnclickListeners();
        panel.setBounds(10,10,280,380);
        frame.add(panel);

        frame.setLayout(null);
        frame.setSize(300,400);
        frame.setLocation(200,110);
        frame.setVisible(true);

    }
    public void initButtons(){

        buttons = new JButton[8];
        for(int i=0; i<buttonsText.length; i++){
            buttons[i] = new JButton(buttonsText[i]);
            buttons[i].setFont(defaultTextAreaFont);
        }
        for (int i=0; i<buttonsText.length; i++)
            panel.add(buttons[i]);
    }

    public void setOnclickListeners(){

        buttons[0].addActionListener(e -> {

            Getters g = new Getters(text,file);
        });
        buttons[1].addActionListener(e -> {
            Setters setters = new Setters(text,file);
        });
        buttons[2].addActionListener(e -> {
            GettersAndSetters gettersAndSetters = new GettersAndSetters(text,file);
        });
        buttons[3].addActionListener(e -> {

        });
        buttons[4].addActionListener(e -> {

        });
        buttons[5].addActionListener(e -> {

        });

    }

    public static void main(String args[]){
        Generate generate = new Generate(null,null);
    }
}
