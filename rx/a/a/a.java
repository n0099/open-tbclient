package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class a {
    private static final a oDI = new a();
    private final AtomicReference<b> oDJ = new AtomicReference<>();

    public static a ejP() {
        return oDI;
    }

    a() {
    }

    public b ejQ() {
        if (this.oDJ.get() == null) {
            this.oDJ.compareAndSet(null, b.ejR());
        }
        return this.oDJ.get();
    }
}
