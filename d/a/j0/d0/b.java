package d.a.j0.d0;

import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class b implements d {
    @Override // d.a.j0.d0.d
    public void a(View view, View view2, boolean z) {
        FrameLayout frameLayout = (FrameLayout) view;
        if (z) {
            frameLayout.addView(view2, 0);
        } else {
            frameLayout.addView(view2);
        }
    }
}
