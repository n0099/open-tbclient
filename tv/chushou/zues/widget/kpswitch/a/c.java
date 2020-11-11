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
    private int ctQ = -1;
    private final View fpf;
    private boolean fpg;
    private final int mStatusBarHeight;
    private tv.chushou.zues.widget.kpswitch.a qpx;

    public c(View view) {
        this.fpf = view;
        this.mStatusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(view.getContext());
        this.fpg = e.C((Activity) view.getContext());
    }

    @TargetApi(16)
    public void ac(int i, int i2) {
        if (this.fpg && Build.VERSION.SDK_INT >= 16 && this.fpf.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.fpf.getWindowVisibleDisplayFrame(rect);
            i2 = rect.bottom - rect.top;
        }
        if (i2 >= 0) {
            if (this.ctQ < 0) {
                this.ctQ = i2;
                return;
            }
            int i3 = this.ctQ - i2;
            if (i3 != 0 && Math.abs(i3) != this.mStatusBarHeight) {
                this.ctQ = i2;
                tv.chushou.zues.widget.kpswitch.a en = en(this.fpf);
                if (en != null) {
                    if (i3 > 0) {
                        en.afr();
                    } else if (en.bzW() && en.isVisible()) {
                        en.afq();
                    }
                }
            }
        }
    }

    private tv.chushou.zues.widget.kpswitch.a en(View view) {
        if (this.qpx != null && this.qpx.eIk()) {
            return this.qpx;
        }
        if (view instanceof tv.chushou.zues.widget.kpswitch.a) {
            this.qpx = (tv.chushou.zues.widget.kpswitch.a) view;
            if (this.qpx.eIk()) {
                return this.qpx;
            }
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= ((ViewGroup) view).getChildCount()) {
                    break;
                }
                tv.chushou.zues.widget.kpswitch.a en = en(((ViewGroup) view).getChildAt(i2));
                if (en == null || !en.eIk()) {
                    i = i2 + 1;
                } else {
                    this.qpx = en;
                    return this.qpx;
                }
            }
        }
        return null;
    }

    public void setIsTranslucentStatus(boolean z) {
        this.fpg = z;
    }

    public void eIl() {
        this.ctQ = -1;
    }

    public void euo() {
        this.qpx = null;
    }
}
