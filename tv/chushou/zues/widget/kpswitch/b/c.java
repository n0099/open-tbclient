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
    private final int bRl;
    private final boolean isFullScreen;
    private int oPO = 0;
    private final ViewGroup oPP;
    private final tv.chushou.zues.widget.kpswitch.b oPQ;
    private final boolean oPR;
    private final boolean oPS;
    private int oPT;
    private boolean oPU;
    private final d.a oPV;
    private int oPW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, tv.chushou.zues.widget.kpswitch.b bVar, d.a aVar) {
        this.oPP = viewGroup;
        this.oPQ = bVar;
        this.isFullScreen = z;
        this.oPR = z2;
        this.oPS = z3;
        this.bRl = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(viewGroup.getContext());
        if (viewGroup.getContext() instanceof Activity) {
            this.oPT = tv.chushou.zues.utils.systemBar.b.ay((Activity) viewGroup.getContext());
        } else {
            this.oPT = tv.chushou.zues.utils.systemBar.b.ha(viewGroup.getContext());
        }
        this.oPV = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        View childAt = this.oPP.getChildAt(0);
        View view = (View) this.oPP.getParent();
        Rect rect = new Rect();
        if (this.oPR) {
            view.getWindowVisibleDisplayFrame(rect);
            i = (rect.bottom - rect.top) + this.bRl + this.oPT;
        } else {
            childAt.getWindowVisibleDisplayFrame(rect);
            i = rect.bottom - rect.top;
        }
        if (this.oPO != i) {
            OR(i);
            OS(i);
            this.oPO = i;
        }
    }

    private void OR(int i) {
        int abs;
        int hj;
        if (this.oPO == 0) {
            this.oPO = i;
            this.oPQ.OP(d.hj(getContext()));
            return;
        }
        if (a.m(this.isFullScreen, this.oPR, this.oPS)) {
            int height = ((View) this.oPP.getParent()).getHeight() - i;
            tv.chushou.zues.utils.e.d("KeyboardStatusListener", String.format(Locale.CHINA, "action bar over layout %d display height: %d", Integer.valueOf(((View) this.oPP.getParent()).getHeight()), Integer.valueOf(i)));
            abs = height;
        } else {
            abs = Math.abs(i - this.oPO);
        }
        if (abs > 0) {
            this.oPO = i;
            if (abs == this.bRl) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format(Locale.CHINA, "On global layout change get keyboard height just equal statusBar height %d", Integer.valueOf(abs)));
            } else if (d.K(getContext(), abs) && this.oPQ.getHeight() != (hj = d.hj(getContext()))) {
                this.oPQ.OP(hj);
            }
        }
    }

    private void OS(int i) {
        boolean z;
        boolean z2 = true;
        View view = (View) this.oPP.getParent();
        int height = view.getHeight() - view.getPaddingTop();
        if (a.m(this.isFullScreen, this.oPR, this.oPS)) {
            if (!this.oPR && height - i == this.bRl) {
                z = this.oPU;
            } else {
                z = height > i;
            }
        } else {
            int i2 = this.oPP.getResources().getDisplayMetrics().heightPixels;
            if (!this.oPR && i2 == height) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format("skip the keyboard status calculate, the current activity is paused. and phone-display-height %d, root-height+actionbar-height %d", Integer.valueOf(i2), Integer.valueOf(height)));
                return;
            }
            if (this.oPW == 0) {
                z2 = this.oPU;
            } else if ((this.oPW - this.oPT) - i <= 100) {
                z2 = false;
            }
            this.oPW = Math.max(this.oPW, height);
            z = z2;
        }
        if (this.oPU != z) {
            this.oPQ.yu(z);
            if (this.oPV != null) {
                this.oPV.yu(z);
            }
        }
        this.oPU = z;
    }

    private Context getContext() {
        return this.oPP.getContext();
    }
}
