public class CaesarCipherTwo {

    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;


    public CaesarCipherTwo(int key1, int key2) {
        this.alphabet = "abcdefghijklmnopqrstuvwxyz";
        this.shiftedAlphabet1 = this.alphabet.substring(key1) +
                this.alphabet.substring(0, key1);
        this.shiftedAlphabet2 = this.alphabet.substring(key2) +
                this.alphabet.substring(0, key2);
        this.mainKey1 = key1;
        this.mainKey2 = key2;

    }

    public String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder(input);
        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            if (i % 2 == 0) {
                if (this.alphabet.indexOf(currChar) != -1) {
                    int idx = this.alphabet.indexOf(currChar);
                    char newChar = this.shiftedAlphabet1.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            } else {
                if (this.alphabet.indexOf(currChar) != -1) {
                    int idx = this.alphabet.indexOf(currChar);
                    char newChar = this.shiftedAlphabet2.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            }
        }
        return encrypted.toString();
    }

    public String decrypt(String input) {
        CaesarCipherTwo cc = new CaesarCipherTwo(26 - mainKey1, 26 - mainKey2);
        return cc.encrypt(input);
    }
}