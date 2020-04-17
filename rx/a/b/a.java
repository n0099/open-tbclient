package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes6.dex */
public final class a {
    private static final AtomicReference<a> njc = new AtomicReference<>();
    private final g njd;

    private static a dHD() {
        a aVar;
        do {
            aVar = njc.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!njc.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g dHC = rx.a.a.a.dHz().dHA().dHC();
        if (dHC != null) {
            this.njd = dHC;
        } else {
            this.njd = new b(Looper.getMainLooper());
        }
    }

    public static g dHE() {
        return dHD().njd;
    }
}
