package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes5.dex */
public final class a {
    private static final AtomicReference<a> nMH = new AtomicReference<>();
    private final g nMI;

    private static a dMN() {
        a aVar;
        do {
            aVar = nMH.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!nMH.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g dMM = rx.a.a.a.dMJ().dMK().dMM();
        if (dMM != null) {
            this.nMI = dMM;
        } else {
            this.nMI = new b(Looper.getMainLooper());
        }
    }

    public static g dMO() {
        return dMN().nMI;
    }
}
