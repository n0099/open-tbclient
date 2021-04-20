package com.win.opensdk;

import com.win.opensdk.views.CircleProgressbar;
/* loaded from: classes7.dex */
public class n2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CircleProgressbar f40281a;

    public n2(CircleProgressbar circleProgressbar) {
        this.f40281a = circleProgressbar;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        CircleProgressbar circleProgressbar;
        int i;
        int i2;
        this.f40281a.removeCallbacks(this);
        int ordinal = this.f40281a.i.ordinal();
        if (ordinal == 0) {
            circleProgressbar = this.f40281a;
            i = circleProgressbar.f40358h + 1;
        } else {
            if (ordinal == 1) {
                circleProgressbar = this.f40281a;
                i = circleProgressbar.f40358h - 1;
            }
            CircleProgressbar circleProgressbar2 = this.f40281a;
            i2 = circleProgressbar2.f40358h;
            if (i2 < 0 && i2 <= 100) {
                l lVar = circleProgressbar2.l;
                if (lVar != null) {
                    lVar.a(circleProgressbar2.m, i2);
                }
                this.f40281a.invalidate();
                CircleProgressbar circleProgressbar3 = this.f40281a;
                circleProgressbar3.postDelayed(circleProgressbar3.n, circleProgressbar3.j / 100);
                return;
            }
            CircleProgressbar circleProgressbar4 = this.f40281a;
            int i3 = circleProgressbar4.f40358h;
            circleProgressbar4.f40358h = i3 <= 100 ? i3 < 0 ? 0 : i3 : 100;
        }
        circleProgressbar.f40358h = i;
        CircleProgressbar circleProgressbar22 = this.f40281a;
        i2 = circleProgressbar22.f40358h;
        if (i2 < 0) {
        }
        CircleProgressbar circleProgressbar42 = this.f40281a;
        int i32 = circleProgressbar42.f40358h;
        circleProgressbar42.f40358h = i32 <= 100 ? i32 < 0 ? 0 : i32 : 100;
    }
}
