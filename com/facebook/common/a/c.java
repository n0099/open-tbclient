package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c implements b {
    @Nullable
    private static c lRp = null;

    private c() {
    }

    public static synchronized c dmN() {
        c cVar;
        synchronized (c.class) {
            if (lRp == null) {
                lRp = new c();
            }
            cVar = lRp;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
