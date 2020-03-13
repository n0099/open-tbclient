package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class a {
    private static final a nNG = new a();
    private final AtomicReference<b> nNH = new AtomicReference<>();

    public static a dNZ() {
        return nNG;
    }

    a() {
    }

    public b dOa() {
        if (this.nNH.get() == null) {
            this.nNH.compareAndSet(null, b.dOb());
        }
        return this.nNH.get();
    }
}
