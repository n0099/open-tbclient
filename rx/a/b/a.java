package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes5.dex */
public final class a {
    private static final AtomicReference<a> oDL = new AtomicReference<>();
    private final g oDM;

    private static a ejT() {
        a aVar;
        do {
            aVar = oDL.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!oDL.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g ejS = rx.a.a.a.ejP().ejQ().ejS();
        if (ejS != null) {
            this.oDM = ejS;
        } else {
            this.oDM = new b(Looper.getMainLooper());
        }
    }

    public static g ejU() {
        return ejT().oDM;
    }
}
