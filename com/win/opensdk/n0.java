package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes7.dex */
public class n0 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q0 f37088a;

    public n0(q0 q0Var) {
        this.f37088a = q0Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 11) {
            this.f37088a.f37100e = true;
            this.f37088a.k.removeMessages(11);
            x0.a(this.f37088a.f37097b).a(new y0(this.f37088a.f37101f), 2002, (this.f37088a.b() ? this.f37088a.f37101f.getWt() : 0) * 1000).a();
            this.f37088a.f37103h.onFail(PBError.TIMEOUT);
        }
    }
}
