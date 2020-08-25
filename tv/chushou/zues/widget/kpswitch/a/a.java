package tv.chushou.zues.widget.kpswitch.a;

import android.view.View;
import tv.chushou.zues.widget.kpswitch.b.d;
/* loaded from: classes6.dex */
public class a {
    private View oPA;
    private final View oPy;
    private boolean oPz;

    public a(View view) {
        this.oPy = view;
    }

    public void yu(boolean z) {
        this.oPz = z;
        if (!z && this.oPy.getVisibility() == 4) {
            this.oPy.setVisibility(8);
        }
        if (!z && this.oPA != null) {
            emH();
            this.oPA = null;
        }
    }

    private void emH() {
        this.oPy.setVisibility(4);
        d.dM(this.oPA);
    }
}
