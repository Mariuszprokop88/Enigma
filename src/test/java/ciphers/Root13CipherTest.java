package ciphers;

import ciphers.impl.CesarCipher;
import ciphers.impl.Root13Cipher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Root13CipherTest {
    protected final String textWithNoAlphabeticLetters = "112312[]][";
    protected final String textWithAlphabeticLetters = "Abcdd";
    protected final String exceptedTextForAlphabeticLetters = "Nopqq";
    protected final String mixedText = "123ac";
    protected final String expectedTextForMixedText = "123np";
    protected Cipher root13 = new Root13Cipher();

    @DisplayName("Testing correction of encoding text with no alphabetic letters")
    @Test
    public void testIfOnlyAlphabeticLettersAreEncoded() {
        String decode = root13.encode(textWithNoAlphabeticLetters);
        Assertions.assertEquals(textWithNoAlphabeticLetters, decode);
    }

    @DisplayName("Testing correction of encoding text with alphabetic letter")
    @Test
    public void testIfOnlyNoAlphabeticLettersAreEncoded() {
        String decode = root13.encode(textWithAlphabeticLetters);
        Assertions.assertEquals(exceptedTextForAlphabeticLetters, decode);
    }

    @DisplayName("Testing correction of encoding mixed text")
    @Test
    public void testIfMixedText() {
        String decode = root13.encode(mixedText);
        Assertions.assertEquals(expectedTextForMixedText, decode);
    }
}