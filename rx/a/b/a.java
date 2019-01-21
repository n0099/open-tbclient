package rx.a.b;

import android.os.Looper;
import rx.g;
/* loaded from: classes2.dex */
public final class a {
    private static final a iFC = new a();
    private final g iFD;

    private a() {
        g cev = rx.a.a.a.ces().cet().cev();
        if (cev != null) {
            this.iFD = cev;
        } else {
            this.iFD = new b(Looper.getMainLooper());
        }
    }

    public static g cew() {
        return iFC.iFD;
    }
}
