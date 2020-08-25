package com.facebook.common.memory;
/* loaded from: classes9.dex */
public class d implements c {
    private static d nkR = null;

    public static synchronized d dOC() {
        d dVar;
        synchronized (d.class) {
            if (nkR == null) {
                nkR = new d();
            }
            dVar = nkR;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
