package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes14.dex */
public class eo extends Handler {
    public final /* synthetic */ fa qml;

    public eo(fa faVar) {
        this.qml = faVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 11) {
            this.qml.e = true;
            this.qml.k.removeMessages(11);
            ca.iT(this.qml.b).a(new cd(this.qml.qlN), 2002, (this.qml.b() ? this.qml.qlN.getWt() : 0) * 1000).a();
            this.qml.qmx.onFail(PBError.TIMEOUT);
        }
    }
}
