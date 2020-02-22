package factories.impl;

import ciphers.Cipher;
import ciphers.impl.CesarCipher;
import ciphers.impl.Root13Cipher;
import exceptions.CipherNotFoundException;

public class CipherFactory implements factories.CipherFactory {
    public static final String CESAR = "cipher";
    public static final String ROOT13 = "root13";
    @Override
    public Cipher create(String type) {
        if(type.equals(CESAR)) {
            return new CesarCipher();
        }
        if(type.equals(ROOT13)) {
            return new Root13Cipher();

        }throw new CipherNotFoundException(type);
    }
}
