package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c implements b {
    @Nullable
    private static c mmr = null;

    private c() {
    }

    public static synchronized c duv() {
        c cVar;
        synchronized (c.class) {
            if (mmr == null) {
                mmr = new c();
            }
            cVar = mmr;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
