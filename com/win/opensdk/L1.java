package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
import com.win.opensdk.views.CloseParentView;
/* loaded from: classes7.dex */
public class L1 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CloseParentView f36875a;

    public L1(CloseParentView closeParentView) {
        this.f36875a = closeParentView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 10) {
            CloseParentView closeParentView = this.f36875a;
            closeParentView.f37145a.setText(String.valueOf(closeParentView.f37152h));
            CloseParentView closeParentView2 = this.f36875a;
            if (closeParentView2.f37152h <= 0) {
                closeParentView2.f37145a.setVisibility(8);
                this.f36875a.f37145a.setClickable(false);
                this.f36875a.f37153i.removeMessages(10);
            } else {
                closeParentView2.f37145a.setVisibility(0);
                this.f36875a.f37145a.setClickable(true);
            }
            this.f36875a.f37153i.sendEmptyMessageDelayed(10, 1000L);
            this.f36875a.f37152h--;
        }
    }
}
