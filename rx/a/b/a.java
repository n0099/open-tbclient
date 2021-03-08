package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes4.dex */
public final class a {
    private static final AtomicReference<a> qzg = new AtomicReference<>();
    private final g qzh;

    private static a eMB() {
        a aVar;
        do {
            aVar = qzg.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!qzg.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g eMA = rx.a.a.a.eMx().eMy().eMA();
        if (eMA != null) {
            this.qzh = eMA;
        } else {
            this.qzh = new b(Looper.getMainLooper());
        }
    }

    public static g eMC() {
        return eMB().qzh;
    }
}
