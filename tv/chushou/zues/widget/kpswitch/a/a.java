package tv.chushou.zues.widget.kpswitch.a;

import android.view.View;
import tv.chushou.zues.widget.kpswitch.b.d;
/* loaded from: classes5.dex */
public class a {
    private final View nvc;
    private boolean nvd;
    private View nve;

    public a(View view) {
        this.nvc = view;
    }

    public void wc(boolean z) {
        this.nvd = z;
        if (!z && this.nvc.getVisibility() == 4) {
            this.nvc.setVisibility(8);
        }
        if (!z && this.nve != null) {
            dKp();
            this.nve = null;
        }
    }

    private void dKp() {
        this.nvc.setVisibility(4);
        d.dC(this.nve);
    }
}
