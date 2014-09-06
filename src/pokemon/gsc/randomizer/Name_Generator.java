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
public class Name_Generator {
    Random random;
    public Name_Generator(){
        random = new Random();
    }
    public byte[] generateName(int size){
        
        return new byte[3];
    }
    
    public byte[] getRandomNameSize2(){
        String name = "";
        switch(random.nextInt(10)){
            case 0:
                name = "Ax";
                break;
            case 1:
                name = "Bo";
                break;
            case 2:
                name = "Ho";
                break;
            case 3:
                name = "No";
                break;
            case 4:
                name = "Pa";
                break;
            case 5:
                name = "Wa";
                break;
            case 6:
                name = "Am";
                break;
            case 7:
                name = "So";
                break;
            case 8:
                name = "Ni";
                break;
            case 9:
                name = "[]";
                break;
        }
        byte[] ret = new byte[2];
        for(int i = 0; i < 2; i++){
            ret[i] = convertChar(name.charAt(i));
        }
        return ret;
    }
    public byte[] getRandomNameSize3(){
        String name = "";
        switch(random.nextInt(10)){
            case 0:
                name = "Fez";
                break;
            case 1:
                name = "#21";
                break;
            case 2:
                name = "WTF";
                break;
            case 3:
                name = "Yak";
                break;
            case 4:
                name = "[]!";
                break;
            case 5:
                name = "Rob";
                break;
            case 6:
                name = "Bob";
                break;
            case 7:
                name = "Ass";
                break;
            case 8:
                name = "Bro";
                break;
            case 9:
                name = "Stu";
                break;
        }
        byte[] ret = new byte[3];
        for(int i = 0; i < 3; i++){
            ret[i] = convertChar(name.charAt(i));
        }
        return ret;
    }
    public byte[] getRandomNameSize4(){
        String name = "";
        switch(random.nextInt(12)){
            case 0:
                name = "Jorf";
                break;
            case 1:
                name = "Hess";
                break;
            case 2:
                name = "Wess";
                break;
            case 3:
                name = "Rosh";
                break;
            case 4:
                name = "Boss";
                break;
            case 5:
                name = "Robo";
                break;
            case 6:
                name = "Kill";
                break;
            case 7:
                name = "Talk";
                break;
            case 8:
                name = "XAND";
                break;
            case 9:
                name = "Axon";
                break;
            case 10:
                name = "Noxa";
                break;
            case 11:
                name = "TS06";
                break;
        }
        byte[] ret = new byte[4];
        for(int i = 0; i < 4; i++){
            ret[i] = convertChar(name.charAt(i));
        }
        return ret;
    }
    public byte[] getRandomNameSize5(){
        String name = "";
        switch(random.nextInt(10)){
            case 0:
                name = "Moist";
                break;
            case 1:
                name = "AND4H";
                break;
            case 2:
                name = "Anees";
                break;
            case 3:
                name = "Cheat";
                break;
            case 4:
                name = "BadAI";
                break;
            case 5:
                name = "Jaden";
                break;
            case 6:
                name = "Urkel";
                break;
            case 7:
                name = "Wussy";
                break;
            case 8:
                name = "Spore";
                break;
            case 9:
                name = "Quote";
                break;
        }
        byte[] ret = new byte[5];
        for(int i = 0; i < 5; i++){
            ret[i] = convertChar(name.charAt(i));
        }
        return ret;
    }
    public byte[] getRandomNameSize6(){
        String name = "";
        switch(random.nextInt(10)){
            case 0:
                name = "Misery";
                break;
            case 1:
                name = "Hsanrb";
                break;
            case 2:
                name = "Tallos";
                break;
            case 3:
                name = "Ballos";
                break;
            case 4:
                name = "Venick";
                break;
            case 5:
                name = "Zephyr";
                break;
            case 6:
                name = "Faggot";
                break;
            case 7:
                name = "Gorble";
                break;
            case 8:
                name = "NoNoNo";
                break;
            case 9:
                name = "Bidoof";
                break;
        }
        byte[] ret = new byte[6];
        for(int i = 0; i < 6; i++){
            ret[i] = convertChar(name.charAt(i));
        }
        return ret;
    }
    public byte[] getRandomNameSize7(){
        String name = "";
        switch(random.nextInt(10)){
            case 0:
                name = "Werster";
                break;
            case 1:
                name = "Marksel";
                break;
            case 2:
                name = "Stealer";
                break;
            case 3:
                name = "Hekelot";
                break;
            case 4:
                name = "RaceBot";
                break;
            case 5:
                name = "Oshxmir";
                break;
            case 6:
                name = "Deleter";
                break;
            case 7:
                name = "Kerplor";
                break;
            case 8:
                name = "BigTrap";
                break;
            case 9:
                name = "Axe VII";
                break;
        }
        byte[] ret = new byte[7];
        for(int i = 0; i < 7; i++){
            ret[i] = convertChar(name.charAt(i));
        }
        return ret;
    }
    public byte[] getRandomNameSize8(){
        String name = "";
        switch(random.nextInt(11)){
            case 0:
                name = "Krankdud";
                break;
            case 1:
                name = "Grumbles";
                break;
            case 2:
                name = "Surreal-";
                break;
            case 3:
                name = "Boss Man";
                break;
            case 4:
                name = "Anti Air";
                break;
            case 5:
                name = "GoofBall";
                break;
            case 6:
                name = "Romscout";
                break;
            case 7:
                name = "Bullshit";
                break;
            case 8:
                name = "Alleymew";
                break;
            case 9:
                name = "Personal";
                break;
            case 10:
                name = "PUYOPUYO";
                break;
        }
        byte[] ret = new byte[8];
        for(int i = 0; i < 8; i++){
            ret[i] = convertChar(name.charAt(i));
        }
        return ret;
    }
    public byte[] getRandomNameSize9(){
        String name = "";
        switch(random.nextInt(10)){
            case 0:
                name = "Cantdrown";
                break;
            case 1:
                name = "Spacejump";
                break;
            case 2:
                name = "BobLoblaw";
                break;
            case 3:
                name = "FrootLoop";
                break;
            case 4:
                name = "WOOOOOOOW";
                break;
            case 5:
                name = "-Metroid-";
                break;
            case 6:
                name = "DeeRForCe";
                break;
            case 7:
                name = "MoonJuste";
                break;
            case 8:
                name = "Carbuncle";
                break;
            case 9:
                name = "MashAFast";
                break;
        }
        byte[] ret = new byte[9];
        for(int i = 0; i < 9; i++){
            ret[i] = convertChar(name.charAt(i));
        }
        return ret;
    }
    public byte[] getRandomNameSize10(){
        String name = "";
        switch(random.nextInt(10)){
            case 0:
                name = "TestSubjct";
                break;
            case 1:
                name = "Griff Man-";
                break;
            case 2:
                name = "PoodleSkit";
                break;
            case 3:
                name = "MrSpeedNO!";
                break;
            case 4:
                name = "WOOOOOOOW-";
                break;
            case 5:
                name = "-Metroid--";
                break;
            case 6:
                name = "DeeRForCe-";
                break;
            case 7:
                name = "MoonJuste-";
                break;
            case 8:
                name = "Carbuncle-";
                break;
            case 9:
                name = "MashAFast-";
                break;
        }
        byte[] ret = new byte[10];
        for(int i = 0; i < 10; i++){
            ret[i] = convertChar(name.charAt(i));
        }
        return ret;
    }
    public byte[] getPokemonNameSize9(int pokemon){
        String name = "";
        switch(pokemon){
            case 0x01:
               name = "BULBASAUR";
               break;
            case 0x02:
               name = "IVYSAUR  ";
               break;
            case 0x03:
               name = "VENUSAUR ";
               break;
            case 0x04:
               name = "CHARMANDR";
               break;
            case 0x05:
               name = "CHARMELEN";
               break;
            case 0x06:
               name = "CHARIZARD";
               break;
            case 0x07:
               name = "SQUIRTLE ";
               break;
            case 0x08:
               name = "WARTORTLE";
               break;
            case 0x09:
               name = "BLASTOISE";
               break;
            case 0x0A:
               name = "CATERPIE ";
               break;
            case 0x0B:
               name = "METAPOD  ";
               break;
            case 0x0C:
               name = "BUTTERFRE";
               break;
            case 0x0D:
               name = "WEEDLE   ";
               break;
            case 0x0E:
               name = "KAKUNA   ";
               break;
            case 0x0F:
               name = "BEEDRILL ";
               break;
            case 0x10:
               name = "PIDGEY   ";
               break;
            case 0x11:
               name = "PIDGEOTTO";
               break;
            case 0x12:
               name = "PIDGEOT  ";
               break;
            case 0x13:
               name = "RATATTA  ";
               break;
            case 0x14:
               name = "RATICATE ";
               break;
            case 0x15:
               name = "SPEAROW  ";
               break;
            case 0x16:
               name = "FEAROW   ";
               break;
            case 0x17:
               name = "EKANS    ";
               break;
            case 0x18:
               name = "ARBOK    ";
               break;
            case 0x19:
               name = "PIKACHU  ";
               break;
            case 0x1A:
               name = "RAICHU   ";
               break;
            case 0x1B:
               name = "SANDSHREW";
               break;
            case 0x1C:
               name = "SANDSLASH";
               break;
            case 0x1D:
               name = "NIDORAN F";
               break;
            case 0x1E:
               name = "NIDORINA ";
               break;
            case 0x1F:
               name = "NIDOQUEEN";
               break;
            case 0x20:
               name = "NIDORAN M";
               break;
            case 0x21:
               name = "NIDORINO ";
               break;
            case 0x22:
               name = "NIDOKING ";
               break;
            case 0x23:
               name = "CLEFAIRY ";
               break;
            case 0x24:
               name = "CLEFABLE ";
               break;
            case 0x25:
               name = "VULPIX   ";
               break;
            case 0x26:
               name = "NINETAILS";
               break;
            case 0x27:
               name = "JIGGLYPUF";
               break;
            case 0x28:
               name = "WIGGLYTUF";
               break;
            case 0x29:
               name = "ZUBAT    ";
               break;
            case 0x2A:
               name = "GOLBAT   ";
               break;
            case 0x2B:
               name = "ODDISH   ";
               break;
            case 0x2C:
               name = "GLOOM    ";
               break;
            case 0x2D:
               name = "VILEPLUME";
               break;
            case 0x2E:
               name = "PARAS    ";
               break;
            case 0x2F:
               name = "PARASECT ";
               break;
            case 0x30:
               name = "VENONAT  ";
               break;
            case 0x31:
               name = "VENOMOTH ";
               break;
            case 0x32:
               name = "DIGLETT  ";
               break;
            case 0x33:
               name = "DIGTRIO  ";
               break;
            case 0x34:
               name = "MEOWTH   ";
               break;
            case 0x35:
               name = "PERSIAN  ";
               break;
            case 0x36:
               name = "PSYDUCK  ";
               break;
            case 0x37:
               name = "GOLDUCK  ";
               break;
            case 0x38:
               name = "MANKEY   ";
               break;
            case 0x39:
               name = "PRIMEAPE ";
               break;
            case 0x3A:
               name = "GROWLITHE";
               break;
            case 0x3B:
               name = "ARCANINE ";
               break;
            case 0x3C:
               name = "POLISWAG ";
               break;
            case 0x3D:
               name = "POLIWHIRL";
               break;
            case 0x3E:
               name = "POLIWRATH";
               break;
            case 0x3F:
               name = "ABRA     ";
               break;
            case 0x40:
               name = "KADABRA  ";
               break;
            case 0x41:
               name = "ALAKAZAM ";
               break;
            case 0x42:
               name = "MACHOP   ";
               break;
            case 0x43:
               name = "MACHOKE  ";
               break;
            case 0x44:
               name = "MACHAMP  ";
               break;
            case 0x45:
               name = "BELSPROUT";
               break;
            case 0x46:
               name = "WEEPNBELL";
               break;
            case 0x47:
               name = "VICTREBEL";
               break;
            case 0x48:
               name = "TENTACOOL";
               break;
            case 0x49:
               name = "TENTACRUL";
               break;
            case 0x4A:
               name = "GEODUDE  ";
               break;
            case 0x4B:
               name = "GRAVELER ";
               break;
            case 0x4C:
               name = "GOLEM    ";
               break;
            case 0x4D:
               name = "PONYTA   ";
               break;
            case 0x4E:
               name = "RAPIDASH ";
               break;
            case 0x4F:
               name = "SLOWPOKE ";
               break;
            case 0x50:
               name = "SLOWBRO  ";
               break;
            case 0x51:
               name = "MAGNEMITE";
               break;
            case 0x52:
               name = "MAGNETON ";
               break;
            case 0x53:
               name = "FARFETCHD";
               break;
            case 0x54:
               name = "DODUO    ";
               break;
            case 0x55:
               name = "DODRIO   ";
               break;
            case 0x56:
               name = "SEEL     ";
               break;
            case 0x57:
               name = "DEWGONG  ";
               break;
            case 0x58:
               name = "GRIMER   ";
               break;
            case 0x59:
               name = "ANEES MUK";
               break;
            case 0x5A:
               name = "SHELLDER ";
               break;
            case 0x5B:
               name = "CLOYSTER ";
               break;
            case 0x5C:
               name = "GASTLY   ";
               break;
            case 0x5D:
               name = "HAUNTER  ";
               break;
            case 0x5E:
               name = "GENGAR   ";
               break;
            case 0x5F:
               name = "ONIX     ";
               break;
            case 0x60:
               name = "DROWZEE  ";
               break;
            case 0x61:
               name = "HYPNO    ";
               break;
            case 0x62:
               name = "KRABBY   ";
               break;
            case 0x63:
               name = "KINGLER  ";
               break;
            case 0x64:
               name = "VOLTORB  ";
               break;
            case 0x65:
               name = "ELECTRODE";
               break;
            case 0x66:
               name = "EXEGGCUTE";
               break;
            case 0x67:
               name = "EXEGGUTOR";
               break;
            case 0x68:
               name = "CUBONE   ";
               break;
            case 0x69:
               name = "MAROWAK  ";
               break;
            case 0x6A:
               name = "HOTMONLEE";
               break;
            case 0x6B:
               name = "HITMONCHN";
               break;
            case 0x6C:
               name = "LICKITUNG";
               break;
            case 0x6D:
               name = "KOFFING  ";
               break;
            case 0x6E:
               name = "WEEZING  ";
               break;
            case 0x6F:
               name = "RHYHORN  ";
               break;
            case 0x70:
               name = "RHYDON   ";
               break;
            case 0x71:
               name = "CHANSEY  ";
               break;
            case 0x72:
               name = "TANGELA  ";
               break;
            case 0x73:
               name = "KANGASKAN";
               break;
            case 0x74:
               name = "HORSEA   ";
               break;
            case 0x75:
               name = "SEADRA   ";
               break;
            case 0x76:
               name = "GOLDEEN  ";
               break;
            case 0x77:
               name = "SEAKING  ";
               break;
            case 0x78:
               name = "STARYU   ";
               break;
            case 0x79:
               name = "STARMIE  ";
               break;
            case 0x7A:
               name = "MR MIME  ";
               break;
            case 0x7B:
               name = "SCYTHER  ";
               break;
            case 0x7C:
               name = "JYNX     ";
               break;
            case 0x7D:
               name = "ELECTABUZ";
               break;
            case 0x7E:
               name = "MAGMAR   ";
               break;
            case 0x7F:
               name = "PINSIR   ";
               break;
            case 0x80:
               name = "TAUROS   ";
               break;
            case 0x81:
               name = "MAGIKARP ";
               break;
            case 0x82:
               name = "GYARADOS ";
               break;
            case 0x83:
               name = "LAPRAS   ";
               break;
            case 0x84:
               name = "DITTO    ";
               break;
            case 0x85:
               name = "EEVEE    ";
               break;
            case 0x86:
               name = "VAPOREON ";
               break;
            case 0x87:
               name = "JOLTEON  ";
               break;
            case 0x88:
               name = "FLAREON  ";
               break;
            case 0x89:
               name = "PORYGON  ";
               break;
            case 0x8A:
               name = "OMANYTE  ";
               break;
            case 0x8B:
               name = "OMASTAR  ";
               break;
            case 0x8C:
               name = "KABUTO   ";
               break;
            case 0x8D:
               name = "KABUTOPS ";
               break;
            case 0x8E:
               name = "AERODACTL";
               break;
            case 0x8F:
               name = "SNORLAX  ";
               break;
            case 0x90:
               name = "ARTICUNO ";
               break;
            case 0x91:
               name = "ZAPDOS   ";
               break;
            case 0x92:
               name = "MOLTRES  ";
               break;
            case 0x93:
               name = "DRATINI  ";
               break;
            case 0x94:
               name = "DRAGONAIR";
               break;
            case 0x95:
               name = "DRAGONITE";
               break;
            case 0x96:
               name = "MEWTWO   ";
               break;
            case 0x97:
               name = "MEW      ";
               break;
            case 0x98:
               name = "CHIKORITA";
               break;
            case 0x99:
               name = "BAYLEAF  ";
               break;
            case 0x9A:
               name = "MEGANIUM ";
               break;
            case 0x9B:
               name = "CYNDAQUIL";
               break;
            case 0x9C:
               name = "QUILAVA  ";
               break;
            case 0x9D:
               name = "TYPHLOSON";
               break;
            case 0x9E:
               name = "TOTODILE ";
               break;
            case 0x9F:
               name = "CROCONAW ";
               break;
            case 0xA0:
               name = "FERALIGTR";
               break;
            case 0xA1:
               name = "SENTRET  ";
               break;
            case 0xA2:
               name = "FURRET   ";
               break;
            case 0xA3:
               name = "HOOTHOOT ";
               break;
            case 0xA4:
               name = "NOCTOWL  ";
               break;
            case 0xA5:
               name = "LEDYBA   ";
               break;
            case 0xA6:
               name = "LEDIAN   ";
               break;
            case 0xA7:
               name = "SPINARAK ";
               break;
            case 0xA8:
               name = "ARIADOS  ";
               break;
            case 0xA9:
               name = "CROBAT   ";
               break;
            case 0xAA:
               name = "CHINCHOU ";
               break;
            case 0xAB:
               name = "LANTURN  ";
               break;
            case 0xAC:
               name = "PICHU    ";
               break;
            case 0xAD:
               name = "CLEFFA   ";
               break;
            case 0xAE:
               name = "IGGLYBUFF";
               break;
            case 0xAF:
               name = "TOGEPI   ";
               break;
            case 0xB0:
               name = "TOGETIC  ";
               break;
            case 0xB1:
               name = "NATU     ";
               break;
            case 0xB2:
               name = "XATU     ";
               break;
            case 0xB3:
               name = "MAREEP   ";
               break;
            case 0xB4:
               name = "FLAAFFY  ";
               break;
            case 0xB5:
               name = "AMPHAROS ";
               break;
            case 0xB6:
               name = "BELLOSSOM";
               break;
            case 0xB7:
               name = "MARILL   ";
               break;
            case 0xB8:
               name = "AZUMARILL";
               break;
            case 0xB9:
               name = "SUDOWOODO";
               break;
            case 0xBA:
               name = "POLITOED ";
               break;
            case 0xBB:
               name = "HOPPIP   ";
               break;
            case 0xBC:
               name = "SKIPLOOM ";
               break;
            case 0xBD:
               name = "JUMPLUFF ";
               break;
            case 0xBE:
               name = "AIPOM    ";
               break;
            case 0xBF:
               name = "SUNKERN  ";
               break;
            case 0xC0:
               name = "SUNFLORA ";
               break;
            case 0xC1:
               name = "YANMA    ";
               break;
            case 0xC2:
               name = "WOOPER   ";
               break;
            case 0xC3:
               name = "QUAGSIRE ";
               break;
            case 0xC4:
               name = "ESPEON   ";
               break;
            case 0xC5:
               name = "UMBREON  ";
               break;
            case 0xC6:
               name = "MURKROW  ";
               break;
            case 0xC7:
               name = "SLOWKING ";
               break;
            case 0xC8:
               name = "MISDREAVS";
               break;
            case 0xC9:
               name = "UNOWN    ";
               break;
            case 0xCA:
               name = "WOBBUFFET";
               break;
            case 0xCB:
               name = "GIRAFARIG";
               break;
            case 0xCC:
               name = "PINECO   ";
               break;
            case 0xCD:
               name = "FORETRESS";
               break;
            case 0xCE:
               name = "DUNSPARCE";
               break;
            case 0xCF:
               name = "GLIGAR   ";
               break;
            case 0xD0:
               name = "STEELIX  ";
               break;
            case 0xD1:
               name = "SNUBBULL ";
               break;
            case 0xD2:
               name = "GRANBULL ";
               break;
            case 0xD3:
               name = "QWILFISH ";
               break;
            case 0xD4:
               name = "SCIZOR   ";
               break;
            case 0xD5:
               name = "CHUCKLES ";
               break;
            case 0xD6:
               name = "HERACROSS";
               break;
            case 0xD7:
               name = "SNEASEL  ";
               break;
            case 0xD8:
               name = "TEDDIURSA";
               break;
            case 0xD9:
               name = "URSARING ";
               break;
            case 0xDA:
               name = "SLUGMA   ";
               break;
            case 0xDB:
               name = "MAGCARGO ";
               break;
            case 0xDC:
               name = "SWINUB   ";
               break;
            case 0xDD:
               name = "PILOSWINE";
               break;
            case 0xDE:
               name = "CORSOLA  ";
               break;
            case 0xDF:
               name = "REMORAID ";
               break;
            case 0xE0:
               name = "OCTILLERY";
               break;
            case 0xE1:
               name = "DELIBIRD ";
               break;
            case 0xE2:
               name = "MANTINE  ";
               break;
            case 0xE3:
               name = "SKARMORY ";
               break;
            case 0xE4:
               name = "HOUNDOUR ";
               break;
            case 0xE5:
               name = "HOUNDOOM ";
               break;
            case 0xE6:
               name = "KINGDRA  ";
               break;
            case 0xE7:
               name = "PHANPY   ";
               break;
            case 0xE8:
               name = "DONPHAN  ";
               break;
            case 0xE9:
               name = "PORYGON2 ";
               break;
            case 0xEA:
               name = "STANTLER ";
               break;
            case 0xEB:
               name = "SMEARGLE ";
               break;
            case 0xEC:
               name = "TYROGUE  ";
               break;
            case 0xED:
               name = "HITMONTOP";
               break;
            case 0xEE:
               name = "SMOOCHUM ";
               break;
            case 0xEF:
               name = "ELEKID   ";
               break;
            case 0xF0:
               name = "MAGBY    ";
               break;
            case 0xF1:
               name = "MILTANK  ";
               break;
            case 0xF2:
               name = "BLISSEY  ";
               break;
            case 0xF3:
               name = "RAIKOU   ";
               break;
            case 0xF4:
               name = "ENTEI    ";
               break;
            case 0xF5:
               name = "SUICUNE  ";
               break;
            case 0xF6:
               name = "LARVITAR ";
               break;
            case 0xF7:
               name = "PUPITAR  ";
               break;
            case 0xF8:
               name = "TYRANITAR";
               break;
            case 0xF9:
               name = "LUGIA    ";
               break;
            case 0xFA:
               name = "HO-OH    ";
               break;
            case 0xFB:
               name = "CELEBI   ";
               break;
        }
        byte[] ret = new byte[9];
        for(int i = 0; i < 9; i++){
            ret[i] = convertChar(name.charAt(i));
        }
        return ret;
    }
    
    public byte[] getPokemonNameSize8(int pokemon){
        String name = "";
        switch(pokemon){
            case 0x01:
               name = "BLBASAUR";
               break;
            case 0x02:
               name = "IVYSAUR ";
               break;
            case 0x03:
               name = "VENUSAUR";
               break;
            case 0x04:
               name = "CHRMANDR";
               break;
            case 0x05:
               name = "CHARMELN";
               break;
            case 0x06:
               name = "CHARIZRD";
               break;
            case 0x07:
               name = "SQUIRTLE";
               break;
            case 0x08:
               name = "WARTRTLE";
               break;
            case 0x09:
               name = "BLSTOISE";
               break;
            case 0x0A:
               name = "CATERPIE";
               break;
            case 0x0B:
               name = "METAPOD ";
               break;
            case 0x0C:
               name = "BUTTRFRE";
               break;
            case 0x0D:
               name = "WEEDLE  ";
               break;
            case 0x0E:
               name = "KAKUNA  ";
               break;
            case 0x0F:
               name = "BEEDRILL";
               break;
            case 0x10:
               name = "PIDGEY  ";
               break;
            case 0x11:
               name = "PIDGEOTO";
               break;
            case 0x12:
               name = "PIDGEOT ";
               break;
            case 0x13:
               name = "RATATTA ";
               break;
            case 0x14:
               name = "RATICATE";
               break;
            case 0x15:
               name = "SPEAROW ";
               break;
            case 0x16:
               name = "FEAROW  ";
               break;
            case 0x17:
               name = "EKANS   ";
               break;
            case 0x18:
               name = "ARBOK   ";
               break;
            case 0x19:
               name = "PIKACHU ";
               break;
            case 0x1A:
               name = "RAICHU  ";
               break;
            case 0x1B:
               name = "SANDSHRW";
               break;
            case 0x1C:
               name = "SANDSLSH";
               break;
            case 0x1D:
               name = "NIDORANF";
               break;
            case 0x1E:
               name = "NIDORINA";
               break;
            case 0x1F:
               name = "NIDOQUEN";
               break;
            case 0x20:
               name = "NIDORANM";
               break;
            case 0x21:
               name = "NIDORINO";
               break;
            case 0x22:
               name = "NIDOKING";
               break;
            case 0x23:
               name = "CLEFAIRY";
               break;
            case 0x24:
               name = "CLEFABLE";
               break;
            case 0x25:
               name = "VULPIX  ";
               break;
            case 0x26:
               name = "NINTAILS";
               break;
            case 0x27:
               name = "JIGLYPUF";
               break;
            case 0x28:
               name = "WIGLYTUF";
               break;
            case 0x29:
               name = "ZUBAT   ";
               break;
            case 0x2A:
               name = "GOLBAT  ";
               break;
            case 0x2B:
               name = "ODDISH  ";
               break;
            case 0x2C:
               name = "GLOOM   ";
               break;
            case 0x2D:
               name = "VILEPLUM";
               break;
            case 0x2E:
               name = "PARAS   ";
               break;
            case 0x2F:
               name = "PARASECT";
               break;
            case 0x30:
               name = "VENONAT ";
               break;
            case 0x31:
               name = "VENOMOTH";
               break;
            case 0x32:
               name = "DIGLETT ";
               break;
            case 0x33:
               name = "DIGTRIO ";
               break;
            case 0x34:
               name = "MEOWTH  ";
               break;
            case 0x35:
               name = "PERSIAN ";
               break;
            case 0x36:
               name = "PSYDUCK ";
               break;
            case 0x37:
               name = "GOLDUCK ";
               break;
            case 0x38:
               name = "MANKEY  ";
               break;
            case 0x39:
               name = "PRIMEAPE";
               break;
            case 0x3A:
               name = "GROWLITH";
               break;
            case 0x3B:
               name = "ARCANINE";
               break;
            case 0x3C:
               name = "POLISWAG";
               break;
            case 0x3D:
               name = "POLIWIRL";
               break;
            case 0x3E:
               name = "POLIRATH";
               break;
            case 0x3F:
               name = "ABRA    ";
               break;
            case 0x40:
               name = "KADABRA ";
               break;
            case 0x41:
               name = "ALAKAZAM";
               break;
            case 0x42:
               name = "MACHOP  ";
               break;
            case 0x43:
               name = "MACHOKE ";
               break;
            case 0x44:
               name = "MACHAMP ";
               break;
            case 0x45:
               name = "BELSPROT";
               break;
            case 0x46:
               name = "WEEPNBEL";
               break;
            case 0x47:
               name = "VICTRBEL";
               break;
            case 0x48:
               name = "TENTACOL";
               break;
            case 0x49:
               name = "TNTACRUL";
               break;
            case 0x4A:
               name = "GEODUDE ";
               break;
            case 0x4B:
               name = "GRAVELER";
               break;
            case 0x4C:
               name = "GOLEM   ";
               break;
            case 0x4D:
               name = "PONYTA  ";
               break;
            case 0x4E:
               name = "RAPIDASH";
               break;
            case 0x4F:
               name = "SLOWPOKE";
               break;
            case 0x50:
               name = "SLOWBRO ";
               break;
            case 0x51:
               name = "MAGNMITE";
               break;
            case 0x52:
               name = "MAGNETON";
               break;
            case 0x53:
               name = "FRFETCHD";
               break;
            case 0x54:
               name = "DODUO   ";
               break;
            case 0x55:
               name = "DODRIO  ";
               break;
            case 0x56:
               name = "SEEL    ";
               break;
            case 0x57:
               name = "DEWGONG ";
               break;
            case 0x58:
               name = "GRIMER  ";
               break;
            case 0x59:
               name = "ANEESMUK";
               break;
            case 0x5A:
               name = "SHELLDER";
               break;
            case 0x5B:
               name = "CLOYSTER";
               break;
            case 0x5C:
               name = "GASTLY  ";
               break;
            case 0x5D:
               name = "HAUNTER ";
               break;
            case 0x5E:
               name = "GENGAR  ";
               break;
            case 0x5F:
               name = "ONIX    ";
               break;
            case 0x60:
               name = "DROWZEE ";
               break;
            case 0x61:
               name = "HYPNO   ";
               break;
            case 0x62:
               name = "KRABBY  ";
               break;
            case 0x63:
               name = "KINGLER ";
               break;
            case 0x64:
               name = "VOLTORB ";
               break;
            case 0x65:
               name = "ELCTRODE";
               break;
            case 0x66:
               name = "EXEGCUTE";
               break;
            case 0x67:
               name = "EXEGUTOR";
               break;
            case 0x68:
               name = "CUBONE  ";
               break;
            case 0x69:
               name = "MAROWAK ";
               break;
            case 0x6A:
               name = "HOTMONLE";
               break;
            case 0x6B:
               name = "HITMNCHN";
               break;
            case 0x6C:
               name = "LICKTUNG";
               break;
            case 0x6D:
               name = "KOFFING ";
               break;
            case 0x6E:
               name = "WEEZING ";
               break;
            case 0x6F:
               name = "RHYHORN ";
               break;
            case 0x70:
               name = "RHYDON  ";
               break;
            case 0x71:
               name = "CHANSEY ";
               break;
            case 0x72:
               name = "TANGELA ";
               break;
            case 0x73:
               name = "KANGSKAN";
               break;
            case 0x74:
               name = "HORSEA  ";
               break;
            case 0x75:
               name = "SEADRA  ";
               break;
            case 0x76:
               name = "GOLDEEN ";
               break;
            case 0x77:
               name = "SEAKING ";
               break;
            case 0x78:
               name = "STARYU  ";
               break;
            case 0x79:
               name = "STARMIE ";
               break;
            case 0x7A:
               name = "MR MIME ";
               break;
            case 0x7B:
               name = "SCYTHER ";
               break;
            case 0x7C:
               name = "JYNX    ";
               break;
            case 0x7D:
               name = "ELECTBUZ";
               break;
            case 0x7E:
               name = "MAGMAR  ";
               break;
            case 0x7F:
               name = "PINSIR  ";
               break;
            case 0x80:
               name = "TAUROS  ";
               break;
            case 0x81:
               name = "MAGIKARP";
               break;
            case 0x82:
               name = "GYARADOS";
               break;
            case 0x83:
               name = "LAPRAS  ";
               break;
            case 0x84:
               name = "DITTO   ";
               break;
            case 0x85:
               name = "EEVEE   ";
               break;
            case 0x86:
               name = "VAPOREON";
               break;
            case 0x87:
               name = "JOLTEON ";
               break;
            case 0x88:
               name = "FLAREON ";
               break;
            case 0x89:
               name = "PORYGON ";
               break;
            case 0x8A:
               name = "OMANYTE ";
               break;
            case 0x8B:
               name = "OMASTAR ";
               break;
            case 0x8C:
               name = "KABUTO  ";
               break;
            case 0x8D:
               name = "KABUTOPS";
               break;
            case 0x8E:
               name = "ARODACTL";
               break;
            case 0x8F:
               name = "SNORLAX ";
               break;
            case 0x90:
               name = "ARTICUNO";
               break;
            case 0x91:
               name = "ZAPDOS  ";
               break;
            case 0x92:
               name = "MOLTRES ";
               break;
            case 0x93:
               name = "DRATINI ";
               break;
            case 0x94:
               name = "DRAGNAIR";
               break;
            case 0x95:
               name = "DRAGNITE";
               break;
            case 0x96:
               name = "MEWTWO  ";
               break;
            case 0x97:
               name = "MEW     ";
               break;
            case 0x98:
               name = "CHIKRITA";
               break;
            case 0x99:
               name = "BAYLEAF ";
               break;
            case 0x9A:
               name = "MEGANIUM";
               break;
            case 0x9B:
               name = "CYNDQUIL";
               break;
            case 0x9C:
               name = "QUILAVA ";
               break;
            case 0x9D:
               name = "TYPLOSON";
               break;
            case 0x9E:
               name = "TOTODILE";
               break;
            case 0x9F:
               name = "CROCONAW";
               break;
            case 0xA0:
               name = "FERLIGTR";
               break;
            case 0xA1:
               name = "SENTRET ";
               break;
            case 0xA2:
               name = "FURRET  ";
               break;
            case 0xA3:
               name = "HOOTHOOT";
               break;
            case 0xA4:
               name = "NOCTOWL ";
               break;
            case 0xA5:
               name = "LEDYBA  ";
               break;
            case 0xA6:
               name = "LEDIAN  ";
               break;
            case 0xA7:
               name = "SPINARAK";
               break;
            case 0xA8:
               name = "ARIADOS ";
               break;
            case 0xA9:
               name = "CROBAT  ";
               break;
            case 0xAA:
               name = "CHINCHOU";
               break;
            case 0xAB:
               name = "LANTURN ";
               break;
            case 0xAC:
               name = "PICHU   ";
               break;
            case 0xAD:
               name = "CLEFFA  ";
               break;
            case 0xAE:
               name = "IGGLYBUF";
               break;
            case 0xAF:
               name = "TOGEPI  ";
               break;
            case 0xB0:
               name = "TOGETIC ";
               break;
            case 0xB1:
               name = "NATU    ";
               break;
            case 0xB2:
               name = "XATU    ";
               break;
            case 0xB3:
               name = "MAREEP  ";
               break;
            case 0xB4:
               name = "FLAAFFY ";
               break;
            case 0xB5:
               name = "AMPHAROS";
               break;
            case 0xB6:
               name = "BELOSSOM";
               break;
            case 0xB7:
               name = "MARILL  ";
               break;
            case 0xB8:
               name = "AZUMARIL";
               break;
            case 0xB9:
               name = "SUDOWODO";
               break;
            case 0xBA:
               name = "POLITOED";
               break;
            case 0xBB:
               name = "HOPPIP  ";
               break;
            case 0xBC:
               name = "SKIPLOOM";
               break;
            case 0xBD:
               name = "JUMPLUFF";
               break;
            case 0xBE:
               name = "AIPOM   ";
               break;
            case 0xBF:
               name = "SUNKERN ";
               break;
            case 0xC0:
               name = "SUNFLORA";
               break;
            case 0xC1:
               name = "YANMA   ";
               break;
            case 0xC2:
               name = "WOOPER  ";
               break;
            case 0xC3:
               name = "QUAGSIRE";
               break;
            case 0xC4:
               name = "ESPEON  ";
               break;
            case 0xC5:
               name = "UMBREON ";
               break;
            case 0xC6:
               name = "MURKROW ";
               break;
            case 0xC7:
               name = "SLOWKING";
               break;
            case 0xC8:
               name = "MSDREAVS";
               break;
            case 0xC9:
               name = "UNOWN   ";
               break;
            case 0xCA:
               name = "WOBBUFET";
               break;
            case 0xCB:
               name = "GIRAFRIG";
               break;
            case 0xCC:
               name = "PINECO  ";
               break;
            case 0xCD:
               name = "FORETRES";
               break;
            case 0xCE:
               name = "DUNSPRCE";
               break;
            case 0xCF:
               name = "GLIGAR  ";
               break;
            case 0xD0:
               name = "STEELIX ";
               break;
            case 0xD1:
               name = "SNUBBULL";
               break;
            case 0xD2:
               name = "GRANBULL";
               break;
            case 0xD3:
               name = "QWILFISH";
               break;
            case 0xD4:
               name = "SCIZOR  ";
               break;
            case 0xD5:
               name = "CHUCKLES";
               break;
            case 0xD6:
               name = "HERACROS";
               break;
            case 0xD7:
               name = "SNEASEL ";
               break;
            case 0xD8:
               name = "TEDIURSA";
               break;
            case 0xD9:
               name = "URSARING";
               break;
            case 0xDA:
               name = "SLUGMA  ";
               break;
            case 0xDB:
               name = "MAGCARGO";
               break;
            case 0xDC:
               name = "SWINUB  ";
               break;
            case 0xDD:
               name = "PILSWINE";
               break;
            case 0xDE:
               name = "CORSOLA ";
               break;
            case 0xDF:
               name = "REMORAID";
               break;
            case 0xE0:
               name = "OCTILERY";
               break;
            case 0xE1:
               name = "DELIBIRD";
               break;
            case 0xE2:
               name = "MANTINE ";
               break;
            case 0xE3:
               name = "SKARMORY";
               break;
            case 0xE4:
               name = "HOUNDOUR";
               break;
            case 0xE5:
               name = "HOUNDOOM";
               break;
            case 0xE6:
               name = "KINGDRA ";
               break;
            case 0xE7:
               name = "PHANPY  ";
               break;
            case 0xE8:
               name = "DONPHAN ";
               break;
            case 0xE9:
               name = "PORYGON2";
               break;
            case 0xEA:
               name = "STANTLER";
               break;
            case 0xEB:
               name = "SMEARGLE";
               break;
            case 0xEC:
               name = "TYROGUE ";
               break;
            case 0xED:
               name = "HITMNTOP";
               break;
            case 0xEE:
               name = "SMOOCHUM";
               break;
            case 0xEF:
               name = "ELEKID  ";
               break;
            case 0xF0:
               name = "MAGBY   ";
               break;
            case 0xF1:
               name = "MILTANK ";
               break;
            case 0xF2:
               name = "BLISSEY ";
               break;
            case 0xF3:
               name = "RAIKOU  ";
               break;
            case 0xF4:
               name = "ENTEI   ";
               break;
            case 0xF5:
               name = "SUICUNE ";
               break;
            case 0xF6:
               name = "LARVITAR";
               break;
            case 0xF7:
               name = "PUPITAR ";
               break;
            case 0xF8:
               name = "TYRNITAR";
               break;
            case 0xF9:
               name = "LUGIA   ";
               break;
            case 0xFA:
               name = "HO-OH   ";
               break;
            case 0xFB:
               name = "CELEBI  ";
               break;
        }
        byte[] ret = new byte[8];
        for(int i = 0; i < 8; i++){
            ret[i] = convertChar(name.charAt(i));
        }
        return ret;
    }
    
    private byte convertChar(char a){
        switch(a){
            case '#':
                return(byte) 0x57;
            case '*':
                return(byte) 0x51;
            case '+':
                return(byte) 0x55;
            case '$':
                return(byte) 0x58;
            case 'A':
                return(byte) 0x80;
            case 'B':
                return(byte) 0x81;
            case 'C':
                return(byte) 0x82;
            case 'D':
                return(byte) 0x83;
            case 'E':
                return(byte) 0x84;
            case 'F':
                return(byte) 0x85;
            case 'G':
                return(byte) 0x86;
            case 'H':
                return(byte) 0x87;
            case 'I':
                return(byte) 0x88;
            case 'J':
                return(byte) 0x89;
            case 'K':
                return(byte) 0x8A;
            case 'L':
                return(byte) 0x8B;
            case 'M':
                return(byte) 0x8C;
            case 'N':
                return(byte) 0x8D;
            case 'O':
                return(byte) 0x8E;
            case 'P':
                return(byte) 0x8F;
            case 'Q':
                return(byte) 0x90;
            case 'R':
                return(byte) 0x91;
            case 'S':
                return(byte) 0x92;
            case 'T':
                return(byte) 0x93;
            case 'U':
                return(byte) 0x94;
            case 'V':
                return(byte) 0x95;
            case 'W':
                return(byte) 0x96;
            case 'X':
                return(byte) 0x97;
            case 'Y':
                return (byte) 0x98;
            case 'Z':
                return (byte) 0x99;
            case ':':
                return (byte) 0x9C;
            case 'a':
                return (byte) 0xA0;
            case 'b':
                return (byte) 0xA1;
            case 'c':
                return (byte) 0xA2;
            case 'd':
                return (byte) 0xA3;
            case 'e':
                return (byte) 0xA4;
            case 'f':
                return (byte) 0xA5;
            case 'g':
                return (byte) 0xA6;
            case 'h':
                return (byte) 0xA7;
            case 'i':
                return (byte) 0xA8;
            case 'j':
                return (byte) 0xA9;
            case 'k':
                return (byte) 0xAA;
            case 'l':
                return (byte) 0xAB;
            case 'm':
                return (byte) 0xAC;
            case 'n':
                return (byte) 0xAD;
            case 'o':
                return (byte) 0xAE;
            case 'p':
                return (byte) 0xAF;
            case 'q':
                return (byte) 0xB0;
            case 'r':
                return (byte) 0xB1;
            case 's':
                return (byte) 0xB2;
            case 't':
                return (byte) 0xB3;
            case 'u':
                return (byte) 0xB4;
            case 'v':
                return (byte) 0xB5;
            case 'w':
                return (byte) 0xB6;
            case 'x':
                return (byte) 0xB7;
            case 'y':
                return (byte) 0xB8;
            case 'z':
                return (byte) 0xB9;
            case ',':
                return (byte) 0xBA;
            case '\'':
                return (byte) 0xE0;
            case '[':
                return (byte) 0xE1;
            case ']':
                return (byte) 0xE2;
            case '-':
                return (byte) 0xE3;
            case '?':
                return (byte) 0xE6;
            case '!':
                return (byte) 0xE7;
            case '.':
                return (byte) 0xE8;
            case '0':
                return (byte) 0xF6;
            case '1':
                return (byte) 0xF7;
            case '2':
                return (byte) 0xF8;
            case '3':
                return (byte) 0xF9;
            case '4':
                return (byte) 0xFA;
            case '5':
                return (byte) 0xFB;
            case '6':
                return (byte) 0xFC;
            case '7':
                return (byte) 0xFD;
            case '8':
                return (byte) 0xFE;
            case '9':
                return (byte) 0xFF;
        }
        return (byte) 0x7F;
    }
}
