package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes14.dex */
public class c implements b {
    @Nullable
    private static c pom = null;

    private c() {
    }

    public static synchronized c epX() {
        c cVar;
        synchronized (c.class) {
            if (pom == null) {
                pom = new c();
            }
            cVar = pom;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
