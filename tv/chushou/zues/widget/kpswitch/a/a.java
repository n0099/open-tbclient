package tv.chushou.zues.widget.kpswitch.a;

import android.view.View;
import tv.chushou.zues.widget.kpswitch.b.d;
/* loaded from: classes5.dex */
public class a {
    private final View nZf;
    private boolean nZg;
    private View nZh;

    public a(View view) {
        this.nZf = view;
    }

    public void wj(boolean z) {
        this.nZg = z;
        if (!z && this.nZf.getVisibility() == 4) {
            this.nZf.setVisibility(8);
        }
        if (!z && this.nZh != null) {
            dQP();
            this.nZh = null;
        }
    }

    private void dQP() {
        this.nZf.setVisibility(4);
        d.dL(this.nZh);
    }
}
