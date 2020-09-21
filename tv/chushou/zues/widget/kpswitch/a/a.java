package tv.chushou.zues.widget.kpswitch.a;

import android.view.View;
import tv.chushou.zues.widget.kpswitch.b.d;
/* loaded from: classes6.dex */
public class a {
    private final View eOD;
    private boolean eOE;
    private View eOF;

    public a(View view) {
        this.eOD = view;
    }

    public void jm(boolean z) {
        this.eOE = z;
        if (!z && this.eOD.getVisibility() == 4) {
            this.eOD.setVisibility(8);
        }
        if (!z && this.eOF != null) {
            bsV();
            this.eOF = null;
        }
    }

    private void bsV() {
        this.eOD.setVisibility(4);
        d.bu(this.eOF);
    }
}
