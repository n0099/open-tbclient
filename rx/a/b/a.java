package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes7.dex */
public final class a {
    private static final AtomicReference<a> oNI = new AtomicReference<>();
    private final g oNJ;

    private static a enZ() {
        a aVar;
        do {
            aVar = oNI.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!oNI.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g enY = rx.a.a.a.enV().enW().enY();
        if (enY != null) {
            this.oNJ = enY;
        } else {
            this.oNJ = new b(Looper.getMainLooper());
        }
    }

    public static g eoa() {
        return enZ().oNJ;
    }
}
