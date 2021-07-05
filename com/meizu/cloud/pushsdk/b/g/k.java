package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes7.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static j f40260a;

    /* renamed from: b  reason: collision with root package name */
    public static long f40261b;

    public static j a() {
        synchronized (k.class) {
            if (f40260a != null) {
                j jVar = f40260a;
                f40260a = jVar.f40258f;
                jVar.f40258f = null;
                f40261b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    public static void a(j jVar) {
        if (jVar.f40258f != null || jVar.f40259g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.f40256d) {
            return;
        }
        synchronized (k.class) {
            if (f40261b + 2048 > 65536) {
                return;
            }
            f40261b += 2048;
            jVar.f40258f = f40260a;
            jVar.f40255c = 0;
            jVar.f40254b = 0;
            f40260a = jVar;
        }
    }
}
