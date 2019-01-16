package rx.a.b;

import android.os.Looper;
import rx.g;
/* loaded from: classes2.dex */
public final class a {
    private static final a iFB = new a();
    private final g iFC;

    private a() {
        g cev = rx.a.a.a.ces().cet().cev();
        if (cev != null) {
            this.iFC = cev;
        } else {
            this.iFC = new b(Looper.getMainLooper());
        }
    }

    public static g cew() {
        return iFB.iFC;
    }
}
