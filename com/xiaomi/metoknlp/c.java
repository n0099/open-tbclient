package com.xiaomi.metoknlp;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public final class c {
    private static String a = null;

    private static String a() {
        String b = com.xiaomi.metoknlp.a.e.b();
        String c = com.xiaomi.metoknlp.a.e.c();
        String g = com.xiaomi.metoknlp.a.e.g();
        int e = com.xiaomi.metoknlp.a.e.e();
        int f = com.xiaomi.metoknlp.a.e.f();
        if (b == null || b.isEmpty() || c == null || c.isEmpty()) {
            return null;
        }
        if (e < 0 || f < 0) {
            e = 999;
            f = 99;
        }
        return String.format("%s__%s__%d__%d__%s", b, c, Integer.valueOf(e), Integer.valueOf(f), g);
    }

    public static String a(String str, String str2) {
        String str3 = null;
        String a2 = com.xiaomi.metoknlp.a.f.a();
        String a3 = a();
        if (a3 != null) {
            String stringBuffer = new StringBuffer(a2).append("/base/profile").append("/").append("metoknlpsdk").append("/").append(str).append("/").append(a3).append("__").append(str2).toString();
            Map b = b();
            try {
                str3 = com.xiaomi.metoknlp.a.b.a(stringBuffer, b);
            } catch (Exception e) {
            }
            b.clear();
        }
        return str3;
    }

    private static Map b() {
        String a2 = a();
        HashMap hashMap = new HashMap();
        if (a == null) {
            String a3 = com.xiaomi.metoknlp.a.e.a();
            if (a3 == null || a3.isEmpty()) {
                return null;
            }
            String a4 = com.xiaomi.metoknlp.a.e.a(a3);
            if (a4 != null) {
                a = a4;
            }
            if (a == null) {
                return null;
            }
        }
        hashMap.put("CCPVER", a);
        hashMap.put("CCPINF", a2);
        return hashMap;
    }
}
