package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes14.dex */
public final class a {
    private static final AtomicReference<a> qob = new AtomicReference<>();
    private final g qoc;

    private static a eKv() {
        a aVar;
        do {
            aVar = qob.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!qob.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g eKu = rx.a.a.a.eKr().eKs().eKu();
        if (eKu != null) {
            this.qoc = eKu;
        } else {
            this.qoc = new b(Looper.getMainLooper());
        }
    }

    public static g eKw() {
        return eKv().qoc;
    }
}
