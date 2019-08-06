package rx.a.b;

import android.os.Looper;
import rx.g;
/* loaded from: classes2.dex */
public final class a {
    private static final a kvL = new a();
    private final g kvM;

    private a() {
        g cPz = rx.a.a.a.cPw().cPx().cPz();
        if (cPz != null) {
            this.kvM = cPz;
        } else {
            this.kvM = new b(Looper.getMainLooper());
        }
    }

    public static g cPA() {
        return kvL.kvM;
    }
}
