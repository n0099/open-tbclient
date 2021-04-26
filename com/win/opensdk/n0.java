package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes6.dex */
public class n0 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q0 f37914a;

    public n0(q0 q0Var) {
        this.f37914a = q0Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 11) {
            this.f37914a.f37926e = true;
            this.f37914a.k.removeMessages(11);
            x0.a(this.f37914a.f37923b).a(new y0(this.f37914a.f37927f), 2002, (this.f37914a.b() ? this.f37914a.f37927f.getWt() : 0) * 1000).a();
            this.f37914a.f37929h.onFail(PBError.TIMEOUT);
        }
    }
}
