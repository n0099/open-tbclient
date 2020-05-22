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
    private int nQo = 0;
    private final ViewGroup nQp;
    private final tv.chushou.zues.widget.kpswitch.b nQq;
    private final boolean nQr;
    private final boolean nQs;
    private int nQt;
    private boolean nQu;
    private final d.a nQv;
    private int nQw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, tv.chushou.zues.widget.kpswitch.b bVar, d.a aVar) {
        this.nQp = viewGroup;
        this.nQq = bVar;
        this.isFullScreen = z;
        this.nQr = z2;
        this.nQs = z3;
        this.bGF = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(viewGroup.getContext());
        if (viewGroup.getContext() instanceof Activity) {
            this.nQt = tv.chushou.zues.utils.systemBar.b.aw((Activity) viewGroup.getContext());
        } else {
            this.nQt = tv.chushou.zues.utils.systemBar.b.gA(viewGroup.getContext());
        }
        this.nQv = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        View childAt = this.nQp.getChildAt(0);
        View view = (View) this.nQp.getParent();
        Rect rect = new Rect();
        if (this.nQr) {
            view.getWindowVisibleDisplayFrame(rect);
            i = (rect.bottom - rect.top) + this.bGF + this.nQt;
        } else {
            childAt.getWindowVisibleDisplayFrame(rect);
            i = rect.bottom - rect.top;
        }
        if (this.nQo != i) {
            KM(i);
            KN(i);
            this.nQo = i;
        }
    }

    private void KM(int i) {
        int abs;
        int gJ;
        if (this.nQo == 0) {
            this.nQo = i;
            this.nQq.KK(d.gJ(getContext()));
            return;
        }
        if (a.l(this.isFullScreen, this.nQr, this.nQs)) {
            int height = ((View) this.nQp.getParent()).getHeight() - i;
            tv.chushou.zues.utils.e.d("KeyboardStatusListener", String.format(Locale.CHINA, "action bar over layout %d display height: %d", Integer.valueOf(((View) this.nQp.getParent()).getHeight()), Integer.valueOf(i)));
            abs = height;
        } else {
            abs = Math.abs(i - this.nQo);
        }
        if (abs > 0) {
            this.nQo = i;
            if (abs == this.bGF) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format(Locale.CHINA, "On global layout change get keyboard height just equal statusBar height %d", Integer.valueOf(abs)));
            } else if (d.I(getContext(), abs) && this.nQq.getHeight() != (gJ = d.gJ(getContext()))) {
                this.nQq.KK(gJ);
            }
        }
    }

    private void KN(int i) {
        boolean z;
        boolean z2 = true;
        View view = (View) this.nQp.getParent();
        int height = view.getHeight() - view.getPaddingTop();
        if (a.l(this.isFullScreen, this.nQr, this.nQs)) {
            if (!this.nQr && height - i == this.bGF) {
                z = this.nQu;
            } else {
                z = height > i;
            }
        } else {
            int i2 = this.nQp.getResources().getDisplayMetrics().heightPixels;
            if (!this.nQr && i2 == height) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format("skip the keyboard status calculate, the current activity is paused. and phone-display-height %d, root-height+actionbar-height %d", Integer.valueOf(i2), Integer.valueOf(height)));
                return;
            }
            if (this.nQw == 0) {
                z2 = this.nQu;
            } else if ((this.nQw - this.nQt) - i <= 100) {
                z2 = false;
            }
            this.nQw = Math.max(this.nQw, height);
            z = z2;
        }
        if (this.nQu != z) {
            this.nQq.wA(z);
            if (this.nQv != null) {
                this.nQv.wA(z);
            }
        }
        this.nQu = z;
    }

    private Context getContext() {
        return this.nQp.getContext();
    }
}
