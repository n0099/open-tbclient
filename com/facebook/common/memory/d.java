package com.facebook.common.memory;
/* loaded from: classes13.dex */
public class d implements c {
    private static d mIP = null;

    public static synchronized d dzl() {
        d dVar;
        synchronized (d.class) {
            if (mIP == null) {
                mIP = new d();
            }
            dVar = mIP;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
