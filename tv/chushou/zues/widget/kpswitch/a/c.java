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
    private int byS = -1;
    private final int mStatusBarHeight;
    private final View nvj;
    private boolean nvk;
    private tv.chushou.zues.widget.kpswitch.a nvl;

    public c(View view) {
        this.nvj = view;
        this.mStatusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(view.getContext());
        this.nvk = e.A((Activity) view.getContext());
    }

    @TargetApi(16)
    public void V(int i, int i2) {
        if (this.nvk && Build.VERSION.SDK_INT >= 16 && this.nvj.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.nvj.getWindowVisibleDisplayFrame(rect);
            i2 = rect.bottom - rect.top;
        }
        if (i2 >= 0) {
            if (this.byS < 0) {
                this.byS = i2;
                return;
            }
            int i3 = this.byS - i2;
            if (i3 != 0 && Math.abs(i3) != this.mStatusBarHeight) {
                this.byS = i2;
                tv.chushou.zues.widget.kpswitch.a dA = dA(this.nvj);
                if (dA != null) {
                    if (i3 > 0) {
                        dA.NZ();
                    } else if (dA.dKn() && dA.isVisible()) {
                        dA.NY();
                    }
                }
            }
        }
    }

    private tv.chushou.zues.widget.kpswitch.a dA(View view) {
        if (this.nvl != null && this.nvl.dKo()) {
            return this.nvl;
        }
        if (view instanceof tv.chushou.zues.widget.kpswitch.a) {
            this.nvl = (tv.chushou.zues.widget.kpswitch.a) view;
            if (this.nvl.dKo()) {
                return this.nvl;
            }
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= ((ViewGroup) view).getChildCount()) {
                    break;
                }
                tv.chushou.zues.widget.kpswitch.a dA = dA(((ViewGroup) view).getChildAt(i2));
                if (dA == null || !dA.dKo()) {
                    i = i2 + 1;
                } else {
                    this.nvl = dA;
                    return this.nvl;
                }
            }
        }
        return null;
    }

    public void setIsTranslucentStatus(boolean z) {
        this.nvk = z;
    }

    public void dKq() {
        this.byS = -1;
    }

    public void dwX() {
        this.nvl = null;
    }
}
