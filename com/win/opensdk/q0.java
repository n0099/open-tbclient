package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes7.dex */
public class q0 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t0 f40307a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(t0 t0Var, Looper looper) {
        super(looper);
        this.f40307a = t0Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what != 1101) {
            return;
        }
        this.f40307a.f40324e.removeMessages(1101);
        t0 t0Var = this.f40307a;
        if (!t0Var.f40321b && t0Var.a(t0Var.f40320a)) {
            s0 s0Var = this.f40307a.f40322c;
            if (s0Var != null) {
                s0Var.a();
            }
            this.f40307a.f40321b = true;
            return;
        }
        this.f40307a.f40324e.sendEmptyMessageDelayed(1101, 300L);
    }
}
