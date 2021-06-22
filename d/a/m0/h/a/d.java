package d.a.m0.h.a;

import android.annotation.SuppressLint;
import android.view.View;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.m0.a.g1.f;
import d.a.m0.a.p.b.a.n;
/* loaded from: classes3.dex */
public class d {
    public static boolean a(View view, d.a.m0.a.l1.e.a.a aVar) {
        n X = f.V().X();
        return X != null && X.c(view, aVar);
    }

    public static boolean b() {
        n X = f.V().X();
        return (X == null || !X.b() || X.h()) ? false : true;
    }

    public static boolean c(View view) {
        n X = f.V().X();
        return X != null && X.d(view);
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    public static boolean d(View view) {
        n X = f.V().X();
        if (X == null) {
            return false;
        }
        if (X.h()) {
            SwanAppActivity activity = f.V().getActivity();
            if (activity != null) {
                activity.setRequestedOrientation(0);
            }
            X.g(false);
        }
        return X.removeView(view);
    }
}
