package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes10.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static j f74305a;

    /* renamed from: b  reason: collision with root package name */
    public static long f74306b;

    public static j a() {
        synchronized (k.class) {
            if (f74305a != null) {
                j jVar = f74305a;
                f74305a = jVar.f74303f;
                jVar.f74303f = null;
                f74306b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    public static void a(j jVar) {
        if (jVar.f74303f != null || jVar.f74304g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.f74301d) {
            return;
        }
        synchronized (k.class) {
            if (f74306b + 2048 > 65536) {
                return;
            }
            f74306b += 2048;
            jVar.f74303f = f74305a;
            jVar.f74300c = 0;
            jVar.f74299b = 0;
            f74305a = jVar;
        }
    }
}
