package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes6.dex */
public final class a {
    private static final AtomicReference<a> nNy = new AtomicReference<>();
    private final g nNz;

    private static a dOc() {
        a aVar;
        do {
            aVar = nNy.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!nNy.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g dOb = rx.a.a.a.dNY().dNZ().dOb();
        if (dOb != null) {
            this.nNz = dOb;
        } else {
            this.nNz = new b(Looper.getMainLooper());
        }
    }

    public static g dOd() {
        return dOc().nNz;
    }
}
