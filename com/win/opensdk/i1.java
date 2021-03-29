package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes7.dex */
public class i1 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n1 f39945a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i1(n1 n1Var, Looper looper) {
        super(looper);
        this.f39945a = n1Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        int i = message.what;
        n1.c();
        if (i == 100101) {
            this.f39945a.j.removeMessages(100101);
            Z0 a2 = a1.a(this.f39945a.f39984a);
            b1 b1Var = new b1(null);
            b1Var.f39887a = this.f39945a.f39985b;
            a2.a(b1Var, V1.s(this.f39945a.f39984a) * 1000, 2002, 0).a();
            this.f39945a.a(PBError.TIMEOUT);
        }
    }
}
