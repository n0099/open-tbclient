package com.facebook.common.a;
/* loaded from: classes2.dex */
public class c implements b {
    private static c jzd = null;

    private c() {
    }

    public static synchronized c cty() {
        c cVar;
        synchronized (c.class) {
            if (jzd == null) {
                jzd = new c();
            }
            cVar = jzd;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
