package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes5.dex */
public final class a {
    private static final AtomicReference<a> oEd = new AtomicReference<>();
    private final g oEe;

    private static a ekc() {
        a aVar;
        do {
            aVar = oEd.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!oEd.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g ekb = rx.a.a.a.ejY().ejZ().ekb();
        if (ekb != null) {
            this.oEe = ekb;
        } else {
            this.oEe = new b(Looper.getMainLooper());
        }
    }

    public static g ekd() {
        return ekc().oEe;
    }
}
