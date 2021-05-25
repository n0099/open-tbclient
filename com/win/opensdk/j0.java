package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes7.dex */
public class j0 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m0 f37074a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(m0 m0Var, Looper looper) {
        super(looper);
        this.f37074a = m0Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what != 1101) {
            return;
        }
        this.f37074a.f37084e.removeMessages(1101);
        m0 m0Var = this.f37074a;
        if (!m0Var.f37081b && m0Var.a(m0Var.f37080a)) {
            l0 l0Var = this.f37074a.f37082c;
            if (l0Var != null) {
                l0Var.a();
            }
            this.f37074a.f37081b = true;
            return;
        }
        this.f37074a.f37084e.sendEmptyMessageDelayed(1101, 300L);
    }
}
