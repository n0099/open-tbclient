package com.facebook.common.memory;
/* loaded from: classes17.dex */
public class d implements c {
    private static d nvj = null;

    public static synchronized d dSJ() {
        d dVar;
        synchronized (d.class) {
            if (nvj == null) {
                nvj = new d();
            }
            dVar = nvj;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
