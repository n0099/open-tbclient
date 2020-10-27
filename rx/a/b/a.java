package rx.a.b;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.g;
/* loaded from: classes16.dex */
public final class a {
    private static final AtomicReference<a> pUr = new AtomicReference<>();
    private final g pUs;

    private static a eBJ() {
        a aVar;
        do {
            aVar = pUr.get();
            if (aVar != null) {
                break;
            }
            aVar = new a();
        } while (!pUr.compareAndSet(null, aVar));
        return aVar;
    }

    private a() {
        g eBI = rx.a.a.a.eBF().eBG().eBI();
        if (eBI != null) {
            this.pUs = eBI;
        } else {
            this.pUs = new b(Looper.getMainLooper());
        }
    }

    public static g eBK() {
        return eBJ().pUs;
    }
}
