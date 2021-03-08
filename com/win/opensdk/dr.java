package com.win.opensdk;

import com.win.opensdk.views.CircleProgressbar;
/* loaded from: classes14.dex */
public class dr implements Runnable {
    public final /* synthetic */ CircleProgressbar qlU;

    public dr(CircleProgressbar circleProgressbar) {
        this.qlU = circleProgressbar;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        CircleProgressbar circleProgressbar;
        int i;
        int i2;
        int i3;
        this.qlU.removeCallbacks(this);
        int ordinal = this.qlU.qmp.ordinal();
        if (ordinal == 0) {
            circleProgressbar = this.qlU;
            i = circleProgressbar.h + 1;
        } else {
            if (ordinal == 1) {
                circleProgressbar = this.qlU;
                i = circleProgressbar.h - 1;
            }
            CircleProgressbar circleProgressbar2 = this.qlU;
            i2 = circleProgressbar2.h;
            if (i2 < 0 && i2 <= 100) {
                di diVar = circleProgressbar2.qmr;
                if (diVar != null) {
                    diVar.a(circleProgressbar2.m, i2);
                }
                this.qlU.invalidate();
                CircleProgressbar circleProgressbar3 = this.qlU;
                circleProgressbar3.postDelayed(circleProgressbar3.n, circleProgressbar3.j / 100);
                return;
            }
            CircleProgressbar circleProgressbar4 = this.qlU;
            i3 = circleProgressbar4.h;
            if (i3 <= 100) {
                i3 = 100;
            } else if (i3 < 0) {
                i3 = 0;
            }
            circleProgressbar4.h = i3;
        }
        circleProgressbar.h = i;
        CircleProgressbar circleProgressbar22 = this.qlU;
        i2 = circleProgressbar22.h;
        if (i2 < 0) {
        }
        CircleProgressbar circleProgressbar42 = this.qlU;
        i3 = circleProgressbar42.h;
        if (i3 <= 100) {
        }
        circleProgressbar42.h = i3;
    }
}
