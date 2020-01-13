package tv.chushou.zues.widget.kpswitch.a;

import android.view.View;
import tv.chushou.zues.widget.kpswitch.b.d;
/* loaded from: classes4.dex */
public class a {
    private final View nYk;
    private boolean nYl;
    private View nYm;

    public a(View view) {
        this.nYk = view;
    }

    public void wf(boolean z) {
        this.nYl = z;
        if (!z && this.nYk.getVisibility() == 4) {
            this.nYk.setVisibility(8);
        }
        if (!z && this.nYm != null) {
            dPy();
            this.nYm = null;
        }
    }

    private void dPy() {
        this.nYk.setVisibility(4);
        d.dJ(this.nYm);
    }
}
