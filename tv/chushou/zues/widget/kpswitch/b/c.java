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
    private final int cua;
    private int fpn = 0;
    private final ViewGroup fpo;
    private final boolean fpq;
    private final boolean fpr;
    private boolean fpt;
    private int fpw;
    private final boolean isFullScreen;
    private final tv.chushou.zues.widget.kpswitch.b qpE;
    private int qpF;
    private final d.a qpG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, tv.chushou.zues.widget.kpswitch.b bVar, d.a aVar) {
        this.fpo = viewGroup;
        this.qpE = bVar;
        this.isFullScreen = z;
        this.fpq = z2;
        this.fpr = z3;
        this.cua = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(viewGroup.getContext());
        if (viewGroup.getContext() instanceof Activity) {
            this.qpF = tv.chushou.zues.utils.systemBar.b.aI((Activity) viewGroup.getContext());
        } else {
            this.qpF = tv.chushou.zues.utils.systemBar.b.hH(viewGroup.getContext());
        }
        this.qpG = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        View childAt = this.fpo.getChildAt(0);
        View view = (View) this.fpo.getParent();
        Rect rect = new Rect();
        if (this.fpq) {
            view.getWindowVisibleDisplayFrame(rect);
            i = (rect.bottom - rect.top) + this.cua + this.qpF;
        } else {
            childAt.getWindowVisibleDisplayFrame(rect);
            i = rect.bottom - rect.top;
        }
        if (this.fpn != i) {
            rs(i);
            rt(i);
            this.fpn = i;
        }
    }

    private void rs(int i) {
        int abs;
        int el;
        if (this.fpn == 0) {
            this.fpn = i;
            this.qpE.rq(d.el(getContext()));
            return;
        }
        if (a.f(this.isFullScreen, this.fpq, this.fpr)) {
            int height = ((View) this.fpo.getParent()).getHeight() - i;
            tv.chushou.zues.utils.e.d("KeyboardStatusListener", String.format(Locale.CHINA, "action bar over layout %d display height: %d", Integer.valueOf(((View) this.fpo.getParent()).getHeight()), Integer.valueOf(i)));
            abs = height;
        } else {
            abs = Math.abs(i - this.fpn);
        }
        if (abs > 0) {
            this.fpn = i;
            if (abs == this.cua) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format(Locale.CHINA, "On global layout change get keyboard height just equal statusBar height %d", Integer.valueOf(abs)));
            } else if (d.y(getContext(), abs) && this.qpE.getHeight() != (el = d.el(getContext()))) {
                this.qpE.rq(el);
            }
        }
    }

    private void rt(int i) {
        boolean z;
        boolean z2 = true;
        View view = (View) this.fpo.getParent();
        int height = view.getHeight() - view.getPaddingTop();
        if (a.f(this.isFullScreen, this.fpq, this.fpr)) {
            if (!this.fpq && height - i == this.cua) {
                z = this.fpt;
            } else {
                z = height > i;
            }
        } else {
            int i2 = this.fpo.getResources().getDisplayMetrics().heightPixels;
            if (!this.fpq && i2 == height) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format("skip the keyboard status calculate, the current activity is paused. and phone-display-height %d, root-height+actionbar-height %d", Integer.valueOf(i2), Integer.valueOf(height)));
                return;
            }
            if (this.fpw == 0) {
                z2 = this.fpt;
            } else if ((this.fpw - this.qpF) - i <= 100) {
                z2 = false;
            }
            this.fpw = Math.max(this.fpw, height);
            z = z2;
        }
        if (this.fpt != z) {
            this.qpE.kg(z);
            if (this.qpG != null) {
                this.qpG.kg(z);
            }
        }
        this.fpt = z;
    }

    private Context getContext() {
        return this.fpo.getContext();
    }
}
