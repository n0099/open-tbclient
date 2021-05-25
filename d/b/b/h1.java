package d.b.b;

import android.content.Context;
import android.os.Build;
/* loaded from: classes6.dex */
public final class h1 {
    public static g1 a(Context context) {
        if (l.d()) {
            return new l1(new r1());
        }
        if (r1.b()) {
            return new r1();
        }
        if (k1.c()) {
            return new k1(context);
        }
        if (l.c(context)) {
            return new a1();
        }
        if (l.f()) {
            return new l1();
        }
        if (l.e()) {
            return new c1();
        }
        if (Build.VERSION.SDK_INT > 28) {
            if (l.g()) {
                return new m1();
            }
            if (l.i()) {
                return new d1();
            }
            if (l.h()) {
                return new b1();
            }
            if (l.j()) {
                return new k0();
            }
            return new w0();
        } else if (l.b() || !a1.c(context)) {
            return null;
        } else {
            return new a1();
        }
    }
}
