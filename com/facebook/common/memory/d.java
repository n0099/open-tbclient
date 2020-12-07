package com.facebook.common.memory;
/* loaded from: classes19.dex */
public class d implements c {
    private static d pca = null;

    public static synchronized d epU() {
        d dVar;
        synchronized (d.class) {
            if (pca == null) {
                pca = new d();
            }
            dVar = pca;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
