package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes7.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static j f38399a;

    /* renamed from: b  reason: collision with root package name */
    public static long f38400b;

    public static j a() {
        synchronized (k.class) {
            if (f38399a != null) {
                j jVar = f38399a;
                f38399a = jVar.f38397f;
                jVar.f38397f = null;
                f38400b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    public static void a(j jVar) {
        if (jVar.f38397f != null || jVar.f38398g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.f38395d) {
            return;
        }
        synchronized (k.class) {
            if (f38400b + 2048 > 65536) {
                return;
            }
            f38400b += 2048;
            jVar.f38397f = f38399a;
            jVar.f38394c = 0;
            jVar.f38393b = 0;
            f38399a = jVar;
        }
    }
}
