package com.facebook.common.memory;
/* loaded from: classes2.dex */
public class d implements c {
    private static d kaw = null;

    public static synchronized d cFb() {
        d dVar;
        synchronized (d.class) {
            if (kaw == null) {
                kaw = new d();
            }
            dVar = kaw;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
