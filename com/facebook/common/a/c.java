package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c implements b {
    @Nullable
    private static c mlh = null;

    private c() {
    }

    public static synchronized c duh() {
        c cVar;
        synchronized (c.class) {
            if (mlh == null) {
                mlh = new c();
            }
            cVar = mlh;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
