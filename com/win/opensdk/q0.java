package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes7.dex */
public class q0 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t0 f40402a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(t0 t0Var, Looper looper) {
        super(looper);
        this.f40402a = t0Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what != 1101) {
            return;
        }
        this.f40402a.f40419e.removeMessages(1101);
        t0 t0Var = this.f40402a;
        if (!t0Var.f40416b && t0Var.a(t0Var.f40415a)) {
            s0 s0Var = this.f40402a.f40417c;
            if (s0Var != null) {
                s0Var.a();
            }
            this.f40402a.f40416b = true;
            return;
        }
        this.f40402a.f40419e.sendEmptyMessageDelayed(1101, 300L);
    }
}
