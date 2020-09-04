package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class a {
    private static final a oEa = new a();
    private final AtomicReference<b> oEb = new AtomicReference<>();

    public static a ejY() {
        return oEa;
    }

    a() {
    }

    public b ejZ() {
        if (this.oEb.get() == null) {
            this.oEb.compareAndSet(null, b.eka());
        }
        return this.oEb.get();
    }
}
