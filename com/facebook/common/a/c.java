package com.facebook.common.a;
/* loaded from: classes2.dex */
public class c implements b {
    private static c hWG = null;

    private c() {
    }

    public static synchronized c bRv() {
        c cVar;
        synchronized (c.class) {
            if (hWG == null) {
                hWG = new c();
            }
            cVar = hWG;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
