package com.facebook.common.memory;
/* loaded from: classes2.dex */
public class d implements c {
    private static d jzr = null;

    public static synchronized d ctH() {
        d dVar;
        synchronized (d.class) {
            if (jzr == null) {
                jzr = new d();
            }
            dVar = jzr;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
