package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class c implements b {
    @Nullable
    private static c psQ = null;

    private c() {
    }

    public static synchronized c etR() {
        c cVar;
        synchronized (c.class) {
            if (psQ == null) {
                psQ = new c();
            }
            cVar = psQ;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
