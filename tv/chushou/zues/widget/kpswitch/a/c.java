package tv.chushou.zues.widget.kpswitch.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import tv.chushou.zues.widget.kpswitch.b.e;
/* loaded from: classes4.dex */
public class c {
    private int aVM = -1;
    private final int mStatusBarHeight;
    private final View nYr;
    private boolean nYs;
    private tv.chushou.zues.widget.kpswitch.a nYt;

    public c(View view) {
        this.nYr = view;
        this.mStatusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(view.getContext());
        this.nYs = e.C((Activity) view.getContext());
    }

    @TargetApi(16)
    public void T(int i, int i2) {
        if (this.nYs && Build.VERSION.SDK_INT >= 16 && this.nYr.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.nYr.getWindowVisibleDisplayFrame(rect);
            i2 = rect.bottom - rect.top;
        }
        if (i2 >= 0) {
            if (this.aVM < 0) {
                this.aVM = i2;
                return;
            }
            int i3 = this.aVM - i2;
            if (i3 != 0 && Math.abs(i3) != this.mStatusBarHeight) {
                this.aVM = i2;
                tv.chushou.zues.widget.kpswitch.a dH = dH(this.nYr);
                if (dH != null) {
                    if (i3 > 0) {
                        dH.DR();
                    } else if (dH.dPw() && dH.isVisible()) {
                        dH.DQ();
                    }
                }
            }
        }
    }

    private tv.chushou.zues.widget.kpswitch.a dH(View view) {
        if (this.nYt != null && this.nYt.dPx()) {
            return this.nYt;
        }
        if (view instanceof tv.chushou.zues.widget.kpswitch.a) {
            this.nYt = (tv.chushou.zues.widget.kpswitch.a) view;
            if (this.nYt.dPx()) {
                return this.nYt;
            }
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= ((ViewGroup) view).getChildCount()) {
                    break;
                }
                tv.chushou.zues.widget.kpswitch.a dH = dH(((ViewGroup) view).getChildAt(i2));
                if (dH == null || !dH.dPx()) {
                    i = i2 + 1;
                } else {
                    this.nYt = dH;
                    return this.nYt;
                }
            }
        }
        return null;
    }

    public void setIsTranslucentStatus(boolean z) {
        this.nYs = z;
    }

    public void dPz() {
        this.aVM = -1;
    }

    public void dAY() {
        this.nYt = null;
    }
}
