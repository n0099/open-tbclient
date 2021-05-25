package com.sdk.base.framework.a.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes7.dex */
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
            fVar.f35576a.a((Object[]) fVar.f35577b);
            return;
        }
        c cVar = fVar.f35576a;
        Object obj = fVar.f35577b[0];
        cVar.f35571f.get();
    }
}
