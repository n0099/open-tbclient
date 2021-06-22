package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes7.dex */
public class n0 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q0 f40870a;

    public n0(q0 q0Var) {
        this.f40870a = q0Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 11) {
            this.f40870a.f40882e = true;
            this.f40870a.k.removeMessages(11);
            x0.a(this.f40870a.f40879b).a(new y0(this.f40870a.f40883f), 2002, (this.f40870a.b() ? this.f40870a.f40883f.getWt() : 0) * 1000).a();
            this.f40870a.f40885h.onFail(PBError.TIMEOUT);
        }
    }
}
