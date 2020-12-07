package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes12.dex */
public final class a {
    private static final AtomicReference<a> pPq = new AtomicReference<>();
    private final g pPr;

    private static a eFy() {
        a aVar;
        do {
            aVar = pPq.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!pPq.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g eFx = rx.a.a.a.eFu().eFv().eFx();
        if (eFx != null) {
            this.pPr = eFx;
        } else {
            this.pPr = new b(Looper.getMainLooper());
        }
    }

    public static g eFz() {
        return eFy().pPr;
    }
}
