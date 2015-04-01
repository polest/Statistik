import java.text.DecimalFormat;
import java.util.*;

public class stats
{
    
    public static void stati(){
        // 1 - 0,1€ - 0,1€ - +0,2
        // 2 - 0,1€ - 0,2€ - +0,1
        // 3 - 0,2€ - 0,4€ - +0,2
        // 4 - 0,3€ - 0,7€ - +0,2
        // 5 - 0,4€ - 1,1€ - +0,1
        // 6 - 0,6€ - 1,7€ - +0,1
        // 7 - 0,9€ - 2,6€ - +0,1
        // 8 - 1,4€ - 4,0€ - +0,2
        // 9 - 2,1€ - 6,1€ - +0,2
        // 10 - 3,1€ - 9,2€ - +0,1
        // 11 - 4,7€ - 13,9€ - +0,2
        // 12 - 7,0€ - 20,9€ - +0,1
        // 13 - 10,5€ - 31,4€ - +0,1
        // 14 - 15,8€ - 47,2€ - +0,2
        
        double konto = 25;
        double minKonto = 999999999;
        double maxKonto = 0;
        
        
        int start = 8;
        
        int duz1 = 0;
        int duz2 = 0;
        int duz3 = 0;
        int trefferNull = 0;
        
        int[] arrayTrefferBei = new int[0];
        int[] arrayTrefferAnzahl = new int[0];
        
        for(int i = 1; i <= 100000; i++){
            int zahl;
            int curDuz;
            int trefferBei = 0;
            int index;
            
            zahl = randInt(0,36);
            
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
            
            if(trefferBei == (start + 1)){
                konto += 0.2;
            }
            
            if(trefferBei == (start + 2)){
                konto += 0.1;
            }
            
            if(trefferBei == (start + 3)){
                konto += 0.2;
            }
            
            if(trefferBei == (start + 4)){
                konto += 0.2;
            }
            
            if(trefferBei == (start + 5)){
                konto += 0.1;
            }
            
            if(trefferBei == (start + 6)){
                konto += 0.1;
            }
            
            if(trefferBei == (start + 7)){
                konto += 0.1;
            }
            
            if(trefferBei >= (start + 8)){
                konto += 0.2;
            }
            
            if(trefferBei == (start + 9)){
                konto += 0.2;
            }
            
            if(trefferBei == (start + 10)){
                konto += 0.1;
            }
            
            if(trefferBei == (start + 11)){
                konto += 0.2;
            }
            
            if(trefferBei == (start + 12)){
                konto += 0.1;
            }
            
            
            if(trefferBei > (start + 12)){
                konto -= 20.9;
            }
            
            
           if(konto > maxKonto){
               maxKonto = konto;
           }
           
           if(konto < minKonto){
               minKonto = konto;
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
        
        IO.println("\nKonto -> " + konto + "€");
        
        IO.println("\nmaxKonto -> " + maxKonto + "€");
        IO.println("minKonto -> " + minKonto + "€");
        
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
    
    
    public static int randInt(int min, int max) {
    
        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();
    
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;
    
        return randomNum;
    }

    
    
    
    public static void duzend(){
        
        int zero = 0;
        int duz1 = 0;
        int duz2 = 0;
        int duz3 = 0;
        double faktor = 3.4;
        int betDuz = 0;
        
        int konto = 25;
        int maxKonto = 0;
        int minKonto = 999999999;
        
        int schleifen = 0;
        
        for(int i = 1; i <= 5000; i++){
            
            int zahl;
            
            zahl = randInt(0,36); // 1,2,3
            
            if(betDuz != 0){
                
                IO.println("bet "+betDuz);
                IO.println("zahl "+zahl);
                
                konto = konto - 1;
                
                if(zahl >= 1 && zahl <=12){
                    if(betDuz == 1){
                        konto = konto + 3;
                    } 
                } else if(zahl >= 13 && zahl <= 24){
                    if(betDuz == 2){
                        konto = konto + 3;
                    } 
                } else if(zahl >= 25 && zahl <= 36){
                    if(betDuz == 3){
                        konto = konto + 3;
                    } 
                }
                
                betDuz = 0;
            }
            
   
            if(zahl == 0){
                zero++;
            } else if(zahl >= 1 && zahl <=12){
                duz1++;
            } else if(zahl >= 13 && zahl <= 24){
                duz2++;
            } else if(zahl >= 25 && zahl <= 36){
                duz3++;
            }
        
            int minInt = duz1;
            int curMinDuz = 1;
       
           if(duz2 < minInt){
               minInt = duz2;
               curMinDuz = 2;
               if(duz3 < minInt){
                   minInt = duz3;
                   curMinDuz = 3;
               }
           } else if(duz3 < minInt){
               minInt = duz3;
               curMinDuz = 3;
           }
            
            
            if(i >= 300){
                
                double erg = (double)i / (double)minInt;
                IO.println(erg);
                //IO.println(erg);
                if(erg >= faktor){
                    // bet auf min duzend
                    // min duz herausfinden
                    schleifen++;
                    betDuz = curMinDuz;
                }
                
            }
            
            if(konto > maxKonto){
               maxKonto = konto;
           }
           
           if(konto < minKonto){
               minKonto = konto;
           }
            
        }
        
        /*
        IO.println("0 = " + zero);
        IO.println("1 = " + duz1);
        IO.println("2 = " + duz2);
        IO.println("3 = " + duz3);
        IO.println("");
        */
       
       /*
       int minInt = duz1;
       
       if(duz2 < minInt){
           minInt = duz2;
           
           if(duz3 < minInt){
               minInt = duz3;
           }
       } else if(duz3 < minInt){
           minInt = duz3;
       }
       */
       
       
       IO.println("################");
       IO.println("GELD -> " + konto);
       IO.println("maxGELD -> " + maxKonto);
       IO.println("minGELD -> " + minKonto);
       //IO.println("schleifen -> " + schleifen);
       IO.println("################" + duz1);
       IO.println("");
       //IO.println("min = " + minInt);
       
       //return minInt;
       
    }
    
    public static void main(String[] args){
        //IO.println("Das ist Test \n");
        
       //int minMin = 999999999;
        
        //stati();
        
       
      
        duzend();
            
       
       
        
    }
}
