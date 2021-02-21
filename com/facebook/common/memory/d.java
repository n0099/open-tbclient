package com.facebook.common.memory;
/* loaded from: classes6.dex */
public class d implements c {
    private static d pzy = null;

    public static synchronized d esL() {
        d dVar;
        synchronized (d.class) {
            if (pzy == null) {
                pzy = new d();
            }
            dVar = pzy;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
