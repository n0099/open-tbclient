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
    private int baa = -1;
    private final int mStatusBarHeight;
    private final View nZx;
    private boolean nZy;
    private tv.chushou.zues.widget.kpswitch.a nZz;

    public c(View view) {
        this.nZx = view;
        this.mStatusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(view.getContext());
        this.nZy = e.D((Activity) view.getContext());
    }

    @TargetApi(16)
    public void T(int i, int i2) {
        if (this.nZy && Build.VERSION.SDK_INT >= 16 && this.nZx.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.nZx.getWindowVisibleDisplayFrame(rect);
            i2 = rect.bottom - rect.top;
        }
        if (i2 >= 0) {
            if (this.baa < 0) {
                this.baa = i2;
                return;
            }
            int i3 = this.baa - i2;
            if (i3 != 0 && Math.abs(i3) != this.mStatusBarHeight) {
                this.baa = i2;
                tv.chushou.zues.widget.kpswitch.a dJ = dJ(this.nZx);
                if (dJ != null) {
                    if (i3 > 0) {
                        dJ.Gi();
                    } else if (dJ.dQO() && dJ.isVisible()) {
                        dJ.Gh();
                    }
                }
            }
        }
    }

    private tv.chushou.zues.widget.kpswitch.a dJ(View view) {
        if (this.nZz != null && this.nZz.dQP()) {
            return this.nZz;
        }
        if (view instanceof tv.chushou.zues.widget.kpswitch.a) {
            this.nZz = (tv.chushou.zues.widget.kpswitch.a) view;
            if (this.nZz.dQP()) {
                return this.nZz;
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
                if (dJ == null || !dJ.dQP()) {
                    i = i2 + 1;
                } else {
                    this.nZz = dJ;
                    return this.nZz;
                }
            }
        }
        return null;
    }

    public void setIsTranslucentStatus(boolean z) {
        this.nZy = z;
    }

    public void dQR() {
        this.baa = -1;
    }

    public void dCj() {
        this.nZz = null;
    }
}
