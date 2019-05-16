package com.facebook.common.a;
/* loaded from: classes2.dex */
public class c implements b {
    private static c jRT = null;

    private c() {
    }

    public static synchronized c cBv() {
        c cVar;
        synchronized (c.class) {
            if (jRT == null) {
                jRT = new c();
            }
            cVar = jRT;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
