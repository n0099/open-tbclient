package tv.chushou.zues.widget.kpswitch.a;

import android.view.View;
import tv.chushou.zues.widget.kpswitch.b.d;
/* loaded from: classes6.dex */
public class a {
    private final View oPQ;
    private boolean oPR;
    private View oPS;

    public a(View view) {
        this.oPQ = view;
    }

    public void yw(boolean z) {
        this.oPR = z;
        if (!z && this.oPQ.getVisibility() == 4) {
            this.oPQ.setVisibility(8);
        }
        if (!z && this.oPS != null) {
            emQ();
            this.oPS = null;
        }
    }

    private void emQ() {
        this.oPQ.setVisibility(4);
        d.dM(this.oPS);
    }
}
