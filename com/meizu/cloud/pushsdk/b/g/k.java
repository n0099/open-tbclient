package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes6.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static j f37274a;

    /* renamed from: b  reason: collision with root package name */
    public static long f37275b;

    public static j a() {
        synchronized (k.class) {
            if (f37274a != null) {
                j jVar = f37274a;
                f37274a = jVar.f37272f;
                jVar.f37272f = null;
                f37275b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    public static void a(j jVar) {
        if (jVar.f37272f != null || jVar.f37273g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.f37270d) {
            return;
        }
        synchronized (k.class) {
            if (f37275b + 2048 > 65536) {
                return;
            }
            f37275b += 2048;
            jVar.f37272f = f37274a;
            jVar.f37269c = 0;
            jVar.f37268b = 0;
            f37274a = jVar;
        }
    }
}
