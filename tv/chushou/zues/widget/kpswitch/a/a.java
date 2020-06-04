package tv.chushou.zues.widget.kpswitch.a;

import android.view.View;
import tv.chushou.zues.widget.kpswitch.b.d;
/* loaded from: classes5.dex */
public class a {
    private final View nRi;
    private boolean nRj;
    private View nRk;

    public a(View view) {
        this.nRi = view;
    }

    public void wC(boolean z) {
        this.nRj = z;
        if (!z && this.nRi.getVisibility() == 4) {
            this.nRi.setVisibility(8);
        }
        if (!z && this.nRk != null) {
            dSx();
            this.nRk = null;
        }
    }

    private void dSx() {
        this.nRi.setVisibility(4);
        d.dD(this.nRk);
    }
}
