package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class w extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C f40375a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(C c2, Looper looper) {
        super(looper);
        this.f40375a = c2;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        int i = message.what;
        if (i == 100151) {
            Info info = this.f40375a.f39931h;
            a1.a(this.f40375a.f39926c).a(new b1(this.f40375a.f39931h), 2002, (info != null ? info.getWt() : 0) * 1000).a();
            this.f40375a.o.removeMessages(100151);
            this.f40375a.a(PBError.TIMEOUT);
        } else if (i != 100152) {
        } else {
            if (this.f40375a.j.get() < 3) {
                PBBannerView pBBannerView = this.f40375a.f39925b;
                if (pBBannerView != null && pBBannerView.isVisible()) {
                    this.f40375a.e();
                    return;
                }
                C c2 = this.f40375a;
                c2.o.sendEmptyMessageDelayed(100152, c2.f39928e * 1000);
                return;
            }
            this.f40375a.o.removeMessages(100152);
        }
    }
}
