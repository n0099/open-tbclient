package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes6.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static j f35546a;

    /* renamed from: b  reason: collision with root package name */
    public static long f35547b;

    public static j a() {
        synchronized (k.class) {
            if (f35546a != null) {
                j jVar = f35546a;
                f35546a = jVar.f35544f;
                jVar.f35544f = null;
                f35547b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    public static void a(j jVar) {
        if (jVar.f35544f != null || jVar.f35545g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.f35542d) {
            return;
        }
        synchronized (k.class) {
            if (f35547b + 2048 > 65536) {
                return;
            }
            f35547b += 2048;
            jVar.f35544f = f35546a;
            jVar.f35541c = 0;
            jVar.f35540b = 0;
            f35546a = jVar;
        }
    }
}
