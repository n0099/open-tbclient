package com.facebook.common.memory;
/* loaded from: classes12.dex */
public class d implements c {
    private static d mQU = null;

    public static synchronized d dCB() {
        d dVar;
        synchronized (d.class) {
            if (mQU == null) {
                mQU = new d();
            }
            dVar = mQU;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
