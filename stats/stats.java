import java.text.DecimalFormat;
import java.util.*;

public class stats
{
    
    public static void stati(){
        // 1 - 1€ - 1€
        // 2 - 1€ - 2€
        // 3 - 2€ - 4€
        // 4 - 3€ - 7€
        // 5 - 4€ - 11€
        // 6 - 6€ - 17€
        // 7 - 9€ - 26€
        
        int konto = 0;
        
        int duz1 = 0;
        int duz2 = 0;
        int duz3 = 0;
        int trefferNull = 0;
        
        int[] arrayTrefferBei = new int[0];
        int[] arrayTrefferAnzahl = new int[0];
        
        for(int i = 1; i <= 1000000; i++){
            int zahl;
            int curDuz;
            int trefferBei = 0;
            int index;
            
            zahl = myRandom(0,36);
            
            //IO.println("" + zahl);
            
            if(zahl == 0){
                
                trefferNull++;
                
                duz1 += 1;
                duz2 += 1;
                duz3 += 1;
            } else if(zahl >= 1 && zahl <= 12 ){
                
                trefferBei = duz1 + 1;
               
                duz1 = 0;
                duz2 += 1;
                duz3 += 1;
            } else if(zahl >= 13 && zahl <= 24){
                
                trefferBei = duz2 + 1;
                 
                duz1 += 1;
                duz2 = 0;
                duz3 += 1;
            } else if(zahl >= 25 && zahl <= 36){
                
                trefferBei = duz3 + 1;
                 
                duz1 += 1;
                duz2 += 1;
                duz3 = 0;
            }
            
            //IO.println("Treffer bei " + trefferBei);
            
            if(trefferExsist(trefferBei, arrayTrefferBei)){
               
                int ind = getIndex(trefferBei, arrayTrefferBei);    
            
                arrayTrefferAnzahl[ind]++;
                
            } else {
                if(trefferBei != 0){
                    int[] newArray = new int[arrayTrefferBei.length + 1];
                    int[] newArrayAnzahl = new int[arrayTrefferBei.length + 1];
                  
                    for(int x = 0; x < arrayTrefferBei.length; x++){
                        newArray[x] = arrayTrefferBei[x];
                        newArrayAnzahl[x] = arrayTrefferAnzahl[x];
                    }
                    
                    newArray[newArray.length - 1] = trefferBei; 
                    newArrayAnzahl[newArray.length - 1] = 1;
                    
                    arrayTrefferAnzahl = newArrayAnzahl;
                    arrayTrefferBei = newArray;
                }
            }
           
        }      
        
        DecimalFormat df = (DecimalFormat)DecimalFormat.getInstance(Locale.GERMAN);
        df.applyPattern( "#,###,##0" );
        
        
        for(int a = 0; a < arrayTrefferAnzahl.length; a++){
            IO.println("Treffer bei -> " + arrayTrefferBei[a] + " - Anzahl -> " + df.format(arrayTrefferAnzahl[a]));            
        }
        
        //IO.println("\n Null -> " + trefferNull);
        
    }
    
    public static boolean trefferExsist(int trefferBei, int[] array) {
        boolean existInArray = false;
        
        for(int i = 0; i < array.length; i++){
            if(array[i] == trefferBei){
                existInArray = true;
            }
        }
        
        return existInArray;
    }
    
    public static int getIndex(int trefferBei, int[] array) {
        int index = 0;
        
        for(int x = 0; x < array.length; x++){
            if(array[x] == trefferBei){
                index = x;
            }
        }
        
        return index;
    }
    
    public static int myRandom(int low, int high) {
        return (int) (Math.random() * (high - low) + low);
    }
    
    public static void main(String[] args){
        //IO.println("Das ist Test \n");
        
       
        
        stati();
    }
}
