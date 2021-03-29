package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes7.dex */
public class i2 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m2 f39946a;

    public i2(m2 m2Var) {
        this.f39946a = m2Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 11) {
            this.f39946a.f39979e = true;
            this.f39946a.k.removeMessages(11);
            a1.a(this.f39946a.f39976b).a(new b1(this.f39946a.f39980f), 2002, (this.f39946a.b() ? this.f39946a.f39980f.getWt() : 0) * 1000).a();
            this.f39946a.f39982h.onFail(PBError.TIMEOUT);
        }
    }
}
