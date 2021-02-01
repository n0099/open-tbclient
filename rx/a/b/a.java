package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes5.dex */
public final class a {
    private static final AtomicReference<a> qye = new AtomicReference<>();
    private final g qyf;

    private static a eML() {
        a aVar;
        do {
            aVar = qye.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!qye.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g eMK = rx.a.a.a.eMH().eMI().eMK();
        if (eMK != null) {
            this.qyf = eMK;
        } else {
            this.qyf = new b(Looper.getMainLooper());
        }
    }

    public static g eMM() {
        return eML().qyf;
    }
}
