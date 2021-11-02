package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static j f67403a;

    /* renamed from: b  reason: collision with root package name */
    public static long f67404b;

    public static j a() {
        synchronized (k.class) {
            if (f67403a != null) {
                j jVar = f67403a;
                f67403a = jVar.f67401f;
                jVar.f67401f = null;
                f67404b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    public static void a(j jVar) {
        if (jVar.f67401f != null || jVar.f67402g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.f67399d) {
            return;
        }
        synchronized (k.class) {
            if (f67404b + 2048 > 65536) {
                return;
            }
            f67404b += 2048;
            jVar.f67401f = f67403a;
            jVar.f67398c = 0;
            jVar.f67397b = 0;
            f67403a = jVar;
        }
    }
}
