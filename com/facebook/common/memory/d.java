package com.facebook.common.memory;
/* loaded from: classes13.dex */
public class d implements c {
    private static d mlF = null;

    public static synchronized d duu() {
        d dVar;
        synchronized (d.class) {
            if (mlF == null) {
                mlF = new d();
            }
            dVar = mlF;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
