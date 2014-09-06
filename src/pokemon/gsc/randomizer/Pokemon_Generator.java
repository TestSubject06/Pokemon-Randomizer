/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.gsc.randomizer;

import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author Zack
 */
public class Pokemon_Generator {
        public static void main(String[] args) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Throwable t) {
                //
            }
            JFrame frame = new JFrame(randomString());
            GeneratorPanel panel = new GeneratorPanel();
            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.pack();
            
        }
        
        private static String randomString(){
        int i = (int)(Math.random()*3);
        switch(i){
            case 0:
                return "Pokemon Randomizer";
            case 1:
                return "Pokemans Shuffle";
            case 2:
                return "Whirly Bird";
        }
        return "Hurrrrrr";
    }
}
