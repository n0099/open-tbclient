package com.meizu.cloud.pushsdk.b.g;
/* loaded from: classes6.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static j f37900a;

    /* renamed from: b  reason: collision with root package name */
    public static long f37901b;

    public static j a() {
        synchronized (k.class) {
            if (f37900a != null) {
                j jVar = f37900a;
                f37900a = jVar.f37898f;
                jVar.f37898f = null;
                f37901b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    public static void a(j jVar) {
        if (jVar.f37898f != null || jVar.f37899g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.f37896d) {
            return;
        }
        synchronized (k.class) {
            if (f37901b + 2048 > 65536) {
                return;
            }
            f37901b += 2048;
            jVar.f37898f = f37900a;
            jVar.f37895c = 0;
            jVar.f37894b = 0;
            f37900a = jVar;
        }
    }
}
