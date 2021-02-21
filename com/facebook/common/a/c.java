package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class c implements b {
    @Nullable
    private static c pzb = null;

    private c() {
    }

    public static synchronized c esy() {
        c cVar;
        synchronized (c.class) {
            if (pzb == null) {
                pzb = new c();
            }
            cVar = pzb;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
