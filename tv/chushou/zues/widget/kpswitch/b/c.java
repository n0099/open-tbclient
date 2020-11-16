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
    private final int cso;
    private boolean foA;
    private int foD;
    private int fov = 0;
    private final ViewGroup fow;
    private final boolean foy;
    private final boolean foz;
    private final boolean isFullScreen;
    private final tv.chushou.zues.widget.kpswitch.b qrh;
    private int qri;
    private final d.a qrj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, tv.chushou.zues.widget.kpswitch.b bVar, d.a aVar) {
        this.fow = viewGroup;
        this.qrh = bVar;
        this.isFullScreen = z;
        this.foy = z2;
        this.foz = z3;
        this.cso = tv.chushou.zues.utils.systemBar.b.getStatusBarHeight(viewGroup.getContext());
        if (viewGroup.getContext() instanceof Activity) {
            this.qri = tv.chushou.zues.utils.systemBar.b.aH((Activity) viewGroup.getContext());
        } else {
            this.qri = tv.chushou.zues.utils.systemBar.b.hF(viewGroup.getContext());
        }
        this.qrj = aVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        int i;
        View childAt = this.fow.getChildAt(0);
        View view = (View) this.fow.getParent();
        Rect rect = new Rect();
        if (this.foy) {
            view.getWindowVisibleDisplayFrame(rect);
            i = (rect.bottom - rect.top) + this.cso + this.qri;
        } else {
            childAt.getWindowVisibleDisplayFrame(rect);
            i = rect.bottom - rect.top;
        }
        if (this.fov != i) {
            rQ(i);
            rR(i);
            this.fov = i;
        }
    }

    private void rQ(int i) {
        int abs;
        int el;
        if (this.fov == 0) {
            this.fov = i;
            this.qrh.rO(d.el(getContext()));
            return;
        }
        if (a.f(this.isFullScreen, this.foy, this.foz)) {
            int height = ((View) this.fow.getParent()).getHeight() - i;
            tv.chushou.zues.utils.e.d("KeyboardStatusListener", String.format(Locale.CHINA, "action bar over layout %d display height: %d", Integer.valueOf(((View) this.fow.getParent()).getHeight()), Integer.valueOf(i)));
            abs = height;
        } else {
            abs = Math.abs(i - this.fov);
        }
        if (abs > 0) {
            this.fov = i;
            if (abs == this.cso) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format(Locale.CHINA, "On global layout change get keyboard height just equal statusBar height %d", Integer.valueOf(abs)));
            } else if (d.y(getContext(), abs) && this.qrh.getHeight() != (el = d.el(getContext()))) {
                this.qrh.rO(el);
            }
        }
    }

    private void rR(int i) {
        boolean z;
        boolean z2 = true;
        View view = (View) this.fow.getParent();
        int height = view.getHeight() - view.getPaddingTop();
        if (a.f(this.isFullScreen, this.foy, this.foz)) {
            if (!this.foy && height - i == this.cso) {
                z = this.foA;
            } else {
                z = height > i;
            }
        } else {
            int i2 = this.fow.getResources().getDisplayMetrics().heightPixels;
            if (!this.foy && i2 == height) {
                tv.chushou.zues.utils.e.w("KeyboardStatusListener", String.format("skip the keyboard status calculate, the current activity is paused. and phone-display-height %d, root-height+actionbar-height %d", Integer.valueOf(i2), Integer.valueOf(height)));
                return;
            }
            if (this.foD == 0) {
                z2 = this.foA;
            } else if ((this.foD - this.qri) - i <= 100) {
                z2 = false;
            }
            this.foD = Math.max(this.foD, height);
            z = z2;
        }
        if (this.foA != z) {
            this.qrh.kh(z);
            if (this.qrj != null) {
                this.qrj.kh(z);
            }
        }
        this.foA = z;
    }

    private Context getContext() {
        return this.fow.getContext();
    }
}
