package tv.chushou.zues.widget.kpswitch.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.Locale;
import tv.chushou.zues.widget.kpswitch.b.d;
/* loaded from: classes4.dex */
public class c implements ViewTreeObserver.OnGlobalLayoutListener {
    private int aWg;
    private final int aWi;
    private final boolean isFullScreen;
    private int nYD = 0;
    private final ViewGroup nYE;
    private final tv.chushou.zues.widget.kpswitch.b nYF;
    private final boolean nYG;
    private final boolean nYH;
    private int nYI;
    private boolean nYJ;
    private final d.a nYK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, tv.chushou.zues.widget.kpswitch.b bVar, d.a aVar) {
        this.nYE = viewGroup;
        this.nYF = bVar;
        this.isFullScreen = z;
        this.nYG = z2;
        this.nYH = z3;
        this.aWi = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(viewGroup.getContext());
        if (viewGroup.getContext() instanceof Activity) {
            this.nYI = tv.chushou.zues.utils.systemBar.b.aB((Activity) viewGroup.getContext());
        } else {
            this.nYI = tv.chushou.zues.utils.systemBar.b.hi(viewGroup.getContext());
        }
        this.nYK = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        View childAt = this.nYE.getChildAt(0);
        View view = (View) this.nYE.getParent();
        Rect rect = new Rect();
        if (this.nYG) {
            view.getWindowVisibleDisplayFrame(rect);
            i = (rect.bottom - rect.top) + this.aWi + this.nYI;
        } else {
            childAt.getWindowVisibleDisplayFrame(rect);
            i = rect.bottom - rect.top;
        }
        if (this.nYD != i) {
            Ov(i);
            Ow(i);
            this.nYD = i;
        }
    }

    private void Ov(int i) {
        int abs;
        int bh;
        if (this.nYD == 0) {
            this.nYD = i;
            this.nYF.dv(d.bh(getContext()));
            return;
        }
        if (a.l(this.isFullScreen, this.nYG, this.nYH)) {
            int height = ((View) this.nYE.getParent()).getHeight() - i;
            tv.chushou.zues.utils.e.d("KeyboardStatusListener", String.format(Locale.CHINA, "action bar over layout %d display height: %d", Integer.valueOf(((View) this.nYE.getParent()).getHeight()), Integer.valueOf(i)));
            abs = height;
        } else {
            abs = Math.abs(i - this.nYD);
        }
        if (abs > 0) {
            this.nYD = i;
            if (abs == this.aWi) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format(Locale.CHINA, "On global layout change get keyboard height just equal statusBar height %d", Integer.valueOf(abs)));
            } else if (d.N(getContext(), abs) && this.nYF.getHeight() != (bh = d.bh(getContext()))) {
                this.nYF.dv(bh);
            }
        }
    }

    private void Ow(int i) {
        boolean z;
        boolean z2 = true;
        View view = (View) this.nYE.getParent();
        int height = view.getHeight() - view.getPaddingTop();
        if (a.l(this.isFullScreen, this.nYG, this.nYH)) {
            if (!this.nYG && height - i == this.aWi) {
                z = this.nYJ;
            } else {
                z = height > i;
            }
        } else {
            int i2 = this.nYE.getResources().getDisplayMetrics().heightPixels;
            if (!this.nYG && i2 == height) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format("skip the keyboard status calculate, the current activity is paused. and phone-display-height %d, root-height+actionbar-height %d", Integer.valueOf(i2), Integer.valueOf(height)));
                return;
            }
            if (this.aWg == 0) {
                z2 = this.nYJ;
            } else if ((this.aWg - this.nYI) - i <= 100) {
                z2 = false;
            }
            this.aWg = Math.max(this.aWg, height);
            z = z2;
        }
        if (this.nYJ != z) {
            this.nYF.wf(z);
            if (this.nYK != null) {
                this.nYK.wf(z);
            }
        }
        this.nYJ = z;
    }

    private Context getContext() {
        return this.nYE.getContext();
    }
}
