package com.facebook.common.memory;
/* loaded from: classes3.dex */
public class d implements c {
    private static d pto = null;

    public static synchronized d eue() {
        d dVar;
        synchronized (d.class) {
            if (pto == null) {
                pto = new d();
            }
            dVar = pto;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
