package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class c implements b {
    @Nullable
    private static c oKQ = null;

    private c() {
    }

    public static synchronized c ejU() {
        c cVar;
        synchronized (c.class) {
            if (oKQ == null) {
                oKQ = new c();
            }
            cVar = oKQ;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
