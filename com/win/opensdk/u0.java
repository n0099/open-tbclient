package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes7.dex */
public class u0 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y0 f40429a;

    public u0(y0 y0Var) {
        this.f40429a = y0Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 11) {
            this.f40429a.f40494e = true;
            this.f40429a.k.removeMessages(11);
            a1.a(this.f40429a.f40491b).a(new b1(this.f40429a.f40495f), 2002, (this.f40429a.b() ? this.f40429a.f40495f.getWt() : 0) * 1000).a();
            this.f40429a.f40497h.onFail(PBError.TIMEOUT);
        }
    }
}
