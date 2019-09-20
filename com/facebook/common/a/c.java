package com.facebook.common.a;
/* loaded from: classes2.dex */
public class c implements b {
    private static c kcE = null;

    private c() {
    }

    public static synchronized c cFG() {
        c cVar;
        synchronized (c.class) {
            if (kcE == null) {
                kcE = new c();
            }
            cVar = kcE;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
