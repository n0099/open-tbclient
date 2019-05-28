package rx.a.b;

import android.os.Looper;
import rx.g;
/* loaded from: classes2.dex */
public final class a {
    private static final a knd = new a();
    private final g kne;

    private a() {
        g cLq = rx.a.a.a.cLn().cLo().cLq();
        if (cLq != null) {
            this.kne = cLq;
        } else {
            this.kne = new b(Looper.getMainLooper());
        }
    }

    public static g cLr() {
        return knd.kne;
    }
}
