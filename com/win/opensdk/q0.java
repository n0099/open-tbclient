package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes7.dex */
public class q0 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t0 f40018a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(t0 t0Var, Looper looper) {
        super(looper);
        this.f40018a = t0Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what != 1101) {
            return;
        }
        this.f40018a.f40035e.removeMessages(1101);
        t0 t0Var = this.f40018a;
        if (!t0Var.f40032b && t0Var.a(t0Var.f40031a)) {
            s0 s0Var = this.f40018a.f40033c;
            if (s0Var != null) {
                s0Var.a();
            }
            this.f40018a.f40032b = true;
            return;
        }
        this.f40018a.f40035e.sendEmptyMessageDelayed(1101, 300L);
    }
}
