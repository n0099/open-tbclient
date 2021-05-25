package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes7.dex */
public class F0 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ K0 f36820a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F0(K0 k0, Looper looper) {
        super(looper);
        this.f36820a = k0;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        int i2 = message.what;
        K0.c();
        if (i2 == 100101) {
            this.f36820a.j.removeMessages(100101);
            w0 a2 = x0.a(this.f36820a.f36854a);
            y0 y0Var = new y0(null);
            y0Var.f37183a = this.f36820a.f36855b;
            a2.a(y0Var, s1.q(this.f36820a.f36854a) * 1000, 2002, 0).a();
            this.f36820a.a(PBError.TIMEOUT);
        }
    }
}
