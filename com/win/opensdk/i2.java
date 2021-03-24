package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes7.dex */
public class i2 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m2 f39945a;

    public i2(m2 m2Var) {
        this.f39945a = m2Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 11) {
            this.f39945a.f39978e = true;
            this.f39945a.k.removeMessages(11);
            a1.a(this.f39945a.f39975b).a(new b1(this.f39945a.f39979f), 2002, (this.f39945a.b() ? this.f39945a.f39979f.getWt() : 0) * 1000).a();
            this.f39945a.f39981h.onFail(PBError.TIMEOUT);
        }
    }
}
