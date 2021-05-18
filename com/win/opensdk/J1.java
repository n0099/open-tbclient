package com.win.opensdk;

import com.win.opensdk.views.CircleProgressbar;
/* loaded from: classes7.dex */
public class J1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CircleProgressbar f36919a;

    public J1(CircleProgressbar circleProgressbar) {
        this.f36919a = circleProgressbar;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        CircleProgressbar circleProgressbar;
        int i2;
        int i3;
        this.f36919a.removeCallbacks(this);
        int ordinal = this.f36919a.f37215i.ordinal();
        if (ordinal == 0) {
            circleProgressbar = this.f36919a;
            i2 = circleProgressbar.f37214h + 1;
        } else {
            if (ordinal == 1) {
                circleProgressbar = this.f36919a;
                i2 = circleProgressbar.f37214h - 1;
            }
            CircleProgressbar circleProgressbar2 = this.f36919a;
            i3 = circleProgressbar2.f37214h;
            if (i3 < 0 && i3 <= 100) {
                l lVar = circleProgressbar2.l;
                if (lVar != null) {
                    lVar.a(circleProgressbar2.m, i3);
                }
                this.f36919a.invalidate();
                CircleProgressbar circleProgressbar3 = this.f36919a;
                circleProgressbar3.postDelayed(circleProgressbar3.n, circleProgressbar3.j / 100);
                return;
            }
            CircleProgressbar circleProgressbar4 = this.f36919a;
            int i4 = circleProgressbar4.f37214h;
            circleProgressbar4.f37214h = i4 <= 100 ? i4 < 0 ? 0 : i4 : 100;
        }
        circleProgressbar.f37214h = i2;
        CircleProgressbar circleProgressbar22 = this.f36919a;
        i3 = circleProgressbar22.f37214h;
        if (i3 < 0) {
        }
        CircleProgressbar circleProgressbar42 = this.f36919a;
        int i42 = circleProgressbar42.f37214h;
        circleProgressbar42.f37214h = i42 <= 100 ? i42 < 0 ? 0 : i42 : 100;
    }
}
