package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
import com.win.opensdk.views.CloseParentView;
/* loaded from: classes7.dex */
public class p2 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CloseParentView f40399a;

    public p2(CloseParentView closeParentView) {
        this.f40399a = closeParentView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 10) {
            CloseParentView closeParentView = this.f40399a;
            closeParentView.f40462a.setText(String.valueOf(closeParentView.f40469h));
            CloseParentView closeParentView2 = this.f40399a;
            if (closeParentView2.f40469h <= 0) {
                closeParentView2.f40462a.setVisibility(8);
                this.f40399a.f40462a.setClickable(false);
                this.f40399a.i.removeMessages(10);
            } else {
                closeParentView2.f40462a.setVisibility(0);
                this.f40399a.f40462a.setClickable(true);
            }
            this.f40399a.i.sendEmptyMessageDelayed(10, 1000L);
            this.f40399a.f40469h--;
        }
    }
}
