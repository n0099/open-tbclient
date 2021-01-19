package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes14.dex */
public class c implements b {
    @Nullable
    private static c pon = null;

    private c() {
    }

    public static synchronized c epX() {
        c cVar;
        synchronized (c.class) {
            if (pon == null) {
                pon = new c();
            }
            cVar = pon;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
