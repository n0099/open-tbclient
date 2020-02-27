package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c implements b {
    @Nullable
    private static c lHY = null;

    private c() {
    }

    public static synchronized c dkx() {
        c cVar;
        synchronized (c.class) {
            if (lHY == null) {
                lHY = new c();
            }
            cVar = lHY;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
