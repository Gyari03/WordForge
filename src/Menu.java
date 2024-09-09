import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import modules.Module;
import modules.date.DateCLI;
import modules.pin.PinCLI;

public class Menu {

    public Menu(){
        List<Module> moduleList = new ArrayList<Module>();
        //load modules here:
        moduleList.add( new DateCLI("DateModule", moduleList.size()+1));
        moduleList.add( new PinCLI("PinModule", moduleList.size()+1));

        for (Module current : moduleList) {
            System.out.printf("%d. %s\n", current.getId(), current.getName());
        }

        Scanner scanner = new Scanner(System.in);

        int input = 0;

        while (true) {
            System.out.println("Enter a module number (or -1 to exit):");
            input = scanner.nextInt();
            if (input == -1) {break;}

            if (input > 0 && input <= moduleList.size()) {moduleList.get(input - 1).Run(); break;}

            else{System.out.println("Invalid input. Please enter a number between 1 and " + moduleList.size() + ".");}
        }
    }
}
