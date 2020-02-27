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
    private int bas;
    private final int bau;
    private final boolean isFullScreen;
    private int nZr = 0;
    private final ViewGroup nZs;
    private final tv.chushou.zues.widget.kpswitch.b nZt;
    private final boolean nZu;
    private final boolean nZv;
    private int nZw;
    private boolean nZx;
    private final d.a nZy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, tv.chushou.zues.widget.kpswitch.b bVar, d.a aVar) {
        this.nZs = viewGroup;
        this.nZt = bVar;
        this.isFullScreen = z;
        this.nZu = z2;
        this.nZv = z3;
        this.bau = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(viewGroup.getContext());
        if (viewGroup.getContext() instanceof Activity) {
            this.nZw = tv.chushou.zues.utils.systemBar.b.aC((Activity) viewGroup.getContext());
        } else {
            this.nZw = tv.chushou.zues.utils.systemBar.b.hh(viewGroup.getContext());
        }
        this.nZy = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        View childAt = this.nZs.getChildAt(0);
        View view = (View) this.nZs.getParent();
        Rect rect = new Rect();
        if (this.nZu) {
            view.getWindowVisibleDisplayFrame(rect);
            i = (rect.bottom - rect.top) + this.bau + this.nZw;
        } else {
            childAt.getWindowVisibleDisplayFrame(rect);
            i = rect.bottom - rect.top;
        }
        if (this.nZr != i) {
            Oy(i);
            Oz(i);
            this.nZr = i;
        }
    }

    private void Oy(int i) {
        int abs;
        int bl;
        if (this.nZr == 0) {
            this.nZr = i;
            this.nZt.dL(d.bl(getContext()));
            return;
        }
        if (a.l(this.isFullScreen, this.nZu, this.nZv)) {
            int height = ((View) this.nZs.getParent()).getHeight() - i;
            tv.chushou.zues.utils.e.d("KeyboardStatusListener", String.format(Locale.CHINA, "action bar over layout %d display height: %d", Integer.valueOf(((View) this.nZs.getParent()).getHeight()), Integer.valueOf(i)));
            abs = height;
        } else {
            abs = Math.abs(i - this.nZr);
        }
        if (abs > 0) {
            this.nZr = i;
            if (abs == this.bau) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format(Locale.CHINA, "On global layout change get keyboard height just equal statusBar height %d", Integer.valueOf(abs)));
            } else if (d.N(getContext(), abs) && this.nZt.getHeight() != (bl = d.bl(getContext()))) {
                this.nZt.dL(bl);
            }
        }
    }

    private void Oz(int i) {
        boolean z;
        boolean z2 = true;
        View view = (View) this.nZs.getParent();
        int height = view.getHeight() - view.getPaddingTop();
        if (a.l(this.isFullScreen, this.nZu, this.nZv)) {
            if (!this.nZu && height - i == this.bau) {
                z = this.nZx;
            } else {
                z = height > i;
            }
        } else {
            int i2 = this.nZs.getResources().getDisplayMetrics().heightPixels;
            if (!this.nZu && i2 == height) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format("skip the keyboard status calculate, the current activity is paused. and phone-display-height %d, root-height+actionbar-height %d", Integer.valueOf(i2), Integer.valueOf(height)));
                return;
            }
            if (this.bas == 0) {
                z2 = this.nZx;
            } else if ((this.bas - this.nZw) - i <= 100) {
                z2 = false;
            }
            this.bas = Math.max(this.bas, height);
            z = z2;
        }
        if (this.nZx != z) {
            this.nZt.wj(z);
            if (this.nZy != null) {
                this.nZy.wj(z);
            }
        }
        this.nZx = z;
    }

    private Context getContext() {
        return this.nZs.getContext();
    }
}
