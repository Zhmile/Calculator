import sun.util.locale.LocaleUtils;

import java.security.PublicKey;
import java.util.Locale;
import java.util.regex.Pattern;

public class Calculobus {
    public String calc(String input) throws Exception {
        String[] splitText = input.split(" ");
        int status = status(splitText);

        if (status == 1){
            if (Integer.parseInt(splitText[0]) <= 10 && Integer.parseInt(splitText[2]) <= 10) {
                switch (splitText[1]) {
                    case "/":
                        return String.valueOf(Integer.parseInt(splitText[0]) / Integer.parseInt(splitText[2]));
                    case "+":
                        return String.valueOf(Integer.parseInt(splitText[0]) + Integer.parseInt(splitText[2]));
                    case "-":
                        return String.valueOf(Integer.parseInt(splitText[0]) - Integer.parseInt(splitText[2]));
                    case "*":
                        return String.valueOf(Integer.parseInt(splitText[0]) * Integer.parseInt(splitText[2]));
                }
            }
            else {
                throw new Exception("если операнд больше 10 выражение не выполняеться");
            }
        }


        if (status == 2){
            if ((Roman2Arabic.toArabic(splitText[0]) <= 10 && Roman2Arabic.toArabic(splitText[2]) <= 10)
                    && (Roman2Arabic.toArabic(splitText[0]) > 0 && Roman2Arabic.toArabic(splitText[2]) > 0) ) {
                switch (splitText[1]) {
                    case "/":
                        return
                                Roman2Arabic.toRoman(Roman2Arabic.toArabic((splitText[0]).toUpperCase())
                                        / Roman2Arabic.toArabic(splitText[2].toUpperCase()));
                    case "+":
                        return Roman2Arabic.toRoman(Roman2Arabic.toArabic((splitText[0]).toUpperCase())
                                + Roman2Arabic.toArabic(splitText[2].toUpperCase()));
                    case "-":
                        return Roman2Arabic.toRoman(Roman2Arabic.toArabic((splitText[0]).toUpperCase())
                                - Roman2Arabic.toArabic(splitText[2].toUpperCase()));

                    case "*":
                        return Roman2Arabic.toRoman(Roman2Arabic.toArabic((splitText[0]).toUpperCase())
                                * Roman2Arabic.toArabic(splitText[2].toUpperCase()));
                }
            }
            else {
                throw new Exception("если операнд больше 10 или меньше 0 выражение не выполняеться");
            }

        }

        if (status == 3){
            throw new Exception("используются одновременно разные системы счисления");
        }
        throw new Exception(" аоааоаооао ");
    }


    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static int status (String[] arg){
        if (isNumeric(arg[0])){
            if (isNumeric(arg[2])){
                return 1;
            }

        }
        if (isNumeric(arg[0]) == false){
            if (isNumeric(arg[2]) == false){
                return 2;
            }
        }
        return 3;

    }
}