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
    private int bTf = -1;
    private final View eOI;
    private boolean eOJ;
    private final int mStatusBarHeight;
    private tv.chushou.zues.widget.kpswitch.a oZu;

    public c(View view) {
        this.eOI = view;
        this.mStatusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(view.getContext());
        this.eOJ = e.B((Activity) view.getContext());
    }

    @TargetApi(16)
    public void ac(int i, int i2) {
        if (this.eOJ && Build.VERSION.SDK_INT >= 16 && this.eOI.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.eOI.getWindowVisibleDisplayFrame(rect);
            i2 = rect.bottom - rect.top;
        }
        if (i2 >= 0) {
            if (this.bTf < 0) {
                this.bTf = i2;
                return;
            }
            int i3 = this.bTf - i2;
            if (i3 != 0 && Math.abs(i3) != this.mStatusBarHeight) {
                this.bTf = i2;
                tv.chushou.zues.widget.kpswitch.a dT = dT(this.eOI);
                if (dT != null) {
                    if (i3 > 0) {
                        dT.Yl();
                    } else if (dT.bsU() && dT.isVisible()) {
                        dT.Yk();
                    }
                }
            }
        }
    }

    private tv.chushou.zues.widget.kpswitch.a dT(View view) {
        if (this.oZu != null && this.oZu.eqM()) {
            return this.oZu;
        }
        if (view instanceof tv.chushou.zues.widget.kpswitch.a) {
            this.oZu = (tv.chushou.zues.widget.kpswitch.a) view;
            if (this.oZu.eqM()) {
                return this.oZu;
            }
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= ((ViewGroup) view).getChildCount()) {
                    break;
                }
                tv.chushou.zues.widget.kpswitch.a dT = dT(((ViewGroup) view).getChildAt(i2));
                if (dT == null || !dT.eqM()) {
                    i = i2 + 1;
                } else {
                    this.oZu = dT;
                    return this.oZu;
                }
            }
        }
        return null;
    }

    public void setIsTranslucentStatus(boolean z) {
        this.eOJ = z;
    }

    public void eqN() {
        this.bTf = -1;
    }

    public void ecO() {
        this.oZu = null;
    }
}
