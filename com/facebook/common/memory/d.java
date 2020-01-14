package com.facebook.common.memory;
/* loaded from: classes12.dex */
public class d implements c {
    private static d lHP = null;

    public static synchronized d djx() {
        d dVar;
        synchronized (d.class) {
            if (lHP == null) {
                lHP = new d();
            }
            dVar = lHP;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
