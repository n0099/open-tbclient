package rx.a.b;

import android.os.Looper;
import rx.g;
/* loaded from: classes2.dex */
public final class a {
    private static final a kng = new a();
    private final g knh;

    private a() {
        g cLp = rx.a.a.a.cLm().cLn().cLp();
        if (cLp != null) {
            this.knh = cLp;
        } else {
            this.knh = new b(Looper.getMainLooper());
        }
    }

    public static g cLq() {
        return kng.knh;
    }
}
