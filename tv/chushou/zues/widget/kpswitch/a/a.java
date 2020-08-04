package tv.chushou.zues.widget.kpswitch.a;

import android.view.View;
import tv.chushou.zues.widget.kpswitch.b.d;
/* loaded from: classes6.dex */
public class a {
    private final View ovH;
    private boolean ovI;
    private View ovJ;

    public a(View view) {
        this.ovH = view;
    }

    public void xD(boolean z) {
        this.ovI = z;
        if (!z && this.ovH.getVisibility() == 4) {
            this.ovH.setVisibility(8);
        }
        if (!z && this.ovJ != null) {
            eaE();
            this.ovJ = null;
        }
    }

    private void eaE() {
        this.ovH.setVisibility(4);
        d.dK(this.ovJ);
    }
}
