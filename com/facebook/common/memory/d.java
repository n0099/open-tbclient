package com.facebook.common.memory;
/* loaded from: classes14.dex */
public class d implements c {
    private static d poM = null;

    public static synchronized d eqk() {
        d dVar;
        synchronized (d.class) {
            if (poM == null) {
                poM = new d();
            }
            dVar = poM;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
