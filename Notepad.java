import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Notepad {

    final static Font menuFont = new Font( "Monospaced", Font.PLAIN, 22);
    final static Font defaultTextAreaFont = new Font("Monospaced", Font.PLAIN, 20);
    JFrame frame;
    JTextArea textArea;
    JMenuBar menuBar;
    String className;

    boolean firstSave;

    MenuItem menuItemGetters,menuItemSetters,menuItemConsWithField,menuItemDefaultCons;

    JMenuItem menuGenerate,menuNewTab,menuSave,menuOptions,menuOpen;
    public Notepad(){

        firstSave = true;
        frame = new JFrame("Untitled");
        textArea = new JTextArea();
        menuBar = new JMenuBar();
        menuOpen = new JMenu("Open  ");
        textArea = new JTextArea();
        menuGenerate = new JMenuItem(new AbstractAction("Generate") {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedText = textArea.getSelectedText();
                String file = textArea.getText();
                if(selectedText != null) {
                    if (!selectedText.equals("")) {
                        new Generate(className,selectedText,file);
                        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                        System.out.println(selectedText);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(frame, "Please Select Variables to Generate");
                }
            }
        });

        menuNewTab = new JMenuItem(new AbstractAction("New") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                new CreateTemplate();
            }
        });

        menuSave = new JMenuItem(new AbstractAction("Save") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Inside Save");
                String fileText = textArea.getText();

                if(fileText != null){
                    new GetPathPrompt(fileText);
                }

            }
        });

        menuOptions = new JMenuItem(new AbstractAction("Options") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                System.out.println("helllo");
            }
        });

        menuOpen = new JMenuItem(new AbstractAction("Open") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                System.out.println("helllo");
            }
        });

        menuOptions = new JMenu("Options");

        menuOptions.setFont(menuFont);
        menuOpen.setFont(menuFont);
        menuGenerate.setFont(menuFont);
        menuNewTab.setFont(menuFont);
        menuSave.setFont(menuFont);

        menuBar.add(new JLabel("                                          "));


        menuBar.add(menuOpen);
        menuBar.add(menuGenerate);

        menuBar.add(menuNewTab);


        menuBar.add(menuSave);
        //menuBar.add(menuOptions);


        frame.setJMenuBar(menuBar);


        frame.add(textArea);
        int width = Utility.getScreenWidth();
        int height = Utility.getScreenHeight();

        textArea.setBounds(10,10,width-100,height-135);
        textArea.setFont(defaultTextAreaFont);

        frame.setSize(width,height);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void setText(String text){
        textArea.setText(text);
    }
    public void setText(String text,String className){
        this.className = className;
        textArea.setText(text);
    }
}
