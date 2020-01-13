package com.facebook.common.memory;
/* loaded from: classes12.dex */
public class d implements c {
    private static d lHK = null;

    public static synchronized d djv() {
        d dVar;
        synchronized (d.class) {
            if (lHK == null) {
                lHK = new d();
            }
            dVar = lHK;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
