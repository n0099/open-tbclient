package i.a.a.e.n;

import android.content.res.Resources;
import android.util.TypedValue;
/* loaded from: classes8.dex */
public class b {
    public static int a(float f2) {
        return (int) TypedValue.applyDimension(1, f2, Resources.getSystem().getDisplayMetrics());
    }
}
