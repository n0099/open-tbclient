package com.facebook.common.memory;
/* loaded from: classes2.dex */
public class d implements c {
    private static d jZq = null;

    public static synchronized d cEG() {
        d dVar;
        synchronized (d.class) {
            if (jZq == null) {
                jZq = new d();
            }
            dVar = jZq;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
