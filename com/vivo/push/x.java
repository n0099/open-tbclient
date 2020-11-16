package com.vivo.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes11.dex */
final class x extends Handler {
    /* JADX INFO: Access modifiers changed from: package-private */
    public x(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Object obj = message.obj;
        if (obj instanceof v) {
            v vVar = (v) obj;
            com.vivo.push.util.p.c("PushClientThread", "PushClientThread-handleMessage, task = " + vVar);
            vVar.run();
        }
    }
}
