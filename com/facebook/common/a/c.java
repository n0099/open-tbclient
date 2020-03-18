package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c implements b {
    @Nullable
    private static c lJR = null;

    private c() {
    }

    public static synchronized c dkX() {
        c cVar;
        synchronized (c.class) {
            if (lJR == null) {
                lJR = new c();
            }
            cVar = lJR;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
