package modules.targeted;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TargetData {
    private List<String> informationList;
    private List<LocalDate> dateList;
    //Bool: all dates from a given date: with 2 ways of writing: 19740429, 740429
    //Bool:

    public TargetData(){
        informationList = new ArrayList<String>();
        dateList = new ArrayList<LocalDate>();
    }

    public List<LocalDate> getDateList(){
        return dateList;
    }

    public List<String> getInformationList(){
        return informationList;
    }

    public void addInformation(String newInformation){
        informationList.add(newInformation);
    }

    public void addInformation(LocalDate newDate){
        dateList.add(newDate);
    }
}
