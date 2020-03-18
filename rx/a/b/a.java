package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes6.dex */
public final class a {
    private static final AtomicReference<a> nPw = new AtomicReference<>();
    private final g nPx;

    private static a dOD() {
        a aVar;
        do {
            aVar = nPw.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!nPw.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g dOC = rx.a.a.a.dOz().dOA().dOC();
        if (dOC != null) {
            this.nPx = dOC;
        } else {
            this.nPx = new b(Looper.getMainLooper());
        }
    }

    public static g dOE() {
        return dOD().nPx;
    }
}
