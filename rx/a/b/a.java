package rx.a.b;

import android.os.Looper;
import rx.g;
/* loaded from: classes2.dex */
public final class a {
    private static final a jUL = new a();
    private final g jUM;

    private a() {
        g cDI = rx.a.a.a.cDF().cDG().cDI();
        if (cDI != null) {
            this.jUM = cDI;
        } else {
            this.jUM = new b(Looper.getMainLooper());
        }
    }

    public static g cDJ() {
        return jUL.jUM;
    }
}
