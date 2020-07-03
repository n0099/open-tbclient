package tv.chushou.zues.widget.kpswitch.a;

import android.view.View;
import tv.chushou.zues.widget.kpswitch.b.d;
/* loaded from: classes5.dex */
public class a {
    private final View omW;
    private boolean omX;
    private View omY;

    public a(View view) {
        this.omW = view;
    }

    public void wY(boolean z) {
        this.omX = z;
        if (!z && this.omW.getVisibility() == 4) {
            this.omW.setVisibility(8);
        }
        if (!z && this.omY != null) {
            dXd();
            this.omY = null;
        }
    }

    private void dXd() {
        this.omW.setVisibility(4);
        d.dE(this.omY);
    }
}
