package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes6.dex */
public class F0 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ K0 f37646a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F0(K0 k0, Looper looper) {
        super(looper);
        this.f37646a = k0;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        int i2 = message.what;
        K0.c();
        if (i2 == 100101) {
            this.f37646a.j.removeMessages(100101);
            w0 a2 = x0.a(this.f37646a.f37680a);
            y0 y0Var = new y0(null);
            y0Var.f38009a = this.f37646a.f37681b;
            a2.a(y0Var, s1.q(this.f37646a.f37680a) * 1000, 2002, 0).a();
            this.f37646a.a(PBError.TIMEOUT);
        }
    }
}
