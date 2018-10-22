package rx.a.b;

import android.os.Looper;
import rx.g;
/* loaded from: classes2.dex */
public final class a {
    private static final a isr = new a();
    private final g iss;

    private a() {
        g cbx = rx.a.a.a.cbu().cbv().cbx();
        if (cbx != null) {
            this.iss = cbx;
        } else {
            this.iss = new b(Looper.getMainLooper());
        }
    }

    public static g cby() {
        return isr.iss;
    }
}
