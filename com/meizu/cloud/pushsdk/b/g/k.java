package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes6.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static j f37995a;

    /* renamed from: b  reason: collision with root package name */
    public static long f37996b;

    public static j a() {
        synchronized (k.class) {
            if (f37995a != null) {
                j jVar = f37995a;
                f37995a = jVar.f37993f;
                jVar.f37993f = null;
                f37996b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    public static void a(j jVar) {
        if (jVar.f37993f != null || jVar.f37994g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.f37991d) {
            return;
        }
        synchronized (k.class) {
            if (f37996b + 2048 > 65536) {
                return;
            }
            f37996b += 2048;
            jVar.f37993f = f37995a;
            jVar.f37990c = 0;
            jVar.f37989b = 0;
            f37995a = jVar;
        }
    }
}
