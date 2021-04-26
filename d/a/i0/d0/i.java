package d.a.i0.d0;

import android.view.View;
import android.widget.RelativeLayout;
/* loaded from: classes3.dex */
public class i implements d {
    @Override // d.a.i0.d0.d
    public void a(View view, View view2, boolean z) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        if (z) {
            relativeLayout.addView(view2, 0);
        } else {
            relativeLayout.addView(view2);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view2.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.addRule(14);
        view2.setLayoutParams(layoutParams);
    }
}
