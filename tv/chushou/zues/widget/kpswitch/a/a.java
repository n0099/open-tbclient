package tv.chushou.zues.widget.kpswitch.a;

import android.view.View;
import tv.chushou.zues.widget.kpswitch.b.d;
/* loaded from: classes5.dex */
public class a {
    private final View nZd;
    private boolean nZe;
    private View nZf;

    public a(View view) {
        this.nZd = view;
    }

    public void wj(boolean z) {
        this.nZe = z;
        if (!z && this.nZd.getVisibility() == 4) {
            this.nZd.setVisibility(8);
        }
        if (!z && this.nZf != null) {
            dQN();
            this.nZf = null;
        }
    }

    private void dQN() {
        this.nZd.setVisibility(4);
        d.dL(this.nZf);
    }
}
