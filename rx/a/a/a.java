package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class a {
    private static final a jVf = new a();
    private final AtomicReference<b> jVg = new AtomicReference<>();

    public static a cDD() {
        return jVf;
    }

    a() {
    }

    public b cDE() {
        if (this.jVg.get() == null) {
            this.jVg.compareAndSet(null, b.cDF());
        }
        return this.jVg.get();
    }
}
