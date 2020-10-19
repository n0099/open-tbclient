package com.facebook.common.memory;
/* loaded from: classes6.dex */
public class d implements c {
    private static d nKC = null;

    public static synchronized d dWu() {
        d dVar;
        synchronized (d.class) {
            if (nKC == null) {
                nKC = new d();
            }
            dVar = nKC;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
