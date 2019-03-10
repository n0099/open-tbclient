package com.facebook.common.memory;
/* loaded from: classes2.dex */
public class d implements c {
    private static d jAf = null;

    public static synchronized d ctL() {
        d dVar;
        synchronized (d.class) {
            if (jAf == null) {
                jAf = new d();
            }
            dVar = jAf;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
