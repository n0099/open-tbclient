package d.a.l0.h.o0;

import android.content.Context;
import android.view.View;
import d.a.l0.a.g1.f;
import d.a.l0.a.p.b.a.n;
/* loaded from: classes3.dex */
public class b {
    public static boolean a(View view, d.a.l0.a.l1.e.a.a aVar) {
        n Y = f.V().Y();
        return Y != null && Y.c(view, aVar);
    }

    public static Context b() {
        n Y = f.V().Y();
        if (Y != null) {
            return Y.getContext();
        }
        return null;
    }

    public static void c(d.a.l0.a.w2.c cVar) {
        n Y = f.V().Y();
        if (Y != null) {
            Y.e(cVar);
        }
    }

    public static boolean d(View view) {
        n Y = f.V().Y();
        return Y != null && Y.removeView(view);
    }

    public static void e(d.a.l0.a.w2.c cVar) {
        n Y = f.V().Y();
        if (Y != null) {
            Y.f(cVar);
        }
    }

    public static boolean f(View view, d.a.l0.a.l1.e.a.a aVar) {
        n Y = f.V().Y();
        return Y != null && Y.a(view, aVar);
    }
}
