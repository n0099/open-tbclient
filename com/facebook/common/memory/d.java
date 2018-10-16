package com.facebook.common.memory;
/* loaded from: classes2.dex */
public class d implements c {
    private static d hWU = null;

    public static synchronized d bRE() {
        d dVar;
        synchronized (d.class) {
            if (hWU == null) {
                hWU = new d();
            }
            dVar = hWU;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
