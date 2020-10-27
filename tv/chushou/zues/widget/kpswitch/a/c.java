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
    private int cnS = -1;
    private final View fjo;
    private boolean fjp;
    private final int mStatusBarHeight;
    private tv.chushou.zues.widget.kpswitch.a qgc;

    public c(View view) {
        this.fjo = view;
        this.mStatusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(view.getContext());
        this.fjp = e.C((Activity) view.getContext());
    }

    @TargetApi(16)
    public void ac(int i, int i2) {
        if (this.fjp && Build.VERSION.SDK_INT >= 16 && this.fjo.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.fjo.getWindowVisibleDisplayFrame(rect);
            i2 = rect.bottom - rect.top;
        }
        if (i2 >= 0) {
            if (this.cnS < 0) {
                this.cnS = i2;
                return;
            }
            int i3 = this.cnS - i2;
            if (i3 != 0 && Math.abs(i3) != this.mStatusBarHeight) {
                this.cnS = i2;
                tv.chushou.zues.widget.kpswitch.a ef = ef(this.fjo);
                if (ef != null) {
                    if (i3 > 0) {
                        ef.acR();
                    } else if (ef.bxx() && ef.isVisible()) {
                        ef.acQ();
                    }
                }
            }
        }
    }

    private tv.chushou.zues.widget.kpswitch.a ef(View view) {
        if (this.qgc != null && this.qgc.eEv()) {
            return this.qgc;
        }
        if (view instanceof tv.chushou.zues.widget.kpswitch.a) {
            this.qgc = (tv.chushou.zues.widget.kpswitch.a) view;
            if (this.qgc.eEv()) {
                return this.qgc;
            }
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= ((ViewGroup) view).getChildCount()) {
                    break;
                }
                tv.chushou.zues.widget.kpswitch.a ef = ef(((ViewGroup) view).getChildAt(i2));
                if (ef == null || !ef.eEv()) {
                    i = i2 + 1;
                } else {
                    this.qgc = ef;
                    return this.qgc;
                }
            }
        }
        return null;
    }

    public void setIsTranslucentStatus(boolean z) {
        this.fjp = z;
    }

    public void eEw() {
        this.cnS = -1;
    }

    public void eqz() {
        this.qgc = null;
    }
}
