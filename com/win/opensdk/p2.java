package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
import com.win.opensdk.views.CloseParentView;
/* loaded from: classes7.dex */
public class p2 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CloseParentView f40014a;

    public p2(CloseParentView closeParentView) {
        this.f40014a = closeParentView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 10) {
            CloseParentView closeParentView = this.f40014a;
            closeParentView.f40077a.setText(String.valueOf(closeParentView.f40084h));
            CloseParentView closeParentView2 = this.f40014a;
            if (closeParentView2.f40084h <= 0) {
                closeParentView2.f40077a.setVisibility(8);
                this.f40014a.f40077a.setClickable(false);
                this.f40014a.i.removeMessages(10);
            } else {
                closeParentView2.f40077a.setVisibility(0);
                this.f40014a.f40077a.setClickable(true);
            }
            this.f40014a.i.sendEmptyMessageDelayed(10, 1000L);
            this.f40014a.f40084h--;
        }
    }
}
