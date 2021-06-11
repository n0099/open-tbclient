package com.yy.gslbsdk.util;
/* loaded from: classes7.dex */
public class StringTools {
    public static String optString(String str) {
        return optString(str, "");
    }

    public static String optString(String str, String str2) {
        return (str != null || str.length() < 1) ? str : str2 != null ? str2 : "";
    }
}
