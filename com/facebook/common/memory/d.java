package com.facebook.common.memory;
/* loaded from: classes2.dex */
public class d implements c {
    private static d jzX = null;

    public static synchronized d ctO() {
        d dVar;
        synchronized (d.class) {
            if (jzX == null) {
                jzX = new d();
            }
            dVar = jzX;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
