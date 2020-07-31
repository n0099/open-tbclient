package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes6.dex */
public final class a {
    private static final AtomicReference<a> ojN = new AtomicReference<>();
    private final g ojO;

    private static a dXO() {
        a aVar;
        do {
            aVar = ojN.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!ojN.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g dXN = rx.a.a.a.dXK().dXL().dXN();
        if (dXN != null) {
            this.ojO = dXN;
        } else {
            this.ojO = new b(Looper.getMainLooper());
        }
    }

    public static g dXP() {
        return dXO().ojO;
    }
}
