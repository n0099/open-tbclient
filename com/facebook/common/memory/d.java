package com.facebook.common.memory;
/* loaded from: classes2.dex */
public class d implements c {
    private static d kcT = null;

    public static synchronized d cFP() {
        d dVar;
        synchronized (d.class) {
            if (kcT == null) {
                kcT = new d();
            }
            dVar = kcT;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
