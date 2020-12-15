package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes12.dex */
public final class a {
    private static final AtomicReference<a> pPs = new AtomicReference<>();
    private final g pPt;

    private static a eFz() {
        a aVar;
        do {
            aVar = pPs.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!pPs.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g eFy = rx.a.a.a.eFv().eFw().eFy();
        if (eFy != null) {
            this.pPt = eFy;
        } else {
            this.pPt = new b(Looper.getMainLooper());
        }
    }

    public static g eFA() {
        return eFz().pPt;
    }
}
