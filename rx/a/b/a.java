package rx.a.b;

import android.os.Looper;
import rx.g;
/* loaded from: classes2.dex */
public final class a {
    private static final a jVt = new a();
    private final g jVu;

    private a() {
        g cDT = rx.a.a.a.cDQ().cDR().cDT();
        if (cDT != null) {
            this.jVu = cDT;
        } else {
            this.jVu = new b(Looper.getMainLooper());
        }
    }

    public static g cDU() {
        return jVt.jVu;
    }
}
