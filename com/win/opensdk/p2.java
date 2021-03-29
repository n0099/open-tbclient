package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
import com.win.opensdk.views.CloseParentView;
/* loaded from: classes7.dex */
public class p2 extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CloseParentView f40015a;

    public p2(CloseParentView closeParentView) {
        this.f40015a = closeParentView;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 10) {
            CloseParentView closeParentView = this.f40015a;
            closeParentView.f40078a.setText(String.valueOf(closeParentView.f40085h));
            CloseParentView closeParentView2 = this.f40015a;
            if (closeParentView2.f40085h <= 0) {
                closeParentView2.f40078a.setVisibility(8);
                this.f40015a.f40078a.setClickable(false);
                this.f40015a.i.removeMessages(10);
            } else {
                closeParentView2.f40078a.setVisibility(0);
                this.f40015a.f40078a.setClickable(true);
            }
            this.f40015a.i.sendEmptyMessageDelayed(10, 1000L);
            this.f40015a.f40085h--;
        }
    }
}
