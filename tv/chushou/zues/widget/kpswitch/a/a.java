package tv.chushou.zues.widget.kpswitch.a;

import android.view.View;
import tv.chushou.zues.widget.kpswitch.b.d;
/* loaded from: classes5.dex */
public class a {
    private final View obd;
    private boolean obe;
    private View obf;

    public a(View view) {
        this.obd = view;
    }

    public void wr(boolean z) {
        this.obe = z;
        if (!z && this.obd.getVisibility() == 4) {
            this.obd.setVisibility(8);
        }
        if (!z && this.obf != null) {
            dRq();
            this.obf = null;
        }
    }

    private void dRq() {
        this.obd.setVisibility(4);
        d.dL(this.obf);
    }
}
