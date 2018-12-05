package com.facebook.common.a;
/* loaded from: classes2.dex */
public class c implements b {
    private static c ifD = null;

    private c() {
    }

    public static synchronized c bSW() {
        c cVar;
        synchronized (c.class) {
            if (ifD == null) {
                ifD = new c();
            }
            cVar = ifD;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
