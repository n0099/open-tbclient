package com.sdk.base.framework.a.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes16.dex */
public final class g extends Handler {
    private g() {
        super(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ g(byte b) {
        this();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        f fVar = (f) message.obj;
        switch (message.what) {
            case 1:
                c cVar = fVar.f4464a;
                Object obj = fVar.b[0];
                cVar.f.get();
                return;
            case 2:
                fVar.f4464a.a((Object[]) fVar.b);
                return;
            default:
                return;
        }
    }
}
