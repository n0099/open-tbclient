package rx.a.b;

import android.os.Looper;
import rx.g;
/* loaded from: classes2.dex */
public final class a {
    private static final a jVB = new a();
    private final g jVC;

    private a() {
        g cDQ = rx.a.a.a.cDN().cDO().cDQ();
        if (cDQ != null) {
            this.jVC = cDQ;
        } else {
            this.jVC = new b(Looper.getMainLooper());
        }
    }

    public static g cDR() {
        return jVB.jVC;
    }
}
