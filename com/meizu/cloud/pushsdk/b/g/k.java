package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static j f68315a;

    /* renamed from: b  reason: collision with root package name */
    public static long f68316b;

    public static j a() {
        synchronized (k.class) {
            if (f68315a != null) {
                j jVar = f68315a;
                f68315a = jVar.f68313f;
                jVar.f68313f = null;
                f68316b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    public static void a(j jVar) {
        if (jVar.f68313f != null || jVar.f68314g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.f68311d) {
            return;
        }
        synchronized (k.class) {
            if (f68316b + 2048 > 65536) {
                return;
            }
            f68316b += 2048;
            jVar.f68313f = f68315a;
            jVar.f68310c = 0;
            jVar.f68309b = 0;
            f68315a = jVar;
        }
    }
}
