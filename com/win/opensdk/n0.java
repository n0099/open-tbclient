package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes7.dex */
public class n0 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q0 f40767a;

    public n0(q0 q0Var) {
        this.f40767a = q0Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 11) {
            this.f40767a.f40779e = true;
            this.f40767a.k.removeMessages(11);
            x0.a(this.f40767a.f40776b).a(new y0(this.f40767a.f40780f), 2002, (this.f40767a.b() ? this.f40767a.f40780f.getWt() : 0) * 1000).a();
            this.f40767a.f40782h.onFail(PBError.TIMEOUT);
        }
    }
}
