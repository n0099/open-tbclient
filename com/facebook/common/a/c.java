package com.facebook.common.a;

import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class c implements b {
    @Nullable
    private static c mIo = null;

    private c() {
    }

    public static synchronized c dyY() {
        c cVar;
        synchronized (c.class) {
            if (mIo == null) {
                mIo = new c();
            }
            cVar = mIo;
        }
        return cVar;
    }

    @Override // com.facebook.common.a.b
    public void a(a aVar) {
    }
}
