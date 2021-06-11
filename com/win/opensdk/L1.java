package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
import com.win.opensdk.views.CloseParentView;
/* loaded from: classes7.dex */
public class L1 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CloseParentView f40554a;

    public L1(CloseParentView closeParentView) {
        this.f40554a = closeParentView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 10) {
            CloseParentView closeParentView = this.f40554a;
            closeParentView.f40824a.setText(String.valueOf(closeParentView.f40831h));
            CloseParentView closeParentView2 = this.f40554a;
            if (closeParentView2.f40831h <= 0) {
                closeParentView2.f40824a.setVisibility(8);
                this.f40554a.f40824a.setClickable(false);
                this.f40554a.f40832i.removeMessages(10);
            } else {
                closeParentView2.f40824a.setVisibility(0);
                this.f40554a.f40824a.setClickable(true);
            }
            this.f40554a.f40832i.sendEmptyMessageDelayed(10, 1000L);
            this.f40554a.f40831h--;
        }
    }
}
