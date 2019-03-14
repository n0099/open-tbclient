package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class a {
    private static final a jVq = new a();
    private final AtomicReference<b> jVr = new AtomicReference<>();

    public static a cDQ() {
        return jVq;
    }

    a() {
    }

    public b cDR() {
        if (this.jVr.get() == null) {
            this.jVr.compareAndSet(null, b.cDS());
        }
        return this.jVr.get();
    }
}
