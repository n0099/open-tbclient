package tv.chushou.zues.widget.kpswitch.a;

import android.view.View;
import tv.chushou.zues.widget.kpswitch.b.d;
/* loaded from: classes6.dex */
public class a {
    private final View fjj;
    private boolean fjk;
    private View fjl;

    public a(View view) {
        this.fjj = view;
    }

    public void jX(boolean z) {
        this.fjk = z;
        if (!z && this.fjj.getVisibility() == 4) {
            this.fjj.setVisibility(8);
        }
        if (!z && this.fjl != null) {
            bxy();
            this.fjl = null;
        }
    }

    private void bxy() {
        this.fjj.setVisibility(4);
        d.bz(this.fjl);
    }
}
