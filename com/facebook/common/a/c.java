package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class c implements b {
    @Nullable
    private static c lDO = null;

    private c() {
    }

    public static synchronized c dih() {
        c cVar;
        synchronized (c.class) {
            if (lDO == null) {
                lDO = new c();
            }
            cVar = lDO;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
