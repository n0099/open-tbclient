package com.facebook.common.memory;
/* loaded from: classes12.dex */
public class d implements c {
    private static d oMS = null;

    public static synchronized d ekf() {
        d dVar;
        synchronized (d.class) {
            if (oMS == null) {
                oMS = new d();
            }
            dVar = oMS;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
