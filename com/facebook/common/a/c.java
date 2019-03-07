package com.facebook.common.a;
/* loaded from: classes2.dex */
public class c implements b {
    private static c jzx = null;

    private c() {
    }

    public static synchronized c cts() {
        c cVar;
        synchronized (c.class) {
            if (jzx == null) {
                jzx = new c();
            }
            cVar = jzx;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
