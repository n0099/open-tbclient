package com.meizu.cloud.pushsdk.b.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    static j f7372a;
    static long b;

    private k() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j a() {
        synchronized (k.class) {
            if (f7372a != null) {
                j jVar = f7372a;
                f7372a = jVar.f;
                jVar.f = null;
                b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(j jVar) {
        if (jVar.f != null || jVar.g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.d) {
            return;
        }
        synchronized (k.class) {
            if (b + 2048 <= 65536) {
                b += 2048;
                jVar.f = f7372a;
                jVar.c = 0;
                jVar.b = 0;
                f7372a = jVar;
            }
        }
    }
}
