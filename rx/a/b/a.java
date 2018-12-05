package rx.a.b;

import android.os.Looper;
import rx.g;
/* loaded from: classes2.dex */
public final class a {
    private static final a iBk = new a();
    private final g iBl;

    private a() {
        g ccX = rx.a.a.a.ccU().ccV().ccX();
        if (ccX != null) {
            this.iBl = ccX;
        } else {
            this.iBl = new b(Looper.getMainLooper());
        }
    }

    public static g ccY() {
        return iBk.iBl;
    }
}
