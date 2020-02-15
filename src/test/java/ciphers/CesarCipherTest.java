package ciphers;

import ciphers.impl.CesarCipher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CesarCipherTest {
    protected final String textWithNoAlphabeticLetters = "112312[]][";
    protected final  String textWithAlphabeticLetters = "abcdd";
    protected final String exceptedTextForAlphabeticLetters = "defgg";
    protected final String mixedText= "123ac";
    protected final String expectedTextForMixedText = "123df//";
    protected Cipher cesarCipher = new CesarCipher();

    @DisplayName("Testing correction of encoding text with no alphabetic letters")
    @Test
    public void testIfOnlyAlphabeticLettersAreEncoded(){
        String decode = cesarCipher.encode(textWithNoAlphabeticLetters);
        Assertions.assertEquals(textWithNoAlphabeticLetters, decode);
    }
    @DisplayName("Testing correction of encoding text with alphabetic letters")
    @Test
    public void testIfOnlyNoAlphabeticLettersAreEncoded(){
        String decode =cesarCipher.encode(textWithAlphabeticLetters);
        Assertions.assertEquals(exceptedTextForAlphabeticLetters,decode);
    }
    @DisplayName("Testing correction of encoding excepted text for alphabetic letters")
    @Test
    public void testIfexcepteTextForAlphabeticLetters(){
        String decode =cesarCipher.encode(textWithAlphabeticLetters);
        Assertions.assertEquals(exceptedTextForAlphabeticLetters, decode);
    }
    @DisplayName("Testing correction of encoding mixed text")
    @Test
    public void testIfMixedText(){
        String decode = cesarCipher.encode(mixedText);
        Assertions.assertEquals(expectedTextForMixedText, decode);
    }
    @DisplayName("Testing correction of encoding excepted text for mixed text")
    @Test
    public void testIfExceptedTextForMixedTest(){
        String decode = cesarCipher.encode(textWithAlphabeticLetters);
        Assertions.assertEquals(exceptedTextForAlphabeticLetters, decode);
    }
    @DisplayName("Testing correction of encoding text with no alphabetic letters")
    @Test
    public void testIfOnlyAlphabeticLettersAreEncoded2(){
        String decode = cesarCipher.encode(textWithNoAlphabeticLetters);
        Assertions.assertEquals(textWithNoAlphabeticLetters, decode);
    }
    @DisplayName("Testing correction of decoding text with no alphabetic letters")
    @Test
    public void testIfDecodingModifyTextWithAlphabeticChars(){
        String decode = cesarCipher.decode(exceptedTextForAlphabeticLetters);
        Assertions.assertEquals(textWithAlphabeticLetters, decode);
    }
}
