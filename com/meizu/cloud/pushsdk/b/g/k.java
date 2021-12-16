package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes3.dex */
public final class k {
    public static j a;

    /* renamed from: b  reason: collision with root package name */
    public static long f60926b;

    public static j a() {
        synchronized (k.class) {
            if (a != null) {
                j jVar = a;
                a = jVar.f60924f;
                jVar.f60924f = null;
                f60926b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    public static void a(j jVar) {
        if (jVar.f60924f != null || jVar.f60925g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.f60922d) {
            return;
        }
        synchronized (k.class) {
            if (f60926b + 2048 > 65536) {
                return;
            }
            f60926b += 2048;
            jVar.f60924f = a;
            jVar.f60921c = 0;
            jVar.f60920b = 0;
            a = jVar;
        }
    }
}
