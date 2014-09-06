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
public class Poke_Generator {
    int lastSafePoke = 0xFB;
    Random random;
    
    
    public Poke_Generator(){
        random = new Random();
    }
    
    public int insertPoke(){
        int d = random.nextInt(lastSafePoke)+1;
        return d;
    }
    public int evolvePokemon(int pokemon, int level){
        int ret = pokemon;
        switch(pokemon){
            case 0x01:
                if(level >= 16){
                    ret = 0x02;
                }
                if(level >= 32){
                    ret = 0x03;
                }
               break;
            case 0x02:
               if(level >= 32){
                    ret = 0x03;
                }
               break;
            case 0x03:
               ret = 0x03;
               break;
            case 0x04:
               if(level >= 16){
                    ret = 0x05;
                }
               if(level >= 36){
                    ret = 0x06;
                }
               break;
            case 0x05:
               if(level >= 36){
                    ret = 0x06;
                }
               break;
            case 0x06:
               ret = 0x06;
               break;
            case 0x07:
               if(level >= 16){
                    ret = 0x08;
                }
               if(level >= 36){
                    ret = 0x09;
                }
               break;
            case 0x08:
               if(level >= 36){
                    ret = 0x09;
                }
               break;
            case 0x09:
               ret = 0x09;
               break;
            case 0x0A:
               if(level >= 7){
                    ret = 0x0B;
                }
               if(level >= 10){
                    ret = 0x0C;
                }
               break;
            case 0x0B:
               if(level >= 10){
                    ret = 0x0C;
                }
               break;
            case 0x0C:
               ret = 0x0C;
               break;
            case 0x0D:
               if(level >= 7){
                    ret = 0x0E;
                }
               if(level >= 10){
                    ret = 0x0F;
                }
               break;
            case 0x0E:
               if(level >= 10){
                    ret = 0x0F;
                }
               break;
            case 0x0F:
               ret = 0x0F;
               break;
            case 0x10:
               if(level >= 18){
                    ret = 0x11;
                }
               if(level >= 36){
                    ret = 0x12;
                }
               break;
            case 0x11:
               if(level >= 36){
                    ret = 0x12;
                }
               break;
            case 0x12:
               ret = 0x12;;
               break;
            case 0x13:
               if(level >= 20){
                    ret = 0x14;
                }
               break;
            case 0x14:
               ret = 0x14;
               break;
            case 0x15:
               if(level >= 20){
                    ret = 0x16;
                }
               break;
            case 0x16:
               ret = 0x16;
               break;
            case 0x17:
               if(level >= 22){
                    ret = 0x18;
                }
               break;
            case 0x18:
               ret = 0x18;
               break;
            case 0x19:
               if(level >= 40){
                    ret = 0x1A;
                }
               break;
            case 0x1A:
               ret = 0x1A;
               break;
            case 0x1B:
               if(level >= 22){
                    ret = 0x1C;
                }
               break;
            case 0x1C:
               ret = 0x1C;
               break;
            case 0x1D:
               if(level >= 16){
                    ret = 0x1E;
                }
               if(level >= 40){
                    ret = 0x1F;
                }
               break;
            case 0x1E:
               if(level >= 40){
                    ret = 0x1F;
                }
               break;
            case 0x1F:
               ret = 0x1F;
               break;
            case 0x20:
               if(level >= 16){
                    ret = 0x21;
                }
               if(level >= 40){
                    ret = 0x22;
                }
               break;
            case 0x21:
               if(level >= 40){
                    ret = 0x22;
                }
               break;
            case 0x22:
               ret = 0x22;
               break;
            case 0x23:
               if(level >= 40){
                    ret = 0x24;
                }
               break;
            case 0x24:
               ret = 0x24;;
               break;
            case 0x25:
               if(level >= 35){
                    ret = 0x26;
                }
               break;
            case 0x26:
               ret = 0x26;
               break;
            case 0x27:
               if(level >= 35){
                    ret = 0x28;
                }
               break;
            case 0x28:
               ret = 0x28;
               break;
            case 0x29:
               if(level >= 22){
                    ret = 0x2A;
                }
               if(level >= 40){
                    ret = 0xA9;
                }
               break;
            case 0x2A:
               if(level >= 40){
                    ret = 0xA9;
                }
               break;
            case 0x2B:
               if(level >= 21){
                    ret = 0x2C;
                }
               if(level >= 35){
                    ret = 0x2D;
                }
               break;
            case 0x2C:
               if(level >= 35){
                    ret = 0x2D;
                }
               break;
            case 0x2D:
               ret = 0x2D;
               break;
            case 0x2E:
               if(level >= 24){
                    ret = 0x2F;
                }
               break;
            case 0x2F:
               ret = 0x2F;
               break;
            case 0x30:
               if(level >= 31){
                    ret = 0x31;
                }
               break;
            case 0x31:
               ret = 0x31;
               break;
            case 0x32:
               if(level >= 26){
                    ret = 0x33;
               }
               break;
            case 0x33:
               ret = 0x33;
               break;
            case 0x34:
               if(level >= 28){
                    ret = 0x35;
               }
               break;
            case 0x35:
               ret = 0x35;
               break;
            case 0x36:
               if(level >= 33){
                    ret = 0x37;
               }
               break;
            case 0x37:
               ret = 0x37;
               break;
            case 0x38:
               if(level >= 28){
                    ret = 0x39;
               }
               break;
            case 0x39:
               ret = 0x39;
               break;
            case 0x3A:
               if(level >= 28){
                    ret = 0x3B;
               }
               break;
            case 0x3B:
               ret = 0x3B;
               break;
            case 0x3C:
               if(level >= 25){
                    ret = 0x3D;
                }
               if(level >= 35){
                    ret = 0x3E;
                }
               break;
            case 0x3D:
               if(level >= 35){
                    ret = 0x3E;
                }
               break;
            case 0x3E:
               ret = 0x3E;
               break;
            case 0x3F:
               if(level >= 16){
                    ret = 0x40;
                }
               if(level >= 40){
                    ret = 0x41;
                }
               break;
            case 0x40:
               if(level >= 40){
                    ret = 0x41;
                }
               break;
            case 0x41:
               ret = 0x41;
               break;
            case 0x42:
               if(level >= 28){
                    ret = 0x43;
                }
               if(level >= 40){
                    ret = 0x44;
                }
               break;
            case 0x43:
               if(level >= 40){
                    ret = 0x44;
                }
               break;
            case 0x44:
               ret = 0x44;
               break;
            case 0x45:
               if(level >= 21){
                    ret = 0x46;
                }
               if(level >= 35){
                    ret = 0x47;
                }
               break;
            case 0x46:
               if(level >= 35){
                    ret = 0x47;
                }
               break;
            case 0x47:
               ret = 0x47;
               break;
            case 0x48:
               if(level >= 30){
                   ret = 0x49;
               }
               break;
            case 0x49:
               ret = 0x49;
               break;
            case 0x4A:
               if(level >= 25){
                    ret = 0x4B;
                }
               if(level >= 40){
                    ret = 0x4C;
                }
               break;
            case 0x4B:
               if(level >= 40){
                    ret = 0x4C;
                }
               break;
            case 0x4C:
               ret = 0x4C;
               break;
            case 0x4D:
               if(level >= 40){
                    ret = 0x4E;
               }
               break;
            case 0x4E:
               ret = 0x4E;
               break;
            case 0x4F:
               if(level >= 37){
                    ret = 0x50;
               }
               break;
            case 0x50:
               ret = 0x50;
               break;
            case 0x51:
               if(level >= 30){
                    ret = 0x52;
               }
               break;
            case 0x52:
               ret = 0x52;
               break;
            case 0x53:
               ret = 0x53;
               break;
            case 0x54:
               if(level >= 31){
                    ret = 0x55;
               }
               break;
            case 0x55:
               ret = 0x55;
               break;
            case 0x56:
               if(level >= 34){
                    ret = 0x57;
               }
               break;
            case 0x57:
               ret = 0x57;
               break;
            case 0x58:
               if(level >= 38){
                    ret = 0x59;
               }
               break;
            case 0x59:
               ret = 0x59;
               break;
            case 0x5A:
               if(level >= 35){
                    ret = 0x5B;
               }
               break;
            case 0x5B:
               ret = 0x5B;
               break;
            case 0x5C:
               if(level >= 25){
                    ret = 0x5D;
                }
                if(level >= 40){
                    ret = 0x5E;
                }
               break;
            case 0x5D:
               if(level >= 40){
                    ret = 0x5E;
                }
               break;
            case 0x5E:
               ret = 0x5E;
               break;
            case 0x5F:
               if(level >= 40){
                    ret = 0xD0;
                }
               break;
            case 0x60:
               if(level >= 26){
                    ret = 0x61;
                }
               break;
            case 0x61:
               ret = 0x61;
               break;
            case 0x62:
               if(level >= 28){
                    ret = 0x63;
                }
               break;
            case 0x63:
               ret = 0x63;
               break;
            case 0x64:
               if(level >= 30){
                    ret = 0x65;
                }
               break;
            case 0x65:
               ret = 0x65;
               break;
            case 0x66:
               if(level >= 35){
                    ret = 0x67;
                }
               break;
            case 0x67:
               ret = 0x67;
               break;
            case 0x68:
               if(level >= 28){
                    ret = 0x69;
                }
               break;
            case 0x69:
               ret = 0x69;
               break;
            case 0x6A:
               ret = 0x6A;
               break;
            case 0x6B:
               ret = 0x6B;
               break;
            case 0x6C:
               ret = 0x6C;
               break;
            case 0x6D:
               if(level >= 28){
                    ret = 0x6E;
                }
               break;
            case 0x6E:
               ret = 0x6E;
               break;
            case 0x6F:
               if(level >= 42){
                    ret = 0x70;
                }
               break;
            case 0x70:
               ret = 0x70;
               break;
            case 0x71:
               if(level >= 35){
                    ret = 0xF2;
               }
               break;
            case 0x72:
               ret = 0x72;
               break;
            case 0x73:
               ret = 0x73;
               break;
            case 0x74:
               if(level >= 32){
                    ret = 0x75;
                }
               if(level >= 40){
                    ret = 0xE6;
                }
               break;
            case 0x75:
               if(level >= 40){
                    ret = 0xE6;
                }
               break;
            case 0x76:
               if(level >= 33){
                    ret = 0x77;
                }
               break;
            case 0x77:
               ret = 0x77;
               break;
            case 0x78:
               if(level >= 35){
                    ret = 0x79;
                }
               break;
            case 0x79:
               ret = 0x79;
               break;
            case 0x7A:
               ret = 0x7A;
               break;
            case 0x7B:
               if(level >= 40){
                    ret = 0xD4;
                }
               break;
            case 0x7C:
               ret = 0x7C;
               break;
            case 0x7D:
               ret = 0x7D;
               break;
            case 0x7E:
               ret = 0x7E;
               break;
            case 0x7F:
               ret = 0x7F;
               break;
            case 0x80:
               ret = 0x80;
               break;
            case 0x81:
               if(level >= 20){
                    ret = 0x82;
                }
               break;
            case 0x82:
               ret = 0x82;
               break;
            case 0x83:
               ret = 0x83;
               break;
            case 0x84:
               ret = 0x84;
               break;
            case 0x85:
               ret = 0x85;
               break;
            case 0x86:
               ret = 0x86;
               break;
            case 0x87:
               ret = 0x87;
               break;
            case 0x88:
               ret = 0x88;
               break;
            case 0x89:
               if(level >= 40){
                    ret = 0xE9;
               }
               break;
            case 0x8A:
               if(level >= 40){
                    ret = 0x8B;
               }
               break;
            case 0x8B:
               ret = 0x8B;
               break;
            case 0x8C:
               if(level >= 40){
                    ret = 0x8D;
               }
               break;
            case 0x8D:
               ret = 0x8D;
               break;
            case 0x8E:
               ret = 0x8E;
               break;
            case 0x8F:
               ret = 0x8F;
               break;
            case 0x90:
               ret = 0x90;
               break;
            case 0x91:
               ret = 0x91;
               break;
            case 0x92:
               ret = 0x92;
               break;
            case 0x93:
               if(level >= 30){
                    ret = 0x94;
               }
               if(level >= 40){
                    ret = 0x95;
               }
               break;
            case 0x94:
               if(level >= 40){
                    ret = 0x95;
               }
               break;
            case 0x95:
               ret = 0x95;
               break;
            case 0x96:
               ret = 0x96;
               break;
            case 0x97:
               ret = 0x97;
               break;
            case 0x98:
               if(level >= 16){
                    ret = 0x99;
               }
               if(level >= 32){
                    ret = 0x9A;
               }
               break;
            case 0x99:
               if(level >= 32){
                    ret = 0x9A;
               }
               break;
            case 0x9A:
               ret = 0x9A;
               break;
            case 0x9B:
               if(level >= 14){
                    ret = 0x9C;
               }
               if(level >= 36){
                    ret = 0x9D;
               }
               break;
            case 0x9C:
               if(level >= 36){
                    ret = 0x9D;
               }
               break;
            case 0x9D:
               ret = 0x9D;
               break;
            case 0x9E:
               if(level >= 18){
                    ret = 0x9F;
               }
               if(level >= 30){
                    ret = 0xA0;
               }
               break;
            case 0x9F:
               if(level >= 30){
                    ret = 0xA0;
               }
               break;
            case 0xA0:
               ret = 0xA0;
               break;
            case 0xA1:
               if(level >= 15){
                    ret = 0xA2;
               }
               break;
            case 0xA2:
               ret = 0xA2;
               break;
            case 0xA3:
               if(level >= 20){
                    ret = 0xA4;
               }
               break;
            case 0xA4:
               ret = 0xA4;
               break;
            case 0xA5:
               if(level >= 18){
                    ret = 0xA6;
               }
               break;
            case 0xA6:
               ret = 0xA6;
               break;
            case 0xA7:
               if(level >= 22){
                    ret = 0xA8;
               }
               break;
            case 0xA8:
               ret = 0xA8;
               break;
            case 0xA9:
               ret = 0xA9;
               break;
            case 0xAA:
               if(level >= 27){
                    ret = 0xAB;
               }
               break;
            case 0xAB:
               ret = 0xAB;
               break;
            case 0xAC:
               if(level >= 20){
                    ret = 0x19;
               }
               break;
            case 0xAD:
               if(level >= 20){
                    ret = 0x23;
               }
               break;
            case 0xAE:
               if(level >= 20){
                    ret = 0x27;
               }
               break;
            case 0xAF:
               if(level >= 35){
                    ret = 0xB0;
               }
               break;
            case 0xB0:
               ret = 0xB0;
               break;
            case 0xB1:
               if(level >= 25){
                    ret = 0xB2;
               }
               break;
            case 0xB2:
               ret = 0xB2;
               break;
            case 0xB3:
               if(level >= 15){
                    ret = 0xB4;
               }
               if(level >= 30){
                    ret = 0xB5;
               }
               break;
            case 0xB4:
               if(level >= 30){
                    ret = 0xB5;
               }
               break;
            case 0xB5:
               ret = 0xB5;
               break;
            case 0xB6:
               ret = 0xB6;
               break;
            case 0xB7:
               if(level >= 18){
                    ret = 0xB8;
               }
               break;
            case 0xB8:
               ret = 0xB8;
               break;
            case 0xB9:
               ret = 0xB9;
               break;
            case 0xBA:
               ret = 0xBA;
               break;
            case 0xBB:
               if(level >= 18){
                    ret = 0xBC;
               }
               if(level >= 27){
                    ret = 0xBD;
               }
               break;
            case 0xBC:
               if(level >= 27){
                    ret = 0xBD;
               }
               break;
            case 0xBD:
               ret = 0xBD;
               break;
            case 0xBE:
               ret = 0xBE;
               break;
            case 0xBF:
               if(level >= 35){
                    ret = 0xC0;
               }
               break;
            case 0xC0:
               ret = 0xC0;
               break;
            case 0xC1:
               ret = 0xC1;
               break;
            case 0xC2:
               if(level >= 20){
                    ret = 0xC3;
               }
               break;
            case 0xC3:
               ret = 0xC3;
               break;
            case 0xC4:
               ret = 0xC4;
               break;
            case 0xC5:
               ret = 0xC5;
               break;
            case 0xC6:
               ret = 0xC6;
               break;
            case 0xC7:
               ret = 0xC7;
               break;
            case 0xC8:
               ret = 0xC8;
               break;
            case 0xC9:
               ret = 0xC9;
               break;
            case 0xCA:
               ret = 0xCA;
               break;
            case 0xCB:
               ret = 0xCB;
               break;
            case 0xCC:
               if(level >= 31){
                    ret = 0xCD;
               }
               break;
            case 0xCD:
               ret = 0xCD;
               break;
            case 0xCE:
               ret = 0xCE;
               break;
            case 0xCF:
               ret = 0xCF;
               break;
            case 0xD0:
               ret = 0xD0;
               break;
            case 0xD1:
               if(level >= 23){
                    ret = 0xD2;
               }
               break;
            case 0xD2:
               ret = 0xD2;
               break;
            case 0xD3:
               ret = 0xD3;
               break;
            case 0xD4:
               ret = 0xD4;
               break;
            case 0xD5:
               ret = 0xD5;
               break;
            case 0xD6:
               ret = 0xD6;
               break;
            case 0xD7:
               ret = 0xD7;
               break;
            case 0xD8:
               if(level >= 30){
                    ret = 0xD9;
               }
               break;
            case 0xD9:
               ret = 0xD9;
               break;
            case 0xDA:
               if(level >= 38){
                    ret = 0xDB;
               }
               break;
            case 0xDB:
               ret = 0xDB;
               break;
            case 0xDC:
               if(level >= 33){
                    ret = 0xDD;
               }
               break;
            case 0xDD:
               ret = 0xDD;
               break;
            case 0xDE:
               ret = 0xDE;
               break;
            case 0xDF:
               if(level >= 25){
                    ret = 0xE0;
               }
               break;
            case 0xE0:
               ret = 0xE0;
               break;
            case 0xE1:
               ret = 0xE1;
               break;
            case 0xE2:
               ret = 0xE2;
               break;
            case 0xE3:
               ret = 0xE3;
               break;
            case 0xE4:
               if(level >= 24){
                    ret = 0xE5;
               }
               break;
            case 0xE5:
               ret = 0xE5;
               break;
            case 0xE6:
               ret = 0xE6;
               break;
            case 0xE7:
               if(level >= 24){
                    ret = 0xE8;
               }
               break;
            case 0xE8:
               ret = 0xE8;
               break;
            case 0xE9:
               ret = 0xE9;
               break;
            case 0xEA:
               ret = 0xEA;
               break;
            case 0xEB:
               ret = 0xEB;
               break;
            case 0xEC:
               if(level >= 20){
                    ret = 0xED;
               }
               break;
            case 0xED:
               ret = 0xED;
               break;
            case 0xEE:
               if(level >= 20){
                    ret = 0x7C;
               }
               break;
            case 0xEF:
               if(level >= 20){
                    ret = 0x7D;
               }
               break;
            case 0xF0:
               if(level >= 20){
                    ret = 0x7E;
               }
               break;
            case 0xF1:
               ret = 0xF1;
               break;
            case 0xF2:
               ret = 0xF2;
               break;
            case 0xF3:
               ret = 0xF3;
               break;
            case 0xF4:
               ret = 0xF4;
               break;
            case 0xF5:
               ret = 0xF5;
               break;
            case 0xF6:
               if(level >= 30){
                    ret = 0xF7;
               }
               if(level >= 45){
                    ret = 0xF8;
               }
               break;
            case 0xF7:
               if(level >= 45){
                    ret = 0xF8;
               }
               break;
            case 0xF8:
               ret = 0xF8;
               break;
            case 0xF9:
               ret = 0xF9;
               break;
            case 0xFA:
               ret = 0xFA;
               break;
            case 0xFB:
               ret = 0xFB;
               break;
        }
        return ret;
    }
}
