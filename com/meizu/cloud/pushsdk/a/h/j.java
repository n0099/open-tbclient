package com.meizu.cloud.pushsdk.a.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j {
    static i a;
    static long b;

    private j() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i a() {
        synchronized (j.class) {
            if (a != null) {
                i iVar = a;
                a = iVar.f;
                iVar.f = null;
                b -= 2048;
                return iVar;
            }
            return new i();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(i iVar) {
        if (iVar.f != null || iVar.g != null) {
            throw new IllegalArgumentException();
        }
        if (!iVar.d) {
            synchronized (j.class) {
                if (b + 2048 <= 65536) {
                    b += 2048;
                    iVar.f = a;
                    iVar.c = 0;
                    iVar.b = 0;
                    a = iVar;
                }
            }
        }
    }
}
