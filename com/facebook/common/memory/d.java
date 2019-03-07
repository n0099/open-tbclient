package com.facebook.common.memory;
/* loaded from: classes2.dex */
public class d implements c {
    private static d jzM = null;

    public static synchronized d ctB() {
        d dVar;
        synchronized (d.class) {
            if (jzM == null) {
                jzM = new d();
            }
            dVar = jzM;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
