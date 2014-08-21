package org.jsoup.helper;

import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class StringUtil {
    private static final String[] padding = {"", " ", "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", "          "};

    public static String join(Collection collection, String str) {
        return join(collection.iterator(), str);
    }

    public static String join(Iterator it, String str) {
        if (!it.hasNext()) {
            return "";
        }
        String obj = it.next().toString();
        if (it.hasNext()) {
            StringBuilder append = new StringBuilder(64).append(obj);
            while (it.hasNext()) {
                append.append(str);
                append.append(it.next());
            }
            return append.toString();
        }
        return obj;
    }

    public static String padding(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("width must be > 0");
        }
        if (i < padding.length) {
            return padding[i];
        }
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = ' ';
        }
        return String.valueOf(cArr);
    }

    public static boolean isBlank(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!isWhitespace(str.codePointAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(str.codePointAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isWhitespace(int i) {
        return i == 32 || i == 9 || i == 10 || i == 12 || i == 13;
    }

    public static String normaliseWhitespace(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (isWhitespace(codePointAt)) {
                if (z2) {
                    z = true;
                } else {
                    if (codePointAt != 32) {
                        z = true;
                    }
                    sb.append(' ');
                    z2 = true;
                }
            } else {
                sb.appendCodePoint(codePointAt);
                z2 = false;
            }
            i += Character.charCount(codePointAt);
        }
        return z ? sb.toString() : str;
    }

    public static boolean in(String str, String... strArr) {
        for (String str2 : strArr) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
