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
public class TM_Generator {
    int lastSafeTM = 0xFB;
    int[] movesPicked;
    int index;
    Random random;
    
    
    public TM_Generator(){
        movesPicked = new int[57];
        movesPicked[0] = 0xFA;
        movesPicked[1] = 0x7F;
        movesPicked[2] = 0x39;
        movesPicked[3] = 0x94;
        movesPicked[4] = 0x46;
        movesPicked[5] = 0x13;
        movesPicked[6] = 0x0F;
        random = new Random();
        index = 7;
    }
    
    public int insertTM(){
        boolean goodNumber = false;
        int d = 0;
        while(!goodNumber){
            d = random.nextInt(lastSafeTM)+1;
            goodNumber = true;
            for(int i = 0; i < 57; i++){
                if(d == movesPicked[i] || d == 0){
                    goodNumber = false;
                    System.out.println("Threw out HM or Repeat "+d);
                }
            }
        }
        movesPicked[index] = d;
        index++;
        return d;
    }
    
    public int giveMove(){
        return random.nextInt(lastSafeTM)+1;
    }
    public int giveNonHMMove(){
        boolean goodNumber = false;
        int d = 0;
        while(!goodNumber){
            d = random.nextInt(lastSafeTM)+1;
            goodNumber = true;
            for(int i = 0; i < 7; i++){
                if(d == movesPicked[i] || d == 0){
                    goodNumber = false;
                }
            }
        }
        return d;
    }
    public int giveRandomByte(){
        return random.nextInt(256);
    }
}
