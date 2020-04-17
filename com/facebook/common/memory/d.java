package com.facebook.common.memory;
/* loaded from: classes13.dex */
public class d implements c {
    private static d lRJ = null;

    public static synchronized d dnd() {
        d dVar;
        synchronized (d.class) {
            if (lRJ == null) {
                lRJ = new d();
            }
            dVar = lRJ;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
