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
    private final int bzc;
    private final boolean isFullScreen;
    private int nvA;
    private int nvs = 0;
    private final ViewGroup nvt;
    private final tv.chushou.zues.widget.kpswitch.b nvu;
    private final boolean nvv;
    private final boolean nvw;
    private int nvx;
    private boolean nvy;
    private final d.a nvz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, tv.chushou.zues.widget.kpswitch.b bVar, d.a aVar) {
        this.nvt = viewGroup;
        this.nvu = bVar;
        this.isFullScreen = z;
        this.nvv = z2;
        this.nvw = z3;
        this.bzc = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(viewGroup.getContext());
        if (viewGroup.getContext() instanceof Activity) {
            this.nvx = tv.chushou.zues.utils.systemBar.b.ax((Activity) viewGroup.getContext());
        } else {
            this.nvx = tv.chushou.zues.utils.systemBar.b.fY(viewGroup.getContext());
        }
        this.nvz = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        View childAt = this.nvt.getChildAt(0);
        View view = (View) this.nvt.getParent();
        Rect rect = new Rect();
        if (this.nvv) {
            view.getWindowVisibleDisplayFrame(rect);
            i = (rect.bottom - rect.top) + this.bzc + this.nvx;
        } else {
            childAt.getWindowVisibleDisplayFrame(rect);
            i = rect.bottom - rect.top;
        }
        if (this.nvs != i) {
            Kb(i);
            Kc(i);
            this.nvs = i;
        }
    }

    private void Kb(int i) {
        int abs;
        int gi;
        if (this.nvs == 0) {
            this.nvs = i;
            this.nvu.JZ(d.gi(getContext()));
            return;
        }
        if (a.l(this.isFullScreen, this.nvv, this.nvw)) {
            int height = ((View) this.nvt.getParent()).getHeight() - i;
            tv.chushou.zues.utils.e.d("KeyboardStatusListener", String.format(Locale.CHINA, "action bar over layout %d display height: %d", Integer.valueOf(((View) this.nvt.getParent()).getHeight()), Integer.valueOf(i)));
            abs = height;
        } else {
            abs = Math.abs(i - this.nvs);
        }
        if (abs > 0) {
            this.nvs = i;
            if (abs == this.bzc) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format(Locale.CHINA, "On global layout change get keyboard height just equal statusBar height %d", Integer.valueOf(abs)));
            } else if (d.I(getContext(), abs) && this.nvu.getHeight() != (gi = d.gi(getContext()))) {
                this.nvu.JZ(gi);
            }
        }
    }

    private void Kc(int i) {
        boolean z;
        boolean z2 = true;
        View view = (View) this.nvt.getParent();
        int height = view.getHeight() - view.getPaddingTop();
        if (a.l(this.isFullScreen, this.nvv, this.nvw)) {
            if (!this.nvv && height - i == this.bzc) {
                z = this.nvy;
            } else {
                z = height > i;
            }
        } else {
            int i2 = this.nvt.getResources().getDisplayMetrics().heightPixels;
            if (!this.nvv && i2 == height) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format("skip the keyboard status calculate, the current activity is paused. and phone-display-height %d, root-height+actionbar-height %d", Integer.valueOf(i2), Integer.valueOf(height)));
                return;
            }
            if (this.nvA == 0) {
                z2 = this.nvy;
            } else if ((this.nvA - this.nvx) - i <= 100) {
                z2 = false;
            }
            this.nvA = Math.max(this.nvA, height);
            z = z2;
        }
        if (this.nvy != z) {
            this.nvu.wc(z);
            if (this.nvz != null) {
                this.nvz.wc(z);
            }
        }
        this.nvy = z;
    }

    private Context getContext() {
        return this.nvt.getContext();
    }
}
