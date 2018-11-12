package com.facebook.common.a;
/* loaded from: classes2.dex */
public class c implements b {
    private static c hYq = null;

    private c() {
    }

    public static synchronized c bQQ() {
        c cVar;
        synchronized (c.class) {
            if (hYq == null) {
                hYq = new c();
            }
            cVar = hYq;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
