package com.facebook.common.memory;
/* loaded from: classes2.dex */
public class d implements c {
    private static d hWV = null;

    public static synchronized d bRE() {
        d dVar;
        synchronized (d.class) {
            if (hWV == null) {
                hWV = new d();
            }
            dVar = hWV;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
