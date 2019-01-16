package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class a {
    private static final a iFy = new a();
    private final AtomicReference<b> iFz = new AtomicReference<>();

    public static a ces() {
        return iFy;
    }

    a() {
    }

    public b cet() {
        if (this.iFz.get() == null) {
            this.iFz.compareAndSet(null, b.ceu());
        }
        return this.iFz.get();
    }
}
