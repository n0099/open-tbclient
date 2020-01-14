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
    private final View nYw;
    private boolean nYx;
    private tv.chushou.zues.widget.kpswitch.a nYy;

    public c(View view) {
        this.nYw = view;
        this.mStatusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(view.getContext());
        this.nYx = e.C((Activity) view.getContext());
    }

    @TargetApi(16)
    public void T(int i, int i2) {
        if (this.nYx && Build.VERSION.SDK_INT >= 16 && this.nYw.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.nYw.getWindowVisibleDisplayFrame(rect);
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
                tv.chushou.zues.widget.kpswitch.a dH = dH(this.nYw);
                if (dH != null) {
                    if (i3 > 0) {
                        dH.DR();
                    } else if (dH.dPy() && dH.isVisible()) {
                        dH.DQ();
                    }
                }
            }
        }
    }

    private tv.chushou.zues.widget.kpswitch.a dH(View view) {
        if (this.nYy != null && this.nYy.dPz()) {
            return this.nYy;
        }
        if (view instanceof tv.chushou.zues.widget.kpswitch.a) {
            this.nYy = (tv.chushou.zues.widget.kpswitch.a) view;
            if (this.nYy.dPz()) {
                return this.nYy;
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
                if (dH == null || !dH.dPz()) {
                    i = i2 + 1;
                } else {
                    this.nYy = dH;
                    return this.nYy;
                }
            }
        }
        return null;
    }

    public void setIsTranslucentStatus(boolean z) {
        this.nYx = z;
    }

    public void dPB() {
        this.aVM = -1;
    }

    public void dBa() {
        this.nYy = null;
    }
}
