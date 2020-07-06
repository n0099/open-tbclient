package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c implements b {
    @Nullable
    private static c mIt = null;

    private c() {
    }

    public static synchronized c dzc() {
        c cVar;
        synchronized (c.class) {
            if (mIt == null) {
                mIt = new c();
            }
            cVar = mIt;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
