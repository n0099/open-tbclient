package com.facebook.common.memory;
/* loaded from: classes2.dex */
public class d implements c {
    private static d hYF = null;

    public static synchronized d bQZ() {
        d dVar;
        synchronized (d.class) {
            if (hYF == null) {
                hYF = new d();
            }
            dVar = hYF;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
