/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapanalyser;
import mapanalyser.Record;

/**
 *
 * @author saleor
 */
public class MAPAnalyser {
    private Record data[];
    private int nrecords;
    
    public MAPAnalyser(){
        // invoke loadFromTables
        this.loadFromTables();
        // after record creation sorting has to be done by id using sortByID
        this.sortByID();
    }
    
    public Record find(String id){        
        for(int i=0; i<this.data.length; i++){
            //System.out.println(this.data[i]);
            if(this.data[i].getId().equals(id)){
				//System.out.println(this.data[i]);
                return this.data[i];
            }
        }
        return  null;
    }
    
    public int lowest(){
        if(this.data.length == 0){
            return 0;
        } else{
            Record min_val = this.data[0];
            for(int i=1; i<this.data.length; i++){
                if(this.data[i].getMap()< min_val.getMap()){
                   min_val = this.data[i]; 
                }
            }
            return min_val.getMap();
        }
    }
    
    public int highest(){
        if(this.data.length == 0){
            return 0;
        } else{
            Record max_val = this.data[0];
            for(int i=1; i<this.data.length; i++){
                if(this.data[i].getMap() > max_val.getMap()){
                   max_val = this.data[i]; 
                }
            }
            return max_val.getMap();
        }
    }
    
    public int median(){
        if(this.data.length == 0){
            return 0;
        } if(this.data.length%2 == 0){
            return (int)(this.data[this.nrecords/2].getMap() + this.data[this.nrecords/2+1].getMap())/2;
        } else{
            return this.data[this.nrecords/2].getMap();
        }
    }
    
    public Record[] find(int map1, int map2){
        Record[] r = new Record[0];
        for(int i=0; i<this.data.length; i++){
            if(this.data[i].getMap() <= map2 & this.data[i].getMap() >= map1){
				System.out.println(this.data[i]);
                Record[] temp = new Record[r.length + 1];
                for(int j=0; j<r.length; j++){
                    temp[j] = r[j];
                }
                r = temp;
            }
        }
        return r;
    }
    
    private void sortByID(){
        // selection sort algorithm
        Record[] a = this.data;
        
        for (int i=0; i<a.length-1; i++) {
            for (int j=i+1; j<a.length; j++) {
               if (a[i].getId().compareTo(a[j].getId()) > 0) {
                  Record temp=a[j];
                  a[j]=a[i];
                  a[i]=temp;
               }
            }
        }
        this.data = a;
    }
    
    private void loadFromTables(){
        // iterates through 3 arrays and create Record object
        String[] id_list = {"s1", "s6", "s4", "s3", "s7"}; 
        int[] sbp_list = {60, 100, 90, 80, 70};
        int[] dbp_list = {65, 105, 95, 85, 75};
        
        // initialize class variables with length of arrays
        nrecords = id_list.length;
        data = new Record[nrecords];

        // iterate through id_list, sbp_list, dbp_list
        for(int i=0; i<id_list.length; i++){
            // calculate map value using formula given
            int map = (int) (1.0/3.0 * sbp_list[i] + 2.0 / 3.0 * dbp_list[i]);
            // get the category of the map value
            String category = this.classify(map);
            // create record object
            Record r = new Record(id_list[i], sbp_list[i], dbp_list[i], map, category);
            // store that into data array
            data[i] = r;
        }
        
    };
    
    private String classify(int map){
        // returns the category of the map value
        if(map<=70){
            return "low";
        } else if(map<=100){
            return "medium";
        } else{
            return "high";
        }
    }  
}
