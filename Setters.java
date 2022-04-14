import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.Vector;

public class Setters {

    JFrame frame;
    JPanel panel,panel2;
    JButton buttonApply,buttonCancel;
    JCheckBox checkBox[],checkBoxSelectAll;
    Vector<Integer> selectedBoxes = new Vector<>();
    String text;
    String file;
    String[] variables;
    String[] dataTypes;

    final static Font defaultFont = new Font("Monospaced", Font.PLAIN, 20);


    public Setters(String text,String file) {

        this.text = text;
        this.file = file;
        text = text.trim();

        String lines[] = text.split("\\r?\\n");

        String attributes[] = new String[lines.length];

        String temp = "";
        for(int i=0; i<lines.length; i++){
            temp += lines[i].trim()+" ";
        }

        System.out.println(temp);

        String[] splited = temp.split("\\s+");

        variables = new String[splited.length / 2];
        dataTypes = new String[splited.length / 2];

        int v = 0;
        int d = 0;
        for (int i=0; i<splited.length; i++){
            if(i % 2 == 0) {
                dataTypes[d] = splited[i];
                d++;
            }
            else {
                variables[v] = splited[i].substring(0,splited[i].length() - 1);
                v++;
            }
        }
        System.out.println("variables");

        for (int i=0; i<variables.length; i++){
            System.out.println(variables[i]);
        }
        System.out.println("data Types");

        for (int i=0; i<variables.length; i++){
            System.out.println(dataTypes[i]);
        }


        frame = new JFrame("Setters");
        panel = new JPanel(new GridLayout(12,0));
        panel2 = new JPanel(new GridLayout(0,2,6,10));
        buttonApply = new JButton("Apply");
        buttonCancel = new JButton("Cancel");
        checkBoxSelectAll = new JCheckBox(" Select All");

        Font selectAllFont = new Font("Monospaced", Font.ITALIC, 22);
        checkBoxSelectAll.setFont(selectAllFont);
        frame.add(panel);
        frame.add(panel2);

        panel.setBounds(10,10,280,600);
        panel2.setBounds(10,620,280,30);

        panel2.add(buttonCancel);
        panel2.add(buttonApply);

        panel.add(checkBoxSelectAll);
        addVariablesOnPanel();
        setOnClickListeners();

        frame.setSize(300,700);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void setOnClickListeners(){

        buttonCancel.addActionListener(e -> {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        });

        buttonApply.addActionListener(e -> {
            String getters = getSetters();

            String outputFile = file.replace(text,text+"\n"+getters);
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

            Notepad n = new Notepad();
            n.setText(outputFile);

        });
        checkBoxSelectAll.addActionListener(e -> {

            if(!checkBoxSelectAll.isSelected()){
                for(int i=0;i<variables.length; i++)
                    checkBox[i].setSelected(false);
            }

            else{
                for(int i=0;i<variables.length; i++)
                    checkBox[i].setSelected(true);
            }

        });

    }

    public void addVariablesOnPanel(){

        checkBox = new JCheckBox[dataTypes.length];

        for (int i=0; i<variables.length; i++){

            checkBox[i] = new JCheckBox(" "+dataTypes[i]+" "+variables[i]);
            checkBox[i].setFont(defaultFont);
            panel.add(checkBox[i]);
        }

    }

    public String getSetters(){

        String setters = "\n";

        for(int i=0; i<checkBox.length; i++){
            if(checkBox[i].isSelected()){
                setters += getSetter(i);
            }
        }
        System.out.println(setters);

        return setters;
    }

    public String getSetter(int i){

        return "\tpublic void set"+variables[i].substring(0,1).toUpperCase()+variables[i].substring(1)+"("+dataTypes[i]+" "+variables[i]+"){"+
                "\n\t\t"+"this."+variables[i]+" = "+variables[i]+";"+
                "\n\t}"+"\n";

    }
    void setSelectedBoxes(){
        for(int i=0; i<checkBox.length; i++)
            if(checkBox[i].isSelected()) {
                System.out.println(i);
                selectedBoxes.add(i);
            }
    }



}
