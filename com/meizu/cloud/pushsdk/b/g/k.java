package com.meizu.cloud.pushsdk.b.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class k {
    static j a;
    static long b;

    private k() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(j jVar) {
        if (jVar.f != null || jVar.g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.d) {
            return;
        }
        synchronized (k.class) {
            if (b + 2048 <= 65536) {
                b += 2048;
                jVar.f = a;
                jVar.c = 0;
                jVar.b = 0;
                a = jVar;
            }
        }
    }
}
