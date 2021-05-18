package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes7.dex */
public class F1 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I1 f36892a;

    public F1(I1 i1) {
        this.f36892a = i1;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 11) {
            this.f36892a.f36910e = true;
            this.f36892a.k.removeMessages(11);
            x0.a(this.f36892a.f36907b).a(new y0(this.f36892a.f36911f), 2002, (this.f36892a.b() ? this.f36892a.f36911f.getWt() : 0) * 1000).a();
            this.f36892a.f36913h.onFail(PBError.TIMEOUT);
        }
    }
}
