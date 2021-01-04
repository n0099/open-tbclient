package com.facebook.common.memory;
/* loaded from: classes3.dex */
public class d implements c {
    private static d pth = null;

    public static synchronized d etY() {
        d dVar;
        synchronized (d.class) {
            if (pth == null) {
                pth = new d();
            }
            dVar = pth;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
