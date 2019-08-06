package com.facebook.common.a;
/* loaded from: classes2.dex */
public class c implements b {
    private static c kah = null;

    private c() {
    }

    public static synchronized c cES() {
        c cVar;
        synchronized (c.class) {
            if (kah == null) {
                kah = new c();
            }
            cVar = kah;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
