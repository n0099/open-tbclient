package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes7.dex */
public final class k {
    public static j a;

    /* renamed from: b  reason: collision with root package name */
    public static long f42020b;

    public static j a() {
        synchronized (k.class) {
            if (a != null) {
                j jVar = a;
                a = jVar.f42018f;
                jVar.f42018f = null;
                f42020b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    public static void a(j jVar) {
        if (jVar.f42018f != null || jVar.f42019g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.f42016d) {
            return;
        }
        synchronized (k.class) {
            if (f42020b + 2048 > 65536) {
                return;
            }
            f42020b += 2048;
            jVar.f42018f = a;
            jVar.f42015c = 0;
            jVar.f42014b = 0;
            a = jVar;
        }
    }
}
