package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class a {
    private static final a jVy = new a();
    private final AtomicReference<b> jVz = new AtomicReference<>();

    public static a cDN() {
        return jVy;
    }

    a() {
    }

    public b cDO() {
        if (this.jVz.get() == null) {
            this.jVz.compareAndSet(null, b.cDP());
        }
        return this.jVz.get();
    }
}
