package com.facebook.common.memory;
/* loaded from: classes13.dex */
public class d implements c {
    private static d lKp = null;

    public static synchronized d dlk() {
        d dVar;
        synchronized (d.class) {
            if (lKp == null) {
                lKp = new d();
            }
            dVar = lKp;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
