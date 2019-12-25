package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes4.dex */
public final class a {
    private static final AtomicReference<a> ndD = new AtomicReference<>();
    private final g ndE;

    private static a dGk() {
        a aVar;
        do {
            aVar = ndD.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!ndD.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g dGj = rx.a.a.a.dGg().dGh().dGj();
        if (dGj != null) {
            this.ndE = dGj;
        } else {
            this.ndE = new b(Looper.getMainLooper());
        }
    }

    public static g dGl() {
        return dGk().ndE;
    }
}
