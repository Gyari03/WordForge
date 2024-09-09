package modules.pin;

import java.util.Scanner;
import modules.Module;
import utils.ConsoleUtils;

public class PinCLI extends Module {
    private int lowerBound;
    private int upperBound;

    public PinCLI(String name,int id){
        super(name,id);
    }

    @Override
    public void Run(){
        ConsoleUtils.clearConsole();
        Scanner scanner = new Scanner(System.in);



        System.out.println("Lowerbound:");
        lowerBound = scanner.nextInt();

        System.out.println("Upperbound:");
        upperBound = scanner.nextInt();

        String filename;
        System.out.println("Give me a file name:");
        filename = scanner.nextLine();
        if(!filename.substring(filename.length()-4).equals(".txt")){
            filename.concat(".txt");
        }

        PinComputer computer = new PinComputer(lowerBound,upperBound);
        computer.writeOut(filename);
    }

}
