package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes7.dex */
public class i1 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n1 f39944a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i1(n1 n1Var, Looper looper) {
        super(looper);
        this.f39944a = n1Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        int i = message.what;
        n1.c();
        if (i == 100101) {
            this.f39944a.j.removeMessages(100101);
            Z0 a2 = a1.a(this.f39944a.f39983a);
            b1 b1Var = new b1(null);
            b1Var.f39886a = this.f39944a.f39984b;
            a2.a(b1Var, V1.s(this.f39944a.f39983a) * 1000, 2002, 0).a();
            this.f39944a.a(PBError.TIMEOUT);
        }
    }
}
