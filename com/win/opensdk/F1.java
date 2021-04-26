package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes6.dex */
public class F1 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ I1 f37647a;

    public F1(I1 i1) {
        this.f37647a = i1;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 11) {
            this.f37647a.f37665e = true;
            this.f37647a.k.removeMessages(11);
            x0.a(this.f37647a.f37662b).a(new y0(this.f37647a.f37666f), 2002, (this.f37647a.b() ? this.f37647a.f37666f.getWt() : 0) * 1000).a();
            this.f37647a.f37668h.onFail(PBError.TIMEOUT);
        }
    }
}
