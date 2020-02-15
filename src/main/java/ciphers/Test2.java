package ciphers;

import ciphers.impl.CesarCipher;

public class Test2 {
    public static void main(String[] args) {
        Cipher cesarCipher = new CesarCipher();
        String example = cesarCipher.encode("abcde");
        System.out.println(example);
        String decoded = cesarCipher.decode("xyz");
        System.out.println(decoded);
    }
}
