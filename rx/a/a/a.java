package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class a {
    private static final a njc = new a();
    private final AtomicReference<b> njd = new AtomicReference<>();

    public static a dHv() {
        return njc;
    }

    a() {
    }

    public b dHw() {
        if (this.njd.get() == null) {
            this.njd.compareAndSet(null, b.dHx());
        }
        return this.njd.get();
    }
}
