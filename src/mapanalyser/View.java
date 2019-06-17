/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapanalyser;
import mapanalyser.MAPAnalyser;
import mapanalyser.Record;
import java.util.Scanner;

/**
 *
 * @author saleor
 */
public class View {
    private MAPAnalyser a;
    public View(MAPAnalyser a){
        this.a = a;
    }
    public void commandLoop(){
        boolean continue_loop = true;
        Scanner reader = new Scanner(System.in);

        while(continue_loop){
            System.out.println("The following commands are recognized");
            System.out.println("Display this message                                  > 0");
            System.out.println("Display a specific subject record                     > 1 id");
            System.out.println("Display records for all subject recordswithin a range > 2 map1 map2");
            System.out.println("Display statistics (minimum, maximum and median)      > 3");
            System.out.println("Exit the application                                  > 9");
            
            int option = reader.nextInt();

            switch(option){
                case 0:
                        System.out.println("Display the same message again");
                        break;
                case 1: 
                        // find the record eith this id
                        String id = reader.next().replace("\n",  "");
                        System.out.println(id);
                        Record r = a.find(id);
                        if(r == null){
                            System.out.println("There is no such record with this id "+id);
                        } else{
                            System.out.println(r);
                        }
                        break;
                case 2: 
                        // subjects with in range map1 map2
                        int map1 = reader.nextInt();
                        int map2 = reader.nextInt();
                        Record[] found = a.find(map1, map2);
                        for(int i=0; i< found.length; i++){
                            //System.out.println(found[i]);
                        }
                        break;
                case 3: 
                        // display statistics
                        System.out.println("Lowest MAP : "+ a.lowest());
                        System.out.println("Highest MAP : "+ a.highest());
                        System.out.println("Median MAP : "+ a.median());
                        break;
                case 9: 
                        continue_loop = false;
                        System.out.println("Exiting the programme, Thanks..");
                        break;
            }

        }
        reader.close();
    }
}
