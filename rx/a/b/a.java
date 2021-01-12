package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes14.dex */
public final class a {
    private static final AtomicReference<a> qoa = new AtomicReference<>();
    private final g qob;

    private static a eKv() {
        a aVar;
        do {
            aVar = qoa.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!qoa.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g eKu = rx.a.a.a.eKr().eKs().eKu();
        if (eKu != null) {
            this.qob = eKu;
        } else {
            this.qob = new b(Looper.getMainLooper());
        }
    }

    public static g eKw() {
        return eKv().qob;
    }
}
