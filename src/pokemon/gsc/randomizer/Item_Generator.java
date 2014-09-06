/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.gsc.randomizer;

import java.util.Random;

/**
 *
 * @author Zack
 */
public class Item_Generator {
    int lastSafeItem = 0xF1;
    int[] invalidItems;
    int index;
    Random random;
    
    
    public Item_Generator(){
        invalidItems = new int[45];
        //Empty spaces
        invalidItems[0] = 0x06;
        invalidItems[1] = 0x19;
        invalidItems[2] = 0x2D;
        invalidItems[3] = 0x32;
        invalidItems[4] = 0x38;
        invalidItems[5] = 0x46;
        invalidItems[6] = 0x5A;
        invalidItems[7] = 0x64;
        invalidItems[8] = 0x73;
        invalidItems[9] = 0x74;
        invalidItems[10] = 0x78;
        invalidItems[11] = 0x81;
        invalidItems[12] = 0x87;
        invalidItems[13] = 0x88;
        invalidItems[14] = 0x89;
        invalidItems[15] = 0x8D;
        invalidItems[16] = 0x8E;
        invalidItems[17] = 0x91;
        invalidItems[18] = 0x93;
        invalidItems[19] = 0x94;
        invalidItems[20] = 0x95;
        invalidItems[21] = 0x99;
        invalidItems[22] = 0x9A;
        invalidItems[23] = 0x9B;
        invalidItems[24] = 0xA2;
        invalidItems[25] = 0xAB;
        invalidItems[26] = 0xB0;
        invalidItems[27] = 0xB3;
        invalidItems[28] = 0xBE;
        
        //Key Items that'd be broken as fuck to have
        invalidItems[29] = 0x07;
        invalidItems[30] = 0x36;
        invalidItems[31] = 0x3D;
        invalidItems[32] = 0x42;
        invalidItems[33] = 0x44;
        invalidItems[34] = 0x43;
        invalidItems[35] = 0x45;
        invalidItems[37] = 0x47;
        invalidItems[38] = 0x7F;
        invalidItems[39] = 0x80;
        invalidItems[40] = 0x82;
        invalidItems[41] = 0x85;
        invalidItems[42] = 0x86;
        invalidItems[43] = 0xAF;
        invalidItems[44] = 0xB2;
        random = new Random();
    }
    
    public int insertItem(){
        boolean goodNumber = false;
        int d = 0;
        while(!goodNumber){
            d = random.nextInt(lastSafeItem)+1;
            goodNumber = true;
            for(int i = 0; i < 45; i++){
                if(d == invalidItems[i] || d == 0){
                    goodNumber = false;
                    System.out.println("Threw out Item "+d);
                }
            }
        }
        return d;
    }
    
    public int insertItemAny(){
        boolean goodNumber = false;
        int d = 0;
        while(!goodNumber){
            d = random.nextInt(lastSafeItem)+1;
            goodNumber = true;
            for(int i = 0; i < 29; i++){
                if(d == invalidItems[i] || d == 0){
                    goodNumber = false;
                    System.out.println("Threw out Item "+d);
                }
            }
        }
        return d;
    }
}
