package com.facebook.common.memory;
/* loaded from: classes13.dex */
public class d implements c {
    private static d lRN = null;

    public static synchronized d dnb() {
        d dVar;
        synchronized (d.class) {
            if (lRN == null) {
                lRN = new d();
            }
            dVar = lRN;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
