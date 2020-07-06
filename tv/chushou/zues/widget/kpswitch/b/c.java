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
    private int onq = 0;
    private final ViewGroup onr;
    private final tv.chushou.zues.widget.kpswitch.b ons;
    private final boolean ont;
    private final boolean onu;
    private int onv;
    private boolean onw;
    private final d.a onx;
    private int ony;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, tv.chushou.zues.widget.kpswitch.b bVar, d.a aVar) {
        this.onr = viewGroup;
        this.ons = bVar;
        this.isFullScreen = z;
        this.ont = z2;
        this.onu = z3;
        this.bLt = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(viewGroup.getContext());
        if (viewGroup.getContext() instanceof Activity) {
            this.onv = tv.chushou.zues.utils.systemBar.b.aw((Activity) viewGroup.getContext());
        } else {
            this.onv = tv.chushou.zues.utils.systemBar.b.gB(viewGroup.getContext());
        }
        this.onx = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        View childAt = this.onr.getChildAt(0);
        View view = (View) this.onr.getParent();
        Rect rect = new Rect();
        if (this.ont) {
            view.getWindowVisibleDisplayFrame(rect);
            i = (rect.bottom - rect.top) + this.bLt + this.onv;
        } else {
            childAt.getWindowVisibleDisplayFrame(rect);
            i = rect.bottom - rect.top;
        }
        if (this.onq != i) {
            LU(i);
            LV(i);
            this.onq = i;
        }
    }

    private void LU(int i) {
        int abs;
        int gK;
        if (this.onq == 0) {
            this.onq = i;
            this.ons.LS(d.gK(getContext()));
            return;
        }
        if (a.l(this.isFullScreen, this.ont, this.onu)) {
            int height = ((View) this.onr.getParent()).getHeight() - i;
            tv.chushou.zues.utils.e.d("KeyboardStatusListener", String.format(Locale.CHINA, "action bar over layout %d display height: %d", Integer.valueOf(((View) this.onr.getParent()).getHeight()), Integer.valueOf(i)));
            abs = height;
        } else {
            abs = Math.abs(i - this.onq);
        }
        if (abs > 0) {
            this.onq = i;
            if (abs == this.bLt) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format(Locale.CHINA, "On global layout change get keyboard height just equal statusBar height %d", Integer.valueOf(abs)));
            } else if (d.I(getContext(), abs) && this.ons.getHeight() != (gK = d.gK(getContext()))) {
                this.ons.LS(gK);
            }
        }
    }

    private void LV(int i) {
        boolean z;
        boolean z2 = true;
        View view = (View) this.onr.getParent();
        int height = view.getHeight() - view.getPaddingTop();
        if (a.l(this.isFullScreen, this.ont, this.onu)) {
            if (!this.ont && height - i == this.bLt) {
                z = this.onw;
            } else {
                z = height > i;
            }
        } else {
            int i2 = this.onr.getResources().getDisplayMetrics().heightPixels;
            if (!this.ont && i2 == height) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format("skip the keyboard status calculate, the current activity is paused. and phone-display-height %d, root-height+actionbar-height %d", Integer.valueOf(i2), Integer.valueOf(height)));
                return;
            }
            if (this.ony == 0) {
                z2 = this.onw;
            } else if ((this.ony - this.onv) - i <= 100) {
                z2 = false;
            }
            this.ony = Math.max(this.ony, height);
            z = z2;
        }
        if (this.onw != z) {
            this.ons.wY(z);
            if (this.onx != null) {
                this.onx.wY(z);
            }
        }
        this.onw = z;
    }

    private Context getContext() {
        return this.onr.getContext();
    }
}
