package Bai7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^(http|https)://(www.)*[A-Za-z0-9]+.[a-z]{2,6}[^\\s]+$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("https://tiki.vn/dien-thoai-may-tinh-bang/c1789?src=mega-menu");
        boolean matchFound = matcher.find();

        System.out.println(matchFound);
    }
}
