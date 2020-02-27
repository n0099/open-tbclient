package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes6.dex */
public final class a {
    private static final AtomicReference<a> nNw = new AtomicReference<>();
    private final g nNx;

    private static a dOa() {
        a aVar;
        do {
            aVar = nNw.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!nNw.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g dNZ = rx.a.a.a.dNW().dNX().dNZ();
        if (dNZ != null) {
            this.nNx = dNZ;
        } else {
            this.nNx = new b(Looper.getMainLooper());
        }
    }

    public static g dOb() {
        return dOa().nNx;
    }
}
