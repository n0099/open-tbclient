package com.facebook.common.memory;
/* loaded from: classes6.dex */
public class d implements c {
    private static d oBV = null;

    public static synchronized d egs() {
        d dVar;
        synchronized (d.class) {
            if (oBV == null) {
                oBV = new d();
            }
            dVar = oBV;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
