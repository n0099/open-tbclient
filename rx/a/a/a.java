package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class a {
    private static final a iFz = new a();
    private final AtomicReference<b> iFA = new AtomicReference<>();

    public static a ces() {
        return iFz;
    }

    a() {
    }

    public b cet() {
        if (this.iFA.get() == null) {
            this.iFA.compareAndSet(null, b.ceu());
        }
        return this.iFA.get();
    }
}
