package rx.a.b;

import android.os.Looper;
import rx.g;
/* loaded from: classes2.dex */
public final class a {
    private static final a jVi = new a();
    private final g jVj;

    private a() {
        g cDG = rx.a.a.a.cDD().cDE().cDG();
        if (cDG != null) {
            this.jVj = cDG;
        } else {
            this.jVj = new b(Looper.getMainLooper());
        }
    }

    public static g cDH() {
        return jVi.jVj;
    }
}
