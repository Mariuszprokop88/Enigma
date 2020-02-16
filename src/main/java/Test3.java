public class Test3 {
    public static void main(String[] args) {
        //System.out.println((int)('A') +3);
        //char d = 68;
        //System.out.println((char)(d + 4));

        String mama = "abcd";
            char[] lettersInMamaWord = mama.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();

            for(char letter: lettersInMamaWord){
                int newLetterNumber = letter +3;
                stringBuilder.append((char)newLetterNumber);

        }
        System.out.print(stringBuilder.toString());
    }
}
