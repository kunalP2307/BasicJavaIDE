import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class CreateTemplate {

    JFrame frame;
    JPanel panel;
    final static Font menuFont = new Font( "Monospaced", Font.PLAIN, 22);
    CheckboxGroup checkboxGroup;
    JButton buttonCreate;
    Checkbox checkBoxClass,checkBoxInterface,checkBoxRecord,checkBoxEnum,
            checkBoxAnnotation;
    JTextField textFieldName;
    JCheckBox checkBoxAddMainMethod;

    public CreateTemplate(){

        frame = new JFrame("New");
        panel = new JPanel(new GridLayout(10,0,8,0));
        textFieldName = new JTextField();
        checkBoxAddMainMethod = new JCheckBox("  Add Main Method");
        checkBoxAddMainMethod.setEnabled(false);
        buttonCreate = new JButton("Create");
        checkBoxAddMainMethod.setFont(menuFont);
        buttonCreate.setFont(menuFont);

        checkboxGroup = new CheckboxGroup();

        textFieldName.setFont(menuFont);


        checkBoxClass = new Checkbox("Class",checkboxGroup,false);
        checkBoxClass.setFont(menuFont);

        checkBoxInterface = new Checkbox("Interface",checkboxGroup,false);
        checkBoxInterface.setFont(menuFont);

        checkBoxAnnotation = new Checkbox("Annotation",checkboxGroup,false);
        checkBoxAnnotation.setFont(menuFont);

        checkBoxEnum = new Checkbox("Enum",checkboxGroup,false);
        checkBoxEnum.setFont(menuFont);

        checkBoxRecord = new Checkbox("Record",checkboxGroup,false);
        checkBoxRecord.setFont(menuFont);

        addLisnter();

        panel.add(textFieldName);
        panel.add(checkBoxClass);
        panel.add(checkBoxInterface);
        panel.add(checkBoxAnnotation);
        panel.add(checkBoxEnum);
        panel.add(checkBoxRecord);
        panel.add(new Label("------------------------------------------------------------------------------------"));
        panel.add(checkBoxAddMainMethod);
        panel.add(new Label());
        panel.add(buttonCreate);
        panel.setBounds(10,10,280,530);
        frame.add(panel);
        frame.setSize(300,600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocation(1100,110);
    }

    public void addLisnter(){

        this.buttonCreate.addActionListener(e -> {

            Checkbox checkbox = checkboxGroup.getSelectedCheckbox();
            String selectedItem;

            String name = textFieldName.getText();
            if(checkbox != null && !name.equals("")){
                selectedItem = checkbox.getLabel();

                if(!selectedItem.equals("")){
                    if(selectedItem.equals("Class"))
                        createClassTemplate(name);
                    else if(selectedItem.equals("Interface"))
                        createInterface(name);
                    else if(selectedItem.equals("Annotation"))
                        createAnnotation(name);
                    else if(selectedItem.equals("Enum"))
                        createEnum(name);
                    else if(selectedItem.equals("Record"))
                        createRecord(name);
                }
            }
        });

        checkBoxClass.addItemListener(e -> {
            if(checkBoxClass.getState())
                checkBoxAddMainMethod.setEnabled(true);
            else
                checkBoxAddMainMethod.setEnabled(false);

        });
    }

    public void createClassTemplate(String className) {

        String mainMethod = "";
        if (checkBoxAddMainMethod.isSelected()) {
            mainMethod = "public static void main(String Args[]){\n" +
                    "\n" +
                    "\t}";
        }

        String classTemplate = "public class " + className + "{" +
                "\n\n\t"+mainMethod+
                "\n\n"+"}"+"\n";
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        Notepad n = new Notepad();
        n.setText(classTemplate,className);
    }

    public void createInterface(String interfaceName){
        String interfaceTemplate = "public interface "+interfaceName+"{"+
                "\n\n"+"}"+"\n";
        Notepad n = new Notepad();
        n.setText(interfaceTemplate);
    }
    public void createAnnotation(String annotationName){
        String annotationTemplate = "public @interface "+annotationName+"{"+
                "\n\n"+"}"+"\n";
        Notepad n = new Notepad();
        n.setText(annotationTemplate);
    }
    public void createRecord(String recordName){
        String recordTemplate = "public record "+recordName+"(){"+
                "\n\n"+"}"+"\n";
        Notepad n = new Notepad();
        n.setText(recordTemplate);
    }
    public void createEnum(String enumName){
        String enumTemplate = "public enum "+enumName+"{"+
                "\n\n"+"}"+"\n";
        Notepad n = new Notepad();
        n.setText(enumTemplate);
    }

    public static void main(String args[]){

        new CreateTemplate();


    }
}
