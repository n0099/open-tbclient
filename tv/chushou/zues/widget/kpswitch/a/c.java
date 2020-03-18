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
    private int ban = -1;
    private final int mStatusBarHeight;
    private final View obl;
    private boolean obm;
    private tv.chushou.zues.widget.kpswitch.a obn;

    public c(View view) {
        this.obl = view;
        this.mStatusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(view.getContext());
        this.obm = e.D((Activity) view.getContext());
    }

    @TargetApi(16)
    public void T(int i, int i2) {
        if (this.obm && Build.VERSION.SDK_INT >= 16 && this.obl.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.obl.getWindowVisibleDisplayFrame(rect);
            i2 = rect.bottom - rect.top;
        }
        if (i2 >= 0) {
            if (this.ban < 0) {
                this.ban = i2;
                return;
            }
            int i3 = this.ban - i2;
            if (i3 != 0 && Math.abs(i3) != this.mStatusBarHeight) {
                this.ban = i2;
                tv.chushou.zues.widget.kpswitch.a dJ = dJ(this.obl);
                if (dJ != null) {
                    if (i3 > 0) {
                        dJ.Gn();
                    } else if (dJ.dRo() && dJ.isVisible()) {
                        dJ.Gm();
                    }
                }
            }
        }
    }

    private tv.chushou.zues.widget.kpswitch.a dJ(View view) {
        if (this.obn != null && this.obn.dRp()) {
            return this.obn;
        }
        if (view instanceof tv.chushou.zues.widget.kpswitch.a) {
            this.obn = (tv.chushou.zues.widget.kpswitch.a) view;
            if (this.obn.dRp()) {
                return this.obn;
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
                if (dJ == null || !dJ.dRp()) {
                    i = i2 + 1;
                } else {
                    this.obn = dJ;
                    return this.obn;
                }
            }
        }
        return null;
    }

    public void setIsTranslucentStatus(boolean z) {
        this.obm = z;
    }

    public void dRr() {
        this.ban = -1;
    }

    public void dCH() {
        this.obn = null;
    }
}
