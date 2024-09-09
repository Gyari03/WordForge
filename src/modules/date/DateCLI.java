package modules.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import utils.ConsoleUtils;

import modules.Module;

public class DateCLI extends Module{
    private LocalDate beginning;
    private LocalDate end;
    private Boolean dateFormatYY;
    private Boolean dateFormatYYYY;


    public DateCLI(String name, int id){
        super(name,id);
        dateFormatYY = false; dateFormatYYYY = false;
    }

    @Override
    public void Run(){
        //inicializing
        Scanner scanner = new Scanner(System.in);
        String input;
        LocalDate date = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        //clearing the console
        ConsoleUtils.clearConsole();

        //Beginning date
        System.out.println("Beginning date(YYYY/MM/DD)");
        while(date == null){
            input = scanner.nextLine();
            try{
                date = LocalDate.parse(input,formatter);
                beginning = date;
            }catch(DateTimeParseException e){
                System.out.println("Invalid date format. please enter date in YYYY/MM/DD format:");
            }
        }
        //End date
        date = null;
        System.out.println("End date(YYYY/MM/DD)");
        while(date == null){
            input = scanner.nextLine();
            try{
                date = LocalDate.parse(input,formatter);
                end = date;
            }catch(DateTimeParseException e){
                System.out.println("Invalid date format. please enter date in YYYY/MM/DD format:");
            }
        }

        System.out.println("Do you want to include both date formats in the wordlist?(YYYY/MM/DD) or (YY/MM/DD) or both?(1/2/3)");
        input = scanner.nextLine();
        try {
            if (input.equals("1")) {
                dateFormatYYYY = true;}
            else if (input.equals("2")) {
                dateFormatYY = true;}
            else if (input.equals("3")){
                dateFormatYYYY=true;dateFormatYY=true;
            }
            else {throw new IllegalArgumentException("Invalid argument provided(Y/N)");}
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Give me a file name:");
        while(input.length()<4){
            input = scanner.nextLine();
            if(input.length()<4){
                System.out.println("Filename should be longer than 3 characters!");
            }
        }
        if(!input.substring(input.length()-4).equals(".txt")){
            input.concat(".txt");
        }

        DateModuleComputer computer = new DateModuleComputer(beginning,end, dateFormatYY,dateFormatYYYY);
        computer.writeOut(input);
        return;
    }
}
