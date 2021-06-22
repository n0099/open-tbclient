package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes7.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static j f38497a;

    /* renamed from: b  reason: collision with root package name */
    public static long f38498b;

    public static j a() {
        synchronized (k.class) {
            if (f38497a != null) {
                j jVar = f38497a;
                f38497a = jVar.f38495f;
                jVar.f38495f = null;
                f38498b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    public static void a(j jVar) {
        if (jVar.f38495f != null || jVar.f38496g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.f38493d) {
            return;
        }
        synchronized (k.class) {
            if (f38498b + 2048 > 65536) {
                return;
            }
            f38498b += 2048;
            jVar.f38495f = f38497a;
            jVar.f38492c = 0;
            jVar.f38491b = 0;
            f38497a = jVar;
        }
    }
}
