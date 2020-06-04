package com.facebook.common.memory;
/* loaded from: classes13.dex */
public class d implements c {
    private static d mmP = null;

    public static synchronized d duI() {
        d dVar;
        synchronized (d.class) {
            if (mmP == null) {
                mmP = new d();
            }
            dVar = mmP;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
