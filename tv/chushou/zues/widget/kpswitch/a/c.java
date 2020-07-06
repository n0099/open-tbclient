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
    private int bLj = -1;
    private final int mStatusBarHeight;
    private final View onh;
    private boolean oni;
    private tv.chushou.zues.widget.kpswitch.a onj;

    public c(View view) {
        this.onh = view;
        this.mStatusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(view.getContext());
        this.oni = e.A((Activity) view.getContext());
    }

    @TargetApi(16)
    public void aa(int i, int i2) {
        if (this.oni && Build.VERSION.SDK_INT >= 16 && this.onh.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.onh.getWindowVisibleDisplayFrame(rect);
            i2 = rect.bottom - rect.top;
        }
        if (i2 >= 0) {
            if (this.bLj < 0) {
                this.bLj = i2;
                return;
            }
            int i3 = this.bLj - i2;
            if (i3 != 0 && Math.abs(i3) != this.mStatusBarHeight) {
                this.bLj = i2;
                tv.chushou.zues.widget.kpswitch.a dC = dC(this.onh);
                if (dC != null) {
                    if (i3 > 0) {
                        dC.Rs();
                    } else if (dC.dXf() && dC.isVisible()) {
                        dC.Rr();
                    }
                }
            }
        }
    }

    private tv.chushou.zues.widget.kpswitch.a dC(View view) {
        if (this.onj != null && this.onj.dXg()) {
            return this.onj;
        }
        if (view instanceof tv.chushou.zues.widget.kpswitch.a) {
            this.onj = (tv.chushou.zues.widget.kpswitch.a) view;
            if (this.onj.dXg()) {
                return this.onj;
            }
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= ((ViewGroup) view).getChildCount()) {
                    break;
                }
                tv.chushou.zues.widget.kpswitch.a dC = dC(((ViewGroup) view).getChildAt(i2));
                if (dC == null || !dC.dXg()) {
                    i = i2 + 1;
                } else {
                    this.onj = dC;
                    return this.onj;
                }
            }
        }
        return null;
    }

    public void setIsTranslucentStatus(boolean z) {
        this.oni = z;
    }

    public void dXi() {
        this.bLj = -1;
    }

    public void dJj() {
        this.onj = null;
    }
}
