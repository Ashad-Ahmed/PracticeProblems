// Below code generates all binary numbers of a given length

class MyArray{
    public static String rec(int n, String str, String chr, String chr_prev){

        //if (chr_prev != "" && chr_prev == chr){return "";}

        if (n == 0) {
            System.out.println(str + chr);
            return str + chr;}

        str += chr;
        rec(n - 1, str, "0", chr); // Passing current chr to be used further as previous character.
        rec(n - 1, str, "1", chr); // Passing current chr to be used further as previous character.

        return "End";
    }

    public static void main(String[] Args){
        String str = "";
        System.out.println(rec(3, str, "", ""));
    }
}
