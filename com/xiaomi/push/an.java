package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.push.am;
/* loaded from: classes8.dex */
public class an extends Handler {
    public final /* synthetic */ am a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(am amVar, Looper looper) {
        super(looper);
        this.a = amVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        am.b bVar = (am.b) message.obj;
        int i = message.what;
        if (i == 0) {
            bVar.a();
        } else if (i == 1) {
            bVar.mo280c();
        }
        super.handleMessage(message);
    }
}
