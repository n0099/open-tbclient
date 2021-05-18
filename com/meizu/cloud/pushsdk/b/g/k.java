package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes6.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static j f34791a;

    /* renamed from: b  reason: collision with root package name */
    public static long f34792b;

    public static j a() {
        synchronized (k.class) {
            if (f34791a != null) {
                j jVar = f34791a;
                f34791a = jVar.f34789f;
                jVar.f34789f = null;
                f34792b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    public static void a(j jVar) {
        if (jVar.f34789f != null || jVar.f34790g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.f34787d) {
            return;
        }
        synchronized (k.class) {
            if (f34792b + 2048 > 65536) {
                return;
            }
            f34792b += 2048;
            jVar.f34789f = f34791a;
            jVar.f34786c = 0;
            jVar.f34785b = 0;
            f34791a = jVar;
        }
    }
}
