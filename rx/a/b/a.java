package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes14.dex */
public final class a {
    private static final AtomicReference<a> qfo = new AtomicReference<>();
    private final g qfp;

    private static a eFz() {
        a aVar;
        do {
            aVar = qfo.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!qfo.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g eFy = rx.a.a.a.eFv().eFw().eFy();
        if (eFy != null) {
            this.qfp = eFy;
        } else {
            this.qfp = new b(Looper.getMainLooper());
        }
    }

    public static g eFA() {
        return eFz().qfp;
    }
}
