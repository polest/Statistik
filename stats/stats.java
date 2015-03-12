import java.text.DecimalFormat;
import java.util.*;

public class stats
{
    
    public static void stati(){
        // 1 - 1€ - 1€ - +2
        // 2 - 1€ - 2€ - +1
        // 3 - 2€ - 4€ - +2
        // 4 - 3€ - 7€ - +2
        // 5 - 4€ - 11€ - +1
        // 6 - 6€ - 17€ - +1
        // 7 - 9€ - 26€ - +1
        
        int konto = 25;
        int minKonto = 0;
        int maxKonto = 0;
        
        
        int start = 0;
        
        int duz1 = 0;
        int duz2 = 0;
        int duz3 = 0;
        int trefferNull = 0;
        
        int[] arrayTrefferBei = new int[0];
        int[] arrayTrefferAnzahl = new int[0];
        
        for(int i = 1; i <= 1000000; i++){
            int zahl;
            int curDuz;
            int trefferBei = 10;
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
               
                if(duz2 >= 8){
                    duz2 = 0;
                    konto -= 26;
                }
                
                if(duz3 >= 8){
                    duz3 = 0;
                    konto -= 26;
                }
                
                duz1 = 0;
                duz2 += 1;
                duz3 += 1;
            } else if(zahl >= 13 && zahl <= 24){
                
                trefferBei = duz2 + 1;
                 
                if(duz1 >= 8){
                    duz1 = 0;
                    konto -= 26;
                }
                
                if(duz3 >= 8){
                    duz3 = 0;
                    konto -= 26;
                }
                
                duz1 += 1;
                duz2 = 0;
                duz3 += 1;
            } else if(zahl >= 25 && zahl <= 36){
                
                trefferBei = duz3 + 1;
                 
                if(duz1 >= 8){
                    duz1 = 0;
                    konto -= 26;
                }
                
                if(duz2 >= 8){
                    duz2 = 0;
                    konto -= 26;
                }
                
                duz1 += 1;
                duz2 += 1;
                duz3 = 0;
            }
            
            if(trefferBei == (start + 1)){
                konto += 2;
            }
            
            if(trefferBei == (start + 2)){
                konto += 1;
            }
            
            if(trefferBei == (start + 3)){
                konto += 2;
            }
            
            if(trefferBei == (start + 4)){
                konto += 2;
            }
            
            if(trefferBei == (start + 5)){
                konto += 1;
            }
            
            if(trefferBei == (start + 6)){
                konto += 1;
            }
            
            if(trefferBei == (start + 7)){
                konto += 1;
            }
            
            if(trefferBei >= (start + 8)){
                konto -= 26;
            }
            
            /*
            
            if(trefferBei == (start + 8)){
                konto -= 24;
            }
            
            if(trefferBei == (start + 9)){
                konto -= 25;
            }
            
            if(trefferBei == (start + 10)){
                konto -= 24;
            }
            
            if(trefferBei == (start + 11)){
                konto -= 24;
            }
            
            if(trefferBei == (start + 12)){
                konto -= 25;
            }
            
            if(trefferBei == (start + 13)){
                konto -= 25;
            }
            
            if(trefferBei == (start + 14)){
                konto -= 25;
            }
            
            */
           /* 
           
            if(trefferBei == (start + 21)){
                konto -= 50;
            }
            
            if(trefferBei == (start + 22)){
                konto -= 51;
            }
            
            if(trefferBei == (start + 23)){
                konto -= 50;
            }
            
            if(trefferBei == (start + 24)){
                konto -= 50;
            }
            
            if(trefferBei == (start + 25)){
                konto -= 51;
            }
            
            if(trefferBei == (start + 26)){
                konto -= 51;
            }
            
            if(trefferBei == (start + 27)){
                konto -= 51;
            }
            
            if(trefferBei == (start + 28)){
                konto -= 51;
            }
            
            if(trefferBei == (start + 29)){
                konto -= 51;
            }
            
            if(trefferBei == (start + 30)){
                konto -= 51;
            }
            
            */
            
            /*
            
            if(trefferBei == (start + 22)){
                konto -= 76;
            }
            
            if(trefferBei == (start + 23)){
                konto -= 77;
            }
            
            if(trefferBei == (start + 24)){
                konto -= 76;
            }
            
            if(trefferBei == (start + 25)){
                konto -= 76;
            }
            
            if(trefferBei == (start + 26)){
                konto -= 77;
            }
            
            if(trefferBei == (start + 27)){
                konto -= 77;
            }
            
            if(trefferBei == (start + 28)){
                konto -= 77;
            }
            
            */
            
            
            /*
            
            if(trefferBei == (start + 29)){
                konto -= 49;
            }
            
            if(trefferBei == (start + 30)){
                konto -= 50;
            }
            
            if(trefferBei == (start + 31)){
                konto -= 49;
            }
            
            if(trefferBei == (start + 32)){
                konto -= 49;
            }
            
            if(trefferBei == (start + 33)){
                konto -= 50;
            }
            
            if(trefferBei == (start + 34)){
                konto -= 50;
            }
            
            if(trefferBei == (start + 35)){
                konto -= 50;
            }
            
            */
            
            
            /*
            
            
            
            
            */
            
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
        
        for(int i = 1; i <= 300; i++){
            int zahl;
            
            zahl = randInt(0,36); // 1,2,3
            
   
            if(zahl == 0){
                zero++;
            } else if(zahl >= 1 && zahl <=12){
                duz1++;
            } else if(zahl >= 13 && zahl <= 24){
                duz2++;
            } else if(zahl >= 25 && zahl <= 36){
                duz3++;
            }
        
        }
        
        /*
        IO.println("0 = " + zero);
        IO.println("1 = " + duz1);
        IO.println("2 = " + duz2);
        IO.println("3 = " + duz3);
        IO.println("");
        */
       
       int minInt = duz1;
       
       if(duz2 < minInt){
           minInt = duz2;
           
           if(duz3 < minInt){
               minInt = duz3;
           }
       } else if(duz3 < minInt){
           minInt = duz3;
       }
       
       
       IO.println("min = " + minInt);
       
       
    }
    
    public static void main(String[] args){
        //IO.println("Das ist Test \n");
        
       
        
        //stati();
        for(int i = 0; i < 20; i++){
            duzend();
        }
    }
}
