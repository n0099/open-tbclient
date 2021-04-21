package d.h.c.a;
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
        int i = 0;
        while (i < length) {
            if (b(str.charAt(i))) {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c2 = charArray[i];
                    if (b(c2)) {
                        charArray[i] = (char) (c2 ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }

    public static char d(char c2) {
        return a(c2) ? (char) (c2 ^ ' ') : c2;
    }

    public static String e(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            if (a(str.charAt(i))) {
                char[] charArray = str.toCharArray();
                while (i < length) {
                    char c2 = charArray[i];
                    if (a(c2)) {
                        charArray[i] = (char) (c2 ^ ' ');
                    }
                    i++;
                }
                return String.valueOf(charArray);
            }
            i++;
        }
        return str;
    }
}
