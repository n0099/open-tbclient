package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes6.dex */
public final class a {
    private static final AtomicReference<a> obd = new AtomicReference<>();
    private final g obe;

    private static a dUs() {
        a aVar;
        do {
            aVar = obd.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!obd.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g dUr = rx.a.a.a.dUo().dUp().dUr();
        if (dUr != null) {
            this.obe = dUr;
        } else {
            this.obe = new b(Looper.getMainLooper());
        }
    }

    public static g dUt() {
        return dUs().obe;
    }
}
