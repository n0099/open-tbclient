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
    private final int cfD;
    private int faX = 0;
    private final ViewGroup faY;
    private final boolean fba;
    private final boolean fbb;
    private boolean fbc;
    private int fbf;
    private final boolean isFullScreen;
    private final tv.chushou.zues.widget.kpswitch.b poX;
    private int poY;
    private final d.a poZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, tv.chushou.zues.widget.kpswitch.b bVar, d.a aVar) {
        this.faY = viewGroup;
        this.poX = bVar;
        this.isFullScreen = z;
        this.fba = z2;
        this.fbb = z3;
        this.cfD = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(viewGroup.getContext());
        if (viewGroup.getContext() instanceof Activity) {
            this.poY = tv.chushou.zues.utils.systemBar.b.aD((Activity) viewGroup.getContext());
        } else {
            this.poY = tv.chushou.zues.utils.systemBar.b.hn(viewGroup.getContext());
        }
        this.poZ = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        View childAt = this.faY.getChildAt(0);
        View view = (View) this.faY.getParent();
        Rect rect = new Rect();
        if (this.fba) {
            view.getWindowVisibleDisplayFrame(rect);
            i = (rect.bottom - rect.top) + this.cfD + this.poY;
        } else {
            childAt.getWindowVisibleDisplayFrame(rect);
            i = rect.bottom - rect.top;
        }
        if (this.faX != i) {
            qX(i);
            qY(i);
            this.faX = i;
        }
    }

    private void qX(int i) {
        int abs;
        int el;
        if (this.faX == 0) {
            this.faX = i;
            this.poX.qV(d.el(getContext()));
            return;
        }
        if (a.f(this.isFullScreen, this.fba, this.fbb)) {
            int height = ((View) this.faY.getParent()).getHeight() - i;
            tv.chushou.zues.utils.e.d("KeyboardStatusListener", String.format(Locale.CHINA, "action bar over layout %d display height: %d", Integer.valueOf(((View) this.faY.getParent()).getHeight()), Integer.valueOf(i)));
            abs = height;
        } else {
            abs = Math.abs(i - this.faX);
        }
        if (abs > 0) {
            this.faX = i;
            if (abs == this.cfD) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format(Locale.CHINA, "On global layout change get keyboard height just equal statusBar height %d", Integer.valueOf(abs)));
            } else if (d.y(getContext(), abs) && this.poX.getHeight() != (el = d.el(getContext()))) {
                this.poX.qV(el);
            }
        }
    }

    private void qY(int i) {
        boolean z;
        boolean z2 = true;
        View view = (View) this.faY.getParent();
        int height = view.getHeight() - view.getPaddingTop();
        if (a.f(this.isFullScreen, this.fba, this.fbb)) {
            if (!this.fba && height - i == this.cfD) {
                z = this.fbc;
            } else {
                z = height > i;
            }
        } else {
            int i2 = this.faY.getResources().getDisplayMetrics().heightPixels;
            if (!this.fba && i2 == height) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format("skip the keyboard status calculate, the current activity is paused. and phone-display-height %d, root-height+actionbar-height %d", Integer.valueOf(i2), Integer.valueOf(height)));
                return;
            }
            if (this.fbf == 0) {
                z2 = this.fbc;
            } else if ((this.fbf - this.poY) - i <= 100) {
                z2 = false;
            }
            this.fbf = Math.max(this.fbf, height);
            z = z2;
        }
        if (this.fbc != z) {
            this.poX.jK(z);
            if (this.poZ != null) {
                this.poZ.jK(z);
            }
        }
        this.fbc = z;
    }

    private Context getContext() {
        return this.faY.getContext();
    }
}
