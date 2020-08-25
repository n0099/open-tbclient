package tv.chushou.zues.widget.kpswitch.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import tv.chushou.zues.widget.kpswitch.b.e;
/* loaded from: classes6.dex */
public class c {
    private int bRb = -1;
    private final int mStatusBarHeight;
    private final View oPF;
    private boolean oPG;
    private tv.chushou.zues.widget.kpswitch.a oPH;

    public c(View view) {
        this.oPF = view;
        this.mStatusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(view.getContext());
        this.oPG = e.A((Activity) view.getContext());
    }

    @TargetApi(16)
    public void ac(int i, int i2) {
        if (this.oPG && Build.VERSION.SDK_INT >= 16 && this.oPF.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.oPF.getWindowVisibleDisplayFrame(rect);
            i2 = rect.bottom - rect.top;
        }
        if (i2 >= 0) {
            if (this.bRb < 0) {
                this.bRb = i2;
                return;
            }
            int i3 = this.bRb - i2;
            if (i3 != 0 && Math.abs(i3) != this.mStatusBarHeight) {
                this.bRb = i2;
                tv.chushou.zues.widget.kpswitch.a dK = dK(this.oPF);
                if (dK != null) {
                    if (i3 > 0) {
                        dK.XC();
                    } else if (dK.emF() && dK.isVisible()) {
                        dK.XB();
                    }
                }
            }
        }
    }

    private tv.chushou.zues.widget.kpswitch.a dK(View view) {
        if (this.oPH != null && this.oPH.emG()) {
            return this.oPH;
        }
        if (view instanceof tv.chushou.zues.widget.kpswitch.a) {
            this.oPH = (tv.chushou.zues.widget.kpswitch.a) view;
            if (this.oPH.emG()) {
                return this.oPH;
            }
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= ((ViewGroup) view).getChildCount()) {
                    break;
                }
                tv.chushou.zues.widget.kpswitch.a dK = dK(((ViewGroup) view).getChildAt(i2));
                if (dK == null || !dK.emG()) {
                    i = i2 + 1;
                } else {
                    this.oPH = dK;
                    return this.oPH;
                }
            }
        }
        return null;
    }

    public void setIsTranslucentStatus(boolean z) {
        this.oPG = z;
    }

    public void emI() {
        this.bRb = -1;
    }

    public void dYH() {
        this.oPH = null;
    }
}
