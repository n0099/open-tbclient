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
    private final tv.chushou.zues.widget.kpswitch.b nYA;
    private final boolean nYB;
    private final boolean nYC;
    private int nYD;
    private boolean nYE;
    private final d.a nYF;
    private int nYy = 0;
    private final ViewGroup nYz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, tv.chushou.zues.widget.kpswitch.b bVar, d.a aVar) {
        this.nYz = viewGroup;
        this.nYA = bVar;
        this.isFullScreen = z;
        this.nYB = z2;
        this.nYC = z3;
        this.aWi = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(viewGroup.getContext());
        if (viewGroup.getContext() instanceof Activity) {
            this.nYD = tv.chushou.zues.utils.systemBar.b.aB((Activity) viewGroup.getContext());
        } else {
            this.nYD = tv.chushou.zues.utils.systemBar.b.hi(viewGroup.getContext());
        }
        this.nYF = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        View childAt = this.nYz.getChildAt(0);
        View view = (View) this.nYz.getParent();
        Rect rect = new Rect();
        if (this.nYB) {
            view.getWindowVisibleDisplayFrame(rect);
            i = (rect.bottom - rect.top) + this.aWi + this.nYD;
        } else {
            childAt.getWindowVisibleDisplayFrame(rect);
            i = rect.bottom - rect.top;
        }
        if (this.nYy != i) {
            Ov(i);
            Ow(i);
            this.nYy = i;
        }
    }

    private void Ov(int i) {
        int abs;
        int bh;
        if (this.nYy == 0) {
            this.nYy = i;
            this.nYA.dv(d.bh(getContext()));
            return;
        }
        if (a.l(this.isFullScreen, this.nYB, this.nYC)) {
            int height = ((View) this.nYz.getParent()).getHeight() - i;
            tv.chushou.zues.utils.e.d("KeyboardStatusListener", String.format(Locale.CHINA, "action bar over layout %d display height: %d", Integer.valueOf(((View) this.nYz.getParent()).getHeight()), Integer.valueOf(i)));
            abs = height;
        } else {
            abs = Math.abs(i - this.nYy);
        }
        if (abs > 0) {
            this.nYy = i;
            if (abs == this.aWi) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format(Locale.CHINA, "On global layout change get keyboard height just equal statusBar height %d", Integer.valueOf(abs)));
            } else if (d.N(getContext(), abs) && this.nYA.getHeight() != (bh = d.bh(getContext()))) {
                this.nYA.dv(bh);
            }
        }
    }

    private void Ow(int i) {
        boolean z;
        boolean z2 = true;
        View view = (View) this.nYz.getParent();
        int height = view.getHeight() - view.getPaddingTop();
        if (a.l(this.isFullScreen, this.nYB, this.nYC)) {
            if (!this.nYB && height - i == this.aWi) {
                z = this.nYE;
            } else {
                z = height > i;
            }
        } else {
            int i2 = this.nYz.getResources().getDisplayMetrics().heightPixels;
            if (!this.nYB && i2 == height) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format("skip the keyboard status calculate, the current activity is paused. and phone-display-height %d, root-height+actionbar-height %d", Integer.valueOf(i2), Integer.valueOf(height)));
                return;
            }
            if (this.aWg == 0) {
                z2 = this.nYE;
            } else if ((this.aWg - this.nYD) - i <= 100) {
                z2 = false;
            }
            this.aWg = Math.max(this.aWg, height);
            z = z2;
        }
        if (this.nYE != z) {
            this.nYA.wf(z);
            if (this.nYF != null) {
                this.nYF.wf(z);
            }
        }
        this.nYE = z;
    }

    private Context getContext() {
        return this.nYz.getContext();
    }
}
