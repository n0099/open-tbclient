package com.facebook.common.memory;
/* loaded from: classes13.dex */
public class d implements c {
    private static d lIy = null;

    public static synchronized d dkM() {
        d dVar;
        synchronized (d.class) {
            if (lIy == null) {
                lIy = new d();
            }
            dVar = lIy;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
