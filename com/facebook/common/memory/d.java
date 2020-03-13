package com.facebook.common.memory;
/* loaded from: classes13.dex */
public class d implements c {
    private static d lIJ = null;

    public static synchronized d dkN() {
        d dVar;
        synchronized (d.class) {
            if (lIJ == null) {
                lIJ = new d();
            }
            dVar = lIJ;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
