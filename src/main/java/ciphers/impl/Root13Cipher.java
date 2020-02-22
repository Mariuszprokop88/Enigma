package ciphers;

public class Root13Cipher implements Cipher {
    public final String ALPHABET =  "abcdefghijklmnoprstuwxyz";
    private final int ROOT_DISPLACEMENT = 13;

    @Override
    public String encode(String textToEncode) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i<textToEncode.length(); i++){
            char sign = textToEncode.charAt(i);
            if(Character.isAlphabetic(sign)) {
                boolean isLowerCase = Character.isLowerCase(sign);
                int indexAlphabet = ALPHABET.indexOf(Character.toLowerCase(sign));
                int indexAfterDisplacement = (indexAlphabet + ROOT_DISPLACEMENT) % ALPHABET.length();
                if (isLowerCase) {
                    stringBuilder.append(ALPHABET.charAt(indexAfterDisplacement));
                } else {
                    stringBuilder.append(Character.toUpperCase(ALPHABET.charAt(indexAfterDisplacement)));
                }
            }else {
                stringBuilder.append(sign);
            }
        }


        return stringBuilder.toString();
    }

    @Override
    public String decode(String textToDecode) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i<textToDecode.length(); i++){
            char sign = textToDecode.charAt(i);
            if(Character.isAlphabetic(sign)) {
                boolean isLowerCase = Character.isLowerCase(sign);
                int indexAlphabet = ALPHABET.indexOf(Character.toLowerCase(sign));
                int indexAfterDisplacement = (indexAlphabet + ALPHABET.length()) % ROOT_DISPLACEMENT;
                if (isLowerCase) {
                    stringBuilder.append(ALPHABET.charAt(indexAfterDisplacement));
                } else {
                    stringBuilder.append(Character.toUpperCase(ALPHABET.charAt(indexAfterDisplacement)));
                }
            }else {
                stringBuilder.append(sign);
            }
        }

        return stringBuilder.toString();
    }
}
