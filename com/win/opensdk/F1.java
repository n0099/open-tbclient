package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes7.dex */
public class F1 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I1 f36821a;

    public F1(I1 i1) {
        this.f36821a = i1;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 11) {
            this.f36821a.f36839e = true;
            this.f36821a.k.removeMessages(11);
            x0.a(this.f36821a.f36836b).a(new y0(this.f36821a.f36840f), 2002, (this.f36821a.b() ? this.f36821a.f36840f.getWt() : 0) * 1000).a();
            this.f36821a.f36842h.onFail(PBError.TIMEOUT);
        }
    }
}
