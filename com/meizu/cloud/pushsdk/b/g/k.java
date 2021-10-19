package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes10.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static j f75039a;

    /* renamed from: b  reason: collision with root package name */
    public static long f75040b;

    public static j a() {
        synchronized (k.class) {
            if (f75039a != null) {
                j jVar = f75039a;
                f75039a = jVar.f75037f;
                jVar.f75037f = null;
                f75040b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    public static void a(j jVar) {
        if (jVar.f75037f != null || jVar.f75038g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.f75035d) {
            return;
        }
        synchronized (k.class) {
            if (f75040b + 2048 > 65536) {
                return;
            }
            f75040b += 2048;
            jVar.f75037f = f75039a;
            jVar.f75034c = 0;
            jVar.f75033b = 0;
            f75039a = jVar;
        }
    }
}
