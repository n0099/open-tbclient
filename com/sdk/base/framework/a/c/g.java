package com.sdk.base.framework.a.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes6.dex */
public final class g extends Handler {
    public g() {
        super(Looper.getMainLooper());
    }

    public /* synthetic */ g(byte b2) {
        this();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        f fVar = (f) message.obj;
        int i2 = message.what;
        if (i2 != 1) {
            if (i2 != 2) {
                return;
            }
            fVar.f36402a.a((Object[]) fVar.f36403b);
            return;
        }
        c cVar = fVar.f36402a;
        Object obj = fVar.f36403b[0];
        cVar.f36397f.get();
    }
}
