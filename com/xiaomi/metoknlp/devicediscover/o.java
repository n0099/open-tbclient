package com.xiaomi.metoknlp.devicediscover;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class o extends Handler {
    final /* synthetic */ g a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(g gVar, Looper looper) {
        super(looper);
        this.a = gVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.a.a(false);
                return;
            case 2:
                this.a.b(message.obj != null ? ((Boolean) message.obj).booleanValue() : false);
                return;
            default:
                return;
        }
    }
}
