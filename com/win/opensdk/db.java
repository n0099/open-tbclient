package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes14.dex */
public class db extends Handler {
    public final /* synthetic */ Cdo qlG;

    public db(Cdo cdo) {
        this.qlG = cdo;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 11) {
            this.qlG.e = true;
            this.qlG.k.removeMessages(11);
            ca.iT(this.qlG.b).a(new cd(this.qlG.qlN), 2002, (this.qlG.b() ? this.qlG.qlN.getWt() : 0) * 1000).a();
            this.qlG.qlP.onFail(PBError.TIMEOUT);
        }
    }
}
