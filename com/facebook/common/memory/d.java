package com.facebook.common.memory;
/* loaded from: classes2.dex */
public class d implements c {
    private static d kal = null;

    public static synchronized d cCL() {
        d dVar;
        synchronized (d.class) {
            if (kal == null) {
                kal = new d();
            }
            dVar = kal;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
