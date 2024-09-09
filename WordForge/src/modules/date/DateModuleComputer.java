package modules.date;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.time.LocalDate;

//Writes out into Documents in both linux and windows
public class DateModuleComputer {
    private final LocalDate beginning;
    private final LocalDate end;
    private final Boolean dateFormatYY;
    private final Boolean dateFormatYYYY;


    public DateModuleComputer(LocalDate beginning, LocalDate end, Boolean dateFormatYY, Boolean dateFormatYYYY){
        this.beginning = beginning;
        this.end = end;
        this.dateFormatYY = dateFormatYY;
        this.dateFormatYYYY = dateFormatYYYY;
    }

    public void writeOut(String nameOfFile){

        String userHome = System.getProperty("user.home");
        Path documentsPath = Paths.get(userHome, "Documents");
        Path wordlistsPath = documentsPath.resolve("Wordlists");

        if(Files.notExists(wordlistsPath)){
            try {
                Files.createDirectories(wordlistsPath);
            } catch (IOException e) {
                System.err.println("Failed to create Wordlists folder: " + e.getMessage());
                return;
            }
        }

        Path filePath = wordlistsPath.resolve(nameOfFile);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile()))){
            LocalDate currentDate = beginning;

            while(!currentDate.isAfter(end)){
                if(dateFormatYYYY){writer.write(DateIntoString(currentDate));writer.newLine();}
                if(dateFormatYY){writer.write(DeprecatedDateIntoString(currentDate));writer.newLine();}
                currentDate = currentDate.plusDays(1);
            }
        }catch(IOException e){e.printStackTrace();}
    }

    public String DateIntoString(LocalDate date){
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();

        String formattedDate = String.format("%d%02d%02d", year, month, day);

        return formattedDate;
    }

    public String DeprecatedDateIntoString(LocalDate date){
        String str = DateIntoString(date);
        str = str.substring(2); //remove the first 2 characters
        return str;
    }
}