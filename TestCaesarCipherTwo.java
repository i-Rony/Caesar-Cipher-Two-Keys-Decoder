import edu.duke.*;

public class TestCaesarCipherTwo {

    public String halfOfString(String message, int start) {
        String answer = "";
        for (int i = start; i < message.length(); i += 2) {
            answer = answer + message.charAt(i);
        }
        return answer;

    }

    public int[] countLetters(String message) {
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int k = 0; k < message.length(); k++) {
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if (dex != -1) {
                counts[dex] += 1;
            }
        }
        return counts;
    }

    public int maxIndex(int[] values) {
        int index = 0;
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
                index = i;
            }
        }
        return index;
    }


    public String breakCaesarCipher(String input) {
        String messageF = halfOfString(input, 0);
        String messageS = halfOfString(input, 1);

        int[] freqs1 = countLetters(messageF);
        int maxDex1 = maxIndex(freqs1);
        int dkey1 = maxDex1 - 4;
        if (maxDex1 < 4) {
            dkey1 = 26 - (4 - maxDex1);
        }

        int[] freqs2 = countLetters(messageS);
        int maxDex2 = maxIndex(freqs2);
        int dkey2 = maxDex2 - 4;
        if (maxDex2 < 4) {
            dkey1 = 26 - (4 - maxDex2);
        }

        CaesarCipherTwo cc = new CaesarCipherTwo(dkey1, dkey2);
        System.out.println(dkey1 + " " + dkey2);
        return cc.decrypt(input);
    }

    public void simpleTests() {
        FileResource resource = new FileResource();
        CaesarCipherTwo cc = new CaesarCipherTwo(17,3);
        String message = resource.asString();
        String encryptMessage = cc.encrypt(message);
        System.out.println(encryptMessage + "\n" + cc.decrypt(encryptMessage));
        String decryptMessage = this.breakCaesarCipher(encryptMessage);
        System.out.println(decryptMessage);
        
    }
}