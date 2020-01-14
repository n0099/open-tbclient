package tv.chushou.zues.widget.kpswitch.a;

import android.view.View;
import tv.chushou.zues.widget.kpswitch.b.d;
/* loaded from: classes4.dex */
public class a {
    private final View nYp;
    private boolean nYq;
    private View nYr;

    public a(View view) {
        this.nYp = view;
    }

    public void wf(boolean z) {
        this.nYq = z;
        if (!z && this.nYp.getVisibility() == 4) {
            this.nYp.setVisibility(8);
        }
        if (!z && this.nYr != null) {
            dPA();
            this.nYr = null;
        }
    }

    private void dPA() {
        this.nYp.setVisibility(4);
        d.dJ(this.nYr);
    }
}
