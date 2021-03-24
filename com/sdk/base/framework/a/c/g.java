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
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            fVar.f38436a.a((Object[]) fVar.f38437b);
            return;
        }
        c cVar = fVar.f38436a;
        Object obj = fVar.f38437b[0];
        cVar.f38431f.get();
    }
}
