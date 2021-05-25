package d.a.m0.d0;

import android.view.View;
import android.widget.LinearLayout;
/* loaded from: classes3.dex */
public class f implements d {
    @Override // d.a.m0.d0.d
    public void a(View view, View view2, boolean z) {
        LinearLayout linearLayout = (LinearLayout) view;
        if (z) {
            linearLayout.addView(view2, 0);
        } else {
            linearLayout.addView(view2);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view2.getLayoutParams();
        layoutParams.gravity = 1;
        view2.setLayoutParams(layoutParams);
    }
}
