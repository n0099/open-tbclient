package d.g.c.a;
/* loaded from: classes6.dex */
public final class a {
    public static boolean a(char c2) {
        return c2 >= 'a' && c2 <= 'z';
    }

    public static boolean b(char c2) {
        return c2 >= 'A' && c2 <= 'Z';
    }

    public static String c(String str) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            if (b(str.charAt(i2))) {
                char[] charArray = str.toCharArray();
                while (i2 < length) {
                    char c2 = charArray[i2];
                    if (b(c2)) {
                        charArray[i2] = (char) (c2 ^ ' ');
                    }
                    i2++;
                }
                return String.valueOf(charArray);
            }
            i2++;
        }
        return str;
    }

    public static char d(char c2) {
        return a(c2) ? (char) (c2 ^ ' ') : c2;
    }

    public static String e(String str) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            if (a(str.charAt(i2))) {
                char[] charArray = str.toCharArray();
                while (i2 < length) {
                    char c2 = charArray[i2];
                    if (a(c2)) {
                        charArray[i2] = (char) (c2 ^ ' ');
                    }
                    i2++;
                }
                return String.valueOf(charArray);
            }
            i2++;
        }
        return str;
    }
}
