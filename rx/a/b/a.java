package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes15.dex */
public final class a {
    private static final AtomicReference<a> qsC = new AtomicReference<>();
    private final g qsD;

    private static a eOl() {
        a aVar;
        do {
            aVar = qsC.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!qsC.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g eOk = rx.a.a.a.eOh().eOi().eOk();
        if (eOk != null) {
            this.qsD = eOk;
        } else {
            this.qsD = new b(Looper.getMainLooper());
        }
    }

    public static g eOm() {
        return eOl().qsD;
    }
}
