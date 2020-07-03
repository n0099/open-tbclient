package tv.chushou.zues.widget.kpswitch.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.Locale;
import tv.chushou.zues.widget.kpswitch.b.d;
/* loaded from: classes5.dex */
public class c implements ViewTreeObserver.OnGlobalLayoutListener {
    private final int bLt;
    private final boolean isFullScreen;
    private int onn = 0;
    private final ViewGroup ono;
    private final tv.chushou.zues.widget.kpswitch.b onp;
    private final boolean onq;
    private final boolean onr;
    private int ons;
    private boolean ont;
    private final d.a onu;
    private int onv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, tv.chushou.zues.widget.kpswitch.b bVar, d.a aVar) {
        this.ono = viewGroup;
        this.onp = bVar;
        this.isFullScreen = z;
        this.onq = z2;
        this.onr = z3;
        this.bLt = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(viewGroup.getContext());
        if (viewGroup.getContext() instanceof Activity) {
            this.ons = tv.chushou.zues.utils.systemBar.b.aw((Activity) viewGroup.getContext());
        } else {
            this.ons = tv.chushou.zues.utils.systemBar.b.gB(viewGroup.getContext());
        }
        this.onu = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        View childAt = this.ono.getChildAt(0);
        View view = (View) this.ono.getParent();
        Rect rect = new Rect();
        if (this.onq) {
            view.getWindowVisibleDisplayFrame(rect);
            i = (rect.bottom - rect.top) + this.bLt + this.ons;
        } else {
            childAt.getWindowVisibleDisplayFrame(rect);
            i = rect.bottom - rect.top;
        }
        if (this.onn != i) {
            LU(i);
            LV(i);
            this.onn = i;
        }
    }

    private void LU(int i) {
        int abs;
        int gK;
        if (this.onn == 0) {
            this.onn = i;
            this.onp.LS(d.gK(getContext()));
            return;
        }
        if (a.l(this.isFullScreen, this.onq, this.onr)) {
            int height = ((View) this.ono.getParent()).getHeight() - i;
            tv.chushou.zues.utils.e.d("KeyboardStatusListener", String.format(Locale.CHINA, "action bar over layout %d display height: %d", Integer.valueOf(((View) this.ono.getParent()).getHeight()), Integer.valueOf(i)));
            abs = height;
        } else {
            abs = Math.abs(i - this.onn);
        }
        if (abs > 0) {
            this.onn = i;
            if (abs == this.bLt) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format(Locale.CHINA, "On global layout change get keyboard height just equal statusBar height %d", Integer.valueOf(abs)));
            } else if (d.I(getContext(), abs) && this.onp.getHeight() != (gK = d.gK(getContext()))) {
                this.onp.LS(gK);
            }
        }
    }

    private void LV(int i) {
        boolean z;
        boolean z2 = true;
        View view = (View) this.ono.getParent();
        int height = view.getHeight() - view.getPaddingTop();
        if (a.l(this.isFullScreen, this.onq, this.onr)) {
            if (!this.onq && height - i == this.bLt) {
                z = this.ont;
            } else {
                z = height > i;
            }
        } else {
            int i2 = this.ono.getResources().getDisplayMetrics().heightPixels;
            if (!this.onq && i2 == height) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format("skip the keyboard status calculate, the current activity is paused. and phone-display-height %d, root-height+actionbar-height %d", Integer.valueOf(i2), Integer.valueOf(height)));
                return;
            }
            if (this.onv == 0) {
                z2 = this.ont;
            } else if ((this.onv - this.ons) - i <= 100) {
                z2 = false;
            }
            this.onv = Math.max(this.onv, height);
            z = z2;
        }
        if (this.ont != z) {
            this.onp.wY(z);
            if (this.onu != null) {
                this.onu.wY(z);
            }
        }
        this.ont = z;
    }

    private Context getContext() {
        return this.ono.getContext();
    }
}
