package com.facebook.common.a;
/* loaded from: classes2.dex */
public class c implements b {
    private static c ijV = null;

    private c() {
    }

    public static synchronized c bUu() {
        c cVar;
        synchronized (c.class) {
            if (ijV == null) {
                ijV = new c();
            }
            cVar = ijV;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
