package com.facebook.common.memory;
/* loaded from: classes2.dex */
public class d implements c {
    private static d ikj = null;

    public static synchronized d bUD() {
        d dVar;
        synchronized (d.class) {
            if (ikj == null) {
                ikj = new d();
            }
            dVar = ikj;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
