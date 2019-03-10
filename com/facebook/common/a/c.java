package com.facebook.common.a;
/* loaded from: classes2.dex */
public class c implements b {
    private static c jzQ = null;

    private c() {
    }

    public static synchronized c ctC() {
        c cVar;
        synchronized (c.class) {
            if (jzQ == null) {
                jzQ = new c();
            }
            cVar = jzQ;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
