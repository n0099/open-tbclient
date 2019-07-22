package com.facebook.common.a;
/* loaded from: classes2.dex */
public class c implements b {
    private static c jZb = null;

    private c() {
    }

    public static synchronized c cEx() {
        c cVar;
        synchronized (c.class) {
            if (jZb == null) {
                jZb = new c();
            }
            cVar = jZb;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
