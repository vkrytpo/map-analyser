/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapanalyser;
import mapanalyser.MAPAnalyser;
import mapanalyser.View;

/**
 *
 * @author saleor
 */
public class Assignment2 {

    
    public static void main(String[] args) {
        // TODO code application logic here
        MAPAnalyser a = new MAPAnalyser();
        View v = new View(a);
        v.commandLoop();
    }
    
}
