package com.facebook.common.memory;
/* loaded from: classes19.dex */
public class d implements c {
    private static d pcc = null;

    public static synchronized d epV() {
        d dVar;
        synchronized (d.class) {
            if (pcc == null) {
                pcc = new d();
            }
            dVar = pcc;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
