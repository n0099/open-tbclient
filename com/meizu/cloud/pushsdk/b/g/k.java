package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes3.dex */
public final class k {
    public static j a;

    /* renamed from: b  reason: collision with root package name */
    public static long f58664b;

    public static j a() {
        synchronized (k.class) {
            if (a != null) {
                j jVar = a;
                a = jVar.f58662f;
                jVar.f58662f = null;
                f58664b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    public static void a(j jVar) {
        if (jVar.f58662f != null || jVar.f58663g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.f58660d) {
            return;
        }
        synchronized (k.class) {
            if (f58664b + 2048 > 65536) {
                return;
            }
            f58664b += 2048;
            jVar.f58662f = a;
            jVar.f58659c = 0;
            jVar.f58658b = 0;
            a = jVar;
        }
    }
}
