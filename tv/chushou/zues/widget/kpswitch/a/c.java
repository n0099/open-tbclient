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
    private int bGv = -1;
    private final int mStatusBarHeight;
    private final View nQf;
    private boolean nQg;
    private tv.chushou.zues.widget.kpswitch.a nQh;

    public c(View view) {
        this.nQf = view;
        this.mStatusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(view.getContext());
        this.nQg = e.A((Activity) view.getContext());
    }

    @TargetApi(16)
    public void Y(int i, int i2) {
        if (this.nQg && Build.VERSION.SDK_INT >= 16 && this.nQf.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.nQf.getWindowVisibleDisplayFrame(rect);
            i2 = rect.bottom - rect.top;
        }
        if (i2 >= 0) {
            if (this.bGv < 0) {
                this.bGv = i2;
                return;
            }
            int i3 = this.bGv - i2;
            if (i3 != 0 && Math.abs(i3) != this.mStatusBarHeight) {
                this.bGv = i2;
                tv.chushou.zues.widget.kpswitch.a dB = dB(this.nQf);
                if (dB != null) {
                    if (i3 > 0) {
                        dB.Qm();
                    } else if (dB.dSh() && dB.isVisible()) {
                        dB.Ql();
                    }
                }
            }
        }
    }

    private tv.chushou.zues.widget.kpswitch.a dB(View view) {
        if (this.nQh != null && this.nQh.dSi()) {
            return this.nQh;
        }
        if (view instanceof tv.chushou.zues.widget.kpswitch.a) {
            this.nQh = (tv.chushou.zues.widget.kpswitch.a) view;
            if (this.nQh.dSi()) {
                return this.nQh;
            }
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= ((ViewGroup) view).getChildCount()) {
                    break;
                }
                tv.chushou.zues.widget.kpswitch.a dB = dB(((ViewGroup) view).getChildAt(i2));
                if (dB == null || !dB.dSi()) {
                    i = i2 + 1;
                } else {
                    this.nQh = dB;
                    return this.nQh;
                }
            }
        }
        return null;
    }

    public void setIsTranslucentStatus(boolean z) {
        this.nQg = z;
    }

    public void dSk() {
        this.bGv = -1;
    }

    public void dEp() {
        this.nQh = null;
    }
}
