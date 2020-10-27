package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class c implements b {
    @Nullable
    private static c oBx = null;

    private c() {
    }

    public static synchronized c egf() {
        c cVar;
        synchronized (c.class) {
            if (oBx == null) {
                oBx = new c();
            }
            cVar = oBx;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
