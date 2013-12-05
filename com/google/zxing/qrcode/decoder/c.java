package com.google.zxing.qrcode.decoder;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private static final c[] f2881a = {new d(null), new e(null), new f(null), new g(null), new h(null), new i(null), new j(null), new k(null)};

    abstract boolean a(int i, int i2);

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(c cVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(com.google.zxing.common.a aVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < i; i3++) {
                if (a(i2, i3)) {
                    aVar.c(i3, i2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c a(int i) {
        if (i < 0 || i > 7) {
            throw new IllegalArgumentException();
        }
        return f2881a[i];
    }
}
