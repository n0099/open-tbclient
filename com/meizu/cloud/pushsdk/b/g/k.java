package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes6.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static j f37611a;

    /* renamed from: b  reason: collision with root package name */
    public static long f37612b;

    public static j a() {
        synchronized (k.class) {
            if (f37611a != null) {
                j jVar = f37611a;
                f37611a = jVar.f37609f;
                jVar.f37609f = null;
                f37612b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    public static void a(j jVar) {
        if (jVar.f37609f != null || jVar.f37610g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.f37607d) {
            return;
        }
        synchronized (k.class) {
            if (f37612b + 2048 > 65536) {
                return;
            }
            f37612b += 2048;
            jVar.f37609f = f37611a;
            jVar.f37606c = 0;
            jVar.f37605b = 0;
            f37611a = jVar;
        }
    }
}
