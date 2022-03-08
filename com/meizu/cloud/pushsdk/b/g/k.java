package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes8.dex */
public final class k {
    public static j a;

    /* renamed from: b  reason: collision with root package name */
    public static long f57181b;

    public static j a() {
        synchronized (k.class) {
            if (a != null) {
                j jVar = a;
                a = jVar.f57179f;
                jVar.f57179f = null;
                f57181b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    public static void a(j jVar) {
        if (jVar.f57179f != null || jVar.f57180g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.f57177d) {
            return;
        }
        synchronized (k.class) {
            if (f57181b + 2048 > 65536) {
                return;
            }
            f57181b += 2048;
            jVar.f57179f = a;
            jVar.f57176c = 0;
            jVar.f57175b = 0;
            a = jVar;
        }
    }
}
