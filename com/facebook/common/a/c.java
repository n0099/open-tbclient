package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class c implements b {
    @Nullable
    private static c nkL = null;

    private c() {
    }

    public static synchronized c dOy() {
        c cVar;
        synchronized (c.class) {
            if (nkL == null) {
                nkL = new c();
            }
            cVar = nkL;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
