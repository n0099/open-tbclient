package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class c implements b {
    @Nullable
    private static c lHm = null;

    private c() {
    }

    public static synchronized c dji() {
        c cVar;
        synchronized (c.class) {
            if (lHm == null) {
                lHm = new c();
            }
            cVar = lHm;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
