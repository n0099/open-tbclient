package com.yy.gslbsdk.util;
/* loaded from: classes10.dex */
public class IPTools {
    public static String hosts2String(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(strArr[i]);
            if (i < length - 1) {
                sb.append('|');
            }
        }
        return sb.toString();
    }

    public static boolean isValidIP(String str) {
        return str.matches("((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)");
    }

    public static boolean isHost(String str) {
        boolean z;
        if (str == null || str.length() < 1 || str.contains(":")) {
            return false;
        }
        if (7 <= str.length() && str.length() <= 15) {
            int i = 0;
            while (true) {
                if (i < str.length()) {
                    if (str.charAt(i) != '.' && !Character.isDigit(str.charAt(i))) {
                        z = false;
                        break;
                    }
                    i++;
                } else {
                    z = true;
                    break;
                }
            }
            if (z) {
                return false;
            }
        }
        return true;
    }
}
