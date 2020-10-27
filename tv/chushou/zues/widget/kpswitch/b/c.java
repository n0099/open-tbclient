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
    private final int coc;
    private final boolean fjA;
    private boolean fjB;
    private int fjE;
    private int fjw = 0;
    private final ViewGroup fjx;
    private final boolean fjz;
    private final boolean isFullScreen;
    private final tv.chushou.zues.widget.kpswitch.b qgj;
    private int qgk;
    private final d.a qgl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, tv.chushou.zues.widget.kpswitch.b bVar, d.a aVar) {
        this.fjx = viewGroup;
        this.qgj = bVar;
        this.isFullScreen = z;
        this.fjz = z2;
        this.fjA = z3;
        this.coc = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(viewGroup.getContext());
        if (viewGroup.getContext() instanceof Activity) {
            this.qgk = tv.chushou.zues.utils.systemBar.b.aG((Activity) viewGroup.getContext());
        } else {
            this.qgk = tv.chushou.zues.utils.systemBar.b.hH(viewGroup.getContext());
        }
        this.qgl = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        View childAt = this.fjx.getChildAt(0);
        View view = (View) this.fjx.getParent();
        Rect rect = new Rect();
        if (this.fjz) {
            view.getWindowVisibleDisplayFrame(rect);
            i = (rect.bottom - rect.top) + this.coc + this.qgk;
        } else {
            childAt.getWindowVisibleDisplayFrame(rect);
            i = rect.bottom - rect.top;
        }
        if (this.fjw != i) {
            ri(i);
            rj(i);
            this.fjw = i;
        }
    }

    private void ri(int i) {
        int abs;
        int el;
        if (this.fjw == 0) {
            this.fjw = i;
            this.qgj.rg(d.el(getContext()));
            return;
        }
        if (a.f(this.isFullScreen, this.fjz, this.fjA)) {
            int height = ((View) this.fjx.getParent()).getHeight() - i;
            tv.chushou.zues.utils.e.d("KeyboardStatusListener", String.format(Locale.CHINA, "action bar over layout %d display height: %d", Integer.valueOf(((View) this.fjx.getParent()).getHeight()), Integer.valueOf(i)));
            abs = height;
        } else {
            abs = Math.abs(i - this.fjw);
        }
        if (abs > 0) {
            this.fjw = i;
            if (abs == this.coc) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format(Locale.CHINA, "On global layout change get keyboard height just equal statusBar height %d", Integer.valueOf(abs)));
            } else if (d.y(getContext(), abs) && this.qgj.getHeight() != (el = d.el(getContext()))) {
                this.qgj.rg(el);
            }
        }
    }

    private void rj(int i) {
        boolean z;
        boolean z2 = true;
        View view = (View) this.fjx.getParent();
        int height = view.getHeight() - view.getPaddingTop();
        if (a.f(this.isFullScreen, this.fjz, this.fjA)) {
            if (!this.fjz && height - i == this.coc) {
                z = this.fjB;
            } else {
                z = height > i;
            }
        } else {
            int i2 = this.fjx.getResources().getDisplayMetrics().heightPixels;
            if (!this.fjz && i2 == height) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format("skip the keyboard status calculate, the current activity is paused. and phone-display-height %d, root-height+actionbar-height %d", Integer.valueOf(i2), Integer.valueOf(height)));
                return;
            }
            if (this.fjE == 0) {
                z2 = this.fjB;
            } else if ((this.fjE - this.qgk) - i <= 100) {
                z2 = false;
            }
            this.fjE = Math.max(this.fjE, height);
            z = z2;
        }
        if (this.fjB != z) {
            this.qgj.jX(z);
            if (this.qgl != null) {
                this.qgl.jX(z);
            }
        }
        this.fjB = z;
    }

    private Context getContext() {
        return this.fjx.getContext();
    }
}
