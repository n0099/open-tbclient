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
    private int aZZ = -1;
    private final int mStatusBarHeight;
    private final View nZm;
    private boolean nZn;
    private tv.chushou.zues.widget.kpswitch.a nZo;

    public c(View view) {
        this.nZm = view;
        this.mStatusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(view.getContext());
        this.nZn = e.D((Activity) view.getContext());
    }

    @TargetApi(16)
    public void T(int i, int i2) {
        if (this.nZn && Build.VERSION.SDK_INT >= 16 && this.nZm.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.nZm.getWindowVisibleDisplayFrame(rect);
            i2 = rect.bottom - rect.top;
        }
        if (i2 >= 0) {
            if (this.aZZ < 0) {
                this.aZZ = i2;
                return;
            }
            int i3 = this.aZZ - i2;
            if (i3 != 0 && Math.abs(i3) != this.mStatusBarHeight) {
                this.aZZ = i2;
                tv.chushou.zues.widget.kpswitch.a dJ = dJ(this.nZm);
                if (dJ != null) {
                    if (i3 > 0) {
                        dJ.Gi();
                    } else if (dJ.dQN() && dJ.isVisible()) {
                        dJ.Gh();
                    }
                }
            }
        }
    }

    private tv.chushou.zues.widget.kpswitch.a dJ(View view) {
        if (this.nZo != null && this.nZo.dQO()) {
            return this.nZo;
        }
        if (view instanceof tv.chushou.zues.widget.kpswitch.a) {
            this.nZo = (tv.chushou.zues.widget.kpswitch.a) view;
            if (this.nZo.dQO()) {
                return this.nZo;
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
                if (dJ == null || !dJ.dQO()) {
                    i = i2 + 1;
                } else {
                    this.nZo = dJ;
                    return this.nZo;
                }
            }
        }
        return null;
    }

    public void setIsTranslucentStatus(boolean z) {
        this.nZn = z;
    }

    public void dQQ() {
        this.aZZ = -1;
    }

    public void dCi() {
        this.nZo = null;
    }
}
