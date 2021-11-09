package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static j f67402a;

    /* renamed from: b  reason: collision with root package name */
    public static long f67403b;

    public static j a() {
        synchronized (k.class) {
            if (f67402a != null) {
                j jVar = f67402a;
                f67402a = jVar.f67400f;
                jVar.f67400f = null;
                f67403b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    public static void a(j jVar) {
        if (jVar.f67400f != null || jVar.f67401g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.f67398d) {
            return;
        }
        synchronized (k.class) {
            if (f67403b + 2048 > 65536) {
                return;
            }
            f67403b += 2048;
            jVar.f67400f = f67402a;
            jVar.f67397c = 0;
            jVar.f67396b = 0;
            f67402a = jVar;
        }
    }
}
