package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class c implements b {
    @Nullable
    private static c lHr = null;

    private c() {
    }

    public static synchronized c djk() {
        c cVar;
        synchronized (c.class) {
            if (lHr == null) {
                lHr = new c();
            }
            cVar = lHr;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
