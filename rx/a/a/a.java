package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class a {
    private static final a nNt = new a();
    private final AtomicReference<b> nNu = new AtomicReference<>();

    public static a dNW() {
        return nNt;
    }

    a() {
    }

    public b dNX() {
        if (this.nNu.get() == null) {
            this.nNu.compareAndSet(null, b.dNY());
        }
        return this.nNu.get();
    }
}
