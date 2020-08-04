package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes6.dex */
public final class a {
    private static final AtomicReference<a> ojP = new AtomicReference<>();
    private final g ojQ;

    private static a dXP() {
        a aVar;
        do {
            aVar = ojP.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!ojP.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g dXO = rx.a.a.a.dXL().dXM().dXO();
        if (dXO != null) {
            this.ojQ = dXO;
        } else {
            this.ojQ = new b(Looper.getMainLooper());
        }
    }

    public static g dXQ() {
        return dXP().ojQ;
    }
}
