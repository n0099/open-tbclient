package com.facebook.common.memory;
/* loaded from: classes2.dex */
public class d implements c {
    private static d ikk = null;

    public static synchronized d bUD() {
        d dVar;
        synchronized (d.class) {
            if (ikk == null) {
                ikk = new d();
            }
            dVar = ikk;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
