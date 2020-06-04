package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes6.dex */
public final class a {
    private static final AtomicReference<a> nFp = new AtomicReference<>();
    private final g nFq;

    private static a dPI() {
        a aVar;
        do {
            aVar = nFp.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!nFp.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g dPH = rx.a.a.a.dPE().dPF().dPH();
        if (dPH != null) {
            this.nFq = dPH;
        } else {
            this.nFq = new b(Looper.getMainLooper());
        }
    }

    public static g dPJ() {
        return dPI().nFq;
    }
}
