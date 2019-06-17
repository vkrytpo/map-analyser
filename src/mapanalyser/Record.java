/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapanalyser;

/**
 *
 * @author saleor
 */
public class Record {
    private String id;
    private int sbp;
    private int dbp;
    private int map;
    private String category;
    
    public Record(String id, int sbp, int dbp, int map, String category){
        this.id = id;
        this.sbp = sbp;
        this.map = map;
        this.category = category;
    }
    // getters for all attributes

    public String getId() {
        return id;
    }

    public int getSbp() {
        return sbp;
    }

    public int getDbp() {
        return dbp;
    }

    public int getMap() {
        return map;
    }

    public String getCategory() {
        return category;
    }
    
    public String toString(){
        return "<"+id+","+sbp+","+dbp+","+map+","+category+">";
    }
    
}
