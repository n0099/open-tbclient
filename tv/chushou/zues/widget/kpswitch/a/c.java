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
    private int cse = -1;
    private final View fon;
    private boolean foo;
    private final int mStatusBarHeight;
    private tv.chushou.zues.widget.kpswitch.a qra;

    public c(View view) {
        this.fon = view;
        this.mStatusBarHeight = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(view.getContext());
        this.foo = e.B((Activity) view.getContext());
    }

    @TargetApi(16)
    public void ac(int i, int i2) {
        if (this.foo && Build.VERSION.SDK_INT >= 16 && this.fon.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.fon.getWindowVisibleDisplayFrame(rect);
            i2 = rect.bottom - rect.top;
        }
        if (i2 >= 0) {
            if (this.cse < 0) {
                this.cse = i2;
                return;
            }
            int i3 = this.cse - i2;
            if (i3 != 0 && Math.abs(i3) != this.mStatusBarHeight) {
                this.cse = i2;
                tv.chushou.zues.widget.kpswitch.a eu = eu(this.fon);
                if (eu != null) {
                    if (i3 > 0) {
                        eu.aeJ();
                    } else if (eu.bzm() && eu.isVisible()) {
                        eu.aeI();
                    }
                }
            }
        }
    }

    private tv.chushou.zues.widget.kpswitch.a eu(View view) {
        if (this.qra != null && this.qra.eIl()) {
            return this.qra;
        }
        if (view instanceof tv.chushou.zues.widget.kpswitch.a) {
            this.qra = (tv.chushou.zues.widget.kpswitch.a) view;
            if (this.qra.eIl()) {
                return this.qra;
            }
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= ((ViewGroup) view).getChildCount()) {
                    break;
                }
                tv.chushou.zues.widget.kpswitch.a eu = eu(((ViewGroup) view).getChildAt(i2));
                if (eu == null || !eu.eIl()) {
                    i = i2 + 1;
                } else {
                    this.qra = eu;
                    return this.qra;
                }
            }
        }
        return null;
    }

    public void setIsTranslucentStatus(boolean z) {
        this.foo = z;
    }

    public void eIm() {
        this.cse = -1;
    }

    public void euo() {
        this.qra = null;
    }
}
