package factories;

import ciphers.Cipher;
import ciphers.impl.CesarCipher;
import ciphers.impl.Root13Cipher;
import exceptions.CipherNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CipherFactoryTest {
    private CipherFactory factory = new factories.impl.CipherFactory();
    private static final String MESSAGE = "Type of cipher is not recognized";

    @Test
    protected void ifCesarInstanceReturnedWithCesarTypeTest() {
        Cipher cipher = factory.create(factories.impl.CipherFactory.CESAR);
        Assertions.assertTrue(cipher instanceof CesarCipher);

    }

    @Test
    protected void ifRoot13InstanceReturnedWithRoot13TypeTest() {
        Cipher cipher = factory.create(factories.impl.CipherFactory.ROOT13);
        Assertions.assertTrue(cipher instanceof Root13Cipher);
    }
    @Test
    protected void shouldThrowExceptionWithGivenUnknowType(){
        String unknow = "unknown";
        Cipher cipher = factory.create(unknow);
        Assertions.assertThrows(CipherNotFoundException.class, () ->factory.create(unknow),
                MESSAGE + unknow);
    }
}