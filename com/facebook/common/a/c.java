package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class c implements b {
    @Nullable
    private static c psP = null;

    private c() {
    }

    public static synchronized c etN() {
        c cVar;
        synchronized (c.class) {
            if (psP == null) {
                psP = new c();
            }
            cVar = psP;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
