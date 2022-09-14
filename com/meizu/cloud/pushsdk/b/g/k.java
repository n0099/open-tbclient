package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes8.dex */
public final class k {
    public static j a;
    public static long b;

    public static j a() {
        synchronized (k.class) {
            if (a != null) {
                j jVar = a;
                a = jVar.f;
                jVar.f = null;
                b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    public static void a(j jVar) {
        if (jVar.f != null || jVar.g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.d) {
            return;
        }
        synchronized (k.class) {
            if (b + 2048 > 65536) {
                return;
            }
            b += 2048;
            jVar.f = a;
            jVar.c = 0;
            jVar.b = 0;
            a = jVar;
        }
    }
}
