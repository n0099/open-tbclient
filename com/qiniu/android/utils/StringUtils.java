package com.qiniu.android.utils;
/* loaded from: classes5.dex */
public final class StringUtils {
    public static String b(String[] strArr, String str) {
        if (strArr == null) {
            return null;
        }
        int length = strArr.length;
        StringBuilder sb = new StringBuilder(length == 0 ? 0 : ((strArr[0] == null ? 16 : strArr[0].length()) + ((str == null || str.equals("")) ? 0 : str.length())) * length);
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                sb.append(str);
            }
            if (strArr[i] != null) {
                sb.append(strArr[i]);
            }
        }
        return sb.toString();
    }

    public static String X(String[] strArr) {
        int length = strArr.length;
        StringBuilder sb = new StringBuilder((strArr[0].length() + 3) * length);
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append('\"');
            sb.append(strArr[i]);
            sb.append('\"');
        }
        return sb.toString();
    }

    public static boolean QX(String str) {
        return str == null || "".equals(str);
    }

    public static String QY(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt > 31 && charAt < 127) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }
}
