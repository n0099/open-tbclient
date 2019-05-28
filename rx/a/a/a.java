package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class a {
    private static final a kna = new a();
    private final AtomicReference<b> knb = new AtomicReference<>();

    public static a cLn() {
        return kna;
    }

    a() {
    }

    public b cLo() {
        if (this.knb.get() == null) {
            this.knb.compareAndSet(null, b.cLp());
        }
        return this.knb.get();
    }
}
