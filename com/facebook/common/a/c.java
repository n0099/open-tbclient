package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class c implements b {
    @Nullable
    private static c nKe = null;

    private c() {
    }

    public static synchronized c dWh() {
        c cVar;
        synchronized (c.class) {
            if (nKe == null) {
                nKe = new c();
            }
            cVar = nKe;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
