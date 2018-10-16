package rx.a.b;

import android.os.Looper;
import rx.g;
/* loaded from: classes2.dex */
public final class a {
    private static final a isq = new a();
    private final g isr;

    private a() {
        g cbx = rx.a.a.a.cbu().cbv().cbx();
        if (cbx != null) {
            this.isr = cbx;
        } else {
            this.isr = new b(Looper.getMainLooper());
        }
    }

    public static g cby() {
        return isq.isr;
    }
}
