package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.push.al;
/* loaded from: classes8.dex */
class am extends Handler {
    final /* synthetic */ al a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am(al alVar, Looper looper) {
        super(looper);
        this.a = alVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        al.b bVar = (al.b) message.obj;
        if (message.what == 0) {
            bVar.a();
        } else if (message.what == 1) {
            bVar.mo223c();
        }
        super.handleMessage(message);
    }
}
