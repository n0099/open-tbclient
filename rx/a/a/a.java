package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class a {
    private static final a njc = new a();
    private final AtomicReference<b> njd = new AtomicReference<>();

    public static a dHw() {
        return njc;
    }

    a() {
    }

    public b dHx() {
        if (this.njd.get() == null) {
            this.njd.compareAndSet(null, b.dHy());
        }
        return this.njd.get();
    }
}
