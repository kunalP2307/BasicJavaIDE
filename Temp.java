public class Temp {

    public static void main(String args[]){
        String abc = "dhfjsdfj\ndsfjdsgfsd\njgdfjgsdjf\nhjhgd";
        String lines[] = abc.split("\\r?\\n");
        System.out.println(abc+"\n");
        for(int i=0; i<lines.length; i++)
            System.out.println(lines[i]);
    }
}
