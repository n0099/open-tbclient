package tv.chushou.zues.widget.kpswitch.a;

import android.view.View;
import tv.chushou.zues.widget.kpswitch.b.d;
/* loaded from: classes5.dex */
public class a {
    private final View nPY;
    private boolean nPZ;
    private View nQa;

    public a(View view) {
        this.nPY = view;
    }

    public void wA(boolean z) {
        this.nPZ = z;
        if (!z && this.nPY.getVisibility() == 4) {
            this.nPY.setVisibility(8);
        }
        if (!z && this.nQa != null) {
            dSj();
            this.nQa = null;
        }
    }

    private void dSj() {
        this.nPY.setVisibility(4);
        d.dD(this.nQa);
    }
}
