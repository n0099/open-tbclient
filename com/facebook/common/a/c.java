package com.facebook.common.a;
/* loaded from: classes2.dex */
public class c implements b {
    private static c hWF = null;

    private c() {
    }

    public static synchronized c bRv() {
        c cVar;
        synchronized (c.class) {
            if (hWF == null) {
                hWF = new c();
            }
            cVar = hWF;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
