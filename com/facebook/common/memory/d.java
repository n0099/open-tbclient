package com.facebook.common.memory;
/* loaded from: classes9.dex */
public class d implements c {
    private static d nlj = null;

    public static synchronized d dOL() {
        d dVar;
        synchronized (d.class) {
            if (nlj == null) {
                nlj = new d();
            }
            dVar = nlj;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
