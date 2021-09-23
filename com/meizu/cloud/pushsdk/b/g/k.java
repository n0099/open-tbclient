package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes10.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static j f75004a;

    /* renamed from: b  reason: collision with root package name */
    public static long f75005b;

    public static j a() {
        synchronized (k.class) {
            if (f75004a != null) {
                j jVar = f75004a;
                f75004a = jVar.f75002f;
                jVar.f75002f = null;
                f75005b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    public static void a(j jVar) {
        if (jVar.f75002f != null || jVar.f75003g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.f75000d) {
            return;
        }
        synchronized (k.class) {
            if (f75005b + 2048 > 65536) {
                return;
            }
            f75005b += 2048;
            jVar.f75002f = f75004a;
            jVar.f74999c = 0;
            jVar.f74998b = 0;
            f75004a = jVar;
        }
    }
}
