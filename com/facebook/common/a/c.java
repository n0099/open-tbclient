package com.facebook.common.a;
/* loaded from: classes2.dex */
public class c implements b {
    private static c jzI = null;

    private c() {
    }

    public static synchronized c ctF() {
        c cVar;
        synchronized (c.class) {
            if (jzI == null) {
                jzI = new c();
            }
            cVar = jzI;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
