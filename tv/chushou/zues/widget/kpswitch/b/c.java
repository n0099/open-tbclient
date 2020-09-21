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
    private final int bTp;
    private int eOQ = 0;
    private final ViewGroup eOR;
    private final boolean eOT;
    private final boolean eOU;
    private boolean eOV;
    private int eOY;
    private final boolean isFullScreen;
    private final tv.chushou.zues.widget.kpswitch.b oZB;
    private int oZC;
    private final d.a oZD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, tv.chushou.zues.widget.kpswitch.b bVar, d.a aVar) {
        this.eOR = viewGroup;
        this.oZB = bVar;
        this.isFullScreen = z;
        this.eOT = z2;
        this.eOU = z3;
        this.bTp = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(viewGroup.getContext());
        if (viewGroup.getContext() instanceof Activity) {
            this.oZC = tv.chushou.zues.utils.systemBar.b.aC((Activity) viewGroup.getContext());
        } else {
            this.oZC = tv.chushou.zues.utils.systemBar.b.hg(viewGroup.getContext());
        }
        this.oZD = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        View childAt = this.eOR.getChildAt(0);
        View view = (View) this.eOR.getParent();
        Rect rect = new Rect();
        if (this.eOT) {
            view.getWindowVisibleDisplayFrame(rect);
            i = (rect.bottom - rect.top) + this.bTp + this.oZC;
        } else {
            childAt.getWindowVisibleDisplayFrame(rect);
            i = rect.bottom - rect.top;
        }
        if (this.eOQ != i) {
            qz(i);
            qA(i);
            this.eOQ = i;
        }
    }

    private void qz(int i) {
        int abs;
        int ee;
        if (this.eOQ == 0) {
            this.eOQ = i;
            this.oZB.qx(d.ee(getContext()));
            return;
        }
        if (a.f(this.isFullScreen, this.eOT, this.eOU)) {
            int height = ((View) this.eOR.getParent()).getHeight() - i;
            tv.chushou.zues.utils.e.d("KeyboardStatusListener", String.format(Locale.CHINA, "action bar over layout %d display height: %d", Integer.valueOf(((View) this.eOR.getParent()).getHeight()), Integer.valueOf(i)));
            abs = height;
        } else {
            abs = Math.abs(i - this.eOQ);
        }
        if (abs > 0) {
            this.eOQ = i;
            if (abs == this.bTp) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format(Locale.CHINA, "On global layout change get keyboard height just equal statusBar height %d", Integer.valueOf(abs)));
            } else if (d.y(getContext(), abs) && this.oZB.getHeight() != (ee = d.ee(getContext()))) {
                this.oZB.qx(ee);
            }
        }
    }

    private void qA(int i) {
        boolean z;
        boolean z2 = true;
        View view = (View) this.eOR.getParent();
        int height = view.getHeight() - view.getPaddingTop();
        if (a.f(this.isFullScreen, this.eOT, this.eOU)) {
            if (!this.eOT && height - i == this.bTp) {
                z = this.eOV;
            } else {
                z = height > i;
            }
        } else {
            int i2 = this.eOR.getResources().getDisplayMetrics().heightPixels;
            if (!this.eOT && i2 == height) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format("skip the keyboard status calculate, the current activity is paused. and phone-display-height %d, root-height+actionbar-height %d", Integer.valueOf(i2), Integer.valueOf(height)));
                return;
            }
            if (this.eOY == 0) {
                z2 = this.eOV;
            } else if ((this.eOY - this.oZC) - i <= 100) {
                z2 = false;
            }
            this.eOY = Math.max(this.eOY, height);
            z = z2;
        }
        if (this.eOV != z) {
            this.oZB.jm(z);
            if (this.oZD != null) {
                this.oZD.jm(z);
            }
        }
        this.eOV = z;
    }

    private Context getContext() {
        return this.eOR.getContext();
    }
}
