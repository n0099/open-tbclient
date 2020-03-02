package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c implements b {
    @Nullable
    private static c lIa = null;

    private c() {
    }

    public static synchronized c dkz() {
        c cVar;
        synchronized (c.class) {
            if (lIa == null) {
                lIa = new c();
            }
            cVar = lIa;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
