package com.facebook.common.memory;
/* loaded from: classes2.dex */
public class d implements c {
    private static d kbc = null;

    public static synchronized d cCN() {
        d dVar;
        synchronized (d.class) {
            if (kbc == null) {
                kbc = new d();
            }
            dVar = kbc;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
