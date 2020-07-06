package com.facebook.common.memory;
/* loaded from: classes13.dex */
public class d implements c {
    private static d mIS = null;

    public static synchronized d dzp() {
        d dVar;
        synchronized (d.class) {
            if (mIS == null) {
                mIS = new d();
            }
            dVar = mIS;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
