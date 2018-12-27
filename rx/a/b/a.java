package rx.a.b;

import android.os.Looper;
import rx.g;
/* loaded from: classes2.dex */
public final class a {
    private static final a iEu = new a();
    private final g iEv;

    private a() {
        g cdN = rx.a.a.a.cdK().cdL().cdN();
        if (cdN != null) {
            this.iEv = cdN;
        } else {
            this.iEv = new b(Looper.getMainLooper());
        }
    }

    public static g cdO() {
        return iEu.iEv;
    }
}
