package ciphers;

import ciphers.impl.CesarCipher;
import ciphers.impl.Root13Cipher;

public class Test2 {
    public static void main(String[] args) {
        Cipher cesarCipher = new CesarCipher();
        String example = cesarCipher.encode("abcde");
        System.out.println(example);
        String decoded = cesarCipher.decode("defgh");
        System.out.println(decoded);


        Cipher root13 = new Root13Cipher();
        String example2 = root13.encode("abcd");
        System.out.println(example2);
        String decode2 = root13.decode("nopr");
        System.out.println(decode2);
    }
}
