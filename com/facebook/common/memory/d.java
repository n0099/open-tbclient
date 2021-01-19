package com.facebook.common.memory;
/* loaded from: classes14.dex */
public class d implements c {
    private static d poN = null;

    public static synchronized d eqk() {
        d dVar;
        synchronized (d.class) {
            if (poN == null) {
                poN = new d();
            }
            dVar = poN;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
