package com.vivo.push.util;
/* loaded from: classes3.dex */
public final class r {
    public static int a(com.vivo.push.b.c cVar) {
        w b2 = w.b();
        int b3 = cVar.b();
        long currentTimeMillis = System.currentTimeMillis();
        int b4 = b2.b("com.vivo.push_preferences.operate." + b3 + "OPERATE_COUNT");
        long b5 = b2.b("com.vivo.push_preferences.operate." + b3 + "START_TIME", 0L);
        if (currentTimeMillis - b5 > 86400000 || currentTimeMillis - b5 < 0) {
            b2.a("com.vivo.push_preferences.operate." + b3 + "START_TIME", System.currentTimeMillis());
            b2.a("com.vivo.push_preferences.operate." + b3 + "OPERATE_COUNT", 1);
        } else if (b4 >= cVar.f()) {
            return 1001;
        } else {
            b2.a("com.vivo.push_preferences.operate." + b3 + "OPERATE_COUNT", b4 + 1);
        }
        return 0;
    }
}
