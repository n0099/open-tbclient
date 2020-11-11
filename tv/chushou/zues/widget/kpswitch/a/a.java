package tv.chushou.zues.widget.kpswitch.a;

import android.view.View;
import tv.chushou.zues.widget.kpswitch.b.d;
/* loaded from: classes6.dex */
public class a {
    private final View fpa;
    private boolean fpb;
    private View fpc;

    public a(View view) {
        this.fpa = view;
    }

    public void kg(boolean z) {
        this.fpb = z;
        if (!z && this.fpa.getVisibility() == 4) {
            this.fpa.setVisibility(8);
        }
        if (!z && this.fpc != null) {
            bzX();
            this.fpc = null;
        }
    }

    private void bzX() {
        this.fpa.setVisibility(4);
        d.bD(this.fpc);
    }
}
