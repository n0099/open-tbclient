package rx.a.b;

import android.os.Looper;
import rx.g;
/* loaded from: classes2.dex */
public final class a {
    private static final a kye = new a();
    private final g kyf;

    private a() {
        g cQl = rx.a.a.a.cQi().cQj().cQl();
        if (cQl != null) {
            this.kyf = cQl;
        } else {
            this.kyf = new b(Looper.getMainLooper());
        }
    }

    public static g cQm() {
        return kye.kyf;
    }
}
