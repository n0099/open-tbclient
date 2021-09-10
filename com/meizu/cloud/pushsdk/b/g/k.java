package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes10.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static j f74685a;

    /* renamed from: b  reason: collision with root package name */
    public static long f74686b;

    public static j a() {
        synchronized (k.class) {
            if (f74685a != null) {
                j jVar = f74685a;
                f74685a = jVar.f74683f;
                jVar.f74683f = null;
                f74686b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    public static void a(j jVar) {
        if (jVar.f74683f != null || jVar.f74684g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.f74681d) {
            return;
        }
        synchronized (k.class) {
            if (f74686b + 2048 > 65536) {
                return;
            }
            f74686b += 2048;
            jVar.f74683f = f74685a;
            jVar.f74680c = 0;
            jVar.f74679b = 0;
            f74685a = jVar;
        }
    }
}
