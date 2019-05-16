package rx.a.b;

import android.os.Looper;
import rx.g;
/* loaded from: classes2.dex */
public final class a {
    private static final a knc = new a();
    private final g knd;

    private a() {
        g cLo = rx.a.a.a.cLl().cLm().cLo();
        if (cLo != null) {
            this.knd = cLo;
        } else {
            this.knd = new b(Looper.getMainLooper());
        }
    }

    public static g cLp() {
        return knc.knd;
    }
}
