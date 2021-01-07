package com.sdk.base.framework.a.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class g extends Handler {
    private g() {
        super(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ g(byte b2) {
        this();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        f fVar = (f) message.obj;
        switch (message.what) {
            case 1:
                c cVar = fVar.f13082a;
                Object obj = fVar.f13083b[0];
                cVar.f.get();
                return;
            case 2:
                fVar.f13082a.a((Object[]) fVar.f13083b);
                return;
            default:
                return;
        }
    }
}
