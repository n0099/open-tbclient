package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes4.dex */
public final class k {
    public static j a;

    /* renamed from: b  reason: collision with root package name */
    public static long f58831b;

    public static j a() {
        synchronized (k.class) {
            if (a != null) {
                j jVar = a;
                a = jVar.f58829f;
                jVar.f58829f = null;
                f58831b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    public static void a(j jVar) {
        if (jVar.f58829f != null || jVar.f58830g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.f58827d) {
            return;
        }
        synchronized (k.class) {
            if (f58831b + 2048 > 65536) {
                return;
            }
            f58831b += 2048;
            jVar.f58829f = a;
            jVar.f58826c = 0;
            jVar.f58825b = 0;
            a = jVar;
        }
    }
}
