package com.facebook.common.memory;
/* loaded from: classes6.dex */
public class d implements c {
    private static d pyY = null;

    public static synchronized d esD() {
        d dVar;
        synchronized (d.class) {
            if (pyY == null) {
                pyY = new d();
            }
            dVar = pyY;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
