package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes5.dex */
public final class a {
    private static final AtomicReference<a> nMC = new AtomicReference<>();
    private final g nMD;

    private static a dML() {
        a aVar;
        do {
            aVar = nMC.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!nMC.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g dMK = rx.a.a.a.dMH().dMI().dMK();
        if (dMK != null) {
            this.nMD = dMK;
        } else {
            this.nMD = new b(Looper.getMainLooper());
        }
    }

    public static g dMM() {
        return dML().nMD;
    }
}
