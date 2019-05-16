package com.facebook.common.memory;
/* loaded from: classes2.dex */
public class d implements c {
    private static d jSi = null;

    public static synchronized d cBE() {
        d dVar;
        synchronized (d.class) {
            if (jSi == null) {
                jSi = new d();
            }
            dVar = jSi;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
