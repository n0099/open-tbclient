package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
import com.win.opensdk.views.CloseParentView;
/* loaded from: classes14.dex */
public class dx extends Handler {
    public final /* synthetic */ CloseParentView qma;

    public dx(CloseParentView closeParentView) {
        this.qma = closeParentView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 10) {
            CloseParentView closeParentView = this.qma;
            closeParentView.f8177a.setText(String.valueOf(closeParentView.h));
            CloseParentView closeParentView2 = this.qma;
            if (closeParentView2.h <= 0) {
                closeParentView2.f8177a.setVisibility(8);
                this.qma.f8177a.setClickable(false);
                this.qma.i.removeMessages(10);
            } else {
                closeParentView2.f8177a.setVisibility(0);
                this.qma.f8177a.setClickable(true);
            }
            this.qma.i.sendEmptyMessageDelayed(10, 1000L);
            CloseParentView closeParentView3 = this.qma;
            closeParentView3.h--;
        }
    }
}
