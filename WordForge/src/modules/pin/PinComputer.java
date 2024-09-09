package modules.pin;

import modules.Module;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.lang.*;

public class PinComputer{
    private final int lowerBound;
    private final int upperBound;
    private final int pinLenght;

    public PinComputer(int lower, int upper){
        lowerBound = lower;
        upperBound = upper;
        pinLenght = String.valueOf(upper).length(); //pincode length will always be the upperbounds length

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
            int currentPin = lowerBound;

            while(currentPin<=upperBound){
                writer.write(PinIntoString(currentPin));
                writer.newLine();
                currentPin++;
            }
        }catch(IOException e){e.printStackTrace();}
    }

    public String PinIntoString(int pin){
        String str = Integer.toString(pin);
        while(str.length() < pinLenght){
            str = "0" + str;
        }
        return str;
    }

}
