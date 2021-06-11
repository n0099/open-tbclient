package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes7.dex */
public class j0 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m0 f40753a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(m0 m0Var, Looper looper) {
        super(looper);
        this.f40753a = m0Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what != 1101) {
            return;
        }
        this.f40753a.f40763e.removeMessages(1101);
        m0 m0Var = this.f40753a;
        if (!m0Var.f40760b && m0Var.a(m0Var.f40759a)) {
            l0 l0Var = this.f40753a.f40761c;
            if (l0Var != null) {
                l0Var.a();
            }
            this.f40753a.f40760b = true;
            return;
        }
        this.f40753a.f40763e.sendEmptyMessageDelayed(1101, 300L);
    }
}
