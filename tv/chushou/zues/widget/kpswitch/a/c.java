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
    private int byN = -1;
    private final int mStatusBarHeight;
    private final View nvg;
    private boolean nvh;
    private tv.chushou.zues.widget.kpswitch.a nvi;

    public c(View view) {
        this.nvg = view;
        this.mStatusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(view.getContext());
        this.nvh = e.A((Activity) view.getContext());
    }

    @TargetApi(16)
    public void V(int i, int i2) {
        if (this.nvh && Build.VERSION.SDK_INT >= 16 && this.nvg.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.nvg.getWindowVisibleDisplayFrame(rect);
            i2 = rect.bottom - rect.top;
        }
        if (i2 >= 0) {
            if (this.byN < 0) {
                this.byN = i2;
                return;
            }
            int i3 = this.byN - i2;
            if (i3 != 0 && Math.abs(i3) != this.mStatusBarHeight) {
                this.byN = i2;
                tv.chushou.zues.widget.kpswitch.a dA = dA(this.nvg);
                if (dA != null) {
                    if (i3 > 0) {
                        dA.Oa();
                    } else if (dA.dKq() && dA.isVisible()) {
                        dA.NZ();
                    }
                }
            }
        }
    }

    private tv.chushou.zues.widget.kpswitch.a dA(View view) {
        if (this.nvi != null && this.nvi.dKr()) {
            return this.nvi;
        }
        if (view instanceof tv.chushou.zues.widget.kpswitch.a) {
            this.nvi = (tv.chushou.zues.widget.kpswitch.a) view;
            if (this.nvi.dKr()) {
                return this.nvi;
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
                if (dA == null || !dA.dKr()) {
                    i = i2 + 1;
                } else {
                    this.nvi = dA;
                    return this.nvi;
                }
            }
        }
        return null;
    }

    public void setIsTranslucentStatus(boolean z) {
        this.nvh = z;
    }

    public void dKt() {
        this.byN = -1;
    }

    public void dwZ() {
        this.nvi = null;
    }
}
