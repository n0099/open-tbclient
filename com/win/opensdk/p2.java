package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
import com.win.opensdk.views.CloseParentView;
/* loaded from: classes7.dex */
public class p2 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CloseParentView f40304a;

    public p2(CloseParentView closeParentView) {
        this.f40304a = closeParentView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 10) {
            CloseParentView closeParentView = this.f40304a;
            closeParentView.f40367a.setText(String.valueOf(closeParentView.f40374h));
            CloseParentView closeParentView2 = this.f40304a;
            if (closeParentView2.f40374h <= 0) {
                closeParentView2.f40367a.setVisibility(8);
                this.f40304a.f40367a.setClickable(false);
                this.f40304a.i.removeMessages(10);
            } else {
                closeParentView2.f40367a.setVisibility(0);
                this.f40304a.f40367a.setClickable(true);
            }
            this.f40304a.i.sendEmptyMessageDelayed(10, 1000L);
            this.f40304a.f40374h--;
        }
    }
}
