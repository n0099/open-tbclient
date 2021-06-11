package com.yy.gslbsdk.util;
/* loaded from: classes7.dex */
public class IPTools {
    public static String hosts2String(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(strArr[i2]);
            if (i2 < length - 1) {
                sb.append('|');
            }
        }
        return sb.toString();
    }

    public static boolean isHost(String str) {
        boolean z;
        if (str == null || str.length() < 1 || str.contains(":")) {
            return false;
        }
        if (7 <= str.length() && str.length() <= 15) {
            int i2 = 0;
            while (true) {
                if (i2 >= str.length()) {
                    z = true;
                    break;
                } else if (str.charAt(i2) != '.' && !Character.isDigit(str.charAt(i2))) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidIP(String str) {
        return str.matches("((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)");
    }
}
