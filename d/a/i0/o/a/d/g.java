package d.a.i0.o.a.d;

import android.graphics.Paint;
import android.view.View;
/* loaded from: classes3.dex */
public class g {
    public static int a(View view) {
        return view.getLayerType();
    }

    public static void b(View view, int i2, Paint paint) {
        view.setLayerType(i2, paint);
    }

    public static void c(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }
}
