package com.xiaomi.metoknlp.a;
/* loaded from: classes3.dex */
public class c {
    private static Class a() {
        return Class.forName("android.os.SystemProperties");
    }

    public static String a(String str, String str2) {
        try {
            return (String) a().getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
