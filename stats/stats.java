public class stats
{
    
    public static void stati(){
        int duz1 = 0;
        int duz2 = 0;
        int duz3 = 0;
        
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
        
        for(int a = 0; a < arrayTrefferAnzahl.length; a++){
            IO.println("Treffer bei -> " + arrayTrefferBei[a] + " - Anzahl -> " + arrayTrefferAnzahl[a]);
        }
        
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
