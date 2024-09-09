package modules.pin;

import java.util.Scanner;
import modules.Module;
import utils.ConsoleUtils;

public class PinCLI extends Module {

    public PinCLI(String name,int id){
        super(name,id);
    }

    @Override
    public void Run(){
        ConsoleUtils.clearConsole();
        Scanner scanner = new Scanner(System.in);



        System.out.println("Lowerbound:");
        int lowerBound = scanner.nextInt();

        System.out.println("Upperbound:");
        int upperBound = scanner.nextInt();

        //empty buffer
        scanner.nextLine();

        String filename;
        System.out.println("Give me a file name (must be longer than 3 characters):");
        filename = scanner.nextLine();


        while (filename.length() < 4) {
            System.out.println("Filename should be longer than 3 characters!");
            System.out.println("Give me a file name (must be longer than 3 characters):");
            filename = scanner.nextLine();
        }

        if(!filename.endsWith(".txt")){
            filename = filename.concat(".txt");
        }
        PinComputer computer = new PinComputer(lowerBound,upperBound);
        computer.writeOut(filename);
    }

}
