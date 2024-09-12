package modules.targeted;

import modules.Module;
import java.util.Scanner;

public class TargetDataCLI extends Module{

    TargetDataCLI(String name,int id){
        super(name,id);
    }

    @Override
    public void Run(){
        Scanner scanner = new Scanner(System.in);
        String input = new String("");
        System.out.println("Add String or a date! Use 'help' for information");
        while(!input.equals("Exit")){
            input = scanner.nextLine();
            if(input.equals("help")){
                Help();
            }

        }

    }

    public void Help(){
        System.out.println("Commandlist:");
        System.out.println("AddString(String) -Add a string information");
        System.out.println("AddDate(YYYY/MM/DD) -Add a date information");
        System.out.println("IncludeOnlyYearCases(true) -it's false by default");
        System.out.println("IncludeMonthAndDayCases(true) -it's false by default");
        System.out.println("Exit");
    }



}

