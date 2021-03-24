package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes7.dex */
public class u0 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y0 f40044a;

    public u0(y0 y0Var) {
        this.f40044a = y0Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 11) {
            this.f40044a.f40109e = true;
            this.f40044a.k.removeMessages(11);
            a1.a(this.f40044a.f40106b).a(new b1(this.f40044a.f40110f), 2002, (this.f40044a.b() ? this.f40044a.f40110f.getWt() : 0) * 1000).a();
            this.f40044a.f40112h.onFail(PBError.TIMEOUT);
        }
    }
}
