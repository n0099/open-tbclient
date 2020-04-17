package tv.chushou.zues.widget.kpswitch.a;

import android.view.View;
import tv.chushou.zues.widget.kpswitch.b.d;
/* loaded from: classes5.dex */
public class a {
    private final View nuZ;
    private boolean nva;
    private View nvb;

    public a(View view) {
        this.nuZ = view;
    }

    public void wc(boolean z) {
        this.nva = z;
        if (!z && this.nuZ.getVisibility() == 4) {
            this.nuZ.setVisibility(8);
        }
        if (!z && this.nvb != null) {
            dKs();
            this.nvb = null;
        }
    }

    private void dKs() {
        this.nuZ.setVisibility(4);
        d.dC(this.nvb);
    }
}
