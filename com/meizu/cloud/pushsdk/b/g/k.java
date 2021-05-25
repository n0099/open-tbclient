package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes6.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static j f34720a;

    /* renamed from: b  reason: collision with root package name */
    public static long f34721b;

    public static j a() {
        synchronized (k.class) {
            if (f34720a != null) {
                j jVar = f34720a;
                f34720a = jVar.f34718f;
                jVar.f34718f = null;
                f34721b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    public static void a(j jVar) {
        if (jVar.f34718f != null || jVar.f34719g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.f34716d) {
            return;
        }
        synchronized (k.class) {
            if (f34721b + 2048 > 65536) {
                return;
            }
            f34721b += 2048;
            jVar.f34718f = f34720a;
            jVar.f34715c = 0;
            jVar.f34714b = 0;
            f34720a = jVar;
        }
    }
}
