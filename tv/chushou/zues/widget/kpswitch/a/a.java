package tv.chushou.zues.widget.kpswitch.a;

import android.view.View;
import tv.chushou.zues.widget.kpswitch.b.d;
/* loaded from: classes6.dex */
public class a {
    private final View faK;
    private boolean faL;
    private View faM;

    public a(View view) {
        this.faK = view;
    }

    public void jK(boolean z) {
        this.faL = z;
        if (!z && this.faK.getVisibility() == 4) {
            this.faK.setVisibility(8);
        }
        if (!z && this.faM != null) {
            bvF();
            this.faM = null;
        }
    }

    private void bvF() {
        this.faK.setVisibility(4);
        d.by(this.faM);
    }
}
