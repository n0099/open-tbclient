package com.facebook.common.a;
/* loaded from: classes2.dex */
public class c implements b {
    private static c jRX = null;

    private c() {
    }

    public static synchronized c cBw() {
        c cVar;
        synchronized (c.class) {
            if (jRX == null) {
                jRX = new c();
            }
            cVar = jRX;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
