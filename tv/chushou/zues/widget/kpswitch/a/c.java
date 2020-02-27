package tv.chushou.zues.widget.kpswitch.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import tv.chushou.zues.widget.kpswitch.b.e;
/* loaded from: classes5.dex */
public class c {
    private int aZY = -1;
    private final int mStatusBarHeight;
    private final View nZk;
    private boolean nZl;
    private tv.chushou.zues.widget.kpswitch.a nZm;

    public c(View view) {
        this.nZk = view;
        this.mStatusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(view.getContext());
        this.nZl = e.D((Activity) view.getContext());
    }

    @TargetApi(16)
    public void T(int i, int i2) {
        if (this.nZl && Build.VERSION.SDK_INT >= 16 && this.nZk.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.nZk.getWindowVisibleDisplayFrame(rect);
            i2 = rect.bottom - rect.top;
        }
        if (i2 >= 0) {
            if (this.aZY < 0) {
                this.aZY = i2;
                return;
            }
            int i3 = this.aZY - i2;
            if (i3 != 0 && Math.abs(i3) != this.mStatusBarHeight) {
                this.aZY = i2;
                tv.chushou.zues.widget.kpswitch.a dJ = dJ(this.nZk);
                if (dJ != null) {
                    if (i3 > 0) {
                        dJ.Gg();
                    } else if (dJ.dQL() && dJ.isVisible()) {
                        dJ.Gf();
                    }
                }
            }
        }
    }

    private tv.chushou.zues.widget.kpswitch.a dJ(View view) {
        if (this.nZm != null && this.nZm.dQM()) {
            return this.nZm;
        }
        if (view instanceof tv.chushou.zues.widget.kpswitch.a) {
            this.nZm = (tv.chushou.zues.widget.kpswitch.a) view;
            if (this.nZm.dQM()) {
                return this.nZm;
            }
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= ((ViewGroup) view).getChildCount()) {
                    break;
                }
                tv.chushou.zues.widget.kpswitch.a dJ = dJ(((ViewGroup) view).getChildAt(i2));
                if (dJ == null || !dJ.dQM()) {
                    i = i2 + 1;
                } else {
                    this.nZm = dJ;
                    return this.nZm;
                }
            }
        }
        return null;
    }

    public void setIsTranslucentStatus(boolean z) {
        this.nZl = z;
    }

    public void dQO() {
        this.aZY = -1;
    }

    public void dCg() {
        this.nZm = null;
    }
}
