package rx.a.a;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class a {
    private static final a kmZ = new a();
    private final AtomicReference<b> kna = new AtomicReference<>();

    public static a cLl() {
        return kmZ;
    }

    a() {
    }

    public b cLm() {
        if (this.kna.get() == null) {
            this.kna.compareAndSet(null, b.cLn());
        }
        return this.kna.get();
    }
}
