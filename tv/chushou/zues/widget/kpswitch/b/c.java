package tv.chushou.zues.widget.kpswitch.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.Locale;
import tv.chushou.zues.widget.kpswitch.b.d;
/* loaded from: classes6.dex */
public class c implements ViewTreeObserver.OnGlobalLayoutListener {
    private final int bRp;
    private final boolean isFullScreen;
    private int oQg = 0;
    private final ViewGroup oQh;
    private final tv.chushou.zues.widget.kpswitch.b oQi;
    private final boolean oQj;
    private final boolean oQk;
    private int oQl;
    private boolean oQm;
    private final d.a oQn;
    private int oQo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, tv.chushou.zues.widget.kpswitch.b bVar, d.a aVar) {
        this.oQh = viewGroup;
        this.oQi = bVar;
        this.isFullScreen = z;
        this.oQj = z2;
        this.oQk = z3;
        this.bRp = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(viewGroup.getContext());
        if (viewGroup.getContext() instanceof Activity) {
            this.oQl = tv.chushou.zues.utils.systemBar.b.ay((Activity) viewGroup.getContext());
        } else {
            this.oQl = tv.chushou.zues.utils.systemBar.b.ha(viewGroup.getContext());
        }
        this.oQn = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        View childAt = this.oQh.getChildAt(0);
        View view = (View) this.oQh.getParent();
        Rect rect = new Rect();
        if (this.oQj) {
            view.getWindowVisibleDisplayFrame(rect);
            i = (rect.bottom - rect.top) + this.bRp + this.oQl;
        } else {
            childAt.getWindowVisibleDisplayFrame(rect);
            i = rect.bottom - rect.top;
        }
        if (this.oQg != i) {
            OR(i);
            OS(i);
            this.oQg = i;
        }
    }

    private void OR(int i) {
        int abs;
        int hj;
        if (this.oQg == 0) {
            this.oQg = i;
            this.oQi.OP(d.hj(getContext()));
            return;
        }
        if (a.m(this.isFullScreen, this.oQj, this.oQk)) {
            int height = ((View) this.oQh.getParent()).getHeight() - i;
            tv.chushou.zues.utils.e.d("KeyboardStatusListener", String.format(Locale.CHINA, "action bar over layout %d display height: %d", Integer.valueOf(((View) this.oQh.getParent()).getHeight()), Integer.valueOf(i)));
            abs = height;
        } else {
            abs = Math.abs(i - this.oQg);
        }
        if (abs > 0) {
            this.oQg = i;
            if (abs == this.bRp) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format(Locale.CHINA, "On global layout change get keyboard height just equal statusBar height %d", Integer.valueOf(abs)));
            } else if (d.K(getContext(), abs) && this.oQi.getHeight() != (hj = d.hj(getContext()))) {
                this.oQi.OP(hj);
            }
        }
    }

    private void OS(int i) {
        boolean z;
        boolean z2 = true;
        View view = (View) this.oQh.getParent();
        int height = view.getHeight() - view.getPaddingTop();
        if (a.m(this.isFullScreen, this.oQj, this.oQk)) {
            if (!this.oQj && height - i == this.bRp) {
                z = this.oQm;
            } else {
                z = height > i;
            }
        } else {
            int i2 = this.oQh.getResources().getDisplayMetrics().heightPixels;
            if (!this.oQj && i2 == height) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format("skip the keyboard status calculate, the current activity is paused. and phone-display-height %d, root-height+actionbar-height %d", Integer.valueOf(i2), Integer.valueOf(height)));
                return;
            }
            if (this.oQo == 0) {
                z2 = this.oQm;
            } else if ((this.oQo - this.oQl) - i <= 100) {
                z2 = false;
            }
            this.oQo = Math.max(this.oQo, height);
            z = z2;
        }
        if (this.oQm != z) {
            this.oQi.yw(z);
            if (this.oQn != null) {
                this.oQn.yw(z);
            }
        }
        this.oQm = z;
    }

    private Context getContext() {
        return this.oQh.getContext();
    }
}
