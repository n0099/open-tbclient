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
    private int baH;
    private final int baJ;
    private final boolean isFullScreen;
    private int obs = 0;
    private final ViewGroup obt;
    private final tv.chushou.zues.widget.kpswitch.b obu;
    private final boolean obv;
    private final boolean obw;
    private int obx;
    private boolean oby;
    private final d.a obz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, tv.chushou.zues.widget.kpswitch.b bVar, d.a aVar) {
        this.obt = viewGroup;
        this.obu = bVar;
        this.isFullScreen = z;
        this.obv = z2;
        this.obw = z3;
        this.baJ = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(viewGroup.getContext());
        if (viewGroup.getContext() instanceof Activity) {
            this.obx = tv.chushou.zues.utils.systemBar.b.aE((Activity) viewGroup.getContext());
        } else {
            this.obx = tv.chushou.zues.utils.systemBar.b.hg(viewGroup.getContext());
        }
        this.obz = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        View childAt = this.obt.getChildAt(0);
        View view = (View) this.obt.getParent();
        Rect rect = new Rect();
        if (this.obv) {
            view.getWindowVisibleDisplayFrame(rect);
            i = (rect.bottom - rect.top) + this.baJ + this.obx;
        } else {
            childAt.getWindowVisibleDisplayFrame(rect);
            i = rect.bottom - rect.top;
        }
        if (this.obs != i) {
            OE(i);
            OF(i);
            this.obs = i;
        }
    }

    private void OE(int i) {
        int abs;
        int bk;
        if (this.obs == 0) {
            this.obs = i;
            this.obu.dL(d.bk(getContext()));
            return;
        }
        if (a.l(this.isFullScreen, this.obv, this.obw)) {
            int height = ((View) this.obt.getParent()).getHeight() - i;
            tv.chushou.zues.utils.e.d("KeyboardStatusListener", String.format(Locale.CHINA, "action bar over layout %d display height: %d", Integer.valueOf(((View) this.obt.getParent()).getHeight()), Integer.valueOf(i)));
            abs = height;
        } else {
            abs = Math.abs(i - this.obs);
        }
        if (abs > 0) {
            this.obs = i;
            if (abs == this.baJ) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format(Locale.CHINA, "On global layout change get keyboard height just equal statusBar height %d", Integer.valueOf(abs)));
            } else if (d.N(getContext(), abs) && this.obu.getHeight() != (bk = d.bk(getContext()))) {
                this.obu.dL(bk);
            }
        }
    }

    private void OF(int i) {
        boolean z;
        boolean z2 = true;
        View view = (View) this.obt.getParent();
        int height = view.getHeight() - view.getPaddingTop();
        if (a.l(this.isFullScreen, this.obv, this.obw)) {
            if (!this.obv && height - i == this.baJ) {
                z = this.oby;
            } else {
                z = height > i;
            }
        } else {
            int i2 = this.obt.getResources().getDisplayMetrics().heightPixels;
            if (!this.obv && i2 == height) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format("skip the keyboard status calculate, the current activity is paused. and phone-display-height %d, root-height+actionbar-height %d", Integer.valueOf(i2), Integer.valueOf(height)));
                return;
            }
            if (this.baH == 0) {
                z2 = this.oby;
            } else if ((this.baH - this.obx) - i <= 100) {
                z2 = false;
            }
            this.baH = Math.max(this.baH, height);
            z = z2;
        }
        if (this.oby != z) {
            this.obu.wr(z);
            if (this.obz != null) {
                this.obz.wr(z);
            }
        }
        this.oby = z;
    }

    private Context getContext() {
        return this.obt.getContext();
    }
}
