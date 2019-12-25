package com.facebook.common.memory;
/* loaded from: classes11.dex */
public class d implements c {
    private static d lEm = null;

    public static synchronized d diu() {
        d dVar;
        synchronized (d.class) {
            if (lEm == null) {
                lEm = new d();
            }
            dVar = lEm;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
