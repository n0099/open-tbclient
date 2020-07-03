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
    private final View ond;
    private boolean onf;
    private tv.chushou.zues.widget.kpswitch.a ong;

    public c(View view) {
        this.ond = view;
        this.mStatusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(view.getContext());
        this.onf = e.A((Activity) view.getContext());
    }

    @TargetApi(16)
    public void aa(int i, int i2) {
        if (this.onf && Build.VERSION.SDK_INT >= 16 && this.ond.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.ond.getWindowVisibleDisplayFrame(rect);
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
                tv.chushou.zues.widget.kpswitch.a dC = dC(this.ond);
                if (dC != null) {
                    if (i3 > 0) {
                        dC.Rs();
                    } else if (dC.dXb() && dC.isVisible()) {
                        dC.Rr();
                    }
                }
            }
        }
    }

    private tv.chushou.zues.widget.kpswitch.a dC(View view) {
        if (this.ong != null && this.ong.dXc()) {
            return this.ong;
        }
        if (view instanceof tv.chushou.zues.widget.kpswitch.a) {
            this.ong = (tv.chushou.zues.widget.kpswitch.a) view;
            if (this.ong.dXc()) {
                return this.ong;
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
                if (dC == null || !dC.dXc()) {
                    i = i2 + 1;
                } else {
                    this.ong = dC;
                    return this.ong;
                }
            }
        }
        return null;
    }

    public void setIsTranslucentStatus(boolean z) {
        this.onf = z;
    }

    public void dXe() {
        this.bLj = -1;
    }

    public void dJf() {
        this.ong = null;
    }
}
