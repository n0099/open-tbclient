package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes7.dex */
public class i2 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m2 f40235a;

    public i2(m2 m2Var) {
        this.f40235a = m2Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 11) {
            this.f40235a.f40268e = true;
            this.f40235a.k.removeMessages(11);
            a1.a(this.f40235a.f40265b).a(new b1(this.f40235a.f40269f), 2002, (this.f40235a.b() ? this.f40235a.f40269f.getWt() : 0) * 1000).a();
            this.f40235a.f40271h.onFail(PBError.TIMEOUT);
        }
    }
}
