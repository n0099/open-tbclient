package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class c implements b {
    @Nullable
    private static c mQy = null;

    private c() {
    }

    public static synchronized c dCp() {
        c cVar;
        synchronized (c.class) {
            if (mQy == null) {
                mQy = new c();
            }
            cVar = mQy;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
