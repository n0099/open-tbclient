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
    private int ovX = 0;
    private final ViewGroup ovY;
    private final tv.chushou.zues.widget.kpswitch.b ovZ;
    private final boolean owa;
    private final boolean owb;
    private int owc;
    private boolean owd;
    private final d.a owe;
    private int owf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, tv.chushou.zues.widget.kpswitch.b bVar, d.a aVar) {
        this.ovY = viewGroup;
        this.ovZ = bVar;
        this.isFullScreen = z;
        this.owa = z2;
        this.owb = z3;
        this.bLP = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(viewGroup.getContext());
        if (viewGroup.getContext() instanceof Activity) {
            this.owc = tv.chushou.zues.utils.systemBar.b.ax((Activity) viewGroup.getContext());
        } else {
            this.owc = tv.chushou.zues.utils.systemBar.b.gI(viewGroup.getContext());
        }
        this.owe = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        View childAt = this.ovY.getChildAt(0);
        View view = (View) this.ovY.getParent();
        Rect rect = new Rect();
        if (this.owa) {
            view.getWindowVisibleDisplayFrame(rect);
            i = (rect.bottom - rect.top) + this.bLP + this.owc;
        } else {
            childAt.getWindowVisibleDisplayFrame(rect);
            i = rect.bottom - rect.top;
        }
        if (this.ovX != i) {
            Mo(i);
            Mp(i);
            this.ovX = i;
        }
    }

    private void Mo(int i) {
        int abs;
        int gR;
        if (this.ovX == 0) {
            this.ovX = i;
            this.ovZ.Mm(d.gR(getContext()));
            return;
        }
        if (a.l(this.isFullScreen, this.owa, this.owb)) {
            int height = ((View) this.ovY.getParent()).getHeight() - i;
            tv.chushou.zues.utils.e.d("KeyboardStatusListener", String.format(Locale.CHINA, "action bar over layout %d display height: %d", Integer.valueOf(((View) this.ovY.getParent()).getHeight()), Integer.valueOf(i)));
            abs = height;
        } else {
            abs = Math.abs(i - this.ovX);
        }
        if (abs > 0) {
            this.ovX = i;
            if (abs == this.bLP) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format(Locale.CHINA, "On global layout change get keyboard height just equal statusBar height %d", Integer.valueOf(abs)));
            } else if (d.I(getContext(), abs) && this.ovZ.getHeight() != (gR = d.gR(getContext()))) {
                this.ovZ.Mm(gR);
            }
        }
    }

    private void Mp(int i) {
        boolean z;
        boolean z2 = true;
        View view = (View) this.ovY.getParent();
        int height = view.getHeight() - view.getPaddingTop();
        if (a.l(this.isFullScreen, this.owa, this.owb)) {
            if (!this.owa && height - i == this.bLP) {
                z = this.owd;
            } else {
                z = height > i;
            }
        } else {
            int i2 = this.ovY.getResources().getDisplayMetrics().heightPixels;
            if (!this.owa && i2 == height) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format("skip the keyboard status calculate, the current activity is paused. and phone-display-height %d, root-height+actionbar-height %d", Integer.valueOf(i2), Integer.valueOf(height)));
                return;
            }
            if (this.owf == 0) {
                z2 = this.owd;
            } else if ((this.owf - this.owc) - i <= 100) {
                z2 = false;
            }
            this.owf = Math.max(this.owf, height);
            z = z2;
        }
        if (this.owd != z) {
            this.ovZ.xD(z);
            if (this.owe != null) {
                this.owe.xD(z);
            }
        }
        this.owd = z;
    }

    private Context getContext() {
        return this.ovY.getContext();
    }
}
