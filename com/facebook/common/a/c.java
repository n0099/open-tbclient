package com.facebook.common.a;
/* loaded from: classes2.dex */
public class c implements b {
    private static c ijU = null;

    private c() {
    }

    public static synchronized c bUu() {
        c cVar;
        synchronized (c.class) {
            if (ijU == null) {
                ijU = new c();
            }
            cVar = ijU;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
