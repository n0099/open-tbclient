package rx.a.b;

import android.os.Looper;
import rx.g;
/* loaded from: classes2.dex */
public final class a {
    private static final a iBk = new a();
    private final g iBl;

    private a() {
        g ccW = rx.a.a.a.ccT().ccU().ccW();
        if (ccW != null) {
            this.iBl = ccW;
        } else {
            this.iBl = new b(Looper.getMainLooper());
        }
    }

    public static g ccX() {
        return iBk.iBl;
    }
}
