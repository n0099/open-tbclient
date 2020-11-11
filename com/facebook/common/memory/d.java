package com.facebook.common.memory;
/* loaded from: classes6.dex */
public class d implements c {
    private static d oLo = null;

    public static synchronized d ekh() {
        d dVar;
        synchronized (d.class) {
            if (oLo == null) {
                oLo = new d();
            }
            dVar = oLo;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
