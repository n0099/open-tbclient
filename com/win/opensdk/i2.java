package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes7.dex */
public class i2 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m2 f40330a;

    public i2(m2 m2Var) {
        this.f40330a = m2Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 11) {
            this.f40330a.f40363e = true;
            this.f40330a.k.removeMessages(11);
            a1.a(this.f40330a.f40360b).a(new b1(this.f40330a.f40364f), 2002, (this.f40330a.b() ? this.f40330a.f40364f.getWt() : 0) * 1000).a();
            this.f40330a.f40366h.onFail(PBError.TIMEOUT);
        }
    }
}
