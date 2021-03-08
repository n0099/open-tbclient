package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.win.opensdk.core.Info;
/* loaded from: classes14.dex */
public class et extends Handler {
    public final /* synthetic */ l qmt;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public et(l lVar, Looper looper) {
        super(looper);
        this.qmt = lVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        int i = message.what;
        if (i == 100151) {
            Info info = this.qmt.qkm;
            ca.iT(this.qmt.c).a(new cd(this.qmt.qkm), 2002, (info != null ? info.getWt() : 0) * 1000).a();
            this.qmt.o.removeMessages(100151);
            this.qmt.a(PBError.TIMEOUT);
        } else if (i == 100152) {
            if (this.qmt.j.get() < 3) {
                PBBannerView pBBannerView = this.qmt.qkj;
                if (pBBannerView != null && pBBannerView.isVisible()) {
                    this.qmt.e();
                    return;
                }
                l lVar = this.qmt;
                lVar.o.sendEmptyMessageDelayed(100152, lVar.e * 1000);
                return;
            }
            this.qmt.o.removeMessages(100152);
        }
    }
}
