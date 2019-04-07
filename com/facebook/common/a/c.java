package com.facebook.common.a;
/* loaded from: classes2.dex */
public class c implements b {
    private static c jzc = null;

    private c() {
    }

    public static synchronized c cty() {
        c cVar;
        synchronized (c.class) {
            if (jzc == null) {
                jzc = new c();
            }
            cVar = jzc;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
