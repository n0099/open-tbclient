package tv.chushou.zues.widget.kpswitch.a;

import android.view.View;
import tv.chushou.zues.widget.kpswitch.b.d;
/* loaded from: classes6.dex */
public class a {
    private final View ovF;
    private boolean ovG;
    private View ovH;

    public a(View view) {
        this.ovF = view;
    }

    public void xD(boolean z) {
        this.ovG = z;
        if (!z && this.ovF.getVisibility() == 4) {
            this.ovF.setVisibility(8);
        }
        if (!z && this.ovH != null) {
            eaD();
            this.ovH = null;
        }
    }

    private void eaD() {
        this.ovF.setVisibility(4);
        d.dK(this.ovH);
    }
}
