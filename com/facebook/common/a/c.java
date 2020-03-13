package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c implements b {
    @Nullable
    private static c lIl = null;

    private c() {
    }

    public static synchronized c dkA() {
        c cVar;
        synchronized (c.class) {
            if (lIl == null) {
                lIl = new c();
            }
            cVar = lIl;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
