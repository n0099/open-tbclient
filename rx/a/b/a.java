package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes16.dex */
public final class a {
    private static final AtomicReference<a> pcY = new AtomicReference<>();
    private final g pcZ;

    private static a erL() {
        a aVar;
        do {
            aVar = pcY.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!pcY.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g erK = rx.a.a.a.erH().erI().erK();
        if (erK != null) {
            this.pcZ = erK;
        } else {
            this.pcZ = new b(Looper.getMainLooper());
        }
    }

    public static g erM() {
        return erL().pcZ;
    }
}
