package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes6.dex */
public final class a {
    private static final AtomicReference<a> nNJ = new AtomicReference<>();
    private final g nNK;

    private static a dOd() {
        a aVar;
        do {
            aVar = nNJ.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!nNJ.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g dOc = rx.a.a.a.dNZ().dOa().dOc();
        if (dOc != null) {
            this.nNK = dOc;
        } else {
            this.nNK = new b(Looper.getMainLooper());
        }
    }

    public static g dOe() {
        return dOd().nNK;
    }
}
