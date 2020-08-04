package com.facebook.common.memory;
/* loaded from: classes12.dex */
public class d implements c {
    private static d mQW = null;

    public static synchronized d dCC() {
        d dVar;
        synchronized (d.class) {
            if (mQW == null) {
                mQW = new d();
            }
            dVar = mQW;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}
