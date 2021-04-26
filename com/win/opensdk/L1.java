package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
import com.win.opensdk.views.CloseParentView;
/* loaded from: classes6.dex */
public class L1 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CloseParentView f37701a;

    public L1(CloseParentView closeParentView) {
        this.f37701a = closeParentView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 10) {
            CloseParentView closeParentView = this.f37701a;
            closeParentView.f37971a.setText(String.valueOf(closeParentView.f37978h));
            CloseParentView closeParentView2 = this.f37701a;
            if (closeParentView2.f37978h <= 0) {
                closeParentView2.f37971a.setVisibility(8);
                this.f37701a.f37971a.setClickable(false);
                this.f37701a.f37979i.removeMessages(10);
            } else {
                closeParentView2.f37971a.setVisibility(0);
                this.f37701a.f37971a.setClickable(true);
            }
            this.f37701a.f37979i.sendEmptyMessageDelayed(10, 1000L);
            this.f37701a.f37978h--;
        }
    }
}
