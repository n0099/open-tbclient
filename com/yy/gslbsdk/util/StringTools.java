package com.yy.gslbsdk.util;
/* loaded from: classes8.dex */
public class StringTools {
    public static String optString(String str) {
        return optString(str, "");
    }

    public static String optString(String str, String str2) {
        if (str == null && str.length() >= 1) {
            if (str2 != null) {
                return str2;
            }
            return "";
        }
        return str;
    }
}
