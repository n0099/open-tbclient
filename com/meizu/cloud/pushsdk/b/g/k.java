package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes2.dex */
public final class k {
    public static j a;

    /* renamed from: b  reason: collision with root package name */
    public static long f60345b;

    public static j a() {
        synchronized (k.class) {
            if (a != null) {
                j jVar = a;
                a = jVar.f60343f;
                jVar.f60343f = null;
                f60345b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    public static void a(j jVar) {
        if (jVar.f60343f != null || jVar.f60344g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.f60341d) {
            return;
        }
        synchronized (k.class) {
            if (f60345b + 2048 > 65536) {
                return;
            }
            f60345b += 2048;
            jVar.f60343f = a;
            jVar.f60340c = 0;
            jVar.f60339b = 0;
            a = jVar;
        }
    }
}
