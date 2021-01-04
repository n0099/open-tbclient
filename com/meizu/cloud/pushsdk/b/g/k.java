package com.meizu.cloud.pushsdk.b.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    static j f11509a;

    /* renamed from: b  reason: collision with root package name */
    static long f11510b;

    private k() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j a() {
        synchronized (k.class) {
            if (f11509a != null) {
                j jVar = f11509a;
                f11509a = jVar.f;
                jVar.f = null;
                f11510b -= 2048;
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
            if (f11510b + 2048 <= 65536) {
                f11510b += 2048;
                jVar.f = f11509a;
                jVar.c = 0;
                jVar.f11508b = 0;
                f11509a = jVar;
            }
        }
    }
}
