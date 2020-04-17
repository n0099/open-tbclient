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
    private final int byX;
    private final boolean isFullScreen;
    private int nvp = 0;
    private final ViewGroup nvq;
    private final tv.chushou.zues.widget.kpswitch.b nvr;
    private final boolean nvs;
    private final boolean nvt;
    private int nvu;
    private boolean nvv;
    private final d.a nvw;
    private int nvx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, tv.chushou.zues.widget.kpswitch.b bVar, d.a aVar) {
        this.nvq = viewGroup;
        this.nvr = bVar;
        this.isFullScreen = z;
        this.nvs = z2;
        this.nvt = z3;
        this.byX = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(viewGroup.getContext());
        if (viewGroup.getContext() instanceof Activity) {
            this.nvu = tv.chushou.zues.utils.systemBar.b.ax((Activity) viewGroup.getContext());
        } else {
            this.nvu = tv.chushou.zues.utils.systemBar.b.gl(viewGroup.getContext());
        }
        this.nvw = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        View childAt = this.nvq.getChildAt(0);
        View view = (View) this.nvq.getParent();
        Rect rect = new Rect();
        if (this.nvs) {
            view.getWindowVisibleDisplayFrame(rect);
            i = (rect.bottom - rect.top) + this.byX + this.nvu;
        } else {
            childAt.getWindowVisibleDisplayFrame(rect);
            i = rect.bottom - rect.top;
        }
        if (this.nvp != i) {
            Kb(i);
            Kc(i);
            this.nvp = i;
        }
    }

    private void Kb(int i) {
        int abs;
        int gu;
        if (this.nvp == 0) {
            this.nvp = i;
            this.nvr.JZ(d.gu(getContext()));
            return;
        }
        if (a.l(this.isFullScreen, this.nvs, this.nvt)) {
            int height = ((View) this.nvq.getParent()).getHeight() - i;
            tv.chushou.zues.utils.e.d("KeyboardStatusListener", String.format(Locale.CHINA, "action bar over layout %d display height: %d", Integer.valueOf(((View) this.nvq.getParent()).getHeight()), Integer.valueOf(i)));
            abs = height;
        } else {
            abs = Math.abs(i - this.nvp);
        }
        if (abs > 0) {
            this.nvp = i;
            if (abs == this.byX) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format(Locale.CHINA, "On global layout change get keyboard height just equal statusBar height %d", Integer.valueOf(abs)));
            } else if (d.I(getContext(), abs) && this.nvr.getHeight() != (gu = d.gu(getContext()))) {
                this.nvr.JZ(gu);
            }
        }
    }

    private void Kc(int i) {
        boolean z;
        boolean z2 = true;
        View view = (View) this.nvq.getParent();
        int height = view.getHeight() - view.getPaddingTop();
        if (a.l(this.isFullScreen, this.nvs, this.nvt)) {
            if (!this.nvs && height - i == this.byX) {
                z = this.nvv;
            } else {
                z = height > i;
            }
        } else {
            int i2 = this.nvq.getResources().getDisplayMetrics().heightPixels;
            if (!this.nvs && i2 == height) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format("skip the keyboard status calculate, the current activity is paused. and phone-display-height %d, root-height+actionbar-height %d", Integer.valueOf(i2), Integer.valueOf(height)));
                return;
            }
            if (this.nvx == 0) {
                z2 = this.nvv;
            } else if ((this.nvx - this.nvu) - i <= 100) {
                z2 = false;
            }
            this.nvx = Math.max(this.nvx, height);
            z = z2;
        }
        if (this.nvv != z) {
            this.nvr.wc(z);
            if (this.nvw != null) {
                this.nvw.wc(z);
            }
        }
        this.nvv = z;
    }

    private Context getContext() {
        return this.nvq.getContext();
    }
}
