import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import modules.Module;
import modules.date.DateCLI;

public class Menu {
    private List<Module> moduleList;



    public Menu(){
        moduleList = new ArrayList<Module>();
        //load modules here:
        //DateModule dateModule = new DateModule("DateModule",moduleList.size()+1);
        moduleList.add( new DateCLI("DateModule",moduleList.size()+1));

        for(int i=0;i<moduleList.size();i++){
            Module current = moduleList.get(i);
            System.out.printf("%d. %s\n",current.getId(),current.getName());
        }

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        while(input != -1){
            moduleList.get(input-1).Run();
            return;
        }
    }
}
