package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class w extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C f40470a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(C c2, Looper looper) {
        super(looper);
        this.f40470a = c2;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        int i = message.what;
        if (i == 100151) {
            Info info = this.f40470a.f40026h;
            a1.a(this.f40470a.f40021c).a(new b1(this.f40470a.f40026h), 2002, (info != null ? info.getWt() : 0) * 1000).a();
            this.f40470a.o.removeMessages(100151);
            this.f40470a.a(PBError.TIMEOUT);
        } else if (i != 100152) {
        } else {
            if (this.f40470a.j.get() < 3) {
                PBBannerView pBBannerView = this.f40470a.f40020b;
                if (pBBannerView != null && pBBannerView.isVisible()) {
                    this.f40470a.e();
                    return;
                }
                C c2 = this.f40470a;
                c2.o.sendEmptyMessageDelayed(100152, c2.f40023e * 1000);
                return;
            }
            this.f40470a.o.removeMessages(100152);
        }
    }
}
