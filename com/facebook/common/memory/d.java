package com.facebook.common.memory;
/* loaded from: classes2.dex */
public class d implements c {
    private static d jSm = null;

    public static synchronized d cBF() {
        d dVar;
        synchronized (d.class) {
            if (jSm == null) {
                jSm = new d();
            }
            dVar = jSm;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
