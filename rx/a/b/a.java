package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes6.dex */
public final class a {
    private static final AtomicReference<a> njf = new AtomicReference<>();
    private final g njg;

    private static a dHA() {
        a aVar;
        do {
            aVar = njf.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!njf.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g dHz = rx.a.a.a.dHw().dHx().dHz();
        if (dHz != null) {
            this.njg = dHz;
        } else {
            this.njg = new b(Looper.getMainLooper());
        }
    }

    public static g dHB() {
        return dHA().njg;
    }
}
