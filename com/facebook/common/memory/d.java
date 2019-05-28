package com.facebook.common.memory;
/* loaded from: classes2.dex */
public class d implements c {
    private static d jSj = null;

    public static synchronized d cBG() {
        d dVar;
        synchronized (d.class) {
            if (jSj == null) {
                jSj = new d();
            }
            dVar = jSj;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
