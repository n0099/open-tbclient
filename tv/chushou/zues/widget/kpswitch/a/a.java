package tv.chushou.zues.widget.kpswitch.a;

import android.view.View;
import tv.chushou.zues.widget.kpswitch.b.d;
/* loaded from: classes6.dex */
public class a {
    private final View foi;
    private boolean foj;
    private View fok;

    public a(View view) {
        this.foi = view;
    }

    public void kh(boolean z) {
        this.foj = z;
        if (!z && this.foi.getVisibility() == 4) {
            this.foi.setVisibility(8);
        }
        if (!z && this.fok != null) {
            bzn();
            this.fok = null;
        }
    }

    private void bzn() {
        this.foi.setVisibility(4);
        d.bG(this.fok);
    }
}
