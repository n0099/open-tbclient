package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes5.dex */
public final class a {
    private static final AtomicReference<a> qyE = new AtomicReference<>();
    private final g qyF;

    private static a eMT() {
        a aVar;
        do {
            aVar = qyE.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!qyE.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g eMS = rx.a.a.a.eMP().eMQ().eMS();
        if (eMS != null) {
            this.qyF = eMS;
        } else {
            this.qyF = new b(Looper.getMainLooper());
        }
    }

    public static g eMU() {
        return eMT().qyF;
    }
}
