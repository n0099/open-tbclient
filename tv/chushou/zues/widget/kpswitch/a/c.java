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
    private int bLF = -1;
    private final int mStatusBarHeight;
    private final View ovM;
    private boolean ovN;
    private tv.chushou.zues.widget.kpswitch.a ovO;

    public c(View view) {
        this.ovM = view;
        this.mStatusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(view.getContext());
        this.ovN = e.A((Activity) view.getContext());
    }

    @TargetApi(16)
    public void aa(int i, int i2) {
        if (this.ovN && Build.VERSION.SDK_INT >= 16 && this.ovM.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.ovM.getWindowVisibleDisplayFrame(rect);
            i2 = rect.bottom - rect.top;
        }
        if (i2 >= 0) {
            if (this.bLF < 0) {
                this.bLF = i2;
                return;
            }
            int i3 = this.bLF - i2;
            if (i3 != 0 && Math.abs(i3) != this.mStatusBarHeight) {
                this.bLF = i2;
                tv.chushou.zues.widget.kpswitch.a dI = dI(this.ovM);
                if (dI != null) {
                    if (i3 > 0) {
                        dI.RH();
                    } else if (dI.eaB() && dI.isVisible()) {
                        dI.RG();
                    }
                }
            }
        }
    }

    private tv.chushou.zues.widget.kpswitch.a dI(View view) {
        if (this.ovO != null && this.ovO.eaC()) {
            return this.ovO;
        }
        if (view instanceof tv.chushou.zues.widget.kpswitch.a) {
            this.ovO = (tv.chushou.zues.widget.kpswitch.a) view;
            if (this.ovO.eaC()) {
                return this.ovO;
            }
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= ((ViewGroup) view).getChildCount()) {
                    break;
                }
                tv.chushou.zues.widget.kpswitch.a dI = dI(((ViewGroup) view).getChildAt(i2));
                if (dI == null || !dI.eaC()) {
                    i = i2 + 1;
                } else {
                    this.ovO = dI;
                    return this.ovO;
                }
            }
        }
        return null;
    }

    public void setIsTranslucentStatus(boolean z) {
        this.ovN = z;
    }

    public void eaE() {
        this.bLF = -1;
    }

    public void dME() {
        this.ovO = null;
    }
}
