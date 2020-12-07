package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes19.dex */
public class c implements b {
    @Nullable
    private static c pbC = null;

    private c() {
    }

    public static synchronized c epH() {
        c cVar;
        synchronized (c.class) {
            if (pbC == null) {
                pbC = new c();
            }
            cVar = pbC;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
