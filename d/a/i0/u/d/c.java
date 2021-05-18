package d.a.i0.u.d;

import android.content.Context;
import android.os.Build;
/* loaded from: classes3.dex */
public class c {
    public static boolean a(Context context, String str) {
        return Build.VERSION.SDK_INT < 23 || context.checkSelfPermission(str) == 0;
    }
}
