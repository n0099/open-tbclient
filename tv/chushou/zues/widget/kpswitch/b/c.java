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
    private int bau;
    private final int baw;
    private final boolean isFullScreen;
    private int nZE = 0;
    private final ViewGroup nZF;
    private final tv.chushou.zues.widget.kpswitch.b nZG;
    private final boolean nZH;
    private final boolean nZI;
    private int nZJ;
    private boolean nZK;
    private final d.a nZL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, tv.chushou.zues.widget.kpswitch.b bVar, d.a aVar) {
        this.nZF = viewGroup;
        this.nZG = bVar;
        this.isFullScreen = z;
        this.nZH = z2;
        this.nZI = z3;
        this.baw = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(viewGroup.getContext());
        if (viewGroup.getContext() instanceof Activity) {
            this.nZJ = tv.chushou.zues.utils.systemBar.b.aE((Activity) viewGroup.getContext());
        } else {
            this.nZJ = tv.chushou.zues.utils.systemBar.b.hh(viewGroup.getContext());
        }
        this.nZL = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        View childAt = this.nZF.getChildAt(0);
        View view = (View) this.nZF.getParent();
        Rect rect = new Rect();
        if (this.nZH) {
            view.getWindowVisibleDisplayFrame(rect);
            i = (rect.bottom - rect.top) + this.baw + this.nZJ;
        } else {
            childAt.getWindowVisibleDisplayFrame(rect);
            i = rect.bottom - rect.top;
        }
        if (this.nZE != i) {
            Oy(i);
            Oz(i);
            this.nZE = i;
        }
    }

    private void Oy(int i) {
        int abs;
        int bl;
        if (this.nZE == 0) {
            this.nZE = i;
            this.nZG.dL(d.bl(getContext()));
            return;
        }
        if (a.l(this.isFullScreen, this.nZH, this.nZI)) {
            int height = ((View) this.nZF.getParent()).getHeight() - i;
            tv.chushou.zues.utils.e.d("KeyboardStatusListener", String.format(Locale.CHINA, "action bar over layout %d display height: %d", Integer.valueOf(((View) this.nZF.getParent()).getHeight()), Integer.valueOf(i)));
            abs = height;
        } else {
            abs = Math.abs(i - this.nZE);
        }
        if (abs > 0) {
            this.nZE = i;
            if (abs == this.baw) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format(Locale.CHINA, "On global layout change get keyboard height just equal statusBar height %d", Integer.valueOf(abs)));
            } else if (d.N(getContext(), abs) && this.nZG.getHeight() != (bl = d.bl(getContext()))) {
                this.nZG.dL(bl);
            }
        }
    }

    private void Oz(int i) {
        boolean z;
        boolean z2 = true;
        View view = (View) this.nZF.getParent();
        int height = view.getHeight() - view.getPaddingTop();
        if (a.l(this.isFullScreen, this.nZH, this.nZI)) {
            if (!this.nZH && height - i == this.baw) {
                z = this.nZK;
            } else {
                z = height > i;
            }
        } else {
            int i2 = this.nZF.getResources().getDisplayMetrics().heightPixels;
            if (!this.nZH && i2 == height) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format("skip the keyboard status calculate, the current activity is paused. and phone-display-height %d, root-height+actionbar-height %d", Integer.valueOf(i2), Integer.valueOf(height)));
                return;
            }
            if (this.bau == 0) {
                z2 = this.nZK;
            } else if ((this.bau - this.nZJ) - i <= 100) {
                z2 = false;
            }
            this.bau = Math.max(this.bau, height);
            z = z2;
        }
        if (this.nZK != z) {
            this.nZG.wj(z);
            if (this.nZL != null) {
                this.nZL.wj(z);
            }
        }
        this.nZK = z;
    }

    private Context getContext() {
        return this.nZF.getContext();
    }
}
