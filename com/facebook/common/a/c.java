package com.facebook.common.a;
/* loaded from: classes2.dex */
public class c implements b {
    private static c jRU = null;

    private c() {
    }

    public static synchronized c cBx() {
        c cVar;
        synchronized (c.class) {
            if (jRU == null) {
                jRU = new c();
            }
            cVar = jRU;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
