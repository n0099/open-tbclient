package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c implements b {
    @Nullable
    private static c lRl = null;

    private c() {
    }

    public static synchronized c dmQ() {
        c cVar;
        synchronized (c.class) {
            if (lRl == null) {
                lRl = new c();
            }
            cVar = lRl;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
