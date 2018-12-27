package com.facebook.common.a;
/* loaded from: classes2.dex */
public class c implements b {
    private static c iiN = null;

    private c() {
    }

    public static synchronized c bTM() {
        c cVar;
        synchronized (c.class) {
            if (iiN == null) {
                iiN = new c();
            }
            cVar = iiN;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
