package rx.a.b;

import android.os.Looper;
import rx.g;
/* loaded from: classes2.dex */
public final class a {
    private static final a kyM = new a();
    private final g kyN;

    private a() {
        g cOr = rx.a.a.a.cOo().cOp().cOr();
        if (cOr != null) {
            this.kyN = cOr;
        } else {
            this.kyN = new b(Looper.getMainLooper());
        }
    }

    public static g cOs() {
        return kyM.kyN;
    }
}
