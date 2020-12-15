package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes19.dex */
public class c implements b {
    @Nullable
    private static c pbE = null;

    private c() {
    }

    public static synchronized c epI() {
        c cVar;
        synchronized (c.class) {
            if (pbE == null) {
                pbE = new c();
            }
            cVar = pbE;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
