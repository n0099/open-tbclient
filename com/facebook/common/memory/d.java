package com.facebook.common.memory;
/* loaded from: classes2.dex */
public class d implements c {
    private static d ijc = null;

    public static synchronized d bTV() {
        d dVar;
        synchronized (d.class) {
            if (ijc == null) {
                ijc = new d();
            }
            dVar = ijc;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
