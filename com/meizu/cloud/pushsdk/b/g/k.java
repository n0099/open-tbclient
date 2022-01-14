package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes3.dex */
public final class k {
    public static j a;

    /* renamed from: b  reason: collision with root package name */
    public static long f58619b;

    public static j a() {
        synchronized (k.class) {
            if (a != null) {
                j jVar = a;
                a = jVar.f58617f;
                jVar.f58617f = null;
                f58619b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    public static void a(j jVar) {
        if (jVar.f58617f != null || jVar.f58618g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.f58615d) {
            return;
        }
        synchronized (k.class) {
            if (f58619b + 2048 > 65536) {
                return;
            }
            f58619b += 2048;
            jVar.f58617f = a;
            jVar.f58614c = 0;
            jVar.f58613b = 0;
            a = jVar;
        }
    }
}
