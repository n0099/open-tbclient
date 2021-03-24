package d.b.g0.m.a.d;

import android.graphics.Paint;
import android.view.View;
/* loaded from: classes3.dex */
public class g {
    public static int a(View view) {
        return view.getLayerType();
    }

    public static void b(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public static void c(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }
}
