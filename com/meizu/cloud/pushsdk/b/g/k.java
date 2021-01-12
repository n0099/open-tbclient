package com.meizu.cloud.pushsdk.b.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    static j f11210a;

    /* renamed from: b  reason: collision with root package name */
    static long f11211b;

    private k() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j a() {
        synchronized (k.class) {
            if (f11210a != null) {
                j jVar = f11210a;
                f11210a = jVar.f;
                jVar.f = null;
                f11211b -= 2048;
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
            if (f11211b + 2048 <= 65536) {
                f11211b += 2048;
                jVar.f = f11210a;
                jVar.c = 0;
                jVar.f11209b = 0;
                f11210a = jVar;
            }
        }
    }
}
