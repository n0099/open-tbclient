package rx.a.b;

import android.os.Looper;
import rx.g;
/* loaded from: classes2.dex */
public final class a {
    private static final a kxV = new a();
    private final g kxW;

    private a() {
        g cOp = rx.a.a.a.cOm().cOn().cOp();
        if (cOp != null) {
            this.kxW = cOp;
        } else {
            this.kxW = new b(Looper.getMainLooper());
        }
    }

    public static g cOq() {
        return kxV.kxW;
    }
}
