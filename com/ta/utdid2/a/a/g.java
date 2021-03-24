package com.ta.utdid2.a.a;
/* loaded from: classes7.dex */
public class g {
    public static String get(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls.newInstance(), str, str2);
        } catch (Exception unused) {
            return "";
        }
    }
}
