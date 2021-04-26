package d.a.h0.g.k0.e;

import android.view.View;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.h0.a.z0.f;
import d.a.h0.g.k0.d;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static int f46440a = d.a.h0.a.w0.a.N().m();

    public static boolean a(View view, d.a.h0.a.e1.d.a.a aVar) {
        d X = f.V().X();
        return X != null && X.f(view, aVar);
    }

    public static int b() {
        return ((Integer) f.V().y().second).intValue();
    }

    public static int c() {
        return ((Integer) f.V().y().first).intValue();
    }

    public static boolean d() {
        return f46440a == 2;
    }

    public static boolean e() {
        return f46440a == 3;
    }

    public static boolean f() {
        d X = f.V().X();
        return (X == null || !X.h() || X.d()) ? false : true;
    }

    public static boolean g(View view) {
        d X = f.V().X();
        return X != null && X.g(view);
    }

    public static void h(d.a.h0.g.k0.a aVar) {
        d X = f.V().X();
        if (X != null) {
            X.l(aVar);
        }
    }

    public static boolean i(View view) {
        d X = f.V().X();
        if (X == null) {
            return false;
        }
        if (X.d()) {
            SwanAppActivity activity = f.V().getActivity();
            if (activity != null) {
                activity.setRequestedOrientation(0);
            }
            X.n(false);
        }
        return X.m(view);
    }

    public static void j(d.a.h0.g.k0.a aVar) {
        d X = f.V().X();
        if (X != null) {
            X.p(aVar);
        }
    }

    public static boolean k(View view, d.a.h0.a.e1.d.a.a aVar) {
        d X = f.V().X();
        return X != null && X.q(view, aVar);
    }
}
