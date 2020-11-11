package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes16.dex */
public final class a {
    private static final AtomicReference<a> qdL = new AtomicReference<>();
    private final g qdM;

    private static a eFy() {
        a aVar;
        do {
            aVar = qdL.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!qdL.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g eFx = rx.a.a.a.eFu().eFv().eFx();
        if (eFx != null) {
            this.qdM = eFx;
        } else {
            this.qdM = new b(Looper.getMainLooper());
        }
    }

    public static g eFz() {
        return eFy().qdM;
    }
}
