package com.facebook.common.memory;
/* loaded from: classes4.dex */
public class d implements c {
    private static d pBD = null;

    public static synchronized d esU() {
        d dVar;
        synchronized (d.class) {
            if (pBD == null) {
                pBD = new d();
            }
            dVar = pBD;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
