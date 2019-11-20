package com.facebook.common.a;
/* loaded from: classes2.dex */
public class c implements b {
    private static c jZW = null;

    private c() {
    }

    public static synchronized c cCC() {
        c cVar;
        synchronized (c.class) {
            if (jZW == null) {
                jZW = new c();
            }
            cVar = jZW;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
