package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes10.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static j f74505a;

    /* renamed from: b  reason: collision with root package name */
    public static long f74506b;

    public static j a() {
        synchronized (k.class) {
            if (f74505a != null) {
                j jVar = f74505a;
                f74505a = jVar.f74503f;
                jVar.f74503f = null;
                f74506b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    public static void a(j jVar) {
        if (jVar.f74503f != null || jVar.f74504g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.f74501d) {
            return;
        }
        synchronized (k.class) {
            if (f74506b + 2048 > 65536) {
                return;
            }
            f74506b += 2048;
            jVar.f74503f = f74505a;
            jVar.f74500c = 0;
            jVar.f74499b = 0;
            f74505a = jVar;
        }
    }
}
