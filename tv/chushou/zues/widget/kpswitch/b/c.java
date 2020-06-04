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
    private final int bGF;
    private final boolean isFullScreen;
    private final tv.chushou.zues.widget.kpswitch.b nRA;
    private final boolean nRB;
    private final boolean nRC;
    private int nRD;
    private boolean nRE;
    private final d.a nRF;
    private int nRG;
    private int nRy = 0;
    private final ViewGroup nRz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, tv.chushou.zues.widget.kpswitch.b bVar, d.a aVar) {
        this.nRz = viewGroup;
        this.nRA = bVar;
        this.isFullScreen = z;
        this.nRB = z2;
        this.nRC = z3;
        this.bGF = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(viewGroup.getContext());
        if (viewGroup.getContext() instanceof Activity) {
            this.nRD = tv.chushou.zues.utils.systemBar.b.aw((Activity) viewGroup.getContext());
        } else {
            this.nRD = tv.chushou.zues.utils.systemBar.b.gA(viewGroup.getContext());
        }
        this.nRF = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        View childAt = this.nRz.getChildAt(0);
        View view = (View) this.nRz.getParent();
        Rect rect = new Rect();
        if (this.nRB) {
            view.getWindowVisibleDisplayFrame(rect);
            i = (rect.bottom - rect.top) + this.bGF + this.nRD;
        } else {
            childAt.getWindowVisibleDisplayFrame(rect);
            i = rect.bottom - rect.top;
        }
        if (this.nRy != i) {
            KO(i);
            KP(i);
            this.nRy = i;
        }
    }

    private void KO(int i) {
        int abs;
        int gJ;
        if (this.nRy == 0) {
            this.nRy = i;
            this.nRA.KM(d.gJ(getContext()));
            return;
        }
        if (a.l(this.isFullScreen, this.nRB, this.nRC)) {
            int height = ((View) this.nRz.getParent()).getHeight() - i;
            tv.chushou.zues.utils.e.d("KeyboardStatusListener", String.format(Locale.CHINA, "action bar over layout %d display height: %d", Integer.valueOf(((View) this.nRz.getParent()).getHeight()), Integer.valueOf(i)));
            abs = height;
        } else {
            abs = Math.abs(i - this.nRy);
        }
        if (abs > 0) {
            this.nRy = i;
            if (abs == this.bGF) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format(Locale.CHINA, "On global layout change get keyboard height just equal statusBar height %d", Integer.valueOf(abs)));
            } else if (d.I(getContext(), abs) && this.nRA.getHeight() != (gJ = d.gJ(getContext()))) {
                this.nRA.KM(gJ);
            }
        }
    }

    private void KP(int i) {
        boolean z;
        boolean z2 = true;
        View view = (View) this.nRz.getParent();
        int height = view.getHeight() - view.getPaddingTop();
        if (a.l(this.isFullScreen, this.nRB, this.nRC)) {
            if (!this.nRB && height - i == this.bGF) {
                z = this.nRE;
            } else {
                z = height > i;
            }
        } else {
            int i2 = this.nRz.getResources().getDisplayMetrics().heightPixels;
            if (!this.nRB && i2 == height) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format("skip the keyboard status calculate, the current activity is paused. and phone-display-height %d, root-height+actionbar-height %d", Integer.valueOf(i2), Integer.valueOf(height)));
                return;
            }
            if (this.nRG == 0) {
                z2 = this.nRE;
            } else if ((this.nRG - this.nRD) - i <= 100) {
                z2 = false;
            }
            this.nRG = Math.max(this.nRG, height);
            z = z2;
        }
        if (this.nRE != z) {
            this.nRA.wC(z);
            if (this.nRF != null) {
                this.nRF.wC(z);
            }
        }
        this.nRE = z;
    }

    private Context getContext() {
        return this.nRz.getContext();
    }
}
