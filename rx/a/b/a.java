package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes15.dex */
public final class a {
    private static final AtomicReference<a> qqU = new AtomicReference<>();
    private final g qqV;

    private static a eNH() {
        a aVar;
        do {
            aVar = qqU.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!qqU.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g eNG = rx.a.a.a.eND().eNE().eNG();
        if (eNG != null) {
            this.qqV = eNG;
        } else {
            this.qqV = new b(Looper.getMainLooper());
        }
    }

    public static g eNI() {
        return eNH().qqV;
    }
}
