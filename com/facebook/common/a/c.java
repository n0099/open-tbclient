package com.facebook.common.a;
/* loaded from: classes2.dex */
public class c implements b {
    private static c kaN = null;

    private c() {
    }

    public static synchronized c cCE() {
        c cVar;
        synchronized (c.class) {
            if (kaN == null) {
                kaN = new c();
            }
            cVar = kaN;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
