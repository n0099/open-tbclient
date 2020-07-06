package tv.chushou.zues.widget.kpswitch.a;

import android.view.View;
import tv.chushou.zues.widget.kpswitch.b.d;
/* loaded from: classes5.dex */
public class a {
    private final View omZ;
    private boolean ona;
    private View onb;

    public a(View view) {
        this.omZ = view;
    }

    public void wY(boolean z) {
        this.ona = z;
        if (!z && this.omZ.getVisibility() == 4) {
            this.omZ.setVisibility(8);
        }
        if (!z && this.onb != null) {
            dXh();
            this.onb = null;
        }
    }

    private void dXh() {
        this.omZ.setVisibility(4);
        d.dE(this.onb);
    }
}
