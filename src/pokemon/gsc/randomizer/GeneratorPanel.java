/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.gsc.randomizer;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Zack
 */


public class GeneratorPanel extends JPanel implements ItemListener, ActionListener{
    
    public int gameVersion;
    public int[] starters;
    public byte[] fileArray;
    public byte[] fileArray2;
    public int offset;
    public ByteArrayOutputStream oStream;
    public TM_Generator TMGen;
    public Poke_Generator PokeGen;
    public Name_Generator NameGen;
    public Item_Generator ItemGen;
    public File save;
    
    //UI Stuff.
    JPanel area1, area2, area3, area4, area5, TMPanel, GamePanel, PokePanel, TrainerPanel, StarterPanel;
    TitledBorder TMBorder, GameBorder, PokeBorder, TrainerBorder, StarterBorder;
    JCheckBox TMCont, TMCompat, GamePokeGift, GameEventPoke, GameWildPoke, PokeStats, PokeTypes, PokeMovesets,
            PokeLevels, PokeLevelsWild, PokeLevelsTrainer, PokeLevelsGifts, PokeTrade, TrainerRival, TrainerNames, TrainerPoke,
            StarterStarters, StarterItems, StarterItemsKeys;
    boolean BTMCont, BTMCompat, BGamePokeGift, BGameEventPoke, BGameWildPoke, BPokeStats, BPokeTypes, BPokeMovesets,
            BPokeLevels, BPokeLevelsWild, BPokeLevelsTrainer, BPokeLevelsGifts, BPokeTrade, BTrainerRival, BTrainerNames, BTrainerPoke,
            BStarterStarters, BStarterItems, BStarterItemsKeys;
    JButton openROM, saveROM, close;
    JFrame confirm;
    JLabel confirmText;
    
    public GeneratorPanel(){
        //setPreferredSize(new Dimension(600, 400));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        //Invisible confirmation window.
        confirm = new JFrame("Rom randomization complete.");
        confirm.setLayout(new BoxLayout(confirm.getContentPane(), BoxLayout.Y_AXIS));
        confirmText = new JLabel("<html><center>Randomization Complete.<br>The rom is at: <br>");
        confirmText.setBorder(new EmptyBorder(5, 5, 5, 5));
        confirm.add(confirmText);
        close = new JButton("Close");
        close.addActionListener(this);
        confirm.add(close);
        confirm.pack();
        confirm.setVisible(false);
        confirm.setAlwaysOnTop(true);
        close.setToolTipText("See this button? See how it's not centered? Fuck this button. >:C");
        confirm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        //UI STUFF BEGINS
        area1 = new JPanel();
        area1.setLayout(new BoxLayout(area1, BoxLayout.Y_AXIS));
        area1.setAlignmentY(TOP_ALIGNMENT);
        area2 = new JPanel();
        area2.setLayout(new BoxLayout(area2, BoxLayout.Y_AXIS));
        area2.setAlignmentY(TOP_ALIGNMENT);
        area3 = new JPanel();
        area3.setLayout(new BoxLayout(area3, BoxLayout.Y_AXIS));
        area3.setAlignmentY(TOP_ALIGNMENT);
        area4 = new JPanel();
        area4.setLayout(new BoxLayout(area4, BoxLayout.X_AXIS));
        area4.setAlignmentY(TOP_ALIGNMENT);
        area5 = new JPanel();
        area5.setLayout(new BoxLayout(area5, BoxLayout.X_AXIS));
        area5.setAlignmentY(TOP_ALIGNMENT);
        
        TMPanel = new JPanel();
        TMBorder = new TitledBorder("TM Options");
        //TMBorder.setTitleFont(TMBorder.getTitleFont().deriveFont(Font.BOLD));
        TMPanel.setBorder(TMBorder);
        TMPanel.setLayout(new BoxLayout(TMPanel, BoxLayout.Y_AXIS));
        
        GamePanel = new JPanel();
        GameBorder = new TitledBorder("Game Options");
        //GameBorder.setTitleFont(GameBorder.getTitleFont().deriveFont(Font.BOLD));
        GamePanel.setBorder(GameBorder);
        GamePanel.setLayout(new BoxLayout(GamePanel, BoxLayout.Y_AXIS));
        
        PokePanel = new JPanel();
        PokeBorder = new TitledBorder("Pokemon Options");
        //PokeBorder.setTitleFont(PokeBorder.getTitleFont().deriveFont(Font.BOLD));
        PokePanel.setBorder(PokeBorder);
        PokePanel.setLayout(new BoxLayout(PokePanel, BoxLayout.Y_AXIS));
        
        TrainerPanel = new JPanel();
        TrainerBorder = new TitledBorder("Trainer Options");
        //TrainerBorder.setTitleFont(TrainerBorder.getTitleFont().deriveFont(Font.BOLD));
        TrainerPanel.setBorder(TrainerBorder);
        TrainerPanel.setLayout(new BoxLayout(TrainerPanel, BoxLayout.Y_AXIS));
        
        StarterPanel = new JPanel();
        StarterBorder = new TitledBorder("Starter Options");
        //StarterBorder.setTitleFont(StarterBorder.getTitleFont().deriveFont(Font.BOLD));
        StarterPanel.setBorder(StarterBorder);
        StarterPanel.setLayout(new BoxLayout(StarterPanel, BoxLayout.Y_AXIS));
        
        openROM = new JButton("Open ROM");
        openROM.setToolTipText("Loads up a ROM.");
        openROM.addActionListener(this);
        saveROM = new JButton("Save ROM");
        saveROM.setToolTipText("Saves a new ROM with the selected settings");
        saveROM.addActionListener(this);
        
        add(area4);
        add(area5);
        area5.add(openROM);
        area5.add(saveROM);
        
        area4.add(area1);
        area4.add(area2);
        area4.add(area3);
        
        area1.add(TMPanel);
        area1.add(GamePanel);
        
        area2.add(PokePanel);
        area3.add(TrainerPanel);
        area3.add(StarterPanel);
        
        
        TMCont = new JCheckBox("TM contents");
        TMCont.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        TMCont.setToolTipText("Randomizes the contents of TMs. Dialoge regarding the TMs are not updated");
        TMCont.addItemListener(this);
        TMCompat = new JCheckBox("TM/HM compatability");
        TMCompat.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        TMCompat.setToolTipText("Randomizes which pokemon can learn what TMs and HMs");
        TMCompat.addItemListener(this);
        
        GamePokeGift = new JCheckBox("Gifted Pokemon");
        GamePokeGift.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        GamePokeGift.setToolTipText("The free pokemon you recieve throughout the game, like the spearow, and the shuckle");
        GamePokeGift.addItemListener(this);
        GameEventPoke = new JCheckBox("Event Pokemon");
        GameEventPoke.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        GameEventPoke.setToolTipText("The pokemon you encounter from events. Like the Red Gyarados, and the Electrodes in Mahogany");
        GameEventPoke.addItemListener(this);
        GameWildPoke = new JCheckBox("Wild Pokemon");
        GameWildPoke.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        GameWildPoke.setToolTipText("This BETTER BE ON, OR I WILL HURT YOU >:C");
        GameWildPoke.addItemListener(this);
        
        PokeStats = new JCheckBox("Stats");
        PokeStats.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        PokeStats.setToolTipText("Not currently supported.");
        PokeStats.addItemListener(this);
        PokeTypes = new JCheckBox("Types");
        PokeTypes.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        PokeTypes.setToolTipText("Not currently supported.");
        PokeTypes.addItemListener(this);
        PokeMovesets = new JCheckBox("Movesets");
        PokeMovesets.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        PokeMovesets.setToolTipText("The moves pokemon learn at their level benchmarks. Cannot be HMs, because that's broken");
        PokeMovesets.addItemListener(this);
        PokeLevels = new JCheckBox("Levels");
        PokeLevels.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        PokeLevels.setToolTipText("Enables the check boxes below. Be aware that these pretty much make the game unplayable");
        PokeLevels.addItemListener(this);
        PokeLevelsWild = new JCheckBox("Wild");
        PokeLevelsWild.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        PokeLevelsWild.setBorder(new EmptyBorder(0, 20, 0, 0));
        PokeLevelsWild.setToolTipText("Randomize the levels of wild and event pokemon");
        PokeLevelsWild.addItemListener(this);
        PokeLevelsTrainer = new JCheckBox("Trainer");
        PokeLevelsTrainer.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        PokeLevelsTrainer.setBorder(new EmptyBorder(0, 20, 0, 0));
        PokeLevelsTrainer.setToolTipText("Randomize the levels of trainer's pokemon");
        PokeLevelsTrainer.addItemListener(this);
        PokeLevelsGifts = new JCheckBox("Gifts");
        PokeLevelsGifts.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        PokeLevelsGifts.setBorder(new EmptyBorder(0, 20, 0, 0));
        PokeLevelsGifts.setToolTipText("Randomize the levels of pokemon gifts to the player");
        PokeLevelsGifts.addItemListener(this);
        PokeTrade = new JCheckBox("Trades evolve at 40");
        PokeTrade.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        PokeTrade.setToolTipText("Instead of having to trade for certain pokemon, they evolve at level 40. Kadabra -> Alakazam for example");
        PokeTrade.addItemListener(this);
        
        TrainerPoke = new JCheckBox("Pokemon");
        TrainerPoke.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        TrainerPoke.setToolTipText("Randomizes the pokemon trainers have. If their fight had their moves hardcoded in, those will be randomized too");
        TrainerPoke.addItemListener(this);
        TrainerNames = new JCheckBox("Names");
        TrainerNames.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        TrainerNames.setToolTipText("Replaces trainers' names from the name pool. You'll probably see a lot of repeats");
        TrainerNames.addItemListener(this);
        TrainerRival = new JCheckBox("Rival keeps starter");
        TrainerRival.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        TrainerRival.setToolTipText("The rival keeps the starter he selects at the beginning of the game");
        TrainerRival.addItemListener(this);
        
        StarterStarters = new JCheckBox("Random starters");
        StarterStarters.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        StarterStarters.setToolTipText("Turn this on and leave it on");
        StarterStarters.addItemListener(this);
        StarterItems = new JCheckBox("Random Items");
        StarterItems.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        StarterItems.setToolTipText("Instead of a Berry, the starter (AND SHUCKIE), will be holding a random item. Shuckie and the starter do not necessarily have the same item.");
        StarterItems.addItemListener(this);
        StarterItemsKeys = new JCheckBox("Ban Key Items");
        StarterItemsKeys.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        StarterItemsKeys.setBorder(new EmptyBorder(0, 20, 0, 0));
        StarterItemsKeys.setToolTipText("Removes Key Items from the pool of possible items. Like the SQUIRTBOTTLE and SUPER ROD");
        StarterItemsKeys.addItemListener(this);
        
        
        TMCont.setEnabled(false);
        TMCompat.setEnabled(false);
        GamePokeGift.setEnabled(false);
        GameEventPoke.setEnabled(false);
        GameWildPoke.setEnabled(false);
        PokeStats.setEnabled(false);
        PokeTypes.setEnabled(false);
        PokeMovesets.setEnabled(false);
        PokeLevels.setEnabled(false);
        PokeLevelsWild.setEnabled(false);
        PokeLevelsTrainer.setEnabled(false);
        PokeLevelsGifts.setEnabled(false);
        PokeTrade.setEnabled(false);
        TrainerPoke.setEnabled(false);
        TrainerNames.setEnabled(false);
        TrainerRival.setEnabled(false);
        StarterStarters.setEnabled(false);
        StarterItems.setEnabled(false);
        StarterItemsKeys.setEnabled(false);
        
        TMPanel.add(TMCont);
        TMPanel.add(TMCompat);
        
        GamePanel.add(GamePokeGift);
        GamePanel.add(GameEventPoke);
        GamePanel.add(GameWildPoke);
        
        PokePanel.add(PokeStats);
        PokePanel.add(PokeTypes);
        PokePanel.add(PokeMovesets);
        PokePanel.add(PokeLevels);
        PokePanel.add(PokeLevelsWild);
        PokePanel.add(PokeLevelsTrainer);
        PokePanel.add(PokeLevelsGifts);
        PokePanel.add(PokeTrade);
        
        TrainerPanel.add(TrainerRival);
        TrainerPanel.add(TrainerPoke);
        TrainerPanel.add(TrainerNames);
        
        StarterPanel.add(StarterStarters);
        StarterPanel.add(StarterItems);
        StarterPanel.add(StarterItemsKeys);
        
        
        starters = new int[3];
        TMGen = new TM_Generator();
        PokeGen = new Poke_Generator();
        NameGen = new Name_Generator();
        ItemGen = new Item_Generator();
        offset = 0x0;
        
        //Done with the initialization.
    }
    public void openROM(){
        JFileChooser choose = new JFileChooser();
        int returnVal = choose.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            try{
                File file = choose.getSelectedFile();
                fileArray = read(file);
                fileArray2 = new byte[fileArray.length];
                oStream = new ByteArrayOutputStream();
                
                System.out.println(fileArray.length);
                
                if(fileArray[9] == 0x27){
                    gameVersion = 0;
                }else if(fileArray[9] == 0x63){
                    gameVersion = 1;
                }
                TMCont.setSelected(true);
                TMCompat.setSelected(true);
                GamePokeGift.setSelected(true);
                GameEventPoke.setSelected(true);
                GameWildPoke.setSelected(true);
                PokeStats.setSelected(false);
                PokeTypes.setSelected(false);
                PokeMovesets.setSelected(true);
                PokeLevels.setSelected(false);
                PokeLevelsWild.setSelected(false);
                PokeLevelsTrainer.setSelected(false);
                PokeLevelsGifts.setSelected(false);
                PokeTrade.setSelected(true);
                TrainerPoke.setSelected(true);
                TrainerNames.setSelected(true);
                TrainerRival.setSelected(true);
                StarterStarters.setSelected(true);
                StarterItems.setSelected(true);
                StarterItemsKeys.setSelected(true);
                
                TMCont.setEnabled(true);
                TMCompat.setEnabled(true);
                GamePokeGift.setEnabled(true);
                GameEventPoke.setEnabled(true);
                GameWildPoke.setEnabled(true);
                PokeStats.setEnabled(false);
                PokeTypes.setEnabled(false);
                PokeMovesets.setEnabled(true);
                PokeLevels.setEnabled(true);
                PokeLevelsWild.setEnabled(false);
                PokeLevelsTrainer.setEnabled(false);
                PokeLevelsGifts.setEnabled(false);
                PokeTrade.setEnabled(true);
                TrainerPoke.setEnabled(true);
                TrainerNames.setEnabled(true);
                TrainerRival.setEnabled(true);
                StarterStarters.setEnabled(true);
                StarterItems.setEnabled(true);
                StarterItemsKeys.setEnabled(true);

                BTMCont = true;
                BTMCompat = true;
                BGamePokeGift = true;
                BGameEventPoke = true;
                BGameWildPoke = true;
                BPokeStats = false;
                BPokeTypes = false;
                BPokeMovesets = true;
                BPokeLevels = false;
                BPokeLevelsWild = false;
                BPokeLevelsTrainer = false;
                BPokeLevelsGifts = false;
                BPokeTrade = true;
                BTrainerPoke = true;
                BTrainerNames = true;
                BTrainerRival = true;
                BStarterStarters = true;
                BStarterItems = true;
                BStarterItemsKeys = true;
            }catch(Throwable t){
                System.out.println("Nope.");
            }
        }
    }
    public void randomizeROM(){
        if(gameVersion == 0){
            randomizeForGold();
            confirmText.setText(confirmText.getText() + save.getAbsolutePath() + "</center></html>");
            confirm.setVisible(true);
            confirm.pack();
            System.out.println("Randomized.");
            //System.exit(0);
        }
        if(gameVersion == 1){
            randomizeForCrystal();
            System.out.println("Randomized.");
            confirmText.setText(confirmText.getText() + save.getAbsolutePath() + "</center></html>");
            confirm.setVisible(true);
            confirm.pack();
            //System.exit(0);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == openROM){
            openROM();
        }
        if(e.getSource() == saveROM){
            randomizeROM();
        }
        if(e.getSource() == close){
            System.exit(0);
        }
    }
    
    @Override
    public void itemStateChanged(ItemEvent e){
        if(e.getItemSelectable() == TMCont){
            if(e.getStateChange() == ItemEvent.DESELECTED){
                BTMCont = false;
            }else{
                BTMCont = true;
            }
        }
        if(e.getItemSelectable() == TMCompat){
            if(e.getStateChange() == ItemEvent.DESELECTED){
                BTMCompat = false;
            }else{
                BTMCompat = true;
            }
        }
        if(e.getItemSelectable() == GameEventPoke){
            if(e.getStateChange() == ItemEvent.DESELECTED){
                BGameEventPoke = false;
            }else{
                BGameEventPoke = true;
            }
        }
        if(e.getItemSelectable() == GamePokeGift){
            if(e.getStateChange() == ItemEvent.DESELECTED){
                BGamePokeGift = false;
            }else{
                BGamePokeGift = true;
            }
        }
        if(e.getItemSelectable() == GameWildPoke){
            if(e.getStateChange() == ItemEvent.DESELECTED){
                BGameWildPoke = false;
            }else{
                BGameWildPoke = true;
            }
        }
        if(e.getItemSelectable() == PokeStats){
            if(e.getStateChange() == ItemEvent.DESELECTED){
                BPokeStats = false;
            }else{
                BPokeStats = true;
            }
        }
        if(e.getItemSelectable() == PokeTypes){
            if(e.getStateChange() == ItemEvent.DESELECTED){
                BPokeTypes = false;
            }else{
                BPokeTypes = true;
            }
        }
        if(e.getItemSelectable() == PokeLevelsWild){
            if(e.getStateChange() == ItemEvent.DESELECTED){
                BPokeLevelsWild = false;
            }else{
                BPokeLevelsWild = true;
            }
        }
        if(e.getItemSelectable() == PokeLevelsTrainer){
            if(e.getStateChange() == ItemEvent.DESELECTED){
                BPokeLevelsTrainer = false;
            }else{
                BPokeLevelsTrainer = true;
            }
        }
        if(e.getItemSelectable() == PokeLevelsGifts){
            if(e.getStateChange() == ItemEvent.DESELECTED){
                BPokeLevelsGifts = false;
            }else{
                BPokeLevelsGifts = true;
            }
        }
        if(e.getItemSelectable() == PokeTrade){
            if(e.getStateChange() == ItemEvent.DESELECTED){
                BPokeTrade = false;
            }else{
                BPokeTrade = true;
            }
        }
        if(e.getItemSelectable() == TrainerRival){
            if(e.getStateChange() == ItemEvent.DESELECTED){
                BTrainerRival = false;
            }else{
                BTrainerRival = true;
            }
        }
        if(e.getItemSelectable() == TrainerNames){
            if(e.getStateChange() == ItemEvent.DESELECTED){
                BTrainerNames = false;
            }else{
                BTrainerNames = true;
            }
        }
        if(e.getItemSelectable() == TrainerPoke){
            if(e.getStateChange() == ItemEvent.DESELECTED){
                BTrainerPoke = false;
            }else{
                BTrainerPoke = true;
            }
        }
        if(e.getItemSelectable() == StarterStarters){
            if(e.getStateChange() == ItemEvent.DESELECTED){
                BStarterStarters = false;
            }else{
                BStarterStarters = true;
            }
        }
        if(e.getItemSelectable() == StarterItemsKeys){
            if(e.getStateChange() == ItemEvent.DESELECTED){
                BStarterItemsKeys = false;
            }else{
                BStarterItemsKeys = true;
            }
        }
        if(e.getItemSelectable() == PokeMovesets){
            if(e.getStateChange() == ItemEvent.DESELECTED){
                BPokeMovesets = false;
            }else{
                BPokeMovesets = true;
            }
        }
        if(e.getItemSelectable() == StarterItems){
            if(e.getStateChange() == ItemEvent.DESELECTED){
                StarterItemsKeys.setEnabled(false);
                StarterItemsKeys.setSelected(false);
                BStarterItemsKeys = false;
            }else{
                StarterItemsKeys.setEnabled(true);
                BStarterItems = true;
            }
        }
        if(e.getItemSelectable() == PokeLevels){
            if(e.getStateChange() == ItemEvent.DESELECTED){
                PokeLevelsWild.setEnabled(false);
                PokeLevelsWild.setSelected(false);
                BPokeLevelsWild = false;
                PokeLevelsTrainer.setEnabled(false);
                PokeLevelsTrainer.setSelected(false);
                BPokeLevelsTrainer = false;
                PokeLevelsGifts.setEnabled(false);
                PokeLevelsGifts.setSelected(false);
                BPokeLevelsGifts = false;
            }else{
                PokeLevelsWild.setEnabled(true);
                PokeLevelsTrainer.setEnabled(true);
                PokeLevelsGifts.setEnabled(true);
                BPokeLevels = true;
            }
        }
    }
    
    public byte[] read(File file) throws IOException {
        
        ByteArrayOutputStream ous = new ByteArrayOutputStream();
        InputStream ios = new FileInputStream(file);
                
        try {
            byte []buffer = new byte[4096];
            ous = new ByteArrayOutputStream();
            ios = new FileInputStream(file);
            int read = 0;
            while ( (read = ios.read(buffer)) != -1 ) {
                ous.write(buffer, 0, read);
            }
        }finally{ 
            try{
                 if(ous != null){
                     ous.close();
                 }
            }catch(IOException e) {
            }

            try {
                 if (ios != null) {
                      ios.close();
                 }
            } catch (IOException e) {
            }
        }
        return ous.toByteArray();
    }

    private void randomizeForGold() {
        //Select the starters, but let's not have two of the same starter.
        boolean weGood = false;
        while(!weGood){
            weGood = true;
            starters[0] = PokeGen.insertPoke();
            starters[1] = PokeGen.insertPoke();
            starters[2] = PokeGen.insertPoke();
            
            if(starters[0] == starters[1] || starters[0] == starters[2] || starters[2] == starters[1]){ 
                weGood = false;
            } 
        }
        //Steps
        //Logical order of addresses
        //Intro poke
        oStream.write(fileArray, offset, 0x5FDE - offset);
        offset += 0x5FDE - offset;
        oStream.write(PokeGen.insertPoke());
        offset++;
        
        //Shuckie the shuckle
        if(BGamePokeGift){
            oStream.write(fileArray, offset, 0x73E6 - offset);
            offset += 0x73E6 - offset;
            oStream.write(PokeGen.insertPoke());
            offset++;
            if(BPokeLevelsGifts){
                oStream.write(fileArray, offset, 4);
                offset += 4;
                oStream.write((byte)Math.ceil(Math.random()*100));
                offset++;
            }
            oStream.write(fileArray, offset, 0x7406 - offset);
            offset += 0x7406 - offset;
            if(BStarterItems){
                if(BStarterItemsKeys){
                    oStream.write(ItemGen.insertItem());
                }else{
                    oStream.write(ItemGen.insertItemAny());
                }
            }else{
                oStream.write(fileArray, offset, 1);
            }
            offset++;
        }
        
        //1. TMs
        if(BTMCont){
            oStream.write(fileArray, offset, 0x11A66 - offset);
            offset += 0x11A66 - offset;
            for(int i = 0; i < 50; i++){
                oStream.write(TMGen.insertTM());
                offset++;
            }
        }
        //2. Wild Encounters
        //Land Pokemon follow: 5 byte header: xx yy zz zz zz followed by [Level] [Species], for 42 bytes. 21 species per area.
        oStream.write(fileArray, offset, 0x2AB35 - offset);
        offset += 0x2AB35 - offset;
        System.out.println("Starting Wild at " + offset);
        System.out.println("Byte at " + offset + " is " + fileArray[offset]);
        for(int i=0; i < 61; i++){
            //Header
            oStream.write(fileArray, offset, 5);
            offset += 5;
            //Pokemon
            for(int k = 0; k < 21; k++){
                if(BPokeLevelsWild){
                    oStream.write((byte)Math.ceil(Math.random()*100));
                    offset++;
                }else{
                    oStream.write(fileArray, offset, 1);
                    offset += 1;
                }
                if(BGameWildPoke){
                    oStream.write(PokeGen.insertPoke());
                    offset += 1;
                }else{
                    oStream.write(fileArray, offset, 1);
                    offset += 1;
                }
            }
        }
        oStream.write((byte)0xFF);
        offset += 1;
        //Water pokemon follow: 3 byte header: xx yy zz zz zz followed by [Level] [Species], for 6 bytes. 3 species per area.
        for(int i=0; i < 38; i++){
            //Header
            oStream.write(fileArray, offset, 3);
            offset += 3;
            //Pokemon
            for(int k = 0; k < 3; k++){
                if(BPokeLevelsWild){
                    oStream.write((byte)Math.ceil(Math.random()*100));
                    offset++;
                }else{
                    oStream.write(fileArray, offset, 1);
                    offset += 1;
                }
                if(BGameWildPoke){
                    oStream.write(PokeGen.insertPoke());
                    offset += 1;
                }else{
                    oStream.write(fileArray, offset, 1);
                    offset += 1;
                }
            }
        }
        oStream.write((byte)0xFF);
        offset += 1;
        //Land Pokemon follow: 5 byte header: xx yy zz zz zz followed by [Level] [Species], for 42 bytes. 21 species per area. (KANTO)
        for(int i=0; i < 30; i++){
            //Header
            oStream.write(fileArray, offset, 5);
            offset += 5;
            //Pokemon
            for(int k = 0; k < 21; k++){
                if(BPokeLevelsWild){
                    oStream.write((byte)Math.ceil(Math.random()*100));
                    offset++;
                }else{
                    oStream.write(fileArray, offset, 1);
                    offset += 1;
                }
                if(BGameWildPoke){
                    oStream.write(PokeGen.insertPoke());
                    offset += 1;
                }else{
                    oStream.write(fileArray, offset, 1);
                    offset += 1;
                }
            }
        }
        oStream.write((byte)0xFF);
        offset += 1;
        //Water pokemon follow: 5 byte header: xx yy zz zz zz followed by [Level] [Species], for 4 bytes. 2 species per area. (KANTO)
        for(int i=0; i < 24; i++){
            //Header
            oStream.write(fileArray, offset, 3);
            offset += 3;
            //Pokemon
            for(int k = 0; k < 3; k++){
                if(BPokeLevelsWild){
                    oStream.write((byte)Math.ceil(Math.random()*100));
                    offset++;
                }else{
                    oStream.write(fileArray, offset, 1);
                    offset += 1;
                }
                if(BGameWildPoke){
                    oStream.write(PokeGen.insertPoke());
                    offset += 1;
                }else{
                    oStream.write(fileArray, offset, 1);
                    offset += 1;
                }
            }
        }
        oStream.write((byte)0xFF);
        offset += 1;
        
        //????? More land pokemon apparently
        for(int i=0; i < 4; i++){
            //Header
            oStream.write(fileArray, offset, 5);
            offset += 5;
            //Pokemon
            for(int k = 0; k < 21; k++){
                if(BPokeLevelsWild){
                    oStream.write((byte)Math.ceil(Math.random()*100));
                    offset++;
                }else{
                    oStream.write(fileArray, offset, 1);
                    offset += 1;
                }
                if(BGameWildPoke){
                    oStream.write(PokeGen.insertPoke());
                    offset += 1;
                }else{
                    oStream.write(fileArray, offset, 1);
                    offset += 1;
                };
            }
        }
        oStream.write((byte)0xFF);
        offset += 1;
        
        //Weird ass water pokemon
        for(int i=0; i < 1; i++){
            //Header
            oStream.write(fileArray, offset, 3);
            offset += 3;
            //Pokemon
            for(int k = 0; k < 3; k++){
                if(BPokeLevelsWild){
                    oStream.write((byte)Math.ceil(Math.random()*100));
                    offset++;
                }else{
                    oStream.write(fileArray, offset, 1);
                    offset += 1;
                }
                if(BGameWildPoke){
                    oStream.write(PokeGen.insertPoke());
                    offset += 1;
                }else{
                    oStream.write(fileArray, offset, 1);
                    offset += 1;
                }
            }
        }
        oStream.write((byte)0xFF);
        offset++;
        
        System.out.println("Wild Pokemon End at: " + offset);
        
        //3. Trainers / Names
        oStream.write(fileArray, offset, 0xDADF);
        offset += 0xDADF;
        
        //3B685 is the end of Trainer Data in Gold
        int count = 0;
        while (offset < 0x3B685){
            if(count == 0){
                System.out.println("Pokemon Trainer Begin: " + offset);
                count++;
            }
            //Trainer Name
            int nameLength = 0;
            int searchOffset = offset;
            byte[] newName;
            while(fileArray[searchOffset] != 0x50){
                nameLength++;
                searchOffset++;
            }
            switch(nameLength){
                case 2:
                    newName = NameGen.getRandomNameSize2();
                    break;
                case 3:
                    newName = NameGen.getRandomNameSize3();
                    break;
                case 4:
                    newName = NameGen.getRandomNameSize4();
                    break;
                case 5:
                    newName = NameGen.getRandomNameSize5();
                    break;
                case 6:
                    newName = NameGen.getRandomNameSize6();
                    break;
                case 7:
                    newName = NameGen.getRandomNameSize7();
                    break;
                case 8:
                    newName = NameGen.getRandomNameSize8();
                    break;
                case 9:
                    newName = NameGen.getRandomNameSize9();
                    break;
                case 10:
                    newName = NameGen.getRandomNameSize10();
                    break;
                default:
                    newName = new byte[]{(byte)0xE6};
                    System.out.println("There is a " + nameLength + " letter at " + offset);
                    break;
            }
            if(BTrainerNames){
                oStream.write(newName, 0, nameLength);
                offset += nameLength;
            }else{
                oStream.write(fileArray, offset, nameLength);
                offset += nameLength;
            }
            
            //0x50 to end the trainer name
            oStream.write((byte) 0x50);
            offset++;
            
            //Fight Type
            byte fightType = fileArray[offset];
            oStream.write(fightType);
            offset++;
            
            //Pokemon Data based on fight Type
            switch(fightType){
                case 0x00:
                    while(fileArray[offset] != (byte) 0xFF){
                        if(BPokeLevelsTrainer){
                            oStream.write((byte)Math.ceil(Math.random()*100));
                        }else{
                            oStream.write(fileArray, offset, 1);
                        }
                        offset++;
                        
                        if(BTrainerPoke){
                            //Special Cases for making the Rival keep his starter.
                            switch(offset){
                                case 0x39A96:
                                    if(BTrainerRival){
                                        oStream.write(PokeGen.evolvePokemon(starters[2], 5)); //Level 5
                                    }else{
                                        oStream.write(PokeGen.insertPoke());
                                    }
                                    offset++;
                                    break;
                                case 0x39A9C:
                                    if(BTrainerRival){
                                        oStream.write(PokeGen.evolvePokemon(starters[0], 5)); //Level 5
                                    }else{
                                        oStream.write(PokeGen.insertPoke());
                                    }
                                    offset++;
                                    break;
                                case 0x39AA2:
                                    if(BTrainerRival){
                                        oStream.write(PokeGen.evolvePokemon(starters[1], 5)); //Level 5
                                    }else{
                                        oStream.write(PokeGen.insertPoke());
                                    }
                                    offset++;
                                    break;
                                case 0x39AAC:
                                    if(BTrainerRival){
                                        oStream.write(PokeGen.evolvePokemon(starters[2], 16)); //Level 16
                                    }else{
                                        oStream.write(PokeGen.insertPoke());
                                    }
                                    offset++;
                                    break;
                                case 0x39AB6:
                                    if(BTrainerRival){
                                        oStream.write(PokeGen.evolvePokemon(starters[0], 16)); //Level 16
                                    }else{
                                        oStream.write(PokeGen.insertPoke());
                                    }
                                    offset++;
                                    break;
                                case 0x39AC0:
                                    if(BTrainerRival){
                                        oStream.write(PokeGen.evolvePokemon(starters[1], 16)); //Level 16
                                    }else{
                                        oStream.write(PokeGen.insertPoke());
                                    }
                                    offset++;
                                    break;
                                default:
                                    oStream.write(PokeGen.insertPoke());
                                    offset++;
                                    break;
                            }
                        }else{
                            oStream.write(fileArray, offset, 1);
                            offset++;
                        }
                    }
                    break;
                case 0x01:
                    while(fileArray[offset] != (byte) 0xFF){
                        if(BPokeLevelsTrainer){
                            oStream.write((byte)Math.ceil(Math.random()*100));
                        }else{
                            oStream.write(fileArray, offset, 1);
                        }
                        offset++;
                        if(BTrainerPoke){
                            switch(offset){
                                case 0x39AD8:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[2], 22)); //Level 22
                                    }else{
                                        oStream.write(PokeGen.insertPoke());
                                    }
                                    offset++;
                                    break;
                                case 0x39AF4:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[0], 22)); //Level 22
                                    }else{
                                        oStream.write(PokeGen.insertPoke());
                                    }
                                    offset++;
                                    break;
                                case 0x39B10:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[1], 22)); //Level 22
                                    }else{
                                        oStream.write(PokeGen.insertPoke());
                                    }
                                    offset++;
                                    break;
                                case 0x39B32:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[2], 32)); //Level 32
                                    }else{
                                        oStream.write(PokeGen.insertPoke());
                                    }
                                    offset++;
                                    break;
                                case 0x39B54:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[0], 32)); //Level 32
                                    }else{
                                        oStream.write(PokeGen.insertPoke());
                                    }
                                    offset++;
                                    break;
                                case 0x39BB76:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[1], 32)); //Level 32
                                    }else{
                                        oStream.write(PokeGen.insertPoke());
                                    }
                                    offset++;
                                    break;
                                case 0x39BB9E:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[2], 38)); //Level 38
                                    }else{
                                        oStream.write(PokeGen.insertPoke());
                                    }
                                    offset++;
                                    break;
                                case 0x39BBC6:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[0], 38)); //Level 38
                                    }else{
                                        oStream.write(PokeGen.insertPoke());
                                    }
                                    offset++;
                                    break;
                                case 0x39BBEE:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[1], 38)); //Level 38
                                    }else{
                                        oStream.write(PokeGen.insertPoke());
                                    }
                                    offset++;
                                    break;
                                case 0x3ABFA:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[2], 45)); //Level 45
                                    }else{
                                        oStream.write(PokeGen.insertPoke());
                                    }
                                    offset++;
                                    break;
                                case 0x3AC22:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[0], 45)); //Level 45
                                    }else{
                                        oStream.write(PokeGen.insertPoke());
                                    }
                                    offset++;
                                    break;
                                case 0x3AC4A:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[1], 45)); //Level 45
                                    }else{
                                        oStream.write(PokeGen.insertPoke());
                                    }
                                    offset++;
                                    break;
                                case 0x3AC72:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[2], 50)); //Level 50
                                    }else{
                                        oStream.write(PokeGen.insertPoke());
                                    }
                                    offset++;
                                    break;
                                case 0x3AC9A:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[0], 50)); //Level 50
                                    }else{
                                        oStream.write(PokeGen.insertPoke());
                                    }
                                    offset++;
                                    break;
                                case 0x3ACC2:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[1], 50)); //Level 50
                                    }else{
                                        oStream.write(PokeGen.insertPoke());
                                    }
                                    offset++;
                                    break;
                                default:
                                    oStream.write(PokeGen.insertPoke());
                                    offset++;
                                    break;
                            }
                            oStream.write(TMGen.giveMove());
                            offset++;
                            oStream.write(TMGen.giveMove());
                            offset++;
                            oStream.write(TMGen.giveMove());
                            offset++;
                            oStream.write(TMGen.giveMove());
                            offset++;
                        }else{
                            oStream.write(fileArray, offset, 5);
                            offset += 5;
                        }
                    }
                    break;
                case 0x02:
                    while(fileArray[offset] != (byte) 0xFF){
                        if(BPokeLevelsTrainer){
                            oStream.write((byte)Math.ceil(Math.random()*100));
                        }else{
                            oStream.write(fileArray, offset, 1);
                        }
                        offset++;
                        if(BTrainerPoke){
                            oStream.write(PokeGen.insertPoke());
                        }else{
                            oStream.write(fileArray, offset, 1);
                        }
                        offset++;
                        oStream.write(fileArray, offset, 1);
                        offset++;
                    }
                    break;
                case 0x03:
                    while(fileArray[offset] != (byte) 0xFF){
                        if(BPokeLevelsTrainer){
                            oStream.write((byte)Math.ceil(Math.random()*100));
                        }else{
                            oStream.write(fileArray, offset, 1);
                        }
                        offset++;
                        if(BTrainerPoke){
                            oStream.write(PokeGen.insertPoke());
                        }else{
                            oStream.write(fileArray, offset, 1);
                        }
                        offset++;
                        oStream.write(fileArray, offset, 1);
                        offset++;
                        if(BTrainerPoke){
                            oStream.write(TMGen.giveMove());
                            oStream.write(TMGen.giveMove());
                            oStream.write(TMGen.giveMove());
                            oStream.write(TMGen.giveMove());
                            offset += 4;
                        }else{
                            oStream.write(fileArray, offset, 4);
                            offset += 4;
                        }
                    }
                    break;
            }
            //End the trainer
            oStream.write(0xFF);
            offset++;
        }
        
        //4. Movesets / Evolution fixes
        oStream.write(fileArray, offset, 0x732E);
        offset += 0x732E;
        
        System.out.println("Pokemon Evolutions Begin at: " + offset);
        
        for(int i = 0; i < 251; i++){
            
            //Evolutions.
            //Evolution Type - Trigger - Evolves to
            while(fileArray[offset] != 0x00){
                //Still have some evolutions to dig through
                switch(fileArray[offset]){
                    case 0x01: //Normal Evolution, No changes made.
                        oStream.write(fileArray, offset, 0x03);
                        offset += 0x03;
                        break;
                    case 0x02://Stone Evolution, No changes made.
                        oStream.write(fileArray, offset, 0x03);
                        offset += 0x03;
                        break;
                    case 0x03://Trade Evolution, Changed to be a Normal Evolution at level 40.
                        if(BPokeTrade){
                            oStream.write(0x01);
                            offset++;
                            oStream.write(0x28);
                            offset++;
                            oStream.write(fileArray, offset, 1);
                            offset++;
                        }else{
                            oStream.write(fileArray, offset, 3);
                            offset += 3;
                        }
                        break;
                    case 0x04://Happiness Evolution, No changes made.
                        oStream.write(fileArray, offset, 0x03);
                        offset += 0x03;
                        break;
                    case 0x05://Tyrogue special Evolution, No changes made.
                        oStream.write(fileArray, offset, 0x04);
                        offset += 0x04;
                        break;
                }
            }
            
            //0x00
            oStream.write(0x00);
            offset++;
            
            //Moves Learned
            //[Level][Move]
            while(fileArray[offset] != 0x00){
                oStream.write(fileArray, offset, 1);
                offset++;
                if(BPokeMovesets){
                    oStream.write(TMGen.giveNonHMMove());
                }else{
                    oStream.write(fileArray, offset, 1);
                }
                offset++;
            }
            
            //0x00
            oStream.write(0x00);
            offset++;
        }
        
        //5. TM/HM Compatability
        oStream.write(fileArray, offset, 0xDCB3);
        offset += 0xDCB3;
        System.out.println("Pokemon Stats start at " + offset);
        
        for(int i = 0; i < 251; i++){
            //Pokemon stats, for 0x17 bytes
            oStream.write(fileArray, offset, 0x17);
            offset += 0x17;
            
            if(BTMCompat){
            //64 bit switches(8 bytes) that just need to be random
                oStream.write(TMGen.giveRandomByte());
                offset++;
                oStream.write(TMGen.giveRandomByte());
                offset++;
                oStream.write(TMGen.giveRandomByte());
                offset++;
                oStream.write(TMGen.giveRandomByte());
                offset++;
                oStream.write(TMGen.giveRandomByte());
                offset++;
                oStream.write(TMGen.giveRandomByte());
                offset++;
                oStream.write(TMGen.giveRandomByte());
                offset++;
                oStream.write(TMGen.giveRandomByte());
                offset++;
            }else{
                oStream.write(fileArray, offset, 8);
                offset += 8;
            }
            
            //One more byte(It seems to mark pokemon that are water type? or something? I dunno.
            oStream.write(fileArray, offset, 1);
            offset += 1;
        }
        System.out.println("Pokemon Stats end at " + offset);
        
        //Fish tables
        //These are basically a leftover from RBY
        //They go [Chance][species][level] 3x for old rod
        //[Chance][species][level] 4x for Good/Super rod
        //The last entry of the Good Rod, and the 2nd entry of the Super rod are specials.
        //Leave them alone.
        oStream.write(fileArray, offset, 0x92A52 - offset);
        offset += 0x92A52 - offset;
        for(int k = 0; k < 12; k++){
            for(int i = 0; i < 11; i++){
                oStream.write(fileArray, offset, 1);
                offset++;
                if(i == 7 || i == 9){
                    oStream.write(fileArray, offset, 1);
                }else{
                    if(BGameWildPoke){
                        oStream.write(PokeGen.insertPoke());
                    }else{
                        oStream.write(fileArray, offset, 1);
                    }
                }
                offset++;
                if(BPokeLevelsWild){
                    oStream.write((byte)Math.ceil(Math.random()*100));
                }else{
                    oStream.write(fileArray, offset, 1);
                }
                offset++;
            }
        }
        System.out.println("Beginning of the water specials " + offset);
        //Special water pokemon bank. This is where those specials from above come from.
        //[Pokemon][Level]
        for(int i = 0; i < 44; i++){
            
            if(BGameWildPoke){
                oStream.write(PokeGen.insertPoke());
            }else{
                oStream.write(fileArray, offset, 1);
            }
            offset++;
            if(BPokeLevelsWild){
                oStream.write((byte)Math.ceil(Math.random()*100));
            }else{
                oStream.write(fileArray, offset, 1);
            }
            offset++;
        }
        
        //Headbutting trees and smashing rocks
        oStream.write(fileArray, offset, 0xBA47C - offset);
        offset += 0xBA47C - offset;
        //Thre are 12 tables for trees, and one for rocks.
        for(int i = 0; i < 13; i++){
            while(fileArray[offset] != (byte) 0xFF){
                oStream.write(fileArray, offset, 1);
                offset++;
                if(BGameWildPoke){
                oStream.write(PokeGen.insertPoke());
                }else{
                    oStream.write(fileArray, offset, 1);
                }
                offset++;
                if(BPokeLevelsWild){
                oStream.write((byte)Math.ceil(Math.random()*100));
                }else{
                    oStream.write(fileArray, offset, 1);
                }
                offset++;
            }
            oStream.write(0xFF);
            offset++;
        }
        
        //Cave LAPRAS
        oStream.write(fileArray, offset, 0x111775 - offset);
        offset += 0x111775 - offset;
        if(BGameEventPoke){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsWild){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        //Pads in Mahogany Base
        //1
        oStream.write(fileArray, offset, 0x1146FE - offset);
        offset += 0x1146FE - offset;
        if(BGameEventPoke){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsWild){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        //2
        oStream.write(fileArray, offset, 0x114711 - offset);
        offset += 0x114711 - offset;
        if(BGameEventPoke){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsWild){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        //3
        oStream.write(fileArray, offset, 0x114724 - offset);
        offset += 0x114724 - offset;
        if(BGameEventPoke){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsWild){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        //Electrodes
        //1
        oStream.write(fileArray, offset, 0x114DBD - offset);
        offset += 0x114DBD - offset;
        if(BGameEventPoke){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsWild){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        //2
        oStream.write(fileArray, offset, 0x114DE8 - offset);
        offset += 0x114DE8 - offset;
        if(BGameEventPoke){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsWild){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        //3
        oStream.write(fileArray, offset, 0x114E13 - offset);
        offset += 0x114E13 - offset;
        if(BGameEventPoke){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsWild){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        //Free Tyrogue
        oStream.write(fileArray, offset, 0x119F20 - offset);
        offset += 0x119F20 - offset;
        if(BGamePokeGift){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsGifts){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        //Lugia
        oStream.write(fileArray, offset, 0x11C1B6 - offset);
        offset += 0x11C1B6 - offset;
        if(BGameEventPoke){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsWild){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        oStream.write(fileArray, offset, 0x11C1C1 - offset);
        offset += 0x11C1C1 - offset;
        if(BGameEventPoke){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsWild){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        //Red Gyarados
        oStream.write(fileArray, offset, 0x124F7A - offset);
        offset += 0x124F7A - offset;
        if(BGameEventPoke){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsWild){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        //Sudowoodo
        oStream.write(fileArray, offset, 0x12E1D6 - offset);
        offset += 0x12E1D6 - offset;
        if(BGameEventPoke){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsWild){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        //Snorlax
        oStream.write(fileArray, offset, 0x13D2AB - offset);
        offset += 0x13D2AB - offset;
        if(BGameEventPoke){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsWild){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        //6. Starters / fixes
        oStream.write(fileArray, offset, 0x15924F - offset);
        offset += 0x15924F - offset;
        if(BGamePokeGift){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsGifts){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        //Spearow KENYA
        oStream.write(fileArray, offset, 0x1599FC - offset);
        offset += 0x1599FC - offset;
        if(BGamePokeGift){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsGifts){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        //Bill's EEVEE
        oStream.write(fileArray, offset, 0x15CC10 - offset);
        offset += 0x15CC10 - offset;
        if(BGamePokeGift){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsGifts){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        //Ho-oh
        oStream.write(fileArray, offset, 0x16E929 - offset);
        offset += 0x16E929 - offset;
        if(BGameEventPoke){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsWild){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        oStream.write(fileArray, offset, 0x16E934 - offset);
        offset += 0x16E934 - offset;
        if(BGameEventPoke){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsWild){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        System.out.println("Starter 1 is " + starters[0]);
        //Set the starters
        //Ball 1
        oStream.write(fileArray, offset, 0x1800D2 - offset);
        offset += 0x1800D2 - offset;
        if(BStarterStarters){
            oStream.write(starters[0]);
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        oStream.write(fileArray, offset, 1);
        offset++;
        if(BStarterStarters){
            oStream.write(starters[0]);
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        oStream.write(fileArray, offset, 0x16);
        offset += 0x16;
        if(BStarterStarters){
            oStream.write(starters[0]);
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        oStream.write(fileArray, offset, 0x0A);
        offset += 0x0A;
        if(BStarterStarters){
            oStream.write(starters[0]);
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsGifts){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BStarterItems){
            if(BStarterItemsKeys){
                oStream.write(ItemGen.insertItem());
            }else{
                oStream.write(ItemGen.insertItemAny());
            }
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        //Ball 2
        oStream.write(fileArray, offset, 0x180114 - offset);
        offset += 0x180114 - offset;
        if(BStarterStarters){
            oStream.write(starters[1]);
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        oStream.write(fileArray, offset, 1);
        offset++;
        if(BStarterStarters){
            oStream.write(starters[1]);
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        oStream.write(fileArray, offset, 0x16);
        offset += 0x16;
        if(BStarterStarters){
            oStream.write(starters[1]);
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        oStream.write(fileArray, offset, 0x0A);
        offset += 0x0A;
        if(BStarterStarters){
            oStream.write(starters[1]);
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsGifts){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BStarterItems){
            if(BStarterItemsKeys){
                oStream.write(ItemGen.insertItem());
            }else{
                oStream.write(ItemGen.insertItemAny());
            }
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        //Ball 3
        oStream.write(fileArray, offset, 0x180150 - offset);
        offset += 0x180150 - offset;
        if(BStarterStarters){
            oStream.write(starters[2]);
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        oStream.write(fileArray, offset, 1);
        offset++;
        if(BStarterStarters){
            oStream.write(starters[2]);
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        oStream.write(fileArray, offset, 0x16);
        offset += 0x16;
        if(BStarterStarters){
            oStream.write(starters[2]);
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        oStream.write(fileArray, offset, 0x0A);
        offset += 0x0A;
        if(BStarterStarters){
            oStream.write(starters[2]);
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsGifts){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BStarterItems){
            if(BStarterItemsKeys){
                oStream.write(ItemGen.insertItem());
            }else{
                oStream.write(ItemGen.insertItemAny());
            }
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        if(BStarterStarters){
            //Pokemon 1 name - 9 Bytes
            oStream.write(fileArray, offset, 0x1805F4 - offset);
            offset += 0x1805F4 - offset;

            byte[] pokeName = NameGen.getPokemonNameSize9(starters[0]);
            oStream.write(pokeName, 0, 9);
            offset+=9;

            //Pokemon 2 name - 8 Bytes
            oStream.write(fileArray, offset, 0x180620 - offset);
            offset += 0x180620 - offset;

            pokeName = NameGen.getPokemonNameSize8(starters[1]);
            oStream.write(pokeName, 0, 8);
            offset+=8;

            //Pokemon 3 name - 9 Bytes
            oStream.write(fileArray, offset, 0x18064D - offset);
            offset += 0x18064D - offset;

            pokeName = NameGen.getPokemonNameSize9(starters[2]);
            oStream.write(pokeName, 0, 9);
            offset+=9;
        }
        
        //Write the new ROM.
        oStream.write(fileArray, offset, fileArray.length - offset);
        save = new File("RenameMe.gbc");
        if(save.exists()){ //Save exists - Purge it.
            try{
                save.delete();
            }catch(Throwable t){
                //
            }
        }
        try{
            save.createNewFile();
            OutputStream oStream2 = new FileOutputStream(save);
            oStream.writeTo(oStream2);
            System.out.println(save.getAbsolutePath());
        }catch(Throwable t){
            //
        }
    }
    
    public void randomizeForCrystal(){
        //Select the starters, but let's not have two of the same starter.
        boolean weGood = false;
        while(!weGood){
            weGood = true;
            starters[0] = PokeGen.insertPoke();
            starters[1] = PokeGen.insertPoke();
            starters[2] = PokeGen.insertPoke();
            
            if(starters[0] == starters[1] || starters[0] == starters[2] || starters[2] == starters[1]){ 
                weGood = false;
            } 
        }
        //Steps
        //Logical order of addresses
        //Intro pokemon
        oStream.write(fileArray, offset, 0x5FD2 - offset);
        offset += 0x5FD2 - offset;
        oStream.write(PokeGen.insertPoke());
        offset++;
        
        if(BGamePokeGift){
            //Shuckie the shuckle
            oStream.write(fileArray, offset, 0x730A - offset);
            offset += 0x730A - offset;
            oStream.write(PokeGen.insertPoke());
            offset++;
            oStream.write(fileArray, offset, 0x7332 - offset);
            offset += 0x7332 - offset;
            if(BStarterItems){
                if(BStarterItemsKeys){
                    oStream.write(ItemGen.insertItem());
                }else{
                    oStream.write(ItemGen.insertItemAny());
                }
            }else{
                oStream.write(fileArray, offset, 1);
            }
            offset++;
        }
        
        //TMs
        if(BTMCont){
            oStream.write(fileArray, offset, 0x1167A - offset);
            offset += 0x1167A - offset;
            for(int i = 0; i < 50; i++){
                oStream.write(TMGen.insertTM());
                offset++;
            }
        }
        //2. Wild Encounters
        //Land Pokemon follow: 5 byte header: xx yy zz zz zz followed by [Level] [Species], for 42 bytes. 21 species per area.
        oStream.write(fileArray, offset, 0x2A5E9-offset);
        offset += 0x2A5E9-offset;
        System.out.println("Starting Wild at " + offset);
        System.out.println("Byte at " + offset + " is " + fileArray[offset]);
        for(int i=0; i < 61; i++){
            //Header
            oStream.write(fileArray, offset, 5);
            offset += 5;
            //Pokemon
            for(int k = 0; k < 21; k++){
                if(BPokeLevelsWild){
                    oStream.write((byte)Math.ceil(Math.random()*100));
                    offset++;
                }else{
                    oStream.write(fileArray, offset, 1);
                    offset += 1;
                }
                if(BGameWildPoke){
                    oStream.write(PokeGen.insertPoke());
                    offset += 1;
                }else{
                    oStream.write(fileArray, offset, 1);
                    offset += 1;
                }
            }
        }
        oStream.write((byte)0xFF);
        offset += 1;
        //Water pokemon follow: 5 byte header: xx yy zz zz zz followed by [Level] [Species], for 4 bytes. 2 species per area.
        for(int i=0; i < 38; i++){
            //Header
            oStream.write(fileArray, offset, 5);
            offset += 5;
            //Pokemon
            for(int k = 0; k < 2; k++){
                if(BPokeLevelsWild){
                    oStream.write((byte)Math.ceil(Math.random()*100));
                    offset++;
                }else{
                    oStream.write(fileArray, offset, 1);
                    offset += 1;
                }
                if(BGameWildPoke){
                    oStream.write(PokeGen.insertPoke());
                    offset += 1;
                }else{
                    oStream.write(fileArray, offset, 1);
                    offset += 1;
                }
            }
        }
        oStream.write((byte)0xFF);
        offset += 1;
        //Land Pokemon follow: 5 byte header: xx yy zz zz zz followed by [Level] [Species], for 42 bytes. 21 species per area. (KANTO)
        for(int i=0; i < 30; i++){
            //Header
            oStream.write(fileArray, offset, 5);
            offset += 5;
            //Pokemon
            for(int k = 0; k < 21; k++){
                if(BPokeLevelsWild){
                    oStream.write((byte)Math.ceil(Math.random()*100));
                    offset++;
                }else{
                    oStream.write(fileArray, offset, 1);
                    offset += 1;
                }
                if(BGameWildPoke){
                    oStream.write(PokeGen.insertPoke());
                    offset += 1;
                }else{
                    oStream.write(fileArray, offset, 1);
                    offset += 1;
                }
            }
        }
        oStream.write((byte)0xFF);
        offset += 1;
        //Water pokemon follow: 5 byte header: xx yy zz zz zz followed by [Level] [Species], for 4 bytes. 2 species per area. (KANTO)
        for(int i=0; i < 24; i++){
            //Header
            oStream.write(fileArray, offset, 5);
            offset += 5;
            //Pokemon
            for(int k = 0; k < 2; k++){
                if(BPokeLevelsWild){
                    oStream.write((byte)Math.ceil(Math.random()*100));
                    offset++;
                }else{
                    oStream.write(fileArray, offset, 1);
                    offset += 1;
                }
                if(BGameWildPoke){
                    oStream.write(PokeGen.insertPoke());
                    offset += 1;
                }else{
                    oStream.write(fileArray, offset, 1);
                    offset += 1;
                }
            }
        }
        oStream.write((byte)0xFF);
        offset += 1;
        
        //????? More land pokemon apparently
        for(int i=0; i < 4; i++){
            //Header
            oStream.write(fileArray, offset, 5);
            offset += 5;
            //Pokemon
            for(int k = 0; k < 21; k++){
                if(BPokeLevelsWild){
                    oStream.write((byte)Math.ceil(Math.random()*100));
                    offset++;
                }else{
                    oStream.write(fileArray, offset, 1);
                    offset += 1;
                }
                if(BGameWildPoke){
                    oStream.write(PokeGen.insertPoke());
                    offset += 1;
                }else{
                    oStream.write(fileArray, offset, 1);
                    offset += 1;
                }
            }
        }
        oStream.write((byte)0xFF);
        offset += 1;
        
        //Weird ass water pokemon
        for(int i=0; i < 1; i++){
            //Header
            oStream.write(fileArray, offset, 5);
            offset += 5;
            //Pokemon
            for(int k = 0; k < 2; k++){
                if(BPokeLevelsWild){
                    oStream.write((byte)Math.ceil(Math.random()*100));
                    offset++;
                }else{
                    oStream.write(fileArray, offset, 1);
                    offset += 1;
                }
                if(BGameWildPoke){
                    oStream.write(PokeGen.insertPoke());
                    offset += 1;
                }else{
                    oStream.write(fileArray, offset, 1);
                    offset += 1;
                }
            }
        }
        oStream.write((byte)0xFF);
        offset++;
        
        System.out.println("Wild Pokemon End at: " + offset);
        
        //3. Trainers / Names
        oStream.write(fileArray, offset, 0x39A1F - offset);
        offset += 0x39A1F - offset;
        
        //3BA67 is the end of Trainer Data in Gold
        int count = 0;
        while (offset < 0x3BA67){
            if(count == 0){
                System.out.println("Pokemon Trainer Begin: " + offset);
                count++;
            }
            //Trainer Name
            int nameLength = 0;
            int searchOffset = offset;
            byte[] newName;
            while(fileArray[searchOffset] != 0x50){
                nameLength++;
                searchOffset++;
            }
            switch(nameLength){
                case 2:
                    newName = NameGen.getRandomNameSize2();
                    break;
                case 3:
                    newName = NameGen.getRandomNameSize3();
                    break;
                case 4:
                    newName = NameGen.getRandomNameSize4();
                    break;
                case 5:
                    newName = NameGen.getRandomNameSize5();
                    break;
                case 6:
                    newName = NameGen.getRandomNameSize6();
                    break;
                case 7:
                    newName = NameGen.getRandomNameSize7();
                    break;
                case 8:
                    newName = NameGen.getRandomNameSize8();
                    break;
                case 9:
                    newName = NameGen.getRandomNameSize9();
                    break;
                case 10:
                    newName = NameGen.getRandomNameSize10();
                    break;
                default:
                    newName = new byte[]{(byte)0xE6};
                    System.out.println("There is a " + nameLength + " letter at " + offset);
                    break;
            }
            if(BTrainerNames){
                oStream.write(newName, 0, nameLength);
                offset += nameLength;
            }else{
                oStream.write(fileArray, offset, nameLength);
                offset += nameLength;
            }
            
            //0x50 to end the trainer name
            oStream.write((byte) 0x50);
            offset++;
            
            //Fight Type
            byte fightType = fileArray[offset];
            oStream.write(fightType);
            offset++;
            
            //Pokemon Data based on fight Type
            switch(fightType){
                case 0x00:
                    while(fileArray[offset] != (byte) 0xFF){
                        if(BPokeLevelsTrainer){
                            oStream.write((byte)Math.ceil(Math.random()*100));
                        }else{
                            oStream.write(fileArray, offset, 1);
                        }
                        offset++;
                        if(BTrainerPoke){
                        //Special Cases for making the Rival keep his starter.
                            switch(offset){
                                case 0x39AF3:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[2], 5)); //Level 5
                                    }else{
                                            oStream.write(PokeGen.insertPoke());
                                        }
                                    offset++;
                                    break;
                                case 0x39AF9:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[0], 5)); //Level 5
                                    }else{
                                            oStream.write(PokeGen.insertPoke());
                                        }
                                    offset++;
                                    break;
                                case 0x39AFF:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[1], 5)); //Level 5
                                    }else{
                                            oStream.write(PokeGen.insertPoke());
                                        }
                                    offset++;
                                    break;
                                case 0x39B09:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[2], 16)); //Level 16
                                    }else{
                                            oStream.write(PokeGen.insertPoke());
                                        }
                                    offset++;
                                    break;
                                case 0x39B13:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[0], 16)); //Level 16
                                    }else{
                                            oStream.write(PokeGen.insertPoke());
                                        }
                                    offset++;
                                    break;
                                case 0x39B1D:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[1], 16)); //Level 16
                                    }else{
                                            oStream.write(PokeGen.insertPoke());
                                        }
                                    offset++;
                                    break;
                                default:
                                    oStream.write(PokeGen.insertPoke());
                                    offset++;
                                    break;
                            }
                        }
                    }
                    break;
                case 0x01:
                    while(fileArray[offset] != (byte) 0xFF){
                        if(BPokeLevelsTrainer){
                            oStream.write((byte)Math.ceil(Math.random()*100));
                        }else{
                            oStream.write(fileArray, offset, 1);
                        }
                        offset++;
                        if(BTrainerPoke){
                            switch(offset){
                                case 0x39B35:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[2], 22)); //Level 22
                                    }else{
                                            oStream.write(PokeGen.insertPoke());
                                        }
                                    offset++;
                                    break;
                                case 0x39B51:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[0], 22)); //Level 22
                                    }else{
                                            oStream.write(PokeGen.insertPoke());
                                        }
                                    offset++;
                                    break;
                                case 0x39B6D:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[1], 22)); //Level 22
                                    }else{
                                            oStream.write(PokeGen.insertPoke());
                                        }
                                    offset++;
                                    break;
                                case 0x39B8F:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[2], 32)); //Level 32
                                    }else{
                                            oStream.write(PokeGen.insertPoke());
                                        }
                                    offset++;
                                    break;
                                case 0x39BB1:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[0], 32)); //Level 32
                                    }else{
                                            oStream.write(PokeGen.insertPoke());
                                        }
                                    offset++;
                                    break;
                                case 0x39BD3:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[1], 32)); //Level 32
                                    }else{
                                            oStream.write(PokeGen.insertPoke());
                                        }
                                    offset++;
                                    break;
                                case 0x39BFB:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[2], 38)); //Level 38
                                    }else{
                                            oStream.write(PokeGen.insertPoke());
                                        }
                                    offset++;
                                    break;
                                case 0x39C23:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[0], 38)); //Level 38
                                    }else{
                                            oStream.write(PokeGen.insertPoke());
                                        }
                                    offset++;
                                    break;
                                case 0x39C4B:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[1], 38)); //Level 38
                                    }else{
                                            oStream.write(PokeGen.insertPoke());
                                        }
                                    offset++;
                                    break;
                                case 0x3AE4C:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[2], 45)); //Level 45
                                    }else{
                                            oStream.write(PokeGen.insertPoke());
                                        }
                                    offset++;
                                    break;
                                case 0x3AE74:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[0], 45)); //Level 45
                                    }else{
                                            oStream.write(PokeGen.insertPoke());
                                        }
                                    offset++;
                                    break;
                                case 0x3AE9C:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[1], 45)); //Level 45
                                    }else{
                                            oStream.write(PokeGen.insertPoke());
                                        }
                                    offset++;
                                    break;
                                case 0x3AEC4:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[2], 50)); //Level 50
                                    }else{
                                            oStream.write(PokeGen.insertPoke());
                                        }
                                    offset++;
                                    break;
                                case 0x3AEEC:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[0], 50)); //Level 50
                                    }else{
                                            oStream.write(PokeGen.insertPoke());
                                        }
                                    offset++;
                                    break;
                                case 0x3AF14:
                                    if(BTrainerRival){
                                    oStream.write(PokeGen.evolvePokemon(starters[1], 50)); //Level 50
                                    }else{
                                            oStream.write(PokeGen.insertPoke());
                                        }
                                    offset++;
                                    break;
                                default:
                                    oStream.write(PokeGen.insertPoke());
                                    offset++;
                                    break;
                            }
                        }
                        oStream.write(TMGen.giveMove());
                        offset++;
                        oStream.write(TMGen.giveMove());
                        offset++;
                        oStream.write(TMGen.giveMove());
                        offset++;
                        oStream.write(TMGen.giveMove());
                        offset++;
                    }
                    break;
                case 0x02:
                    while(fileArray[offset] != (byte) 0xFF){
                        if(BPokeLevelsTrainer){
                            oStream.write((byte)Math.ceil(Math.random()*100));
                        }else{
                            oStream.write(fileArray, offset, 1);
                        }
                        offset++;
                        if(BTrainerPoke){
                            oStream.write(PokeGen.insertPoke());
                        }else{
                            oStream.write(fileArray, offset, 1);
                        }
                        offset++;
                        oStream.write(fileArray, offset, 1);
                        offset++;
                    }
                    break;
                case 0x03:
                    while(fileArray[offset] != (byte) 0xFF){
                        if(BPokeLevelsTrainer){
                            oStream.write((byte)Math.ceil(Math.random()*100));
                        }else{
                            oStream.write(fileArray, offset, 1);
                        }
                        offset++;
                        if(BTrainerPoke){
                            oStream.write(PokeGen.insertPoke());
                        }else{
                            oStream.write(fileArray, offset, 1);
                        }
                        offset++;
                        oStream.write(fileArray, offset, 1);
                        offset++;
                        if(BTrainerPoke){
                            oStream.write(TMGen.giveMove());
                            oStream.write(TMGen.giveMove());
                            oStream.write(TMGen.giveMove());
                            oStream.write(TMGen.giveMove());
                            offset += 4;
                        }else{
                            oStream.write(fileArray, offset, 4);
                            offset += 4;
                        }
                    }
                    break;
            }
            //End the trainer
            oStream.write(0xFF);
            offset++;
        }
        
        //4. Movesets / Evolution fixes
        oStream.write(fileArray, offset, 0x427A7 - offset);
        offset += 0x427A7 - offset;
        
        System.out.println("Pokemon Evolutions Begin at: " + offset);
        
        for(int i = 0; i < 251; i++){
            
            //Evolutions.
            //Evolution Type - Trigger - Evolves to
            while(fileArray[offset] != 0x00){
                //Still have some evolutions to dig through
                switch(fileArray[offset]){
                    case 0x01: //Normal Evolution, No changes made.
                        oStream.write(fileArray, offset, 0x03);
                        offset += 0x03;
                        break;
                    case 0x02://Stone Evolution, No changes made.
                        oStream.write(fileArray, offset, 0x03);
                        offset += 0x03;
                        break;
                    case 0x03://Trade Evolution, Changed to be a Normal Evolution at level 40.
                        if(BPokeTrade){
                            oStream.write(0x01);
                            offset++;
                            oStream.write(0x28);
                            offset++;
                            oStream.write(fileArray, offset, 1);
                            offset++;
                        }else{
                            oStream.write(fileArray, offset, 3);
                            offset += 3;
                        }
                        break;
                    case 0x04://Happiness Evolution, No changes made.
                        oStream.write(fileArray, offset, 0x03);
                        offset += 0x03;
                        break;
                    case 0x05://Tyrogue special Evolution, No changes made.
                        oStream.write(fileArray, offset, 0x04);
                        offset += 0x04;
                        break;
                }
            }
            
            //0x00
            oStream.write(0x00);
            offset++;
            
            //Moves Learned
            //[Level][Move]
            while(fileArray[offset] != 0x00){
                oStream.write(fileArray, offset, 1);
                offset++;
                if(BPokeMovesets){
                    oStream.write(TMGen.giveNonHMMove());
                }else{
                    oStream.write(fileArray, offset, 1);
                }
                offset++;
            }
            
            //0x00
            oStream.write(0x00);
            offset++;
        }
        
        //5. TM/HM Compatability
        oStream.write(fileArray, offset, 0x51424 - offset);
        offset += 0x51424 - offset;
        System.out.println("Pokemon Stats start at " + offset);
        
        for(int i = 0; i < 251; i++){
            //Pokemon stats, for 0x17 bytes
            oStream.write(fileArray, offset, 0x17);
            offset += 0x17;
            
            if(BTMCompat){
                //64 bit switches(8 bytes) that just need to be random
                oStream.write(TMGen.giveRandomByte());
                offset++;
                oStream.write(TMGen.giveRandomByte());
                offset++;
                oStream.write(TMGen.giveRandomByte());
                offset++;
                oStream.write(TMGen.giveRandomByte());
                offset++;
                oStream.write(TMGen.giveRandomByte());
                offset++;
                oStream.write(TMGen.giveRandomByte());
                offset++;
                oStream.write(TMGen.giveRandomByte());
                offset++;
                oStream.write(TMGen.giveRandomByte());
                offset++;
            }else{
                oStream.write(fileArray, offset, 8);
                offset += 8;
            }
            
            //One more byte(It seems to mark pokemon that are water type? or something? I dunno.
            oStream.write(fileArray, offset, 1);
            offset += 1;
        }
        System.out.println("Pokemon Stats end at " + offset);
        
        //Bill's EEVEE
        oStream.write(fileArray, offset, 0x54C06 - offset);
        offset += 0x54C06 - offset;
        if(BGamePokeGift){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsGifts){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        //Cave LAPRAS
        oStream.write(fileArray, offset, 0x5A324 - offset);
        offset += 0x5A324 - offset;
        if(BGameEventPoke){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsWild){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        
        
        //Togepi EGG
        oStream.write(fileArray, offset, 0x694E2 - offset);
        offset += 0x694E2 - offset;
        if(BGamePokeGift){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsGifts){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        //Spearow KENYA
        oStream.write(fileArray, offset, 0x69D65 - offset);
        offset += 0x69D65 - offset;
        if(BGamePokeGift){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsGifts){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        //Pads in Mahogany Base
        //1
        oStream.write(fileArray, offset, 0x6CA43 - offset);
        offset += 0x6CA43 - offset;
        if(BGameEventPoke){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsWild){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        //2
        oStream.write(fileArray, offset, 0x6CA56 - offset);
        offset += 0x6CA56 - offset;
        if(BGameEventPoke){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsWild){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        //3
        oStream.write(fileArray, offset, 0x6CA69 - offset);
        offset += 0x6CA69 - offset;
        if(BGameEventPoke){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsWild){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        //Electrodes
        //1
        oStream.write(fileArray, offset, 0x6D105 - offset);
        offset += 0x6D105 - offset;
        if(BGameEventPoke){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsWild){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        //2
        oStream.write(fileArray, offset, 0x6D130 - offset);
        offset += 0x6D130 - offset;
        if(BGameEventPoke){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsWild){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        //3
        oStream.write(fileArray, offset, 0x6D15B - offset);
        offset += 0x6D15B - offset;
        if(BGameEventPoke){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsWild){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        //Red Gyarados
        oStream.write(fileArray, offset, 0x7006E - offset);
        offset += 0x7006E - offset;
        if(BGameEventPoke){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsWild){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        //Ho-oh
        oStream.write(fileArray, offset, 0x77256 - offset);
        offset += 0x77256 - offset;
        if(BGameEventPoke){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsWild){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        //Starters / fixes
        //Set the starters
        //Ball 1
        oStream.write(fileArray, offset, 0x78C7F - offset);
        offset += 0x78C7F - offset;
       if(BStarterStarters){
            oStream.write(starters[0]);
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        oStream.write(fileArray, offset, 1);
        offset++;
        if(BStarterStarters){
            oStream.write(starters[0]);
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        oStream.write(fileArray, offset, 0x16);
        offset += 0x16;
        if(BStarterStarters){
            oStream.write(starters[0]);
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        oStream.write(fileArray, offset, 0x0A);
        offset += 0x0A;
        if(BStarterStarters){
            oStream.write(starters[0]);
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsGifts){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BStarterItems){
            if(BStarterItemsKeys){
                oStream.write(ItemGen.insertItem());
            }else{
                oStream.write(ItemGen.insertItemAny());
            }
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        //Ball 2
        oStream.write(fileArray, offset, 0x78CC1 - offset);
        offset += 0x78CC1 - offset;
        if(BStarterStarters){
            oStream.write(starters[1]);
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        oStream.write(fileArray, offset, 1);
        offset++;
        if(BStarterStarters){
            oStream.write(starters[1]);
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        oStream.write(fileArray, offset, 0x16);
        offset += 0x16;
        if(BStarterStarters){
            oStream.write(starters[1]);
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        oStream.write(fileArray, offset, 0x0A);
        offset += 0x0A;
        if(BStarterStarters){
            oStream.write(starters[1]);
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsGifts){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BStarterItems){
            if(BStarterItemsKeys){
                oStream.write(ItemGen.insertItem());
            }else{
                oStream.write(ItemGen.insertItemAny());
            }
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        //Ball 3
        oStream.write(fileArray, offset, 0x78CFD - offset);
        offset += 0x78CFD - offset;
         if(BStarterStarters){
            oStream.write(starters[2]);
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        oStream.write(fileArray, offset, 1);
        offset++;
        if(BStarterStarters){
            oStream.write(starters[2]);
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        oStream.write(fileArray, offset, 0x16);
        offset += 0x16;
        if(BStarterStarters){
            oStream.write(starters[2]);
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        oStream.write(fileArray, offset, 0x0A);
        offset += 0x0A;
        if(BStarterStarters){
            oStream.write(starters[2]);
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsGifts){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BStarterItems){
            if(BStarterItemsKeys){
                oStream.write(ItemGen.insertItem());
            }else{
                oStream.write(ItemGen.insertItemAny());
            }
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        
        if(BStarterStarters){
            //Pokemon 1 name - 9 Bytes
            oStream.write(fileArray, offset, 0x793D9 - offset);
            offset += 0x793D9 - offset;

            byte[] pokeName = NameGen.getPokemonNameSize9(starters[0]);
            oStream.write(pokeName, 0, 9);
            offset+=9;

            //Pokemon 2 name - 8 Bytes
            oStream.write(fileArray, offset, 0x79405 - offset);
            offset += 0x79405 - offset;

            pokeName = NameGen.getPokemonNameSize8(starters[1]);
            oStream.write(pokeName, 0, 8);
            offset+=8;

            //Pokemon 3 name - 9 Bytes
            oStream.write(fileArray, offset, 0x79432 - offset);
            offset += 0x79432 - offset;

            pokeName = NameGen.getPokemonNameSize9(starters[2]);
            oStream.write(pokeName, 0, 9);
            offset+=9;
        }
        
        //Free Tyrogue
        oStream.write(fileArray, offset, 0x7E22A - offset);
        offset += 0x7E22A - offset;
        if(BGameEventPoke){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsGifts){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        if(BPokeMovesets){
            //Moveset for the free Dratini
            oStream.write(fileArray, offset, 0x8B1C4 - offset);
            offset += 0x8B1C4 - offset;
            for(int i = 0; i < 9; i++){
                if(i != 4){
                    oStream.write(TMGen.giveNonHMMove());
                }else{
                    oStream.write(0x0);
                }
                offset++;
            }
        }
        
        //Fish tables
        //These are basically a leftover from RBY
        //They go [Chance][species][level] 3x for old rod
        //[Chance][species][level] 4x for Good/Super rod
        //The last entry of the Good Rod, and the 2nd entry of the Super rod are specials.
        //Leave them alone.
        oStream.write(fileArray, offset, 0x924E3 - offset);
        offset += 0x924E3 - offset;
        for(int k = 0; k < 12; k++){
            for(int i = 0; i < 11; i++){
                oStream.write(fileArray, offset, 1);
                offset++;
                if(i == 7 || i == 9){
                    oStream.write(fileArray, offset, 1);
                }else{
                    if(BGameWildPoke){
                        oStream.write(PokeGen.insertPoke());
                    }else{
                        oStream.write(fileArray, offset, 1);
                    }
                }
                offset++;
                if(BPokeLevelsWild){
                    oStream.write((byte)Math.ceil(Math.random()*100));
                }else{
                    oStream.write(fileArray, offset, 1);
                }
                offset++;
            }
        }
        System.out.println("Beginning of the water specials " + offset);
        //Special water pokemon bank. This is where those specials from above come from.
        //[Pokemon][Level]
        for(int i = 0; i < 44; i++){
            if(BGameWildPoke){
            oStream.write(PokeGen.insertPoke());
            }else{
                oStream.write(fileArray, offset, 1);
            }
            offset++;
            if(BPokeLevelsWild){
                oStream.write((byte)Math.ceil(Math.random()*100));
            }else{
                oStream.write(fileArray, offset, 1);
            }
            offset++;
        }
        
        //Headbutting trees and smashing rocks
        oStream.write(fileArray, offset, 0xB82FA - offset);
        offset += 0xB82FA - offset;
        //Thre are 12 tables for trees, and one for rocks.
        for(int i = 0; i < 13; i++){
            while(fileArray[offset] != (byte) 0xFF){
                oStream.write(fileArray, offset, 1);
                offset++;
                if(BGameWildPoke){
                oStream.write(PokeGen.insertPoke());
                }else{
                    oStream.write(fileArray, offset, 1);
                }
                offset++;
                if(BPokeLevelsWild){
                oStream.write((byte)Math.ceil(Math.random()*100));
                }else{
                    oStream.write(fileArray, offset, 1);
                }
                offset++;
            }
            oStream.write(0xFF);
            offset++;
        }
        
        
        //Lugia
        oStream.write(fileArray, offset, 0x1850EA- offset);
        offset += 0x1850EA - offset;
        if(BGameEventPoke){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsWild){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        //Suicune
        oStream.write(fileArray, offset, 0x18C52A - offset);
        offset += 0x18C52A - offset;
        if(BGameEventPoke){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsWild){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        //Dratini
        oStream.write(fileArray, offset, 0x18D1D7 - offset);
        offset += 0x18D1D7 - offset;
        if(BGamePokeGift){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsGifts){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        //Sudowoodo
        oStream.write(fileArray, offset, 0x194068 - offset);
        offset += 0x194068 - offset;
        if(BGameEventPoke){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsWild){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        //Snorlax
        oStream.write(fileArray, offset, 0x1AA9B8 - offset);
        offset += 0x1AA9B8 - offset;
        if(BGameEventPoke){
            oStream.write(PokeGen.insertPoke());
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        if(BPokeLevelsWild){
            oStream.write((byte)Math.ceil(Math.random()*100));
        }else{
            oStream.write(fileArray, offset, 1);
        }
        offset++;
        
        if(BGamePokeGift){
            //Daycare eggs
            oStream.write(fileArray, offset, 0x1FB56E - offset);
            offset += 0x1FB56E - offset;
            while(fileArray[offset] != 0x0){
                oStream.write(PokeGen.insertPoke());
                offset++;
                oStream.write(0x00);
                offset++;
                oStream.write(TMGen.giveNonHMMove());
                offset++;
                oStream.write(TMGen.giveNonHMMove());
                offset++;
                oStream.write(TMGen.giveNonHMMove());
                offset++;
                oStream.write(TMGen.giveNonHMMove());
                offset++;
                oStream.write(fileArray, offset, 0x35);
                offset += 0x35;
            }
        }
        
        //Write the new ROM.
        oStream.write(fileArray, offset, fileArray.length - offset);
        save = new File("RenameMeCrystal.gbc");
        if(save.exists()){ //Save exists - Purge it.
            try{
                save.delete();
            }catch(Throwable t){
                //
            }
        }
        try{
            save.createNewFile();
            OutputStream oStream2 = new FileOutputStream(save);
            oStream.writeTo(oStream2);
            System.out.println(save.getAbsolutePath());
        }catch(Throwable t){
            //
        }
    }
}
