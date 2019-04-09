package rx.a.b;

import android.os.Looper;
import rx.g;
/* loaded from: classes2.dex */
public final class a {
    private static final a jUM = new a();
    private final g jUN;

    private a() {
        g cDI = rx.a.a.a.cDF().cDG().cDI();
        if (cDI != null) {
            this.jUN = cDI;
        } else {
            this.jUN = new b(Looper.getMainLooper());
        }
    }

    public static g cDJ() {
        return jUM.jUN;
    }
}
