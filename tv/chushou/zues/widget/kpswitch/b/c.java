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
    private final int bLP;
    private final boolean isFullScreen;
    private int ovV = 0;
    private final ViewGroup ovW;
    private final tv.chushou.zues.widget.kpswitch.b ovX;
    private final boolean ovY;
    private final boolean ovZ;
    private int owa;
    private boolean owb;
    private final d.a owc;
    private int owd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, tv.chushou.zues.widget.kpswitch.b bVar, d.a aVar) {
        this.ovW = viewGroup;
        this.ovX = bVar;
        this.isFullScreen = z;
        this.ovY = z2;
        this.ovZ = z3;
        this.bLP = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(viewGroup.getContext());
        if (viewGroup.getContext() instanceof Activity) {
            this.owa = tv.chushou.zues.utils.systemBar.b.ax((Activity) viewGroup.getContext());
        } else {
            this.owa = tv.chushou.zues.utils.systemBar.b.gI(viewGroup.getContext());
        }
        this.owc = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        View childAt = this.ovW.getChildAt(0);
        View view = (View) this.ovW.getParent();
        Rect rect = new Rect();
        if (this.ovY) {
            view.getWindowVisibleDisplayFrame(rect);
            i = (rect.bottom - rect.top) + this.bLP + this.owa;
        } else {
            childAt.getWindowVisibleDisplayFrame(rect);
            i = rect.bottom - rect.top;
        }
        if (this.ovV != i) {
            Mo(i);
            Mp(i);
            this.ovV = i;
        }
    }

    private void Mo(int i) {
        int abs;
        int gR;
        if (this.ovV == 0) {
            this.ovV = i;
            this.ovX.Mm(d.gR(getContext()));
            return;
        }
        if (a.l(this.isFullScreen, this.ovY, this.ovZ)) {
            int height = ((View) this.ovW.getParent()).getHeight() - i;
            tv.chushou.zues.utils.e.d("KeyboardStatusListener", String.format(Locale.CHINA, "action bar over layout %d display height: %d", Integer.valueOf(((View) this.ovW.getParent()).getHeight()), Integer.valueOf(i)));
            abs = height;
        } else {
            abs = Math.abs(i - this.ovV);
        }
        if (abs > 0) {
            this.ovV = i;
            if (abs == this.bLP) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format(Locale.CHINA, "On global layout change get keyboard height just equal statusBar height %d", Integer.valueOf(abs)));
            } else if (d.I(getContext(), abs) && this.ovX.getHeight() != (gR = d.gR(getContext()))) {
                this.ovX.Mm(gR);
            }
        }
    }

    private void Mp(int i) {
        boolean z;
        boolean z2 = true;
        View view = (View) this.ovW.getParent();
        int height = view.getHeight() - view.getPaddingTop();
        if (a.l(this.isFullScreen, this.ovY, this.ovZ)) {
            if (!this.ovY && height - i == this.bLP) {
                z = this.owb;
            } else {
                z = height > i;
            }
        } else {
            int i2 = this.ovW.getResources().getDisplayMetrics().heightPixels;
            if (!this.ovY && i2 == height) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format("skip the keyboard status calculate, the current activity is paused. and phone-display-height %d, root-height+actionbar-height %d", Integer.valueOf(i2), Integer.valueOf(height)));
                return;
            }
            if (this.owd == 0) {
                z2 = this.owb;
            } else if ((this.owd - this.owa) - i <= 100) {
                z2 = false;
            }
            this.owd = Math.max(this.owd, height);
            z = z2;
        }
        if (this.owb != z) {
            this.ovX.xD(z);
            if (this.owc != null) {
                this.owc.xD(z);
            }
        }
        this.owb = z;
    }

    private Context getContext() {
        return this.ovW.getContext();
    }
}
