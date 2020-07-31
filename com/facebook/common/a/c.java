package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class c implements b {
    @Nullable
    private static c mQw = null;

    private c() {
    }

    public static synchronized c dCo() {
        c cVar;
        synchronized (c.class) {
            if (mQw == null) {
                mQw = new c();
            }
            cVar = mQw;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
