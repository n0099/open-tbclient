package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes17.dex */
public class c implements b {
    @Nullable
    private static c nuL = null;

    private c() {
    }

    public static synchronized c dSw() {
        c cVar;
        synchronized (c.class) {
            if (nuL == null) {
                nuL = new c();
            }
            cVar = nuL;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
