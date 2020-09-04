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
    private int bRf = -1;
    private final int mStatusBarHeight;
    private final View oPX;
    private boolean oPY;
    private tv.chushou.zues.widget.kpswitch.a oPZ;

    public c(View view) {
        this.oPX = view;
        this.mStatusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(view.getContext());
        this.oPY = e.A((Activity) view.getContext());
    }

    @TargetApi(16)
    public void ac(int i, int i2) {
        if (this.oPY && Build.VERSION.SDK_INT >= 16 && this.oPX.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.oPX.getWindowVisibleDisplayFrame(rect);
            i2 = rect.bottom - rect.top;
        }
        if (i2 >= 0) {
            if (this.bRf < 0) {
                this.bRf = i2;
                return;
            }
            int i3 = this.bRf - i2;
            if (i3 != 0 && Math.abs(i3) != this.mStatusBarHeight) {
                this.bRf = i2;
                tv.chushou.zues.widget.kpswitch.a dK = dK(this.oPX);
                if (dK != null) {
                    if (i3 > 0) {
                        dK.XC();
                    } else if (dK.emO() && dK.isVisible()) {
                        dK.XB();
                    }
                }
            }
        }
    }

    private tv.chushou.zues.widget.kpswitch.a dK(View view) {
        if (this.oPZ != null && this.oPZ.emP()) {
            return this.oPZ;
        }
        if (view instanceof tv.chushou.zues.widget.kpswitch.a) {
            this.oPZ = (tv.chushou.zues.widget.kpswitch.a) view;
            if (this.oPZ.emP()) {
                return this.oPZ;
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
                if (dK == null || !dK.emP()) {
                    i = i2 + 1;
                } else {
                    this.oPZ = dK;
                    return this.oPZ;
                }
            }
        }
        return null;
    }

    public void setIsTranslucentStatus(boolean z) {
        this.oPY = z;
    }

    public void emR() {
        this.bRf = -1;
    }

    public void dYQ() {
        this.oPZ = null;
    }
}
