package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class c implements b {
    @Nullable
    private static c pyB = null;

    private c() {
    }

    public static synchronized c esq() {
        c cVar;
        synchronized (c.class) {
            if (pyB == null) {
                pyB = new c();
            }
            cVar = pyB;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
