package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes6.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static j f37463a;

    /* renamed from: b  reason: collision with root package name */
    public static long f37464b;

    public static j a() {
        synchronized (k.class) {
            if (f37463a != null) {
                j jVar = f37463a;
                f37463a = jVar.f37461f;
                jVar.f37461f = null;
                f37464b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    public static void a(j jVar) {
        if (jVar.f37461f != null || jVar.f37462g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.f37459d) {
            return;
        }
        synchronized (k.class) {
            if (f37464b + 2048 > 65536) {
                return;
            }
            f37464b += 2048;
            jVar.f37461f = f37463a;
            jVar.f37458c = 0;
            jVar.f37457b = 0;
            f37463a = jVar;
        }
    }
}
