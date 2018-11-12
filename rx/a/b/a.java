package rx.a.b;

import android.os.Looper;
import rx.g;
/* loaded from: classes2.dex */
public final class a {
    private static final a iub = new a();
    private final g iuc;

    private a() {
        g caU = rx.a.a.a.caR().caS().caU();
        if (caU != null) {
            this.iuc = caU;
        } else {
            this.iuc = new b(Looper.getMainLooper());
        }
    }

    public static g caV() {
        return iub.iuc;
    }
}
