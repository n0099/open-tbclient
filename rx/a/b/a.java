package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes6.dex */
public final class a {
    private static final AtomicReference<a> nEf = new AtomicReference<>();
    private final g nEg;

    private static a dPu() {
        a aVar;
        do {
            aVar = nEf.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!nEf.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g dPt = rx.a.a.a.dPq().dPr().dPt();
        if (dPt != null) {
            this.nEg = dPt;
        } else {
            this.nEg = new b(Looper.getMainLooper());
        }
    }

    public static g dPv() {
        return dPu().nEg;
    }
}
