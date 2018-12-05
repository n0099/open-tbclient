package com.facebook.common.memory;
/* loaded from: classes2.dex */
public class d implements c {
    private static d ifS = null;

    public static synchronized d bTf() {
        d dVar;
        synchronized (d.class) {
            if (ifS == null) {
                ifS = new d();
            }
            dVar = ifS;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
