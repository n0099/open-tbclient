package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes14.dex */
public class da extends Handler {
    public final /* synthetic */ dq qlF;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public da(dq dqVar, Looper looper) {
        super(looper);
        this.qlF = dqVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        int i = message.what;
        dq.c();
        if (i == 100101) {
            this.qlF.j.removeMessages(100101);
            int iO = bp.iO(this.qlF.f8157a) * 1000;
            bx iT = ca.iT(this.qlF.f8157a);
            cd cdVar = new cd(null);
            cdVar.f8141a = this.qlF.b;
            iT.a(cdVar, iO, 2002, 0).a();
            this.qlF.a(PBError.TIMEOUT);
        }
    }
}
