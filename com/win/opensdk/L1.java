package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
import com.win.opensdk.views.CloseParentView;
/* loaded from: classes7.dex */
public class L1 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CloseParentView f36946a;

    public L1(CloseParentView closeParentView) {
        this.f36946a = closeParentView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 10) {
            CloseParentView closeParentView = this.f36946a;
            closeParentView.f37216a.setText(String.valueOf(closeParentView.f37223h));
            CloseParentView closeParentView2 = this.f36946a;
            if (closeParentView2.f37223h <= 0) {
                closeParentView2.f37216a.setVisibility(8);
                this.f36946a.f37216a.setClickable(false);
                this.f36946a.f37224i.removeMessages(10);
            } else {
                closeParentView2.f37216a.setVisibility(0);
                this.f36946a.f37216a.setClickable(true);
            }
            this.f36946a.f37224i.sendEmptyMessageDelayed(10, 1000L);
            this.f36946a.f37223h--;
        }
    }
}
