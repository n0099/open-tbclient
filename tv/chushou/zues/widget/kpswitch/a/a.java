package tv.chushou.zues.widget.kpswitch.a;

import android.view.View;
import tv.chushou.zues.widget.kpswitch.b.d;
/* loaded from: classes5.dex */
public class a {
    private final View nZq;
    private boolean nZr;
    private View nZs;

    public a(View view) {
        this.nZq = view;
    }

    public void wj(boolean z) {
        this.nZr = z;
        if (!z && this.nZq.getVisibility() == 4) {
            this.nZq.setVisibility(8);
        }
        if (!z && this.nZs != null) {
            dQQ();
            this.nZs = null;
        }
    }

    private void dQQ() {
        this.nZq.setVisibility(4);
        d.dL(this.nZs);
    }
}
