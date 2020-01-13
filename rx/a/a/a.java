package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public final class a {
    private static final a nMz = new a();
    private final AtomicReference<b> nMA = new AtomicReference<>();

    public static a dMH() {
        return nMz;
    }

    a() {
    }

    public b dMI() {
        if (this.nMA.get() == null) {
            this.nMA.compareAndSet(null, b.dMJ());
        }
        return this.nMA.get();
    }
}
