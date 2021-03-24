package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes6.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static j f37610a;

    /* renamed from: b  reason: collision with root package name */
    public static long f37611b;

    public static j a() {
        synchronized (k.class) {
            if (f37610a != null) {
                j jVar = f37610a;
                f37610a = jVar.f37608f;
                jVar.f37608f = null;
                f37611b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    public static void a(j jVar) {
        if (jVar.f37608f != null || jVar.f37609g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.f37606d) {
            return;
        }
        synchronized (k.class) {
            if (f37611b + 2048 > 65536) {
                return;
            }
            f37611b += 2048;
            jVar.f37608f = f37610a;
            jVar.f37605c = 0;
            jVar.f37604b = 0;
            f37610a = jVar;
        }
    }
}
