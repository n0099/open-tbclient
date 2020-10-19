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
    private int cft = -1;
    private final View faP;
    private boolean faQ;
    private final int mStatusBarHeight;
    private tv.chushou.zues.widget.kpswitch.a poQ;

    public c(View view) {
        this.faP = view;
        this.mStatusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(view.getContext());
        this.faQ = e.C((Activity) view.getContext());
    }

    @TargetApi(16)
    public void ab(int i, int i2) {
        if (this.faQ && Build.VERSION.SDK_INT >= 16 && this.faP.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.faP.getWindowVisibleDisplayFrame(rect);
            i2 = rect.bottom - rect.top;
        }
        if (i2 >= 0) {
            if (this.cft < 0) {
                this.cft = i2;
                return;
            }
            int i3 = this.cft - i2;
            if (i3 != 0 && Math.abs(i3) != this.mStatusBarHeight) {
                this.cft = i2;
                tv.chushou.zues.widget.kpswitch.a dX = dX(this.faP);
                if (dX != null) {
                    if (i3 > 0) {
                        dX.aaX();
                    } else if (dX.bvE() && dX.isVisible()) {
                        dX.aaW();
                    }
                }
            }
        }
    }

    private tv.chushou.zues.widget.kpswitch.a dX(View view) {
        if (this.poQ != null && this.poQ.eux()) {
            return this.poQ;
        }
        if (view instanceof tv.chushou.zues.widget.kpswitch.a) {
            this.poQ = (tv.chushou.zues.widget.kpswitch.a) view;
            if (this.poQ.eux()) {
                return this.poQ;
            }
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= ((ViewGroup) view).getChildCount()) {
                    break;
                }
                tv.chushou.zues.widget.kpswitch.a dX = dX(((ViewGroup) view).getChildAt(i2));
                if (dX == null || !dX.eux()) {
                    i = i2 + 1;
                } else {
                    this.poQ = dX;
                    return this.poQ;
                }
            }
        }
        return null;
    }

    public void setIsTranslucentStatus(boolean z) {
        this.faQ = z;
    }

    public void euy() {
        this.cft = -1;
    }

    public void egz() {
        this.poQ = null;
    }
}
