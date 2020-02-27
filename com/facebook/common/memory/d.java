package com.facebook.common.memory;
/* loaded from: classes13.dex */
public class d implements c {
    private static d lIw = null;

    public static synchronized d dkK() {
        d dVar;
        synchronized (d.class) {
            if (lIw == null) {
                lIw = new d();
            }
            dVar = lIw;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
