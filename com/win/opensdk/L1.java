package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
import com.win.opensdk.views.CloseParentView;
/* loaded from: classes7.dex */
public class L1 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CloseParentView f40657a;

    public L1(CloseParentView closeParentView) {
        this.f40657a = closeParentView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 10) {
            CloseParentView closeParentView = this.f40657a;
            closeParentView.f40927a.setText(String.valueOf(closeParentView.f40934h));
            CloseParentView closeParentView2 = this.f40657a;
            if (closeParentView2.f40934h <= 0) {
                closeParentView2.f40927a.setVisibility(8);
                this.f40657a.f40927a.setClickable(false);
                this.f40657a.f40935i.removeMessages(10);
            } else {
                closeParentView2.f40927a.setVisibility(0);
                this.f40657a.f40927a.setClickable(true);
            }
            this.f40657a.f40935i.sendEmptyMessageDelayed(10, 1000L);
            this.f40657a.f40934h--;
        }
    }
}
