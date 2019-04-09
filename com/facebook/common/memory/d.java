package com.facebook.common.memory;
/* loaded from: classes2.dex */
public class d implements c {
    private static d jzs = null;

    public static synchronized d ctH() {
        d dVar;
        synchronized (d.class) {
            if (jzs == null) {
                jzs = new d();
            }
            dVar = jzs;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
