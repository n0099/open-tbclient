package rx.a.b;

import android.os.Looper;
import rx.g;
/* loaded from: classes2.dex */
public final class a {
    private static final a kuF = new a();
    private final g kuG;

    private a() {
        g cPe = rx.a.a.a.cPb().cPc().cPe();
        if (cPe != null) {
            this.kuG = cPe;
        } else {
            this.kuG = new b(Looper.getMainLooper());
        }
    }

    public static g cPf() {
        return kuF.kuG;
    }
}
