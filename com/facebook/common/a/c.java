package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class c implements b {
    @Nullable
    private static c pBg = null;

    private c() {
    }

    public static synchronized c esH() {
        c cVar;
        synchronized (c.class) {
            if (pBg == null) {
                pBg = new c();
            }
            cVar = pBg;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
