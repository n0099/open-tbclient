package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class c implements b {
    @Nullable
    private static c nkt = null;

    private c() {
    }

    public static synchronized c dOp() {
        c cVar;
        synchronized (c.class) {
            if (nkt == null) {
                nkt = new c();
            }
            cVar = nkt;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
