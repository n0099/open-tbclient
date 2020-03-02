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
    private int bat;
    private final int bav;
    private final boolean isFullScreen;
    private final d.a nZA;
    private int nZt = 0;
    private final ViewGroup nZu;
    private final tv.chushou.zues.widget.kpswitch.b nZv;
    private final boolean nZw;
    private final boolean nZx;
    private int nZy;
    private boolean nZz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, tv.chushou.zues.widget.kpswitch.b bVar, d.a aVar) {
        this.nZu = viewGroup;
        this.nZv = bVar;
        this.isFullScreen = z;
        this.nZw = z2;
        this.nZx = z3;
        this.bav = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(viewGroup.getContext());
        if (viewGroup.getContext() instanceof Activity) {
            this.nZy = tv.chushou.zues.utils.systemBar.b.aC((Activity) viewGroup.getContext());
        } else {
            this.nZy = tv.chushou.zues.utils.systemBar.b.hh(viewGroup.getContext());
        }
        this.nZA = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        View childAt = this.nZu.getChildAt(0);
        View view = (View) this.nZu.getParent();
        Rect rect = new Rect();
        if (this.nZw) {
            view.getWindowVisibleDisplayFrame(rect);
            i = (rect.bottom - rect.top) + this.bav + this.nZy;
        } else {
            childAt.getWindowVisibleDisplayFrame(rect);
            i = rect.bottom - rect.top;
        }
        if (this.nZt != i) {
            Oy(i);
            Oz(i);
            this.nZt = i;
        }
    }

    private void Oy(int i) {
        int abs;
        int bl;
        if (this.nZt == 0) {
            this.nZt = i;
            this.nZv.dL(d.bl(getContext()));
            return;
        }
        if (a.l(this.isFullScreen, this.nZw, this.nZx)) {
            int height = ((View) this.nZu.getParent()).getHeight() - i;
            tv.chushou.zues.utils.e.d("KeyboardStatusListener", String.format(Locale.CHINA, "action bar over layout %d display height: %d", Integer.valueOf(((View) this.nZu.getParent()).getHeight()), Integer.valueOf(i)));
            abs = height;
        } else {
            abs = Math.abs(i - this.nZt);
        }
        if (abs > 0) {
            this.nZt = i;
            if (abs == this.bav) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format(Locale.CHINA, "On global layout change get keyboard height just equal statusBar height %d", Integer.valueOf(abs)));
            } else if (d.N(getContext(), abs) && this.nZv.getHeight() != (bl = d.bl(getContext()))) {
                this.nZv.dL(bl);
            }
        }
    }

    private void Oz(int i) {
        boolean z;
        boolean z2 = true;
        View view = (View) this.nZu.getParent();
        int height = view.getHeight() - view.getPaddingTop();
        if (a.l(this.isFullScreen, this.nZw, this.nZx)) {
            if (!this.nZw && height - i == this.bav) {
                z = this.nZz;
            } else {
                z = height > i;
            }
        } else {
            int i2 = this.nZu.getResources().getDisplayMetrics().heightPixels;
            if (!this.nZw && i2 == height) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format("skip the keyboard status calculate, the current activity is paused. and phone-display-height %d, root-height+actionbar-height %d", Integer.valueOf(i2), Integer.valueOf(height)));
                return;
            }
            if (this.bat == 0) {
                z2 = this.nZz;
            } else if ((this.bat - this.nZy) - i <= 100) {
                z2 = false;
            }
            this.bat = Math.max(this.bat, height);
            z = z2;
        }
        if (this.nZz != z) {
            this.nZv.wj(z);
            if (this.nZA != null) {
                this.nZA.wj(z);
            }
        }
        this.nZz = z;
    }

    private Context getContext() {
        return this.nZu.getContext();
    }
}
