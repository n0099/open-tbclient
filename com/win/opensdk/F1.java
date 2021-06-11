package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes7.dex */
public class F1 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I1 f40500a;

    public F1(I1 i1) {
        this.f40500a = i1;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 11) {
            this.f40500a.f40518e = true;
            this.f40500a.k.removeMessages(11);
            x0.a(this.f40500a.f40515b).a(new y0(this.f40500a.f40519f), 2002, (this.f40500a.b() ? this.f40500a.f40519f.getWt() : 0) * 1000).a();
            this.f40500a.f40521h.onFail(PBError.TIMEOUT);
        }
    }
}
