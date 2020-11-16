package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class c implements b {
    @Nullable
    private static c oMu = null;

    private c() {
    }

    public static synchronized c ejS() {
        c cVar;
        synchronized (c.class) {
            if (oMu == null) {
                oMu = new c();
            }
            cVar = oMu;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
