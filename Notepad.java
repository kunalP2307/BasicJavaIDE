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
    JMenu menuOpen,menuOptions;
    MenuItem menuItemGetters,menuItemSetters,menuItemConsWithField,menuItemDefaultCons;

    JMenuItem menuGenerate,menuNewTab;
    public Notepad(){
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
                        new Generate(selectedText,file);
                        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                        System.out.println(selectedText);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(frame, "Please Select Variables to Generate");
                }
            }
        });

        menuNewTab = new JMenuItem(new AbstractAction("|+|") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                new CreateTemplate();
            }
        });
        menuOptions = new JMenu("Options");

        menuOptions.setFont(menuFont);
        menuOpen.setFont(menuFont);
        menuGenerate.setFont(menuFont);
        menuNewTab.setFont(menuFont);


        //menuOpen.setBorderPainted(true);
        //UIManager.put("PopupMenu.border",BorderFactory.createLineBorder(Color.RED));
        menuBar.add(new JLabel("       "));
        menuBar.add(menuOpen);
        menuBar.add(new JLabel(" "));
        menuBar.add(menuGenerate);
        menuBar.add(new JLabel(" "));
        menuBar.add(menuNewTab);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(menuOptions);
        menuBar.add(new JLabel("        "));
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
}
