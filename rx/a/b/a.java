package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes6.dex */
public final class a {
    private static final AtomicReference<a> oba = new AtomicReference<>();
    private final g obb;

    private static a dUo() {
        a aVar;
        do {
            aVar = oba.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!oba.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g dUn = rx.a.a.a.dUk().dUl().dUn();
        if (dUn != null) {
            this.obb = dUn;
        } else {
            this.obb = new b(Looper.getMainLooper());
        }
    }

    public static g dUp() {
        return dUo().obb;
    }
}
